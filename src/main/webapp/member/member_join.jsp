<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp" %>
<style>

  table {
    border-collapse: separate;
    border-spacing: 0 5px; /* 원하는 간격 설정 */
  }
  
    .td-spacing {
    padding-left: 10px; /* 원하는 공백 크기 설정 */
  }
  
    .td-select {
    width: 170px; /* 선택 박스의 너비 조정 */
  }
  
</style>
<section>
	<div align="center" class="fs-3">
		
		<h3>회원가입</h3>
		
		<form action="joinForm.mem" method="post">
			<table>
				<tr>
					<td>아이디</td> 
					<td class="td-spacing"><input type="text" name="memId" required="required" pattern="[A-Za-z0-9]{3,}" placeholder="아이디를 입력하세요"></td>			
				</tr>
				<tr>
					<td>비밀번호</td> 
					<td class="td-spacing"><input type="password" name="memPw" required="required" pattern="\w{4,}" placeholder="비밀번호를 입력하세요"></td>
				</tr>
				<tr>
					<td>비밀번호 확인</td> 
					<td class="td-spacing"><input type="password" name="memPw_check" required="required" pattern="\w{4,}" placeholder="다시 입력해주십시오"></td>
				</tr>
 				<tr>
					<td></td>
					<td class="td-spacing"><div align="center" style="color: red;">${msg }</div></td>
				</tr>
				<tr>
					<td>이름</td>
					<td class="td-spacing"><input type="text" name="memName" required="required" placeholder="이름을 입력하세요"></td>
				</tr>
				<tr>
					<td>닉네임</td>
					<td class="td-spacing"><input type="text" name="memNick" required="required" placeholder="닉네임을 입력하세요"></td>

				</tr>
				<tr>
					<td>이메일</td>
					<td class="td-spacing"><input type="email" name="memEmail" placeholder="xxx@xxx.com"></td>
				</tr>
				<tr>
					<td>핸드폰 번호</td> 
					<td class="td-spacing"><input type="text" name="memPhone" pattern="\d{3}-\d{4}-\d{4}" placeholder="010-0000-0000"></td>
				</tr>
				<tr>
					<td>생일</td>
					<td class="td-spacing"><input type="text" name="memBirth" pattern="\d{2}.\d{2}.\d{2}" placeholder="yy.mm.dd"></td>
				</tr>
				<tr>
					<td>지역</td>
					<td class="td-spacing">
					<select name="memAddr1" class="td-select">
						<option>서울시</option>
						<option>경기도</option>
						<option>강원도</option>
						<option>충청북도</option>
						<option>충청남도</option>
						<option>전라북도</option>
						<option>전라남도</option>
						<option>경상북도</option>
						<option>경상남도</option>					
						<option>제주도</option>					
					</select>
					</td>
				</tr >
				<tr>
					<td>상세주소</td>
					<td class="td-spacing"><input type="text" name="memAddr2" placeholder="상세주소를 입력하십시오"></td>
				</tr>
				<tr>
					<td>성별</td>
					<td align="center" class="td-spacing">
						<input type="radio" name="memGender" value="M" checked="checked">남자
						<input type="radio" name="memGender" value="F">여자					
					</td>
				</tr>			
			</table>	
			
			<!--  <div style="color: red;">${msg }</div> -->	
			
			<br/>
			<input type="submit" value="가입">
			<input type="button" value="돌아가기" onclick="location.href='../index.jsp'">
			
		</form>	
	</div>


</section>


<%@ include file="../include/footer.jsp" %>