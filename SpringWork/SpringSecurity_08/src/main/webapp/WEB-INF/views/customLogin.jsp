<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/includes/header.jsp"%>

<div class="jumbotron jumbotron-fluid">
  <div class="container">
    <h1>로그인</h1>
  </div>
</div>

<div class="container ">
		<form action="/app08/login" method="post">	
				<div class="form-group">
				<label for="id">아이디:</label> <input type="text"
					class="form-control" id="username" placeholder="Enter id" name="username">
			</div>
			<div class="form-group">
				<label for="pass">비밀번호:</label> <input type="password"
					class="form-control" id="password" placeholder="Enter pass"
					name="password">
			</div>

			<br><br>
			<button  class="btn btn-primary" id="btnLogin">로그인</button>
		</form>
		
		
	</div>
