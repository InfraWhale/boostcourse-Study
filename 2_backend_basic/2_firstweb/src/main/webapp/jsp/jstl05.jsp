<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%-- <c:import url="http://localhost:8080/firstweb/jsp/jstlValue.jsp" var="urlValue" scope="request"/> --%>
<c:import url="http://google.co.kr" var="urlValue" scope="request"/>
<%-- <c:import url="http://www.google.com/search" charEncoding="euc-kr" var="googleSearch" scope="request">
	<c:param name="q" value="cyberpunk"/> <!-- 시도해 보았으나 권한땜에 막혀따.. 403 code -->
</c:import> --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
${urlValue }
<%-- ${googleSearch } --%>
</body>
</html>