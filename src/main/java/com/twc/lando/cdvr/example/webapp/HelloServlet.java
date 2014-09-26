package com.twc.lando.cdvr.example.webapp;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 mvn clean compile jetty:run
 then browse to localhost:8080/cdvr/servlet
 root path is per WAR filename; context for /servlet is configured in web.xml
 */
public class HelloServlet extends HttpServlet
{
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        response.setContentType("text/html");
        response.setStatus(HttpServletResponse.SC_OK);
        response.getWriter().println("<h1>This is the Servlet</h1>");
        response.getWriter().println("session=" + request.getSession(true).getId());
    }
}