<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
<link rel="stylesheet" href="/resources/css/member/main.css">
</head>
<body>
	<h1>회원가입</h1>
	<h3>회원정보를 입력하세요.</h3>
<!-- 	 1) post로 하면 쿼리스트링이 안보인다. -->
	<form action="/member/register.do" method="post">
		<fieldset>
			<legend>회원가입</legend>
				<ul>
					<li>
						<label for="id">아이디</label>
						<input type="text" id="id" name="id">  <!--기능을 위한 id, 쿼리스트링 생성을 위한 name -->
					</li>
					<li>
						<label for="password">비밀번호</label>
						<input type="password" id="password" name="password">  <!--기능을 위한 id, 쿼리스트링 생성을 위한 name -->
					</li>
					<li>
						<label for="name">이름</label>
						<input type="text" id="name" name="name">  <!--기능을 위한 id, 쿼리스트링 생성을 위한 name -->
					</li>
					<li>
						<label for="age">나이</label>
						<input type="text" id="age" name="age">  <!--기능을 위한 id, 쿼리스트링 생성을 위한 name -->
					</li>
					<li>
						<label for="gender">성별</label>
						성별 :
						남자 <input type="radio" name="gender" value="M">
						여자 <input type="radio" name="gender" value="F">
<!-- 						<input type="text" id="gender" name="gender">  기능을 위한 id, 쿼리스트링 생성을 위한 name -->
					</li>
					<li>
						<label for="email">이메일</label>
						<input type="text" id="email" name="email">  <!--기능을 위한 id, 쿼리스트링 생성을 위한 name -->
					</li>
					<li>
						<label for="phone">전화번호</label>
						<input type="text" id="phone" name="phone">  <!--기능을 위한 id, 쿼리스트링 생성을 위한 name -->
					</li>
					<li>
						<label for="address">주소</label>
						<input type="text" id="address" name="address">  <!--기능을 위한 id, 쿼리스트링 생성을 위한 name -->
					</li>
					<li>
						<label for="hobby">취미</label>
						<input type="text" id="hobby" name="hobby">  <!--기능을 위한 id, 쿼리스트링 생성을 위한 name -->
					</li>
				</ul>
		</fieldset>
		<input type="submit" value="가입">
	<input type="reset" value="초기화">
	</form>
</body>
</html>