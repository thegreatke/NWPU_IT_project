package com.library.service;
import com.library.bean.Order;
import com.library.dao.OrderDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
@Service
public class OrderService {
    @Autowired
    private OrderDao orderDao;
    public boolean orderBook(long order_id,long book_id,long reader_id){
        return orderDao.addOrderBook(book_id,reader_id)>0 && orderDao.updateOrderBook(order_id)>0;
    }
    public ArrayList<Order> orderList(){
        return orderDao.orderList();
    }

    public ArrayList<Order> getAllOrder(long reader_id) {
        return orderDao.getAllOrders(reader_id);
    }

    public boolean deleteOrder(long order_id) {
        return orderDao.deleteOrder(order_id) > 0;
    }

    public boolean finishOrder(long order_id ,long book_id,long  reader_id) {
        return orderDao.finishOrder(book_id,reader_id) > 0 && orderDao.deleteOrder(order_id) > 0;
    }
}
