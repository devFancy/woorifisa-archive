<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<!-- 태그 lib 사용 / head 태그 내부에 작성 -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

</head>
<body>
<h2>기존 커피 수정</h2>
    <form action="update-coffee" method="POST">
    	<label for="coffee-id">커피 ID:</label>
        <input type="text" id="coffee-id" name="coffeeId" value="${menu.id}">
        <label for="coffee-name">커피 이름:</label>
        <input type="text" id="coffee-name" name="coffeeName" value="${menu.name}">
        <p>커피 사이즈를 선택하세요 :)</p>
          <input type="radio" id="tall" name="coffeeSize" value="TALL" ${menu.size eq 'TALL' ? 'checked' : ''}>
          <label for="tall">TALL</label><br>
          <input type="radio" id="grande" name="coffeeSize" value="GRANDE" ${menu.size eq 'GRANDE' ? 'checked' : ''}>
          <label for="grande">GRANDE</label><br>
          <input type="radio" id="venti" name="coffeeSize" value="VENTI" ${menu.size eq 'VENTI' ? 'checked' : ''}>
          <label for="venti">VENTI</label>
        <br /><br />
        <label for="coffee-price">가격:</label>
        <input type="number" id="coffee-price" name="coffeePrice" value="${menu.price}">
        <br /><br />
        <button type="submit">수정하기</button>
    </form>
</body>
</html>