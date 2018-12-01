package com.dylan.demo.filter;



import com.dylan.demo.bean.User;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


public class LoginFilter implements Filter {

    public LoginFilter() {
    }

    public void destroy() {
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {


        HttpServletRequest req = (HttpServletRequest)request;

        HttpServletResponse rep = (HttpServletResponse)response;

        HttpSession session = req.getSession();

        User user = (User) session.getAttribute("user");


        StringBuffer url = req.getRequestURL();

        if(user != null) {
            chain.doFilter(req, rep);
        }else if(url.toString().contains("/login.jsp")) {	//放行登录页面
            chain.doFilter(req, rep);
        }else if(url.toString().contains("/login")) {	//放行登录页面
            chain.doFilter(req, rep);
        }else if(url.toString().contains("/assets/")) {	//放行静态页面
            chain.doFilter(req, rep);
        }else if(url.toString().contains("/regist.jsp")) {	//放行登陆请求
            chain.doFilter(req, rep);
        }else if(url.toString().contains("/regist")) {	//放行登录页面
            chain.doFilter(req, rep);
        }else {
            rep.sendRedirect(req.getContextPath() + "/login.jsp");
        }

    }

    public void init(FilterConfig fConfig) throws ServletException {
    }

}
