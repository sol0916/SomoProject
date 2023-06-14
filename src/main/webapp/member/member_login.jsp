<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp" %>

<section>
	
	<div align="center" class="fs-3">
	<p>로그인</p> <br/>
	
	<form action="loginForm.mem" method="post" class="st">
		<input type="text" name="memId" placeholder="아이디"> <br/><br/>
		<input type="password" name="memPw" placeholder="비밀번호"> <br/><br/>
		
		<input type="submit" value="로그인" class="btn btn-lg btn-outline-dark">
		<input type="button" value="가입하기" onclick="location.href='member_join.mem'" class="btn btn-lg btn-outline-dark">
	
	</form>	
	
	<div>${msg }</div>
	
	</div>

</section>


<%@ include file="../include/footer.jsp" %>