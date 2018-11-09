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
				아이디 : ${store.id }
			</div>
			<div>
				이름 : ${store.name }
			</div>
			<div>
				전화번호 : ${store.tel }
			</div>
			<div>
				${store.type }
			</div>
			<c:forEach var="dish" items="${store.menu }">
				<div>
					&emsp;${dish }
				</div>
			</c:forEach>
			<div>
				등록일 : ${store.writeDate.toString("y-M-d") }
			</div>
			<div>
				수정일 : ${store.modifyDate.toString("y-MM-dd") }
			</div>
		</div>
	</c:forEach>
	<hr>
	<a href="/DataGround/example/mongo/form">Form보기</a>
</body>
</html>