package org.test.webapp;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public class RootServlet extends HttpServlet {
  @Override protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    //String delay = System.getProperty("delay");
    //int delay_int = Integer.parseInt(delay);

    try {
        Thread.sleep(60000);
    }
    catch (InterruptedException ie) {
        // Handle the exception
    }

    resp.getWriter().println(new Date());
    
    resp.getWriter().println("Request Info Servlet Requested");

    StringBuffer req_url = req.getRequestURL();
    resp.getWriter().println("Request URL " + req_url);

    String req_servlet_path = req.getServletPath();
    resp.getWriter().println("Request Servlet Path " + req_servlet_path);

    String req_remote_address = req.getRemoteAddr();
    resp.getWriter().println("Request Remote Address " + req_remote_address);
  
  }
}  
