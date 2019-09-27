package com.library.service;
import com.library.bean.Order;
import com.library.dao.LendDao;
import com.library.dao.OrderDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

@Service
public class OrderService {
    @Autowired
    private OrderDao orderDao;
    @Autowired
    private LendDao lendDao;

    private DateFormat df =new SimpleDateFormat("yyyy-MM-dd hh:mm");

    public boolean addOrderBook(long book_id,long reader_id) {
        return orderDao.addOrderBookOne(book_id, reader_id) > 0 && orderDao.addOrderBookTwo(book_id) > 0;
    }
    public ArrayList<Order> orderList(){
        return orderDao.orderList();
    }

    public ArrayList<Order> getAllOrder(long reader_id) {
        return orderDao.getAllOrders(reader_id);
    }
    public boolean overDeadline(long book_id) throws ParseException {
//        Date dt1=df.parse(String.valueOf(Calendar.getInstance()));
//
//        // TODO: 2019/9/27
//        Date deadline ;
//
//        if (dt1.getTime() > deadline.getTime())
//            return orderDao.deleteOrder(book_id)>0 && orderDao.updateOrderBook(book_id)>0;
//        else
        return false;
    }

    public boolean finishOrder(long book_id,long  reader_id) {
        return lendDao.lendBookOne(book_id, reader_id) > 0 && orderDao.deleteOrder(book_id, reader_id) > 0;
    }
}
