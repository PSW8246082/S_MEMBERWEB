<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>멤버웹</title>
</head>
<body>
<	<jsp:include page="/header.html"></jsp:include>
	<h1>멤버웹페이지</h1>
	<h2>로그인 페이지</h2>
	<c:if test="${sessionScope.memberId ne null }">
	${sessionScope.memberName} 님 환영합니다.<br>
	 <a href="/member/logout.do">로그아웃</a> 
<!-- 	a태그에서는 직접 name값 적어줘야함 -->
	<a href="/member/myInfo.do?member-id=${memberId}">마이페이지</a>   
	</c:if>
	<c:if test="${memberId eq null}">
		<fieldset>
			<legend>로그인</legend>
			<form action="/member/login.do" method="post">
				<input type="text" name="member-id"><br> 
				<input type="password" name="member-pw"><br>
				<div>
					<input type="submit" value="로그인"> 
					<input type="reset"value="취소">
					<a href="/member/register.do">회원가입</a>
				</div>
			</form>
		</fieldset>
	</c:if>
</body>
</html>
