package com.lsp.controller;


import com.lsp.util.HiveUtil;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

@WebServlet(name = "CarServlet",urlPatterns = "/CarServlet")
public class CarServlet extends HttpServlet {

    private HiveUtil hiveUtil = new HiveUtil();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        ResultSet resultSet = hiveUtil.getCarData();
        Map<String,Double> innerData = new LinkedHashMap<>();
        List<Map<String,Double>> outerData = new ArrayList<>();
        try {
            while (resultSet.next()){
                String age = String.valueOf(resultSet.getInt(1));
                double count = resultSet.getDouble(2);
                String makeName = resultSet.getString(3);
                if (innerData.get(age) == null){
                    innerData.put(age,count);
                }else {
                    innerData.put(age,innerData.get(age) + count);
                }
                Map<String,Double> temp = new LinkedHashMap<>();
                temp.put(makeName,count);
                outerData.add(temp);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println(JSONObject.fromObject(innerData));
        System.out.println(JSONArray.fromObject(outerData));
        Map<String,Object> map = new HashMap<>();
        map.put("innerData",innerData);
        map.put("outerData",outerData);
        System.out.println(JSONObject.fromObject(map));
        response.getWriter().print(JSONObject.fromObject(map));
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
