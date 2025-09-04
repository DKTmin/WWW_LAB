<%@ page import="fit.se.model.Student" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Result submit</title>
</head>
<body>
<%
    Student student = (Student)request.getAttribute("student");
    out.println(
            "First name: " + student.getFirstName() +
                    "<br> Last name: " + student.getLastName() +
                    "<br> Email: " + student.getEmail() +
                    "<br> Gender: " + student.getGender() +
                    "<br> Birthday: " + student.getBirthDate()
    );
%>
</body>
</html>