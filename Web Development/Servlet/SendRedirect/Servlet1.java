package com.cdac.ServletEx;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Servlet1")
public class Servlet1 extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Set a message as an attribute to forward to Servlet2
        request.setAttribute("message", "Forwarded to Servlet2");

        // Forward the request to Servlet2
        RequestDispatcher dispatcher = request.getRequestDispatcher("Servlet2");
        dispatcher.forward(request, response);
        
        //response.sendRedirect("Servlet2");
    }
}

