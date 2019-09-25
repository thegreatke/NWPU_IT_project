package com.library.service;

import com.library.bean.Income;
import com.library.dao.IncomeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;


@Service
public class IncomeService {

    // TODO: 2019/9/23  实现管理图书馆的收入记录，保存到数据库的income_list的表中去，实现增删改查

    @Autowired
    IncomeDao incomeDao;



    public boolean addIncome(final Income income) {
//        income.setType(Income.Type.fine);
                return incomeDao.addIncome(income) > 0;
    }


    public float caculateIncome(List<Income> incomeList){
        float Income = 0;
        for(Income income:incomeList){
            Income += income.getValue();
        }
        return Income;
    }

    // 计算得到某天的所有收入
    public float getOneDayIncome(Date dayDate) {
         return caculateIncome(incomeDao.getDayIncome(dayDate));
    }


    // 计算得到某年某月的所有收入
    public float getMonthIncome(int month, int year) {
        return caculateIncome(incomeDao.getMonthIncome(month, year));
    }

    // 计算得到某年的所有收入
    public float getYearIncome(int year) {
        return caculateIncome(incomeDao.getYearIncome(year));
    }

}
