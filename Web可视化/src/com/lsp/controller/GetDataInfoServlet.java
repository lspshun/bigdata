package com.lsp.controller;


import com.lsp.service.DataInfoService;
import com.lsp.service.impl.DataInfoServiceImpl;
import net.sf.json.JSONArray;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "GetDataInfoServlet",urlPatterns = "/GetDataInfoServlet")
public class GetDataInfoServlet extends HttpServlet {

    private DataInfoService dataInfoService = new DataInfoServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String method = request.getParameter("method");
        switch (method){
            case "getDatabase":{
                response.getWriter().print(JSONArray.fromObject(dataInfoService.getDatabaseName()));
                break;
            }
            case "getTable":{
                String databaseName = request.getParameter("databaseName");
                response.getWriter().print(JSONArray.fromObject(dataInfoService.getTableName(databaseName)));
                break;
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
