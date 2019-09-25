package com.library.dao;

import com.library.bean.lib_notice;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

@Repository
public class NoticeDao {

    private final static String NAMESPACE = "com.library.dao.NoticeDao.";
    @Resource
    private SqlSessionTemplate sqlSessionTemplate;

    public int addNotice(final lib_notice notice) {
        return sqlSessionTemplate.insert(NAMESPACE + "addNotice", notice);
    }

    public lib_notice getNotice(final long noticeId) {
        return sqlSessionTemplate.selectOne(NAMESPACE + "getNotice", noticeId);
    }

    public int deleteNotice(final long noticeId) {
        return sqlSessionTemplate.delete(NAMESPACE + "deleteNotice", noticeId);
    }
}
