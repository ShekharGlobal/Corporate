package com.cdac.ServletEx;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// Map this servlet to "/CurrentDate"
@WebServlet("/CurrentDate")
public class CurrentDate extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Create a Calendar instance to get the current date and time
        Calendar calendar = new GregorianCalendar();
        String date = calendar.getTime().toString();

        // Set the message attribute
        String message = "Current Date is: " + date;
        request.setAttribute("message", message);

        // Forward to the next servlet
        RequestDispatcher dispatcher = request.getRequestDispatcher("DisplayServlet");
        dispatcher.forward(request, response);
    }
}
