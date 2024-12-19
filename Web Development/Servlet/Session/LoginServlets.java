package com.cdac.sessions;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/LoginServlets")
public class LoginServlets extends HttpServlet {
	@Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("pass");
        String location = request.getParameter("location");

        if ("jack".equals(username) && "rose".equalsIgnoreCase(password)) {
           
        	HttpSession session = request.getSession();
        	
            session.setAttribute("user", username);
            session.setAttribute("location", location);
            response.sendRedirect("Inbox");
        } else {
        	// Redirect to login page on failure
            response.sendRedirect("session.html"); 
        
             
        }
    }
}
