package com.contactUsProject.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.contactUsProject.dao.RequestDao;
import com.contactUsProject.model.Request;


@WebServlet("/contactus")
public class ContactusServlet extends HttpServlet {
	 private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
		 RequestDispatcher rd= request.getRequestDispatcher("contactus.jsp");
		rd.forward(request, response);
	 }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String fullName = request.getParameter("user_name");
        String email = request.getParameter("user_email");
        String message = request.getParameter("user_message");
        
        try {
	    	 Request req = new Request(fullName, email, message);
	         RequestDao requestdao = new RequestDao();
			 RequestDao.insertRequest(req);
			 response.getWriter().println("Data stored successfully in the database.");
		} catch (SQLException e) {
			e.printStackTrace();
		}
    }
    
}

