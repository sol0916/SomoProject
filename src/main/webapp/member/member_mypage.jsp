<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="../include/header.jsp" %>

    <style>
      table {
   	 	border-collapse: separate;
    	border-spacing: 0 10px; /* 원하는 간격 설정 */
  		}
  	  td{
  	  	padding-right: 50px
  	  }
      .container {
        margin-top: 50px;
        }
      .card {
            margin-bottom: 20px;
        }
    </style>
</head>
<body>
    <div class="container" align="center">
        <h1>마이페이지</h1>
        
        <div class="card" >
            <div class="card-body fs-3">
              <table>
              	  <tr>					              	
                	<td class="card-text">회원 아이디</td> 
                	<td>${vo.memId }</td>
                  </tr>
                  <tr>
                	<td class="card-text">이름</td>
                	<td> ${vo.memName }</td>
                  </tr>
                  <tr>
              		<td class="card-text">닉네임</td> 
                	<td> ${vo.memNick }</td>
                  </tr>
                  <tr>                                
                	<td class="card-text">폰번호</td> 
                	<td> ${vo.memPhone }</td>
                  </tr>
                  <tr>
                	<td class="card-text">이메일</td>
                	<td> ${vo.memEmail }</td>
                  </tr>
                  <tr>
                	<td class="card-text">주소</td> 
                	<td>${vo.memAddr }</td>
                  <tr/>
					<tr>
					  <td class="card-text">성별</td>
					  <td> 
					    <c:choose>
					      <c:when test="${vo.memGender == 'M'}">
					        남성
					      </c:when>
					      <c:when test="${vo.memGender == 'F'}">
					        여성
					      </c:when>
					      <c:otherwise></c:otherwise>
					    </c:choose>
					  </td>
					</tr>
                  <tr>
                	<td class="card-text">생일</td> 
                	<td>${vo.memBirth }</td>
                  </tr>
              </table>
       		 </div>
            </div>
        </div>
        <div align="center">
           	<button type="button" onclick="location.href='member_myBoardList.mem'">작성 글 보기</button>	 
           	<button type="submit" class="btn btn-primary" onclick="location.href='member_modify.mem'">회원 정보 수정</button>	 
			<button type="submit" class="btn btn-danger" onclick="location.href='member_delete.mem'">회원탈퇴</button>             
        </div>

<%@ include file="../include/footer.jsp" %>