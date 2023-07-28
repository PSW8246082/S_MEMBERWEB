<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>마이페이지</title>
<link rel="stylesheet" href="/resources/css/member/main.css">
</head>
<body>
	<h1>마이페이지</h1>
	<form action="/member/update.do" method="post">
<fieldset>
	<legend>회원상세정보</legend>
	<ul>
		<li>
		<label for="id">아이디</label> 
		<input type="text" id="id" name="id" value="${member.memberId}"readonly }> <!--기능을 위한 id, 쿼리스트링 생성을 위한 name -->
		</li>
		<li>
		<label for="password">비밀번호</label> 
		<input type="password" id="password" name="password"> 
		</li>
		<li>
		<label for="name">이름</label> 
		<input type="text" id="name" name="name" value="${member.memberName}"readonly> <!--기능을 위한 id, 쿼리스트링 생성을 위한 name -->
		</li>
		<li>
		<label for="age">나이</label> 
		<input type="text" id="age" name="age" value="${member.memberAge}"readonly> <!--기능을 위한 id, 쿼리스트링 생성을 위한 name -->
		</li>
		<li>
		<label for="gender">성별</label> 
<!-- 		기존 성별 수정 코드의 오류를 막기 위해 적어주는 input태그, hidden으로 사용자에겐 보이지 않음 -->
		<input type="hidden" id="gender" name="gender" value="${member.memberGender }"> 
<%-- 		${member.memberGender }가  M이면 남자 --%>
		<c:if test="${member.memberGender eq 'M'}">남자</c:if>
<%-- 		${member.memberGender }가  F이면 여자 --%>
		<c:if test="${member.memberGender eq 'F'}">여자</c:if>
<!-- 		성별 수정 가능한 코드 -->
<%-- 		남자 <input type="radio" name="gender" value="M" <c:if test="${member.memberGender eq 'M'}">checked</c:if>>  --%>
<%-- 		여자 <input type="radio" name="gender" value="F" <c:if test="${member.memberGender eq 'F'}">checked</c:if>> --%>
		</li>
		<li>
		<label for="email">이메일</label> 
		<input type="text" id="email" name="email" value="${member.memberEmail}"readonly> <!--기능을 위한 id, 쿼리스트링 생성을 위한 name -->
		</li>
		<li>
		<label for="address">주소</label> 
		<input type="text" id="address" name="address" value="${member.memberAddress}"readonly> <!--기능을 위한 id, 쿼리스트링 생성을 위한 name -->
		</li>
		<li>
		<label for="phone">전화번호</label> 
		<input type="text" id="phone" name="phone" value="${member.memberPhone}"readonly> <!--기능을 위한 id, 쿼리스트링 생성을 위한 name -->
		</li>
		<li>
		<label for="hobby">취미</label> 
		<input type="text" id="hobby" name="hobby" value="${member.memberHobby}"readonly> <!--기능을 위한 id, 쿼리스트링 생성을 위한 name -->
		</li>
		<li>
		<label for="date">가입날짜</label> 
		<input type="text" id="date" name="date" value="${member.memberDate}"readonly> <!--기능을 위한 id, 쿼리스트링 생성을 위한 name -->
		</li>
	</ul>
</fieldset>
	<div>
		<button>수정하기</button>
		<a href="javascript:void(0)" onclick="checkDelete();">탈퇴하기</a>
		<!-- <button>탈퇴하기</button> 버튼 or 링크 선택 가능 -->
	</div>
	</form>
	<script>
	function checkDelete() {
		const memberId = "${sessionScope.memberId}";
		if(confirm("탈퇴하시겠습니까?")) {
			location.href = "/member/delete.do?memberId=" + memberId;
		}
	}
	</script>
</body>
</html>