package com.tools;

import java.io.IOException;  
import java.util.ArrayList;  
import java.util.List;  
  
import javax.servlet.Filter;  
import javax.servlet.FilterChain;  
import javax.servlet.FilterConfig;  
import javax.servlet.ServletException;  
import javax.servlet.ServletRequest;  
import javax.servlet.ServletResponse;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  
  
public class BugFilter implements Filter {  
      
    private List<String> keywords = new ArrayList<String>();  
  
    public BugFilter() {  
    }  
  
    public void destroy() {  
    }  
  
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {  
        HttpServletRequest req = (HttpServletRequest)request;  
        HttpServletResponse res = (HttpServletResponse)response; 
        req.setCharacterEncoding("utf-8");
     
        
       if(!isBugInvade(req)) {//如果BUG入侵  
            chain.doFilter(request, response);  
      } else {  
            res.reset();  
            res.setContentType("text/html; charset=UTF-8");  
            res.getWriter().println("检测到入侵");  
        } 
         
    }  
      
    private boolean isBugInvade(HttpServletRequest request) {  
        //get  
        String queryString = request.getQueryString(); 
       // System.out.println("======================================================================"+queryString);
        if(queryString != null) {  
            for(String keyword : keywords) {  
                if(queryString.indexOf(keyword) != -1) {  
                    return true;  
                }  
            }  
        }  
        //post  
        java.util.Enumeration<String> e = request.getParameterNames(); 
        
        while(e.hasMoreElements()) {  
            String parName = e.nextElement();  
            for(String keyword : keywords) { 
            	//System.out.println("======================================================================"+keyword);
                if(parName.indexOf(keyword) != -1) {  
                    return true;  
                }  
            }  
        }  
        return false;  
    }  
  
    public void init(FilterConfig fConfig) throws ServletException {  
        keywords.add("getWriter");  
        keywords.add("FileOutputStream");  
        keywords.add("getRuntime");  
        keywords.add("getRequest");  
        keywords.add("getProperty");  
        keywords.add("\\u0023");  
        keywords.add("\\43");  
    }  
  
}  
