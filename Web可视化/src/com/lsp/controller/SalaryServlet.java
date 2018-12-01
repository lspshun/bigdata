package com.lsp.controller;

import com.lsp.bean.Teacher;
import com.lsp.service.SalaryService;
import com.lsp.service.impl.SalaryServiceImpl;
import net.sf.json.JSONArray;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "SalaryServlet",urlPatterns = "/SalaryServlet")
public class SalaryServlet extends HttpServlet {

    private SalaryService salaryService = new SalaryServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // String tableName = request.getParameter("tableName");
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        String tableName = "teacher";
        List<Teacher> teacherList = salaryService.getTeacherSalary(tableName);
        response.getWriter().print(JSONArray.fromObject(teacherList).toString());
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
