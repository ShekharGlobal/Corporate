package com.cdac.ServletEx;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/HomeServlet")
public class HomeServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private ServletContext context;
    private String initCount;

    public void init(ServletConfig config) throws ServletException {
        super.init(config); // Ensure parent class init is called
        context = config.getServletContext();
        initCount = context.getInitParameter("initialCount");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String countValue;
        
        if (context.getAttribute("count") != null) {
            countValue = context.getAttribute("count").toString();
        } else {
            countValue = initCount;
        }
        
        int count = Integer.parseInt(countValue);
        count++;
        context.setAttribute("count", count);

		/*
		 * response.setContentType("text/html");
		 * response.getWriter().println("<html><body>");
		 * response.getWriter().println("<h1>Welcome! Site visit count updated to " +
		 * count + "</h1>"); response.getWriter().println("</body></html>");
		 */
    }
}
