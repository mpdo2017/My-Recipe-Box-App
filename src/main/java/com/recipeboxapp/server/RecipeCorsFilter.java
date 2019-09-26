package com.recipeboxapp.server;

import java.io.IOException;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;

public class RecipeCorsFilter {


    /*
    the primary one that determines who can access a resource is Access-Control-Allow-Origin. This header specifies which origins can access the resource.
    https://auth0.com/blog/cors-tutorial-a-guide-to-cross-origin-resource-sharing/ (information found on this site)
     */
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
        response.setHeader("Access-Control-Max-Age", "3600");
        response.setHeader("Access-Control-Allow-Credentials", "true");
        response.setHeader("Access-Control-Allow-Headers", "Origin,Accept,X-Requested-With,Content-Type,Access-Control-Request-Method,Access-Control-Request-Headers,Authorization");
        if (request.getMethod().equals(HttpMethod.OPTIONS.name())) {
            response.setStatus(HttpStatus.NO_CONTENT.value());
        }
        else {
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }
}
