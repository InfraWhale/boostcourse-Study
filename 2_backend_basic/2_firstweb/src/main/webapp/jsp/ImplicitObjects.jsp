<%--4-4. JSP 내장객체 --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
    StringBuffer url = request.getRequestURL(); // 내장객체들 실습
    
    out.print("url :" + url.toString());
    out.print("<br>");
%>
</body>
</html>