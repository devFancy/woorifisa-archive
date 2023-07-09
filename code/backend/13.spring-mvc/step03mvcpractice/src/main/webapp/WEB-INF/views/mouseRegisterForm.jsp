<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="add" method="POST">
		<label for="name">이름</label>
		<input id="name" type="text" name="name"><br/>
		
		<label for="country">국적</label>
		<input id="country" type="text" name="country"><br/>
		
		<label for="address">주소</label>
		<input id="address" type="text" name="address"><br/>
		
		<button type="submit">등록</button>
	</form>
</body>
</html>