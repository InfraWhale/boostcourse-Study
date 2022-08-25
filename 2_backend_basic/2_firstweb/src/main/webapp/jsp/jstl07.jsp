<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:set var="t" value="<script type='text/javascript'>alert(1);</script>"/>

<%-- ${t } --%>
<c:out value="${t }" escapeXml="true"/> <!-- <script type='text/javascript'>alert(1);</script> -->
																				<!-- escapeXml="true"는 생략가능 -->
<%-- <c:out value="${t }" escapeXml="false"/> --%>
</body>
</html>