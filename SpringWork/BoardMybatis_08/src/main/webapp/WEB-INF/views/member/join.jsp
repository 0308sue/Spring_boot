<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/includes/header.jsp"%>

<div class="jumbotron jumbotron-fluid">
  <div class="container">
    <h1>회원가입</h1>
  </div>
</div>

<div class="container ">
		<form>
		

			<div class="row">
				<div class="col">
					<label for="id">아이디:</label> <input type="text"
						class="form-control" id="id" placeholder="Enter id"
						name="id">
				</div>
				<div class="col align-self-end">
					<button type="button" class="btn btn-secondary" id="idCheckBtn">중복확인</button>
				<span id="idcheck"></span>
				</div>
			</div>

			<div class="form-group">
				<label for="pass">비밀번호:</label> <input type="password"
					class="form-control" id="pass" placeholder="Enter password"
					name="pass">
			</div>
			<div class="form-group">
				<label for="pass_check">비밀번호 확인:</label> <input
					type="password" class="form-control" id="pass_check"
					placeholder="Enter password_check" name="pass_check">
			</div>
				<div class="form-group">
				<label for="name">이름:</label> <input type="text"
					class="form-control" id="name" placeholder="Enter name" name="name">
			</div>
			<div class="form-group">
				<label for="addr">주소:</label> <input type="text"
					class="form-control" id="addr" placeholder="Enter address"
					name="addr">
			</div>

			<br><br>
			<button type="button" class="btn btn-primary" id="btnJoin">회원가입</button>
		</form>
		
		<script>
		$("#btnJoin").click(function(){
			
			if(!$("#id").val()){
				alert("아이디를 입력하세요");
				$("#id").focus();
				return false;
			}
			if(!$("#pass").val()){
				alert("비밀번호를 입력하세요");
				$("#pass").focus();
				return false;
			}
			if(!$("#name").val()){
				alert("이름을 입력하세요");
				$("#name").focus();
				return false;
			}
			if(!$("#addr").val()){
				alert("주소를 입력하세요");
				$("#addr").focus();
				return false;
			}
	
			data = {
					"id" : $("#id").val(),
					"pass" : $("#pass").val(),
					"name" : $("#name").val(),
					"addr" : $("#addr").val()
				}
			
			$.ajax({
				type:"post",
				url:"/app07/member/join",
				contentType:"application/json;charset=utf-8",
				data:JSON.stringify(data)
			})
			.done(function(resp){
				if(resp=="success"){
					alert("회원가입을 축하합니다.")
					location.href="login";
				}else if(resp=="fail"){
					alert("아이디 중복확인")
					$("#id").val("");
				}
			})
			.fail(function(e){
				alert("회원가입 실패")
			})
		})
		
		$("#idCheckBtn").click(function(){
			if(!$("#id").val()){
				alert("아이디를 입력하세요");
				$("#id").focus();
				return false;
			}

			$.ajax({
				type:"get",
				url:"/app07/member/idcheck",
				data:{"id" : $("#id").val()}
			})
			.done(function(resp){
				if(resp==0){
					$("#idcheck").html("<b>사용 가능한 아이디</b>")
				}else{
					$("#idcheck").html("<b>사용 불가능한 아이디</b>")
				$("#id").val("");
				$("#id").focus();
				}
			})
		})
		</script>
	</div>

<%@ include file="../includes/footer.jsp"%>