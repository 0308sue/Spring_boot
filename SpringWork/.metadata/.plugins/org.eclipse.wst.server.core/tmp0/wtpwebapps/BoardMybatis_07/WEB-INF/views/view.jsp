<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="includes/header.jsp"%>
<div class="jumbotron jumbotron-fluid">
	<div class="container">
		<h1>${board.writer }의글보기</h1>
	</div>
</div>

<div class="container ">
	
		<input type="hidden" name="num" id="num" value="${board.num }">
		<div class="form-group">
			<label for="title">제목:</label> <input type="text"
				class="form-control" id="title" name="title" value="${board.title }"
				readonly="readonly">
		</div>

		<div class="form-group">
			<label for="pwd">글쓴이:</label> <input type="text" class="form-control"
				id="writer" name="writer" value="${board.writer }"
				readonly="readonly">
		</div>

		<div class="form-group">
			<label for="content">내용:</label>
			<textarea class="form-control" rows="5" name="content" id="content"
				readonly="readonly">${board.content}</textarea>
		</div>

<c:if test="${sessionScope.sMember.id==board.writer}">

		<div class="form-group text-right">
			<button type="button" class="btn btn-secondary" id="btnupdate">수정하기</button>
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
		<hr>
		<div id="replyResult"></div>
	
</div>


<script>
var init = function(){
	$.ajax({
		type:"get",
		url : "/app07/reply/commentList",
		data : {"bnum" : $("#num").val()}
	})
	.done(function(resp) {
			var str = "";
			$.each(resp,function(key,val){
				str += val.userid+" "
				str += val.content+" "
				str += val.regdate+" "
				if("${sessionScope.sMember.id}"==val.userid){					
				str += " <a href = javascript:fdel('"+val.cnum+"')>삭제</a><br/>"
				}
				str +="<br/>"
			})
			$("#replyResult").html(str);
	}).fail(function(e) {
			alert("실패 :" + e);
	})
}

function fdel(cnum){
	$.ajax({
		type:"DELETE",
		url: "/app07/reply/delete/"+cnum
	})
	.done(function(resp) {
			alert(resp+"번 글 삭제 완료")
			init()
	}).fail(function(e) {
			alert("댓글 삭제 실패 :" + e);
	})
}

	$("#btnComment").click(function() {
		if(${empty sessionScope.sMember}){
			alert("로그인 하세요")
			location.href="/app07/member/login"
			return;
		}
		
		if ($("#msg").val() == "") {
			alert("댓글을 입력하세요")
			return;
		}
		data = {
			"bnum" : $("#num").val(),
			"content" : $("#msg").val(),
		}
		console.log(data)
		$.ajax({
			type : "post",
			url : "/app07/reply/commentInsert",
			contentType : "application/json;charset=utf-8",
			data : JSON.stringify(data)
		}).done(function() {
			alert("댓글 추가");
			init();
		}).fail(function(e) {
			alert("댓글 추가 실패 :" + e);
		})
	})

	$("#btnupdate").click(function() {
		if (!confirm("정말 수정할까요?"))
			return false;
		location.href = "/app07/update/${board.num}"
	})

	$("#btndelete").click(function() {
		if (!confirm("정말 삭제할까요?"))
			return false;
		$.ajax({
			type : "delete",
			url : "/app07/delete/${board.num}",
			success : function(resp) {
				if (resp == "success") {
					alert("삭제성공")
					location.href = "/app07/list"
				}
			}
		})
	})
	init();
</script>

<%@ include file="includes/footer.jsp"%>