<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>insert</h1>
	<form id="insertForm" method="post" action="/DataGround/example/mongo/insert">
		<div>
			<input type="text" name="name" placeholder="가게명" />
		</div>
		<div>
			<input type="text" name="tel" placeholder="전화번호" />
		</div>
		<div>
			<select>
				<option id="korean">한식</option>
				<option id="japanese">일식</option>
				<option id="chinese">중식</option>
				<option id="western">양식</option>
			</select>
		</div>
		<div>
			<input type="text" name="menu[0]" placeholder="메뉴1" />
			<input type="text" name="menu[1]" placeholder="메뉴2" />
			<input type="text" name="menu[2]" placeholder="메뉴3" />
		</div>
		<div>
			<input type="submit" value="등록" />
		</div>
	</form>
	<hr>
	<h1>update</h1>
	<form id="updateForm" method="post" action="/DataGround/example/mongo/update">
		<div>
			<input type="text" name="id" placeholder="ID" />
			<input type="text" name="menu[0]" placeholder="추가메뉴1" />
		</div>
		<div>
			<input type="submit" value="메뉴추가등록" />
		</div>
	</form>
	<hr>
	<h1>delete</h1>
	<form id="deleteForm" method="post" action="/DataGround/example/mongo/delete">
		<div>
			<input type="text" name="id" placeholder="ID" />
		</div>
		<div>
			<input type="submit" value="삭제" />
		</div>
	</form>
	<hr>
	<a href="/DataGround/example/mongo/list">List보기</a>
</body>
</html>