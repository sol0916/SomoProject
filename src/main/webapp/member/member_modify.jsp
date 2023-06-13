<%@page import="com.somo.member.model.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp" %>
<section>
	<div align="center">
	
		<h3>회원정보 수정</h3>
		<b>${vo.memName }님 회원 정보를 수정합니다</b>
	
			<form action="member_update.mem" method="post">
			<table>
				<tr>
					<td>아이디</td>
					<td><input type="text" name="memId" value="${vo.memId }" readonly="readonly"></td>			
				</tr>
				<tr>
					<td>이름</td>
					<td><input type="text" name="memName" value="${vo.memName }" readonly="readonly"></td>
				</tr>
				<tr>
					<td>닉네임</td>
					<td><input type="text" name="memNick" value="${vo.memNick }"></td>
				</tr>
				<tr>
					<td>이메일</td>
					<td><input type="email" name="memEmail" value="${vo.memEmail }"></td>
				</tr>
				<tr>
					<td>핸드폰 번호</td>
					<td><input type="text" name="memPhone" value="${vo.memPhone }"></td>
				</tr>
				<tr>
    				<td>지역</td>
				    <td class="td-spacing">
				        <select name="memAddr1" class="td-select">
				            <option ${ memAddr1.equals("서울시") ? "selected" : "" }>서울시</option>
				            <option ${ memAddr1.equals("경기도") ? "selected" : "" }>경기도</option>
				            <option ${ memAddr1.equals("강원도") ? "selected" : "" }>강원도</option>
				            <option ${ memAddr1.equals("충청북도") ? "selected" : "" }>충청북도</option>
				            <option ${ memAddr1.equals("충청남도") ? "selected" : "" }>충청남도</option>
				            <option ${ memAddr1.equals("전라북도") ? "selected" : "" }>전라북도</option>
				            <option ${ memAddr1.equals("전라남도") ? "selected" : "" }>전라남도</option>
				            <option ${ memAddr1.equals("경상북도") ? "selected" : "" }>경상북도</option>
				            <option ${ memAddr1.equals("경상남도") ? "selected" : "" }>경상남도</option>
				            <option ${ memAddr1.equals("제주도") ? "selected" : "" }>제주도</option> 
				        </select>
				    </td>
				</tr>
				<tr>
				    <td>상세주소</td>
				    <td class="td-spacing"><input type="text" name="memAddr2" value="${memAddr2 }"></td>
				</tr>
				<tr>
					<td>생일</td>
					<td><input type="text" name="memBirth" value="${vo.memEmail }"></td>
				</tr>
				<tr>
					<td>성별</td>
					<td>
						<input type="radio" name="gender" value="M" ${vo.memGender == 'M' ? 'checked' : '' }>남자
						<input type="radio" name="gender" value="F" ${vo.memGender == 'F' ? 'checked' : '' }>여자					
					</td>
				</tr>				
			</table>	
			
			
			<input type="submit" value="정보수정">
			<input type="button" value="회원페이지로 가기" onclick="location.href='user_mypage.user'">
			
		</form>	
	
	
	
	</div>
</section>


<%@ include file="../include/footer.jsp" %>