package com.library.controller;


import com.library.bean.lib_notice;
import com.library.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import java.util.*;

@Controller
public class NoticeController {
    @Autowired
    NoticeService noticeService;

    @ResponseBody
    @RequestMapping("/getnotice")
    public String getNotice(@RequestParam("noticeid") int noticeid,Model model){
        Map map = new HashMap();
        lib_notice libNotice=noticeService.getNotice(noticeid);
        long id = libNotice.getId();
        Date date =libNotice.getDateTime();
        String content=libNotice.getContent();
        map.put("id",id);
        map.put("date",date);
        map.put("content",content);
        model.addAttribute(map);
        String test = model.toString();
        return test;
    }
    // TODO: 2019-09-26
    //  1.新增一条公告    传入参数，公告的所有属性除了id，id自动分配， 返回json，装后面的字符串  1.successful add  2.failed。
    //  2.删除某条公告    传入参数公告id, 返回json，装后面的字符串  1.successful add  2.failed。
    //  3.编辑某条------------

}
