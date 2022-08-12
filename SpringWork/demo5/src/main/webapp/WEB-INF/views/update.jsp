<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/includes/header.jsp"%>
<div class="jumbotron jumbotron-fluid">
	<div class="container">
		<h1>${members.username}님의 정보 수정</h1>
	</div>
</div>

<div class="container ">

<form action="/update" method="post">
		<input type="hidden" name="id" id="id" value="${members.id }">
<div class="form-group">
			<label for="username">아이디:</label> <input type="text"
				class="form-control" id="username" name="username" value="${members.username }"
				>
		</div>

		<div class="form-group">
			<label for="password">비밀번호:</label> <input type="text" class="form-control"
				id="password" name="password" 
				readonly="readonly">
		</div>

		<div class="form-group">
			<label for="password">Email:</label> <input type="text" class="form-control"
				id="email" name="email" value="${members.email }"
				>
		</div>



		<div class="form-group text-right">
			<button class="btn btn-secondary" >수정하기</button>
		</div>
</form>	

	
</div>