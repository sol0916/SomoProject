<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp" %>
<section>
   <div align="center" class="fs-3">
   <p>비밀번호 확인</p>
   <form action="member_pwcheck.mem" method="post">
   <input type="hidden" name = "check" value="${param.check }">
   <table>

             <tr>
               <td class="td-spacing"><input type="password" name="memPw" required="required" placeholder="비밀번호를 입력해주세요"></td>
            </tr>
             <tr>
               <td><input type="submit" class="btn btn-lg btn-outline-primary" value="확인하기"></td> 
               <td class="td-spacing"><div align="center" style="color: red;">${msg }</div></td>
            </tr>   
   </table>
   </form>   
   </div>

</section>
<%@ include file="../include/footer.jsp" %>