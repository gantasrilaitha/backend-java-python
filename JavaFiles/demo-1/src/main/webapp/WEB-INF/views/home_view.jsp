<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
    <title>Home Page</title>
</head>
<body>
    <h1>Welcome to the Home Page</h1>
    <p>Message: ${msg}</p>
	
	<%-- Declaration Tag --%>
    <%! int visitCount = 0; %>
    
    <%-- Scriptlet Tag --%>
    <%
        visitCount++;
        out.println("<p>Visit Count: " + visitCount + "</p>");
    %>
    
    <%-- Expression Tag --%>
    <p>Request Context Path: <%= request.getContextPath() %></p>
    
   
</body>
</html>
