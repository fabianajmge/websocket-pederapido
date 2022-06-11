package com.websocket.pederapido.config;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;

@Component
public class CorsFilter implements Filter {

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;
        ArrayList<String> urlsPermitidas = new ArrayList<String>();
        urlsPermitidas.add("http://localhost:4200");
        urlsPermitidas.add("http://ec2-44-203-56-241.compute-1.amazonaws.com:8081");
        urlsPermitidas.add("http://localhost:8080");
        urlsPermitidas.add("http://34.201.0.139:8080");
        String urlCross = "*";
        
        if (urlsPermitidas.contains(request.getHeader("Origin"))) {
        	urlCross = request.getHeader("Origin");
        }

        response.setHeader("Access-Control-Allow-Origin", urlCross);
        response.setHeader("Access-Control-Allow-Credentials", "true");

        if ("OPTIONS".equals(request.getMethod()) && urlCross.equals(request.getHeader("Origin"))) {
            response.setHeader("Access-Control-Allow-Methods", "POST, GET, DELETE, PUT, OPTIONS");
            response.setHeader("Access-Control-Allow-Headers", "Authorization, Content-Type, Accept");
            response.setHeader("Access-Control-Max-Age", "3600");

            response.setStatus(HttpServletResponse.SC_OK);
        } else {
            chain.doFilter(req, resp);
        }

    }

    @Override
    public void destroy() {
    }

    @Override
    public void init(FilterConfig arg0) throws ServletException {
    }

}