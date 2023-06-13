<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp"%>

<div class="container text-center">

	<div class="row ">
		<div class="col-4 ">
			<div class="card" style="width: 90%;">
				<img src="<%=request.getContextPath() %>/img/animal.jpg" class="card-img-top" alt="..." id="card-img">
				<div class="card-body">
					<h5 class="card-title">반려 동물</h5>
					<p class="card-text">Some quick example text to build on the
						card title and make up the bulk of the card's content.</p>
					<a href="<%=request.getContextPath() %>/hboard/hno_board.hboard?hno=1" class="btn btn-primary">Go somewhere</a>
				</div>
			</div>
			
		</div>
		<div class="col-4">
		 <div class="card" style="width: 100%;">
			<img src="<%=request.getContextPath() %>/img/game.jpg" class="card-img-top" alt="..." id="card-img">
			<div class="card-body">
				<h5 class="card-title">보드 게임</h5>
				<p class="card-text">Some quick example text to build on the
						card title and make up the bulk of the card's content.</p>
				<a href="<%=request.getContextPath() %>/hboard/hno_board.hboard?hno=2" class="btn btn-primary">Go somewhere</a>
			</div>
		</div>
		</div>
		<div class="col-4 ">
			<div class="card" style="width: 100%;">
				<img src="<%=request.getContextPath() %>/img/sports.jpg" class="card-img-top" alt="..." id="card-img">
				<div class="card-body">
					<h5 class="card-title">운동</h5>
					<p class="card-text">Some quick example text to build on the
						card title and make up the bulk of the card's content.</p>
					<a href="<%=request.getContextPath() %>/hboard/hno_board.hboard?hno=3" class="btn btn-primary">Go somewhere</a>
				</div>
			</div>
			
		</div>
	</div>
	<hr>
	<div class="row ">
		<div class="col-4 ">
			<div class="card" style="width: 90%;">
				<img src="<%=request.getContextPath() %>/img/cam.jpg" class="card-img-top" alt="..." id="card-img">
				<div class="card-body">
					<h5 class="card-title">카메라</h5>
					<p class="card-text">Some quick example text to build on the
						card title and make up the bulk of the card's content.</p>
					<a href="<%=request.getContextPath() %>/hboard/hno_board.hboard?hno=4" class="btn btn-primary">Go somewhere</a>
				</div>
			</div>
			
		</div>
		<div class="col-4">
		 <div class="card" style="width: 100%;">
			<img src="<%=request.getContextPath() %>/img/dance.jpg" class="card-img-top" alt="..." id="card-img">
			<div class="card-body">
				<h5 class="card-title">댄스</h5>
				<p class="card-text">Some quick example text to build on the
						card title and make up the bulk of the card's content.</p>
				<a href="<%=request.getContextPath() %>/hboard/hno_board.hboard?hno=5" class="btn btn-primary">Go somewhere</a>
			</div>
		</div>
		</div>
		<div class="col-4 ">
			<div class="card" style="width: 100%;">
				<img src="<%=request.getContextPath() %>/img/cook.jpg" class="card-img-top" alt="..." id="card-img">
				<div class="card-body">
					<h5 class="card-title">요리</h5>
					<p class="card-text">Some quick example text to build on the
						card title and make up the bulk of the card's content.</p>
					<a href="<%=request.getContextPath() %>/hboard/hno_board.hboard?hno=6" class="btn btn-primary">Go somewhere</a>
				</div>
			</div>
			
		</div>
	</div>
	


	<!-- /.container -->
</div>
