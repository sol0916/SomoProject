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
				<input type="button" value="목록" class="btn btn-dark btn-lg" onclick="location.href='hboard_list.hboard'">&nbsp;&nbsp;
				<input type="button" value="수정" class="btn btn-dark btn-lg" onclick="location.href='hboard_modify.hboard?boardNum=${vo.boardNum}'">&nbsp;&nbsp;
				<input type="button" value="삭제" class="btn btn-dark btn-lg" onclick="location.href='hboard_delete.hboard?boardNum=${vo.boardNum}'">&nbsp;&nbsp;
			</td>
		</tr>
	 <c:if test="${rplist!=null }">
		<c:forEach var="rp" items="${rplist }">
			<tr>
				<td colspan="4">
					<div class="input-group fs-5">
						<p>${rp.rContent }</p> &nbsp;&nbsp;&nbsp;&nbsp;
					  <button class="btn btn-outline-secondary btn-outline-dark btn-lg" type="button" onclick="location.href='reply_modify.reply?rNo=${rp.rNo}&boardNum=${vo.boardNum}'">수정</button>&nbsp;&nbsp;
					  <button class="btn btn-outline-secondary btn-outline-dark btn-lg" type="button" onclick="location.href='reply_delete.reply?rNo=${rp.rNo}&boardNum=${vo.boardNum}'">삭제</button>
					</div>
				</td>
			</tr>
		</c:forEach>
	 </c:if> 
		<tr>
		 <c:choose>
		  <c:when test="${replymodify ==null }">
			<td colspan="4" align="center">
				 <form class="row" action="<%=request.getContextPath() %>/hboard/reply_insert.reply" method="post">
				 	<input type="hidden" value="${vo.boardNum }" name = "boardNum">
				  <div class="col" align="right">
				    <input type="text" name="rContent" class="form-control" placeholder="댓글 써주세여">
				  </div>
				  <div class="col-auto">
				    <button type="submit" class="btn btn-primary">작성하기</button>
				  </div>
				</form>
			</td>
		  </c:when>
		  <c:otherwise>
		  	<td colspan="4" align="center">
				 <form class="row" action="<%=request.getContextPath() %>/hboard/reply_update.reply" method="post">
				 	<input type="hidden" value="${vo.boardNum }" name = "boardNum">
				 	<input type="hidden" value="${rpvo.rNo}" name = "rNo">
				  <div class="col" align="right">
				    <input type="text" name="rContent" class="form-control" placeholder="댓글 써주세여" value="${rpvo.rContent }">
				  </div>
				  <div class="col-auto">
				    <button type="submit" class="btn btn-primary">수정하기</button>
				  </div>
				</form>
			</td>
		  </c:otherwise>	
		 </c:choose>
		</tr>	
	</table>
			
</div>

<%@ include file="../include/footer.jsp" %>