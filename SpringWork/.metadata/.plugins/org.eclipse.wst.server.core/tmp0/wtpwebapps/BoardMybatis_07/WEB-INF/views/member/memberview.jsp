<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/includes/header.jsp"%>

<div class="jumbotron jumbotron-fluid">
  <div class="container">
    <h1>정보 상세보기</h1>
  </div>
</div>

<div class="container ">
		<form>
		

			<div class="row">
				<div class="col">
					<label for="id">아이디:</label> <input type="text"
						class="form-control" id="id" value="${sMember.id }"
						name="id" readonly="readonly">
				</div>

			</div>

			<div class="form-group">
				<label for="pass">비밀번호:</label> <input type="password"
					class="form-control" id="pass" value="${sMember.pass }"
					name="pass" readonly="readonly">
			</div>
			
				<div class="form-group">
				<label for="name">이름:</label> <input type="text"
					class="form-control" id="name" value="${sMember.name }" name="name" readonly="readonly">
			</div>
			<div class="form-group">
				<label for="addr">주소:</label> <input type="text"
					class="form-control" id="addr" value="${sMember.addr }"
					name="addr" readonly="readonly">
			</div>

			<br><br>
			<button type="button" class="btn btn-primary" id="btnUpdate">수정하기</button>
			<button type="button" class="btn btn-danger" id="btnDelete">탈퇴하기</button>
		</form>
		
		<script>
		$("#btnUpdate").click(function() {
			if (!confirm("정말 수정할까요?"))
				return false;
			location.href = "/app07/member/update"
		})

		$("#btnDelete").click(function() {
			if (!confirm("정말 탈퇴할까요?"))
				return false;
			$.ajax({
				type : "delete",
				url : "/app07/member/delete/${sMember.id}",
				success : function(resp) {
					if (resp == "success") {
						alert("탈퇴완료")
						location.href = "/app07/member/login"
					}
				}
			})
		})
		</script>
	</div>

<%@ include file="../includes/footer.jsp"%>