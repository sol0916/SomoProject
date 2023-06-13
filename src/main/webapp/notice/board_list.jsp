<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>    

<%@ include file="../include/header.jsp" %>
	

	<div class="container">
		<h3>SOMO 공지사항</h3>

		<table class="table table-striped table-bordered fs-4 table-hover border-dark">
			<thead>
				<tr>
					<th>순서</th>
					<th>글 번호</th>
					<th>작성자</th>
					<th>제목</th>
					<th>날짜</th>
					<th>조회수</th>
				</tr>
			</thead>

			<tbody>
				<c:forEach var="vo" items ="${list}" varStatus="x">
				
				<tr>
				
					<td>${x.count }</td>
					<td>${vo.ntno }</td>
					<td>${vo.memid }</td>
					<td><a href="board_content.board?ntno=${vo.ntno}">${vo.nttitle }</a></td>
					<td><fmt:formatDate value="${vo.ntregdate }" pattern="yyyy-MM-dd (E) hh시ss분"/></td>
					<td>${vo.nthit }</td>
				</tr>
				
				</c:forEach>
			</tbody>
			
			<tbody>
				<tr>
					<td colspan="6" align="right" >
						<form action="" class="form-inline" >
						  <div class="form-group">
							<input type="button" value="글 작성" class="btn btn-dark btn-lg" onclick="location.href='board_write.board'">
						  </div>
						</form> 
					</td>
				</tr>
			</tbody>
		
		</table>
	</div>

<%@ include file="../include/footer.jsp" %>






