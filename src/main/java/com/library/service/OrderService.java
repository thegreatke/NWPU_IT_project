package com.library.service;

import com.library.bean.Order;
import com.library.dao.OrderDao;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

// TODO:   差不多模仿 LendService中借书服务类中的写法实现下面的数据访问方法
@Service
public class OrderService {



    public boolean orderBook(Long bookId, long readId) {
        // TODO:
        //   这个是添加预定书籍的记录，向order_list的表中添加一条
        //  大概像这样 return orderDao.add(bookId, long readId) > 0;
        return true;//需要删除
    }


    // TODO: 实现返回所有的预定记录
      public ArrayList<Order> getAllOrder() {

         //return OrderDao.getAllBooks();  orderDao中的这个getAllBooks方法需要去实现
         return null;//需要删除
        }
    //


    // TODO: 2019/9/23  实现删除某一条预约记录
          public boolean deleteOrder(Long orderId) {
          //  return OrderDao.deleteOrder(orderId) > 0;   orderDao中的这个deleteOrder方法需要去实现
              return true;//需要删除

          }

    // TODO: 2019/9/23  实现预定后，规定时间内读者前来借书成功，让某一条预定记录变成一条借书记录
    //      public boolean finishOrder(Long orderId , Long reader_id) {
    //        return ??? > 0;
    //    }
}
