package com.library.dao;

import com.library.bean.Order;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Repository
public class OrderDao {
    @Resource
    private SqlSessionTemplate sqlSessionTemplate;

    private final static String NAMESPACE = "com.library.dao.OrderDao.";

    public int addOrderBook(final long book_id, final long reader_id) {
        Map<String, Object> map = new HashMap<>();
        map.put("book_id", book_id);
        map.put("reader_id", reader_id);
        return sqlSessionTemplate.insert(NAMESPACE + "addOrderBook", map);
    }

    public int updateOrderBook(final long order_id) {
        return sqlSessionTemplate.update(NAMESPACE + "updateOrderBook", order_id);
    }
    //所有 orderlist
    public ArrayList<Order> orderList() {
        List<Order> result = sqlSessionTemplate.selectList(NAMESPACE + "orderList");
        return (ArrayList<Order>) result;
    }
    //读者自己 orderlist
    public  ArrayList<Order> getAllOrders(final long reader_id) {
        List<Order> result = sqlSessionTemplate.selectList(NAMESPACE + "myOrderList",reader_id);
        return (ArrayList<Order>) result;
    }

    public  int deleteOrder(final long order_id) {
        return sqlSessionTemplate.delete(NAMESPACE + "deleteOrder", order_id);
    }
    public int finishOrder(final long book_id, final long reader_id) {
        Map<String, Object> map = new HashMap<>();
        map.put("book_id", book_id);
        map.put("reader_id", reader_id);
        return sqlSessionTemplate.insert(NAMESPACE + "lendBookOne", map);
    }
}
