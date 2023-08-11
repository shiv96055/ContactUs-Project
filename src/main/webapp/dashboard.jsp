<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Dashboard</title>
</head>
<body>
    <h1>Welcome to the Dashboard</h1>
    <h2>Active Requests</h2>
    <table>
        <thead>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Email</th>
                <th>Message</th>
                <th>Action</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${activeRequests}" var="request">
                <tr>
                    <td>${request.getId()}</td>
                    <td>${request.getName()}</td>
                    <td>${request.getEmail()}</td>
                    <td>${request.getMessage()}</td>
                    <td>
                        <form action="dashboard" method="post">
                            <input type="hidden" name="requestId" value="${request.getId()}">
                            <input type="hidden" name="status" value="false">
                            <input type = "submit" value = "Archive">
                        </form>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>

    <h2>Archived Requests</h2>
    <table>
        <thead>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Email</th>
                <th>Message</th>
                <th>Action</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${archivedRequests}" var="request">
                <tr>
                    <td>${request.getId()}</td>
                    <td>${request.getName()}</td>
                    <td>${request.getEmail()}</td>
                    <td>${request.getMessage()}</td>
                    <td>
                        <form action="dashboard" method="post">
                            <input type="hidden" name="requestId" value="${request.getId()}">
                            <input type="hidden" name="status" value="true">
                            <input type = "submit" value = "Active">
                        </form>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>
