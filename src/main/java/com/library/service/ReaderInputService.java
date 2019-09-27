package com.library.service;

import com.library.bean.ReaderInput;
import com.library.dao.ReaderInputDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ReaderInputService {

    @Autowired
    ReaderInputDao readerInputDao;


    public int addRead(ReaderInput read){ return readerInputDao.addLibrarian(read);}

    public ArrayList<ReaderInput> getAllRead(){return readerInputDao.getAllLibrarian();}

}
