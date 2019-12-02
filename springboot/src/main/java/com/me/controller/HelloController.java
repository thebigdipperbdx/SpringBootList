package com.me.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yanyugang
 * @description
 * @date 2019-11-30 12:28
 */
@RestController
public class HelloController {

    @RequestMapping("hello")
    public String helloworld(@RequestParam String name, @RequestParam String age){
        return "hello,"+name+",age,"+age;
    }
    @RequestMapping("hello2")
    public String helloworld2(@RequestBody String content){
        System.out.println(content);
        return null;
    }
}
