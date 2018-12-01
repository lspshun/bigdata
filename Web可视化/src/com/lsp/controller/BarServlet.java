package com.lsp.controller;

import net.sf.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "BarServlet", urlPatterns = "/BarServlet")
public class BarServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        String[] xAxisData = new String[]{"衬衫","羊毛衫","雪纺衫","裤子","高跟鞋","袜子"};
        int[] seriesData = new int[]{5, 20, 36, 10, 10, 20};
        Map<String, Object> map = new HashMap<>();
        map.put("xData", xAxisData);
        map.put("sData", seriesData);
        // String xData = JSONArray.fromObject(xAxisData).toString();
        // String series = JSONArray.fromObject(seriesData).toString();
        String data = JSONObject.fromObject(map).toString();
        PrintWriter out = response.getWriter();
        out.print(data);
        out.flush();
        // 将数据存放在request中
        // request.setAttribute("data", data);
        // 页面转发 - 同时发送数据
        // request.getRequestDispatcher("bar.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
