package com.anyport.AnyPort.configuration;

import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CorsFilter2 extends OncePerRequestFilter {


    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        response.setHeader("Access-Control-Allow-Origin","*");
        response.setHeader("Access-Control-Allow-Method","GET,POSt,PUT,DELETE,OPTIONS");
        response.setHeader("Access-Control-Allow-Headers","authorization,xsrf-tocken,Cache-Control");
        response.setHeader("Access-Control-Expose-Headers","xsrf-tocken");
        if("OPTIONS".equals(request.getMethod())){
            response.setStatus(HttpServletResponse.SC_OK);
        }
        else{
            filterChain.doFilter(request,response);
        }

    }
}
