package com.sto.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * @author yanyugang
 * @description
 * @date 2019-09-10 15:08
 */
@RestController
public class RedisDistributedLockController {
    @Autowired
    private StringRedisTemplate redisTemplate;
    private static final String KEY_OF_ALL_MONEY_SEND="key_of_all_money_send";

    /**
     * 多个CheckBox选中发放
     */
    @RequestMapping("/sendByIds")
    @ResponseBody
    public String sendByIds(@RequestParam Map map, HttpServletRequest request){
        String state="false";
        String msg="正在发放,请稍等";
        try {
            /**
             * 采用redis分布式锁
             * 参考文档：http://redisdoc.com/string/setnx.html
             * 如果key存在,返回false;不存在返回true，并设置key的值
             */
            boolean redisSuccess=redisTemplate.opsForValue().setIfAbsent(KEY_OF_ALL_MONEY_SEND, "1");
            if (!redisSuccess){
                msg="正在发放中,请勿重复发放";
                return "{\"success\":\"" + state + "\",\"msg\":\"" + msg + "\"}";
            }
            // 业务逻辑代码

        } catch (Exception e) {
            msg="发放失败，失败原因：" + e.getMessage();
        } finally {
            // 删除key
            redisTemplate.delete(KEY_OF_ALL_MONEY_SEND);
        }
        return "{\"success\":\"" + state + "\",\"msg\":\"" + msg + "\"}";
    }

}
