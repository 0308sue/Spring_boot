<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/includes/header.jsp"%>
<div class="jumbotron jumbotron-fluid">
	<div class="container">
		<h1>${members.username}님의 상세정보</h1>
	</div>
</div>

<div class="container ">
	
		<input type="hidden" name="id" id="id" value="${members.id }">
		<div class="form-group">
			<label for="username">아이디:</label> <input type="text"
				class="form-control" id="username" name="username" value="${members.username }"
				readonly="readonly">
		</div>

		<div class="form-group">
			<label for="password">비밀번호:</label> <input type="text" class="form-control"
				id="password" name="password" value="${members.password }"
				readonly="readonly">
		</div>

		<div class="form-group">
			<label for="password">Email:</label> <input type="text" class="form-control"
				id="email" name="email" value="${members.email }"
				readonly="readonly">
		</div>



<c:if test="${principal.member.username==members.username}">
		<div class="form-group text-right">
			<button type="button" class="btn btn-primary" id="btnupdate">수정하기</button>
			<button type="button" class="btn btn-danger" id="btndelete">탈퇴하기</button>
		</div>
</c:if>

<script>


	$("#btndelete").click(function() {
		if (!confirm("정말 탈퇴할까요?"))
			return false;
		$.ajax({
			type : "delete",
			url : "/delete/${members.id}",
			success : function(resp) {
				if (resp == "success") {
					alert("탈퇴성공")
					location.href = "/logout"
				}
			},
			error:function(e){
				alert("탈퇴 실패: "+e)
			}
		})
	})
	$("#btnupdate").click(function(){
		if(!confirm("정말 수정할까요?"))
			return false;
		location.href="/update/${members.id}"
	})
	


</script>
	
</div>



