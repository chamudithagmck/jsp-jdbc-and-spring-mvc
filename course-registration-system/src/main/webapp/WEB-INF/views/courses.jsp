<%--
  Created by IntelliJ IDEA.
  User: GMCha
  Date: 5/9/2025
  Time: 6:25 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Courses</title>
</head>
<body>
<h2>Available Courses</h2>
<table border="1">
    <tr>
        <th>Name</th>
        <th>Instructor</th>
        <th>Credits</th>
        <th>Action</th>
    </tr>
    <c:forEach var="course" items="${courses}">
        <tr>
            <td>${course.name}</td>
            <td>${course.instructor}</td>
            <td>${course.credits}</td>
            <td>
                <form method="post" action="register">
                    <input type="hidden" name="courseId" value="${course.courseId}" />
                    <input type="submit" value="Register" />
                </form>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
