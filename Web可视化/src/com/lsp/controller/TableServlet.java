package com.lsp.controller;

import com.lsp.service.TableService;
import com.lsp.service.impl.TableServiceImpl;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@WebServlet(name = "TableServlet",urlPatterns = "/TableServlet")
public class TableServlet extends HttpServlet {

    private TableService tableService = new TableServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        String method = request.getParameter("method");
        String tableName = request.getParameter("tableName");
        switch (method){
            case "getTableInfo" : {
                Map<String,String> tableInfo = tableService.getTableInfo(tableName);
                response.getWriter().print(JSONObject.fromObject(tableInfo).toString());
                break;
            }
            case "getTableDataByArray" : {
                Map<String,List<String>> tableData = tableService.getTableDataArray(tableName);
                response.getWriter().print(JSONObject.fromObject(tableData).toString());
                break;
            }
            case "getTableDataByJson" : {
                List<Map<String,String>> tableData = tableService.getTableDataJson(tableName);
                response.getWriter().print(JSONArray.fromObject(tableData).toString());
                break;
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
