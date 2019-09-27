package com.library.controller;


import com.alibaba.fastjson.JSONObject;
import com.library.bean.Admin;
import com.library.bean.Book;
import com.library.bean.ReaderInfo;
import com.library.service.AdminService;
import com.library.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

@Controller
public class AdminController {

    @Autowired
    AdminService adminService;
    private Admin getAdmin(long adminId , String password, String username , int roles){
        Admin admin = new Admin();
        admin.setRoles(roles);
        admin.setAdminId(adminId);
        admin.setPassword(password);
        admin.setUsername(username);
        return admin;
    }

    @ResponseBody
    @RequestMapping("/addLibrarian")
    public JSONObject addlibrarian(long adminId , String password , String username){

        Admin admin = getAdmin(adminId,password,username,1) ;
        JSONObject jsonObject = new JSONObject();

        long librarianId = adminService.addLibrarian(admin);
        if(librarianId >0)
        {
            jsonObject.put("succ","成功");
        }
        else {
            jsonObject.put("succ","失败");
        }
        return jsonObject;

    }

    @ResponseBody
    @RequestMapping("/deleteLibrarian")
    public JSONObject deletelibrarian( @RequestParam("id") long adminId ){

        JSONObject jsonObject = new JSONObject();

        if(adminService.deleteLibrarian(adminId))
        {
            jsonObject.put("succ","删除成功");
        }
        else {
            jsonObject.put("succ","删除失败");
        }
        return jsonObject;
    }

    @ResponseBody
    @RequestMapping ("/getAllLibrarian")
    public String getAll(Model model) {

        ArrayList<Admin> admins = adminService.getAllLibrarian();

        model.addAttribute("Librarian", admins);
        String res = model.toString();
        return res;
    }






    // TODO: 2019-09-26  作为超管 1.对roles =1 图书管理员操作，  返回他们的所有账户  返回model
    //  2. 对roles =1 图书管理员，  新增一个账户  返回json 字符串：成功或失败
    //  3. --------传入账户id------删除---------------------------------




}

// TODO: 2019-09-26 图书管管员能够添加/编辑书籍类别 • Add /Edit
//  Book Location 图书管管员你能够增加/编辑/删除书籍的所在位置

