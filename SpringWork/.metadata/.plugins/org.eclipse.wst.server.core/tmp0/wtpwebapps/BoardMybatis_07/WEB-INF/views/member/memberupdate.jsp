<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/includes/header.jsp"%>

<div class="jumbotron jumbotron-fluid">
  <div class="container">
    <h1>회원 정보 변경</h1>
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
					name="pass">
			</div>
			
				<div class="form-group">
				<label for="name">이름:</label> <input type="text"
					class="form-control" id="name" value="${sMember.name }" name="name">
			</div>
			<div class="form-group">
				<label for="addr">주소:</label> <input type="text"
					class="form-control" id="addr" value="${sMember.addr }"
					name="addr">
			</div>

			<br><br>
			<button type="button" class="btn btn-primary" id="btnChange">수정하기</button>
			
		</form>
		
		<script>
		$("#btnChange").click(function(){
			data={
					"id":$("#id").val(),
					"name":$("#name").val(),
					"pass":$("#pass").val(),
					"addr":$("#addr").val(),
			}
			$.ajax({
				type:"put",
				url:"/app07/member/update",
				contentType:"application/json;charset=utf-8",
				data:JSON.stringify(data),
				success:function(resp){
					alert("수정 성공")
					location.href="/app07/member/login"
				},
				error:function(e){
					alert("수정 실패:"+e)
				}
				
			})
		})
		</script>
	</div>

<%@ include file="../includes/footer.jsp"%>