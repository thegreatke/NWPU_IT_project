package com.library.dao;

import com.library.bean.Admin;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class AdminDao {

    private final static String NAMESPACE = "com.library.dao.AdminDao.";
    @Resource
    private SqlSessionTemplate sqlSessionTemplate;

    public int getMatchCount(final long admin_id, final String password) {
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("admin_id", admin_id);
        paramMap.put("password", password);
        if(sqlSessionTemplate.selectOne(NAMESPACE + "getMatchCount", paramMap)==null)
        {
            return 10;//非零的任意数字
        }

        return sqlSessionTemplate.selectOne(NAMESPACE + "getMatchCount", paramMap);
    }

    // TODO: 2019/9/23  根据admin分为roles=1的图书管理员和roles = 0的超级管理员
    public int resetPassword(final long admin_id, final String password) {
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("admin_id", admin_id);
        paramMap.put("password", password);
        return sqlSessionTemplate.update(NAMESPACE + "resetPassword", paramMap);
    }

    public String getPassword(final long admin_id) {
        return sqlSessionTemplate.selectOne(NAMESPACE + "getPassword", admin_id);
    }

    public String getUsername(final long admin_id) {
        return sqlSessionTemplate.selectOne(NAMESPACE + "getUsername", admin_id);
    }

    public String getLibraname(final long admin_id) {
        return sqlSessionTemplate.selectOne(NAMESPACE + "getLibraname", admin_id);
    }

    public  final long addLibrarian(final Admin admin){
        if (sqlSessionTemplate.insert(NAMESPACE+"addLibrarian",admin)>0){
            return  sqlSessionTemplate.selectOne(NAMESPACE+"getLibrarianId",admin);
        }else{
            return -1;
        }
    }

    public int deleteLibrarian(long admin_id){
        return sqlSessionTemplate.delete(NAMESPACE+"deleteLibrarian",admin_id);

    }

    public ArrayList<Admin> getAllLibrarian(){
        List<Admin> res = sqlSessionTemplate.selectList(NAMESPACE+"getAllLibrarian");
        return (ArrayList<Admin>) res;
    }

}
