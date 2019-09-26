package com.library.controller;

import com.library.service.DeleteBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class DeleteController {
    @Autowired
    DeleteBookService deleteBookService;
// TODO: 2019-09-26   1.返回所有删书记录     返回model


}
