<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../includes/header.jsp"%>
<div class="container">

<sec:authorize access="isAuthenticated()">
  <input type="hidden" id="prin" name="prin" 
  value ='<sec:authentication property="principal.username"/>' />
</sec:authorize>

<sec:authorize access="isAnonymous()">
  <input type="hidden" id="prin" name="prin"  value="null"  />
</sec:authorize>
	<h3>${board.writer }의글보기</h3>
	<div class="form-group">
		<label for="num">글번호:</label> <input type="text" class="form-control"
			id="num" name="num" value="${board.num }" readonly="readonly">
	</div>
	<div class="form-group">
		<label for="title">제목:</label> <input type="text" class="form-control"
			id="title" name="title" value="${board.title }" readonly="readonly">
	</div>
	<div class="form-group">
		<label for="pwd">글쓴이:</label> <input type="text" class="form-control"
			id="writer" name="writer" value="${board.writer }"
			readonly="readonly">
	</div>
	<div class="form-group">
		<label for="content">내용</label>
		<textarea class="form-control" rows="5" id="content" name="content"
			readonly="readonly">${board.content }</textarea>
	</div>

	<sec:authentication property="principal" var="pinfo" />
	<sec:authorize access="isAuthenticated()">
		<c:if test="${pinfo.username ==board.writer  }">
			<div class="form-group text-right">
				<button type="button" class="btn btn-secondary btn-sm"
					id="btnUpdate">수정</button>
				<button type="button" class="btn btn-danger btn-sm" id="btnDelete">삭제</button>
			</div>
		</c:if>
	</sec:authorize>
	<br /> <br />
	<div align="center">
		<textarea rows="3" cols="50" id="msg"></textarea>
		<button type="button" class="btn btn-secondary btn-sm" id="btnComment">댓글쓰기</button>
	</div>
	<hr/>
	<div id="replyResult"></div>
</div>
<script>
init = function(){
	$.ajax({
		type:"get",
		url : "/app08/reply/commentList/${board.num}"
	}).done(function(resp){
		var str ="";
		$.each(resp, function(key, val){
			str += val.userid +"  "
			str += val.content +"  "
			str += val.regdate +"  "
			if($("#prin").val() ==val.userid ){
				str +="<a href='javascript:fdel("+val.cnum+")'>삭제</a>"
			}
			str+="<br/>"
		})
		$("#replyResult").html(str);
	}).fail(function(resp){
		alert("실패")
	})
}
 $("#btnComment").click(function(){
	 if($("#prin").val()=="null"){
		 alert("로그인하세요")
		 location.href="/app08/customLogin"
		 return;
	 }
	if( $("#msg").val()==""){
		alert("댓글을 입력하세요")
		return;
	}
	dataStr = {
			"bnum" : $("#num").val(),
			"content" : $("#msg").val(),
			"userid" : $("#prin").val(),
	}
	$.ajax({  //commentInsert
		type:"post",
		url : "/app08/reply/commentInsert",
		contentType : "application/json;charset=utf-8",
		data : JSON.stringify(dataStr)
	})
	.done(function(){
		alert("댓글 추가 성공")
		init()
	})
	.fail(function(e){
		alert("댓글 추가 실패 : " + e)
	})
 })
 
 function fdel(cnum){
	$.ajax({
		type:"delete",
		url: "/app08/reply/delete/"+cnum
	})
	.done(function(resp) {
			alert(resp+"번 글 삭제 성공")
			init()
	}).fail(function(e) {
			alert("댓글 삭제 실패 :" + e);
	})
}
 
 $("#btnUpdate").click(function() {
		if (!confirm("정말 수정할까요?"))
			return false;
		location.href = "/app08/update/${board.num}"
	})
	$("#btnDelete").click(function() {
		if (!confirm("정말 삭제할까요?"))
			return false;
		$.ajax({
			type : "delete",
			url : "/app08/delete/${board.num}",
			success : function(resp) {
				if (resp == "success") {
					alert("삭제성공")
					location.href = "/app08/list"
				}
			}
		})
	})

init()
</script>