package com.fuzzy.search.controller;

import com.fuzzy.search.entity.GridModel;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.apache.commons.io.LineIterator;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileInputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;

@Controller
@RequestMapping("/fuzzySearch")
public class FuzzySearchQueryController {
    private static Logger logger=Logger.getLogger(FuzzySearchQueryController.class);
    @Value("${file.path}")
    private String filePath;

    @RequestMapping("/execute")
    public ModelAndView execute(HttpServletRequest request){
        ModelAndView view=new ModelAndView("fuzzysearch");
        DateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        Date date=new Date();
        Calendar c=Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.DAY_OF_MONTH, -3); //当前天数-3
        view.addObject("start", sdf.format(c.getTime()));
        view.addObject("end", sdf.format(c.getTime()));
        view.addObject("timestamp", System.currentTimeMillis());
        System.out.println("方法执行体");
        return view;
    }

    @RequestMapping("/getText")
    @ResponseBody
    public GridModel getAppSecondRecordType(@RequestBody Map<String, String> map){
        GridModel model=new GridModel();
        StringBuffer buffer=new StringBuffer();
        try {
            FileInputStream inputStream=FileUtils.openInputStream(new File(filePath));
            LineIterator it=IOUtils.lineIterator(inputStream, "GBK");
            while (it.hasNext()) {
                String line=it.nextLine();
                if (line.contains(map.get("id"))){
                    buffer.append(line);
                }
            }
            model.setRows(buffer.toString());
            model.setStatus("success");
        } catch (Exception e) {
            logger.error("FuzzySearchQueryController.getAppSecondRecordType异常===>", e);
            model.setStatus("false");
            model.setMsg(e.getMessage());
        }
        return model;
    }


    @RequestMapping("/resume")
    public ModelAndView resume(HttpServletRequest request){
        ModelAndView view=new ModelAndView("resume");
        return view;
    }

    @RequestMapping("/printHello")
    @ResponseBody
    public String printHelloFun(){
        String str="Hello World!!!!!";
        System.out.println(str);
        return str;
    }

}
