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

    Integer delayResponseMilliseconds = 0;

    // if the environment variable DELAY_RESPONSE is set, use 

    String delayResponseEnv = System.getenv("DELAY_RESPONSE");
    if ( delayResponseEnv != null ) {
        delayResponseMilliseconds = Integer.parseInt(delayResponseEnv) * 1000;
    }

    try {
        Thread.sleep(delayResponseMilliseconds);
    }
    catch (InterruptedException ie) {
        // Handle the exception
    }

    resp.getWriter().println(new Date());
    
    resp.getWriter().println("Delay Response Requested");

    resp.getWriter().println("Delay set to: " + (delayResponseMilliseconds / 1000 ) + " seconds");
    resp.getWriter().println("Delay set to: " + delayResponseMilliseconds + " milliseconds");

    StringBuffer reqUrl = req.getRequestURL();
    resp.getWriter().println("Request URL " + reqUrl);

    String reqServletPath = req.getServletPath();
    resp.getWriter().println("Request Servlet Path " + reqServletPath);

    String reqRemoteAddress = req.getRemoteAddr();
    resp.getWriter().println("Request Remote Address " + reqRemoteAddress);
  
  }
}  
