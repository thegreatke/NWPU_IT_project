package com.library.service;

import com.library.bean.Income;
import com.library.dao.IncomeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.crypto.Data;
import java.util.Date;



@Service
public class IncomeService {

    // TODO: 2019/9/23  实现管理图书馆的收入记录，保存到数据库的income_list的表中去，实现增删改查

    @Autowired
    IncomeDao incomeDao;



    public boolean addIncome(final Income income) {
//        income.setType(Income.Type.fine);
                return incomeDao.addIncome(income) > 0;
    }


    // TODO: 2019-09-24  计算得到某天的所有收入
    public float getOneDayIncome(Date dayDate) {

        float dayIncome = 0;
        for(Income income:incomeDao.getDayIncome(dayDate)){

            dayIncome += income.getValue();

        }

         return dayIncome;
    }

}
