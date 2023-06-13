<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@ include file="../include/header.jsp" %>

<div align="center" class="div_center">

	<h3>게시글 내용 보기</h3>
	<hr>
	<table border="1" width="500" class="table-bordered fs-3">
		<tr>
			<td width="20%">글번호</td>
			<td width="30%">${vo.boardNum }</td>
			
			<td width="20%">조회수</td>
			<td width="30%">${vo.boHit }</td>
		</tr>
		<tr>
			<td>작성자</td>
			<td>${vo.boWriter }</td>
			
			<td>작성일</td>
			<td>${vo.boRegdate }</td>
		</tr>
		
		<tr>
			<td width="20%">글제목</td>
			<td colspan="3">${vo.boTitle }</td>
		</tr>
		<tr>
			<td width="20%">글내용</td>
			<td colspan="3" height="120px">${vo.boContent }</td>
		</tr>
		
		<tr>
			<td colspan="4" align="center">
				<input type="button" value="목록" onclick="location.href='hboard_list.hboard'">&nbsp;&nbsp;
				<input type="button" value="수정" onclick="location.href='hboard_modify.hboard?boardNum=${vo.boardNum}'">&nbsp;&nbsp;
				<input type="button" value="삭제">&nbsp;&nbsp;
			</td>
		</tr>
	</table>
	
</div>

<%@ include file="../include/footer.jsp" %>