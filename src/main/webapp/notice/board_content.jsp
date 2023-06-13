<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    

<%@ include file="../include/header.jsp" %>



<div align="center" class="div_center">

	<h3>공지사항 내용 보기</h3>
	<hr>
	<table border="1" width="500" class="table-bordered fs-3">
		<tr>
			<td width="20%">글번호</td>
			<td width="30%">${vo.ntno }</td>
			
			<td width="20%">조회수</td>
			<td width="30%">${vo.nthit }</td>
		</tr>
		<tr>
			<td>작성자</td>
			<td>${vo.memid }</td>
			
			<td>작성일</td>
			<td >${vo.ntregdate }</td>
		</tr>
		
		<tr>
			<td width="20%">글제목</td>
			<td colspan="3">${vo.nttitle }</td>
		</tr>
		<tr>
			<td width="20%">글내용</td>
			<td colspan="3" height="120px">${vo.ntcontent }</td>
		</tr>
		
	
		<tr>
			<td colspan="4" align="center">
				<input type="button" value="목록" class="btn btn-dark btn-lg" onclick="location.href='board_list.board'">&nbsp;&nbsp;
			
				<input type="button" value="수정" class="btn btn-dark btn-lg" onclick="location.href='board_modify.board?ntno=${vo.ntno}'">&nbsp;&nbsp;
				<input type="button" value="삭제" class="btn btn-dark btn-lg" onclick="location.href='board_delete.board?ntno=${vo.ntno}'">&nbsp;&nbsp;
				
				
				
			</td>
		</tr>
	</table>
	


</div>


<%@ include file="../include/footer.jsp" %>