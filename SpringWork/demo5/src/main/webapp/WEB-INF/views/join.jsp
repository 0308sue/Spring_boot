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
		
				<div class="form-group">
					<label for="username">아이디:</label> <input type="text"
						class="form-control" id="username" placeholder="Enter id"
						name="username">
				</div>
				
			<div class="form-group">
				<label for="pass">비밀번호:</label> <input type="password"
					class="form-control" id="password" placeholder="Enter password"
					name="password">
			</div>
			<div class="form-group">
				<label for="email">이메일:</label> <input type="text"
					class="form-control" id="email" placeholder="Enter email"
					name="email">
			</div>

			<br><br>
			<button type="button" class="btn btn-primary" id="btnJoin">회원가입</button>
		</form>
		
		 <script>
		$("#btnJoin").click(function(){
			
			if(!$("#username").val()){
				alert("아이디를 입력하세요");
				$("#username").focus();
				return false;
			}
			if(!$("#password").val()){
				alert("비밀번호를 입력하세요");
				$("#password").focus();
				return false;
			}
			if(!$("#email").val()){
				alert("이메일을 입력하세요");
				$("#email").focus();
				return false;
			}

	
			var dataParam = {
					"username" : $("#username").val(),
					"password" : $("#password").val(),
					"email" : $("#email").val(),
				}
			
			$.ajax({
				type:"post",
				url:"/register",
				contentType:"application/json;charset=utf-8",
				data:JSON.stringify(dataParam)
			})
			.done(function(resp){
				if(resp=="success"){
					alert("회원가입을 축하합니다.")
					location.href="login";
				}else if(resp=="fail"){
					alert("아이디 중복")
					$("#username").val("");
				}
			})
			.fail(function(e){
				alert("회원가입 실패")
			})
		})

		</script>
	</div>
