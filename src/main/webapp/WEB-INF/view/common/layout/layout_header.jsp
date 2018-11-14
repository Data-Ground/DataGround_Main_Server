<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>데이터놀이터, DataGround</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" type="text/css" href="<c:url value='/css/bootstrap-sketch.min.css' />"></link>
<style type="text/css">
.container {
	width: 1170px;
}

footer {
	position: fixed;
	bottom: 0px;
	width: 100%;
	height: 50px;
}
#body-wrapper {
	margin-top: 60px;
}
</style>
<script src="<c:url value='/js/jquery-3.3.1.min.js' />" type="text/javascript"></script>
<script src="<c:url value='/js/bootstrap.js' />" type="text/javascript"></script>
<script type="text/javascript">
	var message = "${param.message}";
	if ( message != "" ) {
		alert(message);
	}
	var message = "${message}";
	if ( message != "" ) {
		alert(message);
	}
</script>
</head>
<body>

<div id = "wrapper">
	<header>
		<jsp:include page="/WEB-INF/view/common/navigation.jsp" />
	</header>
	<section id="body-wrapper">
		<section style="margin-bottom: 48px;">
			
		