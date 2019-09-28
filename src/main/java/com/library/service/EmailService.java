package com.library.service;

import com.library.bean.Mail;

public interface EmailService {

    /**
     * email配置
     * @return
     */
    public void emailManage();

    /**
     * 发送邮件
     * @param mail
     */
    public void sendEmail(Mail mail);

}