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
    public String getNotice(@ModelAttribute lib_notice libNotice){

        return "return Notice";
    }

}
