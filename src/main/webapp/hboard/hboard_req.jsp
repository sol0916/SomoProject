<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp" %>

<div align="center" class="div_center">
	<h3>취미게시판 요청하기</h3>
	<hr>
	
	<form action="hboard_update.hboard" method="post">
			
			<input type="hidden" name="boardNum" value="">
		
		<table border="1" width="500">
			
			
			<tr>
				<td>작성자</td>
				<td><input type="text" name="boWriter" value="${sessionScope.user_id }" readonly></td>
			</tr>
			<tr>
				<td>글 제목</td>
				<td>
					<input type="text" name="boTitle" value="">
				</td>
			</tr>
			<tr>
				<td>글 내용</td>
				<td>
					<textarea rows="10" style="width: 95%;" name="boContent">
					</textarea>
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="요청 하기" onclick="">&nbsp;&nbsp;
					<input type="button" value="돌아가기" onclick="location.href='hboard_list.hboard'">        
				</td>
			</tr>
			
		</table>
	</form>
	
</div>

<%@ include file="../include/footer.jsp" %>