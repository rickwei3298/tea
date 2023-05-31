package Servlet;

import JavaBean.Member;
import JavaBean.Product;
import Service.MemberService;
import com.alibaba.fastjson.JSON;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.UUID;

@WebServlet("/Member/*")
public class MemberServlet extends BaseServlet {
    MemberService memberService = new MemberService();

    public void selectAll(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Member> members = memberService.selectAll();
        String jsonString = JSON.toJSONString(members);
        resp.setContentType("text/json;charset=utf-8");
        resp.getWriter().write("{\"state\":true,\"message\":\"讀取成功\",\"data\":" + jsonString + "}");

    }

    public void signUp(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/json;charset=utf-8");
        BufferedReader br = req.getReader();
        PrintWriter writer = resp.getWriter();
        String jsonString = br.readLine();
        Member member = JSON.parseObject(jsonString, Member.class);
        memberService.add(member);
        writer.write("{\"state\":true,\"message\":\"註冊會員成功\"}");
    }

    public void checkLogin(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/json;charset=utf-8");
        BufferedReader br = req.getReader();
        PrintWriter writer = resp.getWriter();
        String jsonString = br.readLine();
        Member member = JSON.parseObject(jsonString, Member.class);

        if ((member.getUsername()) == null || (member.getUsername()) == "" || (member.getPassword()) == null || (member.getPassword()) == "") {
            writer.write("{\"state\":false,\"message\":\"欄位有誤\"}");
            return;
        }
        if ((member = memberService.checkLogIn(member.getUsername(), member.getPassword())) == null) {
            writer.write("{\"state\":false,\"message\":\"登入失敗\"}");
            return;
        }
        memberService.setUid(UUID.randomUUID().toString(), UUID.randomUUID().toString(), member.getId());
        member = memberService.getMemberById(member.getId());
        jsonString = JSON.toJSONString(member);
        writer.write("{\"state\":true,\"message\":\"登入成功\",\"data\":" + jsonString + "}");

    }

    public void checkUsername(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/json;charset=utf-8");
        BufferedReader br = req.getReader();
        PrintWriter writer = resp.getWriter();
        String jsonString = br.readLine();
        Member member = JSON.parseObject(jsonString, Member.class);

        if ((member.getUsername()) == null || (member.getUsername()) == "") {
            writer.write("{\"state\":false,\"message\":\"欄位有誤\"}");
            return;
        } else if (!memberService.checkUsername(member.getUsername())) {
            writer.write("{\"state\":false,\"message\":\"帳號已使用\"}");
            return;
        }
        writer.write("{\"state\":true,\"message\":\"帳號可使用\"}");


    }

    public void checkUid(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/json;charset=utf-8");
        BufferedReader br = req.getReader();
        PrintWriter writer = resp.getWriter();
        String jsonString = br.readLine();
        Member member = JSON.parseObject(jsonString, Member.class);

        if ((member.getUid01()) == null || (member.getUid01()) == "" || (member.getUid02()) == null || (member.getUid02()) == "") {

            writer.write("{\"state\":false,\"message\":\"欄位有誤\"}");
            return;
        } else if ((member = memberService.checkUid(member.getUid01(), member.getUid02())) == null) {

            writer.write("{\"state\":false,\"message\":\"uid錯誤\"}");
            return;

        }
        jsonString = JSON.toJSONString(member);
        writer.write("{\"state\":true,\"message\":\"登入狀態確認成功\",\"data\":" + jsonString + "}");

    }

    public void setUserstate(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/json;charset=utf-8");
        BufferedReader br = req.getReader();
        PrintWriter writer = resp.getWriter();
        String jsonString = br.readLine();
        Member member = JSON.parseObject(jsonString, Member.class);

        if ((member.getUserState()) == null || (member.getId()) == null) {

            writer.write("{\"state\":false,\"message\":\"欄位有誤\"}");
            return;
        }
        memberService.setUserstate(member.getUserState(), member.getId());

        writer.write("{\"state\":true,\"message\":\"更新成功\"}");
    }


}



