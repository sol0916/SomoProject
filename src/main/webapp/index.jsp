<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp"%>
<style>
.card {
  height: 100%; /* 카드의 높이를 100%로 설정합니다. */

}

.card-img-top {
  height: 200px; /* 카드 이미지의 높이를 조정합니다. */
  object-fit: cover; /* 이미지가 카드 영역에 꽉 차도록 설정합니다. */
}

.card-title {
  margin-top: 10px; /* 카드 제목과 상단 여백을 설정합니다. */
}

.card-text {
  margin-bottom: 10px; /* 카드 내용과 하단 여백을 설정합니다. */
}

.btn-primary {
  margin-top: 10px; /* 버튼과 상단 여백을 설정합니다. */
}

</style>
<div class="container text-center">

	<div class="row ">
		<div class="col-4 ">
			<div class="card" style="width: 90%;">
				<img src="<%=request.getContextPath() %>/img/animal.jpg" class="card-img-top" alt="..." id="card-img">
				<div class="card-body">
					<h5 class="card-title">반려 동물</h5>
					<p class="card-text">반려 동물을 좋아하는 사람들의 모임입니다. 반려동물을 좋아한다면 여기로 오세요!</p>
					<a href="<%=request.getContextPath() %>/hboard/hno_board.hboard?hno=4" class="btn btn-primary">반려 동물 게시판으로 이동</a>
				</div>
			</div>
			
		</div>
		<div class="col-4">
		 <div class="card" style="width: 100%;">
			<img src="<%=request.getContextPath() %>/img/game.jpg" class="card-img-top" alt="..." id="card-img">
			<div class="card-body">
				<h5 class="card-title">보드 게임</h5>
				<p class="card-text">보드 게임을 좋아하는 사람들의 모임입니다. 보드게임 초보자도 환영합니다!</p>
				<a href="<%=request.getContextPath() %>/hboard/hno_board.hboard?hno=6" class="btn btn-primary">보드 게임</a>
			</div>
		</div>
		</div>
		<div class="col-4 ">
			<div class="card" style="width: 100%;">
				<img src="<%=request.getContextPath() %>/img/sports.jpg" class="card-img-top" alt="..." id="card-img">
				<div class="card-body">
					<h5 class="card-title">운동</h5>
					<p class="card-text">운동을 취미로 가지신분들 여기로 모이시면 됩니다.</p>
					<a href="<%=request.getContextPath() %>/hboard/hno_board.hboard?hno=1" class="btn btn-primary">Go somewhere</a>
				</div>
			</div>
			
		</div>
	</div>
	<br/>
	<br/>
	<div class="row ">
		<div class="col-4 ">
			<div class="card" style="width: 90%;">
				<img src="<%=request.getContextPath() %>/img/cam.jpg" class="card-img-top" alt="..." id="card-img">
				<div class="card-body">
					<h5 class="card-title">카메라</h5>
					<p class="card-text">사진 촬영을 좋아하시는분들 모임. 초보자도 환영!!</p>
					<a href="<%=request.getContextPath() %>/hboard/hno_board.hboard?hno=3" class="btn btn-primary">카메라 게시판으로 이동</a>
				</div>
			</div>
			
		</div>
		<div class="col-4">
		 <div class="card" style="width: 100%;">
			<img src="<%=request.getContextPath() %>/img/dance.jpg" class="card-img-top" alt="..." id="card-img">
			<div class="card-body">
				<h5 class="card-title">댄스</h5>
				<p class="card-text">춤을 처음 시작하는사람도 환영입니다 일단 오세요.</p>
				<a href="<%=request.getContextPath() %>/hboard/hno_board.hboard?hno=2" class="btn btn-primary">Go somewhere</a>
			</div>
		</div>
		</div>
		<div class="col-4 ">
			<div class="card" style="width: 100%;">
				<img src="<%=request.getContextPath() %>/img/cook.jpg" class="card-img-top" alt="..." id="card-img">
				<div class="card-body">
					<h5 class="card-title">요리</h5>
					<p class="card-text">요리를 취미로 시작하고 싶은 모든 분들 환영합니다.</p>
					<a href="<%=request.getContextPath() %>/hboard/hno_board.hboard?hno=5" class="btn btn-primary">Go somewhere</a>
				</div>
			</div>
			
		</div>
	</div>
	


	<!-- /.container -->
</div>
<%@ include file="../include/footer.jsp" %>