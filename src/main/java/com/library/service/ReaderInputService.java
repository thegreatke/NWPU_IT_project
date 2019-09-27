package com.library.service;

import com.library.bean.ReaderCard;
import com.library.bean.ReaderInfo;
import com.library.bean.ReaderInput;
import com.library.dao.ReaderCardDao;
import com.library.dao.ReaderInfoDao;
import com.library.dao.ReaderInputDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;

@Service
public class ReaderInputService {

    @Autowired
    ReaderInputDao readerInputDao;

    @Autowired
    ReaderInfoDao readerInfoDao;

    @Autowired
    ReaderCardDao readerCardDao;


    public int addRead(ReaderInput read){ return readerInputDao.addReader(read);}

    public ArrayList<ReaderInput> getAllRead(){return readerInputDao.getAllReader();}


    private ReaderInfo getreaderinfo(long readerId, String name, String sex, Date birth, String address, String phone, String email){
        ReaderInfo readerInfo = new ReaderInfo();
        readerInfo.setReaderId(readerId);
        readerInfo.setName(name);
        readerInfo.setSex(sex);
        readerInfo.setBirth(birth);
        readerInfo.setAddress(address);
        readerInfo.setPhone(phone);
        readerInfo.setEmail(email);
        return  readerInfo;
    }

    public int inserReader(long readId){
        ReaderInput readerInput = readerInputDao.getReaderByid(readId);
        long readerId = readerInput.getReaderId();
        String name = readerInput.getName();
        String sex = readerInput.getSex();
        Date birth = readerInput.getBirth();
        String address = readerInput.getAddress();
        String phone = readerInput.getPhone();
        String email = readerInput.getEmail();

        ReaderInfo readerInfo =getreaderinfo(readerId, name, sex,  birth, address,  phone, email);

        String username = readerInput.getUsername();
        String password = readerInput.getPassword();

        long addreadinfo = readerInfoDao.addReaderInfo2(readerInfo);

        int addreadcard = readerCardDao.addReaderCard(readerInfo,password);

        if(addreadcard>0 & addreadinfo>0)
            return 1;
        else return 0;
    }


}
