<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/includes/header.jsp"%>
<div class="jumbotron jumbotron-fluid">
  <div class="container">
    <h1>board write</h1>
  </div>
</div>

<div class="container ">
		<form action="fileInsert" method="post" enctype="multipart/form-data">

			<div class="form-group">
				<label for="title">제목:</label> <input type="text"
					class="form-control" id="title" placeholder="Enter title"
					name="title">
			</div>
			
			<div class="form-group">
				<label for="writer">글쓴이:</label> <input type="text"
					class="form-control" id="writer" name="writer" placeholder="Enter writer">
			</div>
			<div class="form-group">
				<label for="upload">파일:</label> <input type="file"
					class="form-control" id="upload" name="upload" placeholder="Enter File">
			</div>
			
			<div class="form-group">
				<label for="content">내용:</label> 
				<textarea class="form-control" rows="5" name="content" id="content"></textarea>
			</div>
			
			<div class="form-group text-right">
			<button class="btn btn-primary">Submit</button>
			</div>
			
		</form>
	</div>