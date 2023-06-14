<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>        
<%@ include file="../include/header.jsp" %>

	<div class="container">
		<c:choose>
			<c:when test="${hno==1 }">
				<h3>운동 게시판</h3>
			</c:when>
			<c:when test="${hno==2 }">
				<h3>댄스 게시판</h3>
			</c:when>
			<c:when test="${hno==3 }">
				<h3>사진 게시판</h3>
			</c:when>
			<c:when test="${hno==4 }">
				<h3>동물 게시판</h3>
			</c:when>
			<c:when test="${hno==5 }">
				<h3>요리 게시판</h3>
			</c:when>
			<c:when test="${hno==6 }">
				<h3>보드게임 게시판</h3>
			</c:when>
		</c:choose>
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
				
				<c:forEach var = "vo" items="${list }" varStatus="x">
				<tr>
					<td>${x.count }</td>
					<td>${vo.boardNum }</td>
					<td>${vo.boWriter }</td>
					<td><a href="hboard_content.hboard?boardNum=${vo.boardNum }">${vo.boTitle }</a></td>
					<td><fmt:formatDate value="${vo.boRegdate }" pattern="yyyy-MM-dd(E) hh시mm분"/></td>
					<td>${vo.boHit }</td>
				</tr>
				</c:forEach>
			</tbody>
			
			<tbody>
				<tr>
					<td colspan="6" align="right">
						<form action="hboard_search.hboard" class="form-inline" >
						  <div class="form-group">
						    <input type="text" name="search" placeholder="제목검색" class="form-control" >
						  	<input type="submit" value="검색" class="btn btn-dark btn-lg">
							<c:if test="${sessionScope.user_id !=null }">
							<input type="button" value="글 작성" class="btn btn-dark btn-lg" onclick="location.href='hboard_write.hboard'">
							</c:if>						  
						  </div>
						</form> 
					</td>
				</tr>
			</tbody>
		
		</table>
	</div>

<%@ include file="../include/footer.jsp" %>