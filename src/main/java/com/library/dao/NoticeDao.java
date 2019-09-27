package com.library.dao;

import com.library.bean.lib_notice;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Repository
public class NoticeDao {

    private final static String NAMESPACE = "com.library.dao.NoticeDao.";
    @Resource
    private SqlSessionTemplate sqlSessionTemplate;

    public int addNotice(final lib_notice notice) {
        return sqlSessionTemplate.insert(NAMESPACE + "addNotice", notice);
    }

    public lib_notice getNotice(final int noticeId) {
        return sqlSessionTemplate.selectOne(NAMESPACE + "getNotice", noticeId);
    }

    public int deleteNotice(final long noticeId) {
        return sqlSessionTemplate.delete(NAMESPACE + "deleteNotice", noticeId);
    }

    public int editNotice(final lib_notice notice) {
        return sqlSessionTemplate.update(NAMESPACE + "editNotice", notice);
    }

    public ArrayList<lib_notice> getAllNotices() {
        List<lib_notice> result = sqlSessionTemplate.selectList(NAMESPACE + "getAllNotices");
        return (ArrayList<lib_notice>) result;
    }
}
