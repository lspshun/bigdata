package com.lsp.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "UserCheckServlet", urlPatterns = "/UserCheckServlet")
public class UserCheckServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 解决乱码 - request/response中设置解析数据的编码方式
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        String userName = request.getParameter("userName");
        System.out.println(userName);
        // 经过网络传输后数据变为字符串类型
        if("sand".equals(userName)){
            response.getWriter().print(-1);
        }else {
            response.getWriter().print(1);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
