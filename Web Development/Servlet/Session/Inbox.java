package com.cdac.sessions;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Inbox
 */
@WebServlet("/Inbox")
public class Inbox extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
		HttpSession session = request.getSession();
        
        if (session.getAttribute("user") == null) {
            response.sendRedirect("session.html");
            return;
        }
        
        String userName = session.getAttribute("user").toString();
        String location = session.getAttribute("location").toString();
        
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
        out.print("<html><head><title>Inbox</title></head><body>");
        
        out.print("<h1 style='text-align:center;'>Inbox</h1>");
        
        out.print("<h2>Welcome " + userName + "</h2>");
        out.print("<h2>Location: " + location + "</h2>");
        
        out.print("<a href='SentItems'>Sent Items</a><br/>");
        
        out.print("<a href='Logout'>Log Out</a>");
        
        out.print("</body></html>");
    }

}
