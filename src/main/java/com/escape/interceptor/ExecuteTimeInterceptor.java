package com.escape.interceptor;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.logging.Logger;

/**
 * Created by Sheikz on 8/26/2016.
 */
public class ExecuteTimeInterceptor extends HandlerInterceptorAdapter {

    private static final Logger logger = Logger.getLogger("ExecuteTimeInterceptor");
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        long startTime = System.currentTimeMillis();
        request.setAttribute("startTime", startTime);
        logger.info("Request: ["+request.getRequestURL()+"] start");
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

        long executeTime = System.currentTimeMillis() - (long)request.getAttribute("startTime");
        //logger.info("Request: ["+request.getRequestURL()+"] took "+executeTime+"ms");
    }
}
