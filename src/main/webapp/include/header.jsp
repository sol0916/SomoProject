<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>   
<!DOCTYPE html>
<html>
<head>

	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-idth, initial-scale=1">
   

    <title>Welcome to SOMO</title>

    <!-- Bootstrap Core CSS -->
    <link href="<%=request.getContextPath() %>/css/bootstrap.css" rel="stylesheet">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no"> 

	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
      integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
        crossorigin="anonymous"></script>

    <!-- Custom CSS -->
    <link href="<%=request.getContextPath() %>/css/business-casual.css" rel="stylesheet">

    <!-- Fonts -->
    <link href="https://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800" rel="stylesheet" type="text/css">
    <link href="https://fonts.googleapis.com/css?family=Josefin+Slab:100,300,400,600,700,100italic,300italic,400italic,600italic,700italic" rel="stylesheet" type="text/css">
	
	<!-- jQuery -->
    <script src="<%=request.getContextPath() %>/js/jquery.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="<%=request.getContextPath() %>/js/bootstrap.min.js"></script>
    <script>
    $('.carousel').carousel({
        interval: 2000 //changes the speed
    })
    </script>
   <style>
   .abc {
      position: sticky;
      top: 0px;
      width: 100%; 
      z-index: 10;
   
   #card-img {
    width: 100%;
    height: 100%; 
    object-fit: cover;
   }
   }
   </style>
</head>

<body>
	<!-- header -->
	<div class="brand">SOMO</div>        
    <div class="address-bar">Welcome to SOMO</div>   
    
    <nav class="navbar navbar-default abc fs-2" role="navigation">
        <div class="container">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                
                <a class="navbar-brand" href="/hong">My First Web</a>
            </div>
           
           
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav">
                	<li>
                        <a href="<%=request.getContextPath() %>/index.jsp">HOME</a>
                    </li>
                    <li>
                        <a href="<%=request.getContextPath() %>/notice/board_list.board">NOTICE</a>
                    </li>
                    <li>
                        <a href="<%=request.getContextPath()%>/hboard/hboard_list.hboard">BOARD</a>
                    </li>
                    
                    <c:choose>
                    	<%-- 로그인 됨 --%>
                    	<c:when test="${sessionScope.user_id != null }">
	                    	<li>
	                        	<a href="<%=request.getContextPath()%>/member/member_mypage.mem">MyPage</a>
	                    	</li>
<%-- 	                    	<li>
	                        	<a href="<%=request.getContextPath()%>/member/member_logout.mem" style="color:red">로그아웃</a>
	                    	</li> --%>
	               		</c:when>
	               		
	               		<%-- 로그인 안됨 --%>
	               		<c:otherwise> 
	               			<li>
	                        	<a href="<%=request.getContextPath()%>/member/member_login.mem">LOGIN</a>
	                    	</li>
	                    	
	                    </c:otherwise>
	               	</c:choose>
	               		
                </ul>
            </div>
            
            
            <!-- /.navbar-collapse -->
        </div>
        <!-- /.container -->
    </nav>
 	<!-- end header -->

