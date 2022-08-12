<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/includes/header.jsp"%>

<div class="jumbotron jumbotron-fluid">
  <div class="container">
    <h1>로그인</h1>
  </div>
</div>

<div class="container ">
		<form>		
				<div class="form-group">
				<label for="id">아이디:</label> <input type="text"
					class="form-control" id="id" placeholder="Enter id" name="id">
			</div>
			<div class="form-group">
				<label for="pass">비밀번호:</label> <input type="password"
					class="form-control" id="pass" placeholder="Enter pass"
					name="pass">
			</div>

			<br><br>
			<button type="button" class="btn btn-primary" id="btnLogin">로그인</button>
		</form>
		
		<script>
		$("#btnLogin").click(function(){
			   if($("#id").val()==""){
					alert("아이디 입력");
					$("#id").focus();
					return false;
				}
				if($("#pass").val()==""){
					alert("비밀번호 입력");
					$("#pass").focus();
					return false;
				}
				$.ajax({
					type:"post",
					url : "/app07/member/login",
					data:{"id" : $("#id").val(),"pass" : $("#pass").val()}
				}).done(function(resp){
						if(resp=="no"){
							alert("회원이 아닙니다.회원가입 하세요.")
							location.href = "join"
						}
						else if(resp=="success"){
							alert("로그인 성공 ")
							location.href = "/app07/";
						}
						else {
							alert("비밀번호를 확인하세요")
						}
		   })
		})
		
		</script>
	</div>

<%@ include file="../includes/footer.jsp"%>