package com.library.service;

import com.library.bean.lib_notice;
import com.library.dao.NoticeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class NoticeService {

    // TODO: 2019/9/23  实现管理公告版的操作，保存到数据库的List_notice的公告表中去，增删改查

    @Autowired
    private NoticeDao noticeDao;

    public boolean addNotice(lib_notice notice) {
        return noticeDao.addNotice(notice) > 0;
    }//返回的int是数据库执行操作后影响的行数

    public lib_notice getNotice(int noticeId) {
        return noticeDao.getNotice(noticeId);
    }

    public boolean deleteNotice(Long noticeId) {
        return noticeDao.deleteNotice(noticeId) > 0;
    }

    public boolean editNotice(lib_notice notice) {
        return noticeDao.editNotice(notice) > 0;
    }

    public ArrayList<lib_notice> getAllNotices() {
        return noticeDao.getAllNotices();
    }




}
