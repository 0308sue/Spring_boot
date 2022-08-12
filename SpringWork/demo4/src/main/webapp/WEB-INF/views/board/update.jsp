<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/includes/header.jsp"%>
<div class="jumbotron jumbotron-fluid">
	<div class="container">
		<h1>${boards.num }번 글 수정</h1>
	</div>
</div>

<div class="container ">

<form action="/board/update" method="post">
		<input type="hidden" name="num" id="num" value="${boards.num }">
		<div class="form-group">
			<label for="title">제목:</label> <input type="text"
				class="form-control" id="title" name="title" value="${boards.title }"
				>
		</div>

		<div class="form-group">
			<label for="pwd">작성자:</label> <input type="text" class="form-control"
				id="writer" name="writer" value="${boards.writer }"
				readonly="readonly">
		</div>

		<div class="form-group">
			<label for="content">내용:</label>
			<textarea class="form-control" rows="5" name="content" id="content"
				>${boards.content}</textarea>
		</div>



		<div class="form-group text-right">
			<button class="btn btn-secondary" >수정하기</button>
		</div>
</form>	

	
</div>