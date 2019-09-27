package com.library.service;


import com.library.bean.Admin;
import com.library.dao.AdminDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class AdminService {
    @Autowired
    AdminDao adminDao;


    public long addLibrarian(Admin admin){ return adminDao.addLibrarian(admin);}

    public boolean deleteLibrarian(long adminId){return adminDao.deleteLibrarian(adminId)>0;}

    public ArrayList<Admin> getAllLibrarian(){return adminDao.getAllLibrarian();}
}
