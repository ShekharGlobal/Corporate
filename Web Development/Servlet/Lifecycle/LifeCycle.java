package com.cdac.ServletEx;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/LifeCycle")
public class LifeCycle extends HttpServlet {
	private static final long serialVersionUID = 1L;

	//initialization of count variable
	private int count=0;
	
	public void init(ServletConfig config) {
		
		System.out.println("Servlet Initialized");
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		count++;
		PrintWriter out = response.getWriter();
		out.println(count);
		out.close();
	}
	
	public void destroy() {
		System.out.println("Servlet destroyed");
	}

}
