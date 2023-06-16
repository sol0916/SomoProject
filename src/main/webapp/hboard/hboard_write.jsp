<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div align="center" class="div_center col-6 mx-auto fs-4">
	<h3>게시판 글 작성 페이지</h3>
	<hr>
	
	<form action="registForm.hboard" method="post" enctype="multipart/form-data">
		<table  class ="table">
			<tr>
				<td>작성자</td>
				<td>
					<input type="text" name="boWriter" size="10" value="${sessionScope.user_nick }" readonly="readonly">
				</td>
			</tr>
			<tr>
				<td>글 제목</td>
				<td>
					<input type="text" name="boTitle" >
				</td>
			</tr>
			<tr>
				<td>취미 종류</td>
				<td>
					<select name="hname" class="td-select">
						<c:forEach var = "h" items="${hblist }">
						<option>${h.hname }</option>
						</c:forEach>
					</select>
				</td>
			</tr>
			<tr>
				<td>글 내용</td>
				<td>
					<textarea rows="10" style="width: 95%;" name="boContent"></textarea>
				</td>
			</tr>
			<tr>
				<td>사진 추가</td>
				<td>
					<input type="file" name = "img">
				</td>
			</tr>
			<tr>
				<td colspan="2" align="right">
					<input type="submit" value="작성 완료" onclick="" class="btn btn-dark btn-lg">
					&nbsp;&nbsp;
					<input type="button" value="글목록" class="btn btn-dark btn-lg" onclick="location.href='hboard_list.hboard'">         
				</td>
			</tr>
			
		</table>
	</form>
	
</div>

<%@ include file="../include/footer.jsp" %>