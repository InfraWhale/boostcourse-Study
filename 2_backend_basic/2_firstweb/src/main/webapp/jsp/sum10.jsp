<%--4-1. JSP 들어가기 --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%> <%--페이지 지시문 --%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<% 
    int total = 0;
    for(int i = 1; i <= 10; i++){
        total = total + i;
    } //Scriptlet
%>

1부터 10까지의 합 : <%=total %> <%-- out.print(total)과 같다고 생각하면 됨 --%>
</body>
</html>