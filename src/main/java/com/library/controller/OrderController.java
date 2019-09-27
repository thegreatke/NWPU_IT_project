package com.library.controller;

import com.alibaba.fastjson.JSONObject;
import com.library.bean.Order;
import com.library.bean.ReaderCard;
import com.library.service.BookService;
import com.library.service.LendService;
import com.library.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.time.Instant;
import java.util.Date;

@Controller
public class OrderController {
    @Autowired
    private LendService lendService;
    @Autowired
    private BookService bookService;
    @Autowired
    private OrderService orderService;

//    @ResponseBody  //
    @RequestMapping("/orderList")
    public ModelAndView  orderList(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView("admin_order_list");
        modelAndView.addObject("list", orderService.orderList());

//        return orderService.orderList().toString();
        return modelAndView;
    }
      //@ResponseBody
    @RequestMapping("/myorderList")
    public ModelAndView myOrder(HttpServletRequest request) {
        ReaderCard readerCard = (ReaderCard) request.getSession().getAttribute("readerCard");
        ModelAndView modelAndView = new ModelAndView("reader_order_list");
        modelAndView.addObject("list", orderService.getAllOrder(readerCard.getReaderId()));
       return modelAndView;
    }

    @RequestMapping("/overDeadline.html")
    public String overDeadline(HttpServletRequest request, RedirectAttributes redirectAttributes) throws ParseException {
        long book_id = Long.parseLong(request.getParameter("book_id"));
        if (orderService.overDeadline(book_id)) {
            redirectAttributes.addFlashAttribute("succeed", "记录删除成功！");
        } else {
            redirectAttributes.addFlashAttribute("error", "记录删除失败！");
        }
        return "redirect:/orderlist.html";
    }
    @ResponseBody
    @RequestMapping("/addOrderBook")
    public JSONObject  addOrderBook(long bookId,  long readerId) {
        JSONObject jsonObject = new JSONObject();
        //long bookId = Long.parseLong(request.getParameter("bookId"));
        //long readerId = ((ReaderCard) request.getSession().getAttribute("readerCard")).getReaderId();
        //long readerId = ((ReaderCard) request.getSession().getAttribute("readerCard")).getReaderId();
        if (orderService.addOrderBook(bookId, readerId)) {
            jsonObject.put("succeed", "图书预定成功！");
        } else {
            jsonObject.put("error", "图书预定失败！");
        }
        return jsonObject;
    }

    @ResponseBody
    @RequestMapping("/finishOrder")
    public JSONObject finishOrder(long bookId,  long readerId) {

        JSONObject jsonObject = new JSONObject();
//        long bookId = Long.parseLong(request.getParameter("bookId"));
//        long readerId = ((ReaderCard) request.getSession().getAttribute("readerCard")).getReaderId();
        //long readerId = ((ReaderCard) request.getSession().getAttribute("readerCard")).getReaderId();
        if (orderService.finishOrder(bookId, readerId)) {
            jsonObject.put("succeed", "图书借阅成功！");
        } else {
            jsonObject.put("error", "图书借阅失败！");
        }

        return jsonObject;
    }


    // TODO: 2019-09-26
    //  1.新增一条预订记录    传入参数，预订记录的所有属性（除了id），id自动分配， 返回json，装后面的字符串  1.successful add  2.failed。
    //  2.超时所以删除某条预订记录    传入参数，预订记录id, 返回json，装后面的字符串  1.successful add  2.failed。
    //  3.成功确认某条预约------------，分为两步，首先将此添加到lend_list中，然后删除此预订记录 返回json，装后面的字符串  1.successful add  2.failed。




}
