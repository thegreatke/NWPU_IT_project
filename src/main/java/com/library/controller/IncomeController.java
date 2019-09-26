package com.library.controller;


import com.alibaba.fastjson.JSONObject;
import com.library.bean.Book;
import com.library.bean.Income;
import com.library.service.IncomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.xml.crypto.Data;
import java.util.*;

@Controller
public class IncomeController {


    @Autowired
    IncomeService incomeService;

    @ResponseBody
    @RequestMapping("/getDayIncome")
    public String getincome(@RequestParam("day") Date date, Model model){
        Map map = new HashMap();

        float income = incomeService.getOneDayIncome(date);
        map.put("test", 123);
        map.put("income", income);

        model.addAllAttributes(map);

        String test = model.toString();
        return test;
    }


    @ResponseBody
    @RequestMapping("/getMonthIncome")
    public String getMonthIncome(@RequestParam("month") int month,@RequestParam("year") int year, Model model){

        Map map = new HashMap();
        float income = incomeService.getMonthIncome(month,year);
        map.put("income", income);
        model.addAllAttributes(map);
        String test = model.toString();
        return test;
    }

    @ResponseBody
    @RequestMapping("/getYearIncome")
    public String getincome(@RequestParam("year") int year, Model model){
        Map map = new HashMap();
        float income = incomeService.getYearIncome(year);
        map.put("income", income);
        model.addAllAttributes(map);
        String test = model.toString();
        return test;
    }

















    @ResponseBody
    @RequestMapping("/test01")
    public JSONObject getTest( ){
        Map map = new HashMap();
        JSONObject jsonObject = new JSONObject();
        List<Book> testVos = new ArrayList<>();
        Book book = new Book();
        book.setName("fulei");
        Book book01 = new Book();
        book01.setName("wangmeng");
        testVos.add(book);
        testVos.add(book01);
        map.put("user", "love");
        map.put("url", "http://www.baidu.com/");
        map.put("name", "百度");
//        map.put("testVos", testVos);
//        model.addAllAttributes(map);
//        String test = model.toString();
        jsonObject.put("test", map);

        return jsonObject;
    }

}
