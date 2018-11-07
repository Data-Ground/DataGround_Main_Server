<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="/DataGround/js/jquery-3.3.1.min.js" type="text/javascript"></script>
</head>
<body>
	<c:forEach var="store" items="${mongoExampleVOList }">
		<div style="border: 1px solid black">
			<div>
				${store.id }
			</div>
			<div>
				${store.name }
			</div>
			<div>
				${store.tel }
			</div>
			<div>
				${store.type }
			</div>
			<c:forEach var="dish" items="${store.menu }">
				<div>
					${dish }
				</div>
			</c:forEach>
		</div>
	</c:forEach>
	<hr>
	<a href="/DataGround/example/mongo/form">Form보기</a>
</body>
</html>