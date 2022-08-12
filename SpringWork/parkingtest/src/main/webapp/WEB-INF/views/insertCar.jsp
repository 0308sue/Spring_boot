<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ include file="/WEB-INF/views/includes/header.jsp"%>
<body>
<h1>입차</h1>

<form>
<input type="hidden" name="parkinglotId" id="parkinglotId" value="13">
차량번호 :<input type="text" id="carNum" placeholder="차 번호를 입력하세요" name="carNum"><br/>
차종 :<input type="text" id="carName" placeholder="차종을 입력하세요" name="carName"><br/>
차량 종류 :  
<label for="small">소형</label><input class="carType" type="radio" value = "소형" id = "carType" name ="carType" checked> 
<label for="big">대형</label><input class="carType" type="radio" value = "대형" id = "carType" name ="carType"> <br/>



정기권 사용 :  
<label for="month">월주차</label><input class="fee" type="radio" value = "300000" id = "month" name ="fee" checked> 
<label for="week">주주차</label><input class="fee" type="radio" value = "100000" id = "week" name ="fee"> <br/>
<label for="day">일주차</label><input class="fee" type="radio" value = "20000" id = "day" name ="fee"> <br/>
<label for="non">사용 안함</label><input class="fee" type="radio" value = "1500" id = "non" name ="fee"> <br/>

<br><br>
<button type="button" class="btn btn-primary" id="btninsert">입차</button>
</form>
		 <script>
		$("#btninsert").click(function(){
			
			let out = new Date(); 
			//alert($('input[name="fee"]:checked').id)
			if(!$("#carNum").val()){
				alert("차 번호를 입력하세요");
				$("#carNum").focus();
				return false;
			}
			if(!$("#carName").val()){
				alert("차종을 입력하세요");
				$("#carName").focus();
				return false;
			}
	
			var dataParam = {
					"carNum" : $("#carNum").val(),
					"carName" : $("#carName").val(),
					"carType" : $('input[name="carType"]:checked').val(),
					"fee" : $('input[name="fee"]:checked').val(),
					"parkingId": $("#parkinglotId").val(),
					"outtime": out
				}
			
			$.ajax({
				type:"post",
				url:"/insert",
				contentType:"application/json;charset=utf-8",
				data:JSON.stringify(dataParam)
			})
			.done(function(resp){
				if(resp=="success"){
					alert("차 번호:"+$("#carNum").val()+"  입차를 완료했습니다.")
					location.href="/list";
				}
			})
			.fail(function(e){
				alert("입차 실패")
			})
		})

		</script>
</body>
</html>