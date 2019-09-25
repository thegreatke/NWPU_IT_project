package com.library.dao;


import com.library.bean.Income;
import org.apache.ibatis.annotations.Param;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.*;

@Repository
public class IncomeDao {

    private final static String NAMESPACE = "com.library.dao.IncomeDao.";
    @Resource
    private SqlSessionTemplate sqlSessionTemplate;

    public ArrayList<Income> getAllIncome() {
        List<Income> result = sqlSessionTemplate.selectList(NAMESPACE + "getAllIncome");
        return (ArrayList<Income>) result;
    }


    public int addIncome(final Income income) {
        return sqlSessionTemplate.insert(NAMESPACE + "addIncome", income);
    }


    //  2019-09-23 返回某一天的所有收入记录的list
    public List<Income> getDayIncome(Date  date) {

        List<Income> incomeArrayList = new ArrayList<Income>();
        incomeArrayList =  sqlSessionTemplate.selectList(NAMESPACE + "getDayIncome", date);//, date

        return incomeArrayList;
    }

    public List<Income> getMonthIncome(@Param("month") int  month, @Param("year") int year) {

        Map<String, Integer> map_multy_param = new HashMap<String, Integer>();

        map_multy_param.put("month", month);
        map_multy_param.put("year", year);

        List<Income> incomeArrayList = new ArrayList<Income>();
        incomeArrayList =  sqlSessionTemplate.selectList(NAMESPACE + "getMonthIncome", map_multy_param);

        return incomeArrayList;
    }

    public List<Income> getYearIncome(int  year) {

        List<Income> incomeArrayList = new ArrayList<Income>();
        incomeArrayList =  sqlSessionTemplate.selectList(NAMESPACE + "getYearIncome", year);//, date

        return incomeArrayList;
    }

    //        income.setType(Income.Type.fine);

}
