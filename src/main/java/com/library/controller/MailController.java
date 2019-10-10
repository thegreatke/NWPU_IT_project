package com.library.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.library.service.EmailService;
import com.library.utils.EmailUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
public class MailController {


    @RequestMapping("/sendEmail")
    @ResponseBody
    public String sendEmail() throws JsonProcessingException {
        boolean isSend = EmailUtils.sendEmail("这是一封测试邮件", new String[]{"sjysshigh@163.com"}, null, "<h3><a href='http://www.baidu.com'>百度一下，你就知道</a></h3>", null);
        return "发送邮件:" + isSend;
    }               


    @Resource
    EmailService emailService;

    private static final Logger logger = LoggerFactory.getLogger(MailController.class);

    @ResponseBody
    @RequestMapping("/sendEmailTask")
    public void sendEmailTask() {
        logger.info("-------------执行发送邮件START---------------");
        //写入excel
        //insuranceService.excelManage();
        //发邮件
        emailService.emailManage();

        logger.info("-------------执行发送邮件END---------------");

    }


}
