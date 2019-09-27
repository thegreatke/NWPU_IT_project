package com.library.dao;


import com.library.bean.Admin;
import com.library.bean.ReaderInput;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ReaderInputDao {

    private final static String NAMESPACE = "com.library.dao.ReaderInputDao.";
    @Resource
    private SqlSessionTemplate sqlSessionTemplate;

    public ArrayList<ReaderInput> getAllReader(){
        List<ReaderInput> res = sqlSessionTemplate.selectList(NAMESPACE+"getread");
        return (ArrayList<ReaderInput>) res;
    }

    public  final int addReader(final ReaderInput read){
        if (sqlSessionTemplate.insert(NAMESPACE+"addread",read)>0){
            return  1;
        }else{
            return -1;
        }
    }

    public ReaderInput getReaderByid(long readerId){
        return sqlSessionTemplate.selectOne(NAMESPACE+"getreadbyid",readerId);
    }


}
