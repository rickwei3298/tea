package Servlet;

import JavaBean.Member;
import JavaBean.Order;
import Service.OrderService;
import com.alibaba.fastjson.JSON;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/Order/*")
public class OrderServlet extends BaseServlet {
    OrderService orderService = new OrderService();

    public void add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/json;charset=utf-8");
        BufferedReader br = req.getReader();
        PrintWriter writer = resp.getWriter();
        String jsonString = br.readLine();
        Order order = JSON.parseObject(jsonString, Order.class);
        orderService.add(order);
        writer.write("{\"state\":true,\"message\":\"新增資料成功\"}");

    }

    public void selectAll(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<Order> orders = orderService.selectAll();
        String jsonString = JSON.toJSONString(orders);
        resp.setContentType("text/json;charset=utf-8");
        resp.getWriter().write("{\"state\":true,\"message\":\"讀取成功\",\"data\":" + jsonString + "}");

    }

    public void deleteById(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/json;charset=utf-8");
        BufferedReader br = req.getReader();
        PrintWriter writer = resp.getWriter();
        String jsonString = br.readLine();
        Order order = JSON.parseObject(jsonString, Order.class);
        if(!orderService.deleteById(order.getId())){
            writer.write("{\"state\":false,\"message\":\"刪除資料失敗\"}");
            return;
        }

        writer.write("{\"state\":true,\"message\":\"刪除資料成功\"}");

    }




}
