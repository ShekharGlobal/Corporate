package com.cdac.ServletEx;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

@WebServlet("/DisplayCount")
public class DisplayCount extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ServletContext context;

	public void init(ServletConfig config) throws ServletException {
		super.init(config); // Ensure parent class init is called
		context = config.getServletContext();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");

		String count = context.getAttribute("count").toString();

		out.print("<html><head><title>Display Count</title></head>");
		out.print("<body>");
		out.print("<h1>The Site was visited " + count + " times</h1>");
		out.print("</body></html>");

		//context.removeAttribute("count");
	}
}
