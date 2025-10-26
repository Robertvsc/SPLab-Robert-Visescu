package com.splab.proiect;

import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import javax.servlet.FilterChain;        
import javax.servlet.ServletException;   
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse; 
import java.io.IOException;


@Component
public class RequestLoggingFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request, 
                                    HttpServletResponse response, 
                                    FilterChain filterChain) 
            throws ServletException, IOException {

        
        System.out.println(
            "RequestLoggingFilter: Început procesare request: " + 
            request.getMethod() + " " + request.getRequestURI()
        );

       
        filterChain.doFilter(request, response);

        
        System.out.println(
            "RequestLoggingFilter: Terminat procesare request: " + 
            request.getMethod() + " " + request.getRequestURI()
        );
    }
}