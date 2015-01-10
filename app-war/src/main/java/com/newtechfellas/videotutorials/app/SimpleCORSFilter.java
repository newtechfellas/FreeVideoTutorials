package com.newtechfellas.videotutorials.app;

import com.google.appengine.repackaged.com.google.common.collect.Lists;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: suman
 * Date: 8/19/14.
 * Time: 1:14 PM
 */
public class SimpleCORSFilter implements Filter {

    private List<String> allowedOrigins = Lists.newArrayList("http://localhost:1841", "http://free-video-tutorials.appspot.com");

    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
        HttpServletResponse response = (HttpServletResponse) res;
        HttpServletRequest httpReq = (HttpServletRequest) req;

        addCORSHeaders(httpReq, response);

        chain.doFilter(req, res);
    }

    private void addCORSHeaders(HttpServletRequest req, HttpServletResponse response) {
        String origin = req.getHeader("origin");

        if ( allowedOrigins.contains(origin)) {
            response.setHeader("Access-Control-Allow-Origin", origin);
        }

        response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
        response.setHeader("Access-Control-Max-Age", "3600");
        response.setHeader("Access-Control-Allow-Headers", "x-requested-with, Content-Type");
    }

    public void init(FilterConfig filterConfig) {}

    public void destroy() {}

}
