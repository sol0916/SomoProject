<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp"%>

<div align="center" class="div_center">
	<h3>공지사항 </h3>
	<hr>
	
	<form action="registForm.board" method="post">
		<table border="1" width="500" class="table-bordered fs-3">
			<tr>
				<td>작성자</td>
				<td><input type="text" name="writer" value="${sessionScope.user_id}" readonly="readonly" size="10" ></td>
			</tr>
			<tr>
				<td>공지 제목</td>
				<td><input type="text" name="title"></td>
			</tr>
			<tr>
				<td>공지 내용</td>
				<td><textarea rows="10" style="width: 95%;" name="content"></textarea>
				</td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="작성 완료" onclick="" class="btn btn-outline-dark btn-lg">
					&nbsp;&nbsp; <input type="button" value="목록" onclick="location.href='board_list.board'" class="btn btn-outline-dark btn-lg"></td>
			</tr>

		</table>
	</form>

</div>
<%@ include file="../include/footer.jsp"%>