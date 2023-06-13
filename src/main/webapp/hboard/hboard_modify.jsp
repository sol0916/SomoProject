<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp" %>

<div align="center" class="div_center">
	<h3>게시판 글 수정 페이지</h3>
	<hr>
	
	<form action="hboard_update.hboard" method="post">
			
			<input type="hidden" name="boardNum" value="${vo.boardNum }">
		
		<table border="1" width="500">
			
			<!--<tr> 
				<td>글 번호</td>
				<td></td>
			</tr> -->
			
			<tr>
				<td>작성자</td>
				<td><input type="text" name="boWriter" value="${vo.boWriter }" readonly></td>
			</tr>
			<tr>
				<td>글 제목</td>
				<td>
					<input type="text" name="boTitle" value="${vo.boTitle }">
				</td>
			</tr>
			<tr>
				<td>글 내용</td>
				<td>
					<textarea rows="10" style="width: 95%;" name="boContent">%{vo.boContent}
					</textarea>
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="수정 하기" onclick="">&nbsp;&nbsp;
					<input type="button" value="목록">        
				</td>
			</tr>
			
		</table>
	</form>
	
</div>

<%@ include file="../include/footer.jsp" %>