package com.alwaysnearyou.controller.filters;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter("/*")
public class UserFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        HttpSession session = request.getSession(false);
        String loginURI = request.getContextPath() + "/logIn";
        String newAcURI = request.getContextPath() + "/new";
        String confirmURI = request.getContextPath() + "/confirmPage";
        String save = request.getContextPath() + "/save";
        String confirm = request.getContextPath() + "/confirm";

        boolean loggedIn = session != null && session.getAttribute("user") != null;
        boolean newAc = session != null && session.getAttribute("user") == null;
        boolean loginRequest = request.getRequestURI().equals(loginURI);
        boolean newAcRequest = request.getRequestURI().equals(newAcURI);
        boolean confirmURIRequest = request.getRequestURI().equals(confirmURI);
        boolean saveRequest = request.getRequestURI().equals(save);
        boolean confirmRequest = request.getRequestURI().equals(confirm);

        if (loggedIn || loginRequest) {
            filterChain.doFilter(request, response);
        }else if (newAcRequest && newAc){
            filterChain.doFilter(request, response);
        }else if (saveRequest){
            filterChain.doFilter(request, response);
        }else if (confirmRequest){
            filterChain.doFilter(request, response);
        }else if (confirmURIRequest && newAc){
            filterChain.doFilter(request, response);
        }else {
            response.sendRedirect(loginURI);
        }
    }

    @Override
    public void destroy() {
        //TODO: nothing here
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        //TODO: nothing here
    }

}
