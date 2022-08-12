<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/includes/header.jsp"%>
<div class="jumbotron jumbotron-fluid">
	<div class="container">
		<h1>${boards.writer }의글보기</h1>
	</div>
</div>

<div class="container ">
	
		<input type="hidden" name="num" id="num" value="${boards.num }">
		<div class="form-group">
			<label for="title">제목:</label> <input type="text"
				class="form-control" id="title" name="title" value="${boards.title }"
				readonly="readonly">
		</div>

		<div class="form-group">
			<label for="pwd">작성자:</label> <input type="text" class="form-control"
				id="writer" name="writer" value="${boards.writer }"
				readonly="readonly">
		</div>

		<div class="form-group">
			<label for="content">내용:</label>
			<textarea class="form-control" rows="5" name="content" id="content"
				readonly="readonly">${boards.content}</textarea>
		</div>


<c:if test="${principal.user.username==boards.writer}">
		<div class="form-group text-right">
			<button type="button" class="btn btn-primary" id="btnupdate">수정하기</button>
			<button type="button" class="btn btn-danger" id="btndelete">삭제하기</button>
		</div>
</c:if>
		<br>
		<br>

		<div align="center">
			<textarea rows="3" cols="50" id="msg"></textarea>
			<button type="button" class="btn btn-secondary btn-sm"
				id="btnComment">댓글쓰기</button>
		</div>
		<div id="replyResult"></div>
	
</div>


<script>

var init = function(){
	$.ajax({
		type:"get",
		url : "/reply/commentList/"+$("#num").val()
	})
	.done(function(resp) {
		var str = "<table class='table table-hover mt-3'>"
			console.log(resp)
			$.each(resp,function(key,val){
				str +="<tr>"
				str +="<td>"+val.user.id+"</td>"
				str +="<td>"+val.content+"</td>"
				str +="<td>"+val.regdate+"</td>"
				if("${principal.user.id}"==val.user.id){					
				str += "<td> <a href = javascript:fdel('"+val.cnum+"')>삭제</a></td>"				
				}
				str +="</tr>"
			})
			str +="</table>"
			$("#replyResult").html(str);
	}).fail(function(e) {
			alert("실패 :" + e);
	})
}

	$("#btndelete").click(function() {
		if (!confirm("정말 삭제할까요?"))
			return false;
		$.ajax({
			type : "delete",
			url : "/board/delete/${boards.num}",
			success : function(resp) {
				if (resp == "success") {
					alert("삭제성공")
					location.href = "/board/list"
				}
			},
			error:function(e){
				alert("삭제 실패: "+e)
			}
		})
	})
	$("#btnupdate").click(function(){
		if(!confirm("정말 수정할까요?"))
			return false;
		location.href="/board/update/${boards.num}"
	})
	
	$("#btnComment").click(function(){
		if(${empty principal.user}){
			alert("로그인 하세요");
			location.href="/login"
			return;
		}
		if($("#msg").val()==""){
			alert("댓글을 입력하세요")
			return;
		}	
	var data={
			"bnum":$("#num").val(),
			"content":$("#msg").val()
	}
	$.ajax({
		type:"post",
		url:"/reply/commentInsert/"+$("#num").val(),
		contentType : "application/json;charset=utf-8",
		data : JSON.stringify(data)
	})
	.done(function(resp){
		alert("댓글 추가");
		init();
	})
	.fail(function(e){
		alert("댓글 추가 실패:"+e);
	})
	
})	
function fdel(cnum){
	$.ajax({
		type:"DELETE",
		url: "/reply/delete/"+cnum
	})
	.done(function(resp) {
			alert("댓글 삭제 완료")
			init()
	}).fail(function(e) {
			alert("댓글 삭제 실패 :" + e);
	})
}

init();
</script>

