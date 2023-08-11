package com.contactUsProject.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.contactUsProject.dao.RequestDao;
import com.contactUsProject.model.Request;

@WebServlet("/dashboard")
public class DashboardServlet extends HttpServlet {
    private RequestDao requestDao;

    @Override
    public void init() throws ServletException {
        super.init();
        requestDao = new RequestDao();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Request> activeRequests = RequestDao.fetchRequests(true);
        List<Request> archivedRequests = RequestDao.fetchRequests(false);

        request.setAttribute("activeRequests", activeRequests);
        request.setAttribute("archivedRequests", archivedRequests);

        request.getRequestDispatcher("/dashboard.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int requestId = Integer.parseInt(request.getParameter("requestId"));
        boolean status = Boolean.parseBoolean(request.getParameter("status"));

        RequestDao.changeStatus(requestId, status);

        response.sendRedirect(request.getContextPath() + "/dashboard");
    }

}
