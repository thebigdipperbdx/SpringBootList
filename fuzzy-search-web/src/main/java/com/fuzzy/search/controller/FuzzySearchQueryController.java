package com.fuzzy.search.controller;

import com.fuzzy.search.entity.GridModel;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.apache.commons.io.LineIterator;
import org.apache.log4j.Logger;
import org.omg.CORBA_2_3.ORB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.FileInputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;

@Controller
@RequestMapping("/fuzzySearch")
@SuppressWarnings("all")
@CrossOrigin(origins="*",maxAge=3600)
public class FuzzySearchQueryController {
    private static Logger logger=Logger.getLogger(FuzzySearchQueryController.class);
    @Value("${file.path}")
    private String filePath;
    @Autowired
    private HelloBean helloBean;


    @RequestMapping("/execute")
    public ModelAndView execute(HttpServletRequest request){
        HttpSession session=request.getSession();
        session.setAttribute("hello","world");

        ModelAndView view=new ModelAndView("fuzzysearch");
        DateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        Date date=new Date();
        Calendar c=Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.DAY_OF_MONTH, -3); //当前天数-3
        view.addObject("start", sdf.format(c.getTime()));
        view.addObject("end", sdf.format(c.getTime()));
        view.addObject("timestamp", System.currentTimeMillis());

        helloBean.executeProcess("sayBean");

        System.out.println(session.getAttribute("hello"));
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

}
