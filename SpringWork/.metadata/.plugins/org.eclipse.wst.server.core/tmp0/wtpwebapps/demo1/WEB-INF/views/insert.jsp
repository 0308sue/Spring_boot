<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="includes/header.jsp"%>
<div class="jumbotron jumbotron-fluid">
  <div class="container">
    <h1>board write</h1>
  </div>
</div>

<div class="container ">
		<form action="insert" method="post" >

			<div class="form-group">
				<label for="title">제목:</label> <input type="text"
					class="form-control" id="title" placeholder="Enter title"
					name="title">
			</div>
			
			<div class="form-group">
				<label for="pwd">글쓴이:</label> <input type="text"
					class="form-control" id="writer" name="writer" placeholder="Enter writer"
					>
			</div>
			
			<div class="form-group">
				<label for="content">내용:</label> 
				<textarea class="form-control" rows="5" name="content" id="content"></textarea>
			</div>
			
			<div class="form-group text-right">
			<button class="btn btn-primary">글쓰기</button>
			</div>
			
		</form>
	</div>
