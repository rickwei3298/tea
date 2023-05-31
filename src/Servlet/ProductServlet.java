package Servlet;

import JavaBean.Member;
import JavaBean.Order;
import JavaBean.Product;
import Service.ProductService;
import com.alibaba.fastjson.JSON;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/Product/*")
public class ProductServlet extends BaseServlet {
    ProductService productService = new ProductService();

    public void selectAll(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Product> products = productService.selectAll();
        String jsonString = JSON.toJSONString(products);
        resp.setContentType("text/json;charset=utf-8");
        resp.getWriter().write(jsonString);

    }

    public void setProduct(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/json;charset=utf-8");
        BufferedReader br = req.getReader();
        PrintWriter writer = resp.getWriter();
        String jsonString = br.readLine();
        Product product = JSON.parseObject(jsonString, Product.class);
        if (product.getPrice() == null) {
            writer.write("{\"state\":false,\"message\":\"價格請輸入數字\"}");
            return;
        }
        productService.setProduct(product);
        writer.write("{\"state\":true,\"message\":\"更新資料成功\"}");


    }

    public void add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/json;charset=utf-8");
        BufferedReader br = req.getReader();
        PrintWriter writer = resp.getWriter();
        String jsonString = br.readLine();
        Product product = JSON.parseObject(jsonString, Product.class);

        if (product.getPrice() == null) {
            writer.write("{\"state\":false,\"message\":\"價格請輸入數字\"}");
            return;
        }
        productService.add(product);
        writer.write("{\"state\":true,\"message\":\"新增資料成功\"}");

    }

    public void deleteById(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/json;charset=utf-8");
        BufferedReader br = req.getReader();
        PrintWriter writer = resp.getWriter();
        String jsonString = br.readLine();
        Product product = JSON.parseObject(jsonString, Product.class);

        productService.deleteById(product.getId());
        writer.write("{\"state\":true,\"message\":\"刪除資料成功\"}");


    }

}
