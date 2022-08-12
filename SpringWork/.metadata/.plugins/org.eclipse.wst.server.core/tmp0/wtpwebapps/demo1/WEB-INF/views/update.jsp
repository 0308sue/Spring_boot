<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="includes/header.jsp"%>
<div class="jumbotron jumbotron-fluid">
  <div class="container">
    <h1>board 수정</h1>
  </div>
</div>

<div class="container ">
		
<input type="hidden" name="num" id="num" value="${board.num }">
			<div class="form-group">
				<label for="title">제목:</label> <input type="text"
					class="form-control" id="title"  value="${board.title }"
					name="title">
			</div>
			
			<div class="form-group">
				<label for="pwd">글쓴이:</label> <input type="text"
					class="form-control" id="writer" name="writer" value="${board.writer }" readonly="readonly">
			</div>
			
			<div class="form-group">
				<label for="content">내용:</label> 
				<textarea class="form-control" rows="5" name="content" id="content">${board.content}</textarea>
			</div>
			
			<div class="form-group text-right">
			<button type="button" class="btn btn-secondary" id="btnModify">수정하기</button>
			</div>
			
	
	</div>
	
	<script>
	$("#btnModify").click(function(){
		data={
				"num":$("#num").val(),
				"title":$("#title").val(),
				"content":$("#content").val(),
		}
		$.ajax({
			type:"put",
			url:"/update",
			contentType:"application/json;charset=utf-8",
			data:JSON.stringify(data),
			success:function(resp){
				if(resp=="success"){					
				alert("수정 성공")
				location.href="/list"
				}
			}			
		})
	})
</script>
