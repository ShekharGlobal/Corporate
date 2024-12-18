package com.cdac.ServletEx;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(urlPatterns = { "/ConfigDemo" }, initParams = {
		@WebInitParam(name = "adminEmail", value = "admin@coforge.com") })
public class ConfigDemo extends HttpServlet {
	private String adminEmail;

	public void init(ServletConfig config) throws ServletException {
		adminEmail = config.getInitParameter("adminEmail");
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		out.print("<html><head>");
		out.print("<title>Config Demo</title>");
		out.print("</head>");
		out.print("<body>");
		out.print("<h1>The Admin Email is: " + adminEmail + "</h1>");
		out.print("</body>");
		out.print("</html>");
	}
}
