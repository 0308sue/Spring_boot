<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ include file="/WEB-INF/views/includes/header.jsp"%>

	<script>
	
	
		function minutes(intime,id){
				
			const date1 = new Date();
			
			const date2 = new Date(intime);
	
			const elapsedMSec = date1.getTime() - date2.getTime(); 
			
			const elapsedMin = Math.ceil(elapsedMSec / 1000 / 60);
			//alert(elapsedMin)
			
			document.getElementById(id).innerHTML = elapsedMin;
	} 

		function mleftdays(intime,id){
			
			const date3 = new Date();
			
			const date4 = new Date(intime);
	
			const leftMSec = date3.getTime() - date4.getTime(); 
			
			const useday = Math.floor(leftMSec / (1000 * 3600 * 24));
			
			const mleftday = 30 - useday;
			document.getElementById(id).innerHTML = mleftday;
	} 
		
		function wleftdays(intime,id){
					
					const date5 = new Date();
					
					const date6 = new Date(intime);
			
					const leftMSec = date5.getTime() - date6.getTime(); 
					
					const useday = Math.floor(leftMSec / (1000 * 3600 * 24));
					
					const wleftday = 7 - useday;
					document.getElementById(id).innerHTML = wleftday;
	}
		
		function fee(intime,id){
			
			const date7 = new Date();
			
			const date8 = new Date(intime);
	
			const leftsMSec = date7.getTime() - date8.getTime(); 
			
			const elapsedMin = Math.ceil(leftsMSec / 1000 / 60);
			
			const payfee = 1000*((elapsedMin - 10)/10)+1500;
			document.getElementById(id).innerHTML = payfee;
}


</script>

<div class="jumbotron jumbotron-fluid">
<div class="container mb-5">
<h1>입차 목록(${count })</h1>
</div>
  <div class="container">
<table class="table table-hover">
    <thead>
      <tr>
        	<th>차번호</th>
			<th>차종</th>
			<th>주차유형</th>
			<th>이용시간</th>
			<th>요금</th>
			<th>출차</th>

      </tr>
	</thead>
	<tbody>
	<c:forEach items="${cars.content }" var="car" varStatus="st">
		<tr>	
		<td>${car.carNum} 
		<input type="hidden" id="fee" value="${car.fee }">
		<input type="hidden" id="intime" value="${car.intime }"></td>
    	<td> <a href="/view/${car.carNum}">${car.carName }</a></td>
    	<td>${car.parkingType }</td>
    	<c:choose>
    	<c:when test="${car.parkingType eq '월주차' }">
    	<td >
    		<span id='spanID1${st.index}'></span><script>mleftdays('${car.intime }' ,'spanID1${st.index}')</script>  
    		일 남음</td>
    	</c:when>
    	<c:when test="${car.parkingType eq '주주차' }">
    	<td >
    		<span id='spanID2${st.index}'></span><script>wleftdays('${car.intime }' ,'spanID2${st.index}')</script>  
    		일 남음</td>
    	</c:when>
    	<c:when test="${car.parkingType eq '일주차' }">
    	<td>일주차</td>
    	</c:when>
    	<c:otherwise>
    		<td >
    		<span id='spanID3${st.index}'></span><script>minutes('${car.intime }' ,'spanID3${st.index}')</script>  
    		분</td>
    	</c:otherwise>
    	</c:choose>
    	<c:choose>
    	<c:when test="${car.parkingType eq '월주차' }">
    	<td>월주차</td>
    	</c:when>
    	<c:when test="${car.parkingType eq '주주차' }">
    	<td>주주차</td>
    	</c:when>
    	<c:when test="${car.parkingType eq '일주차' }">
    	<td>일주차</td>
    	</c:when>
    	<c:otherwise>
    		<td >
    		<span id='spanID4${st.index}'></span><script>fee('${car.intime }' ,'spanID4${st.index}')</script>  
    		원</td>
    	</c:otherwise>
    	</c:choose>
    	<td><button type="button" class="btn btn-danger" id="btnout">출차</button></td>
    	</tr>
	</c:forEach>
	</tbody>
	</table>
		<div  class="d-flex justify-content-between mt-5 mr-auto">
			<c:choose>
				<c:when test="${cars.first }">
				[First]
				<a href="?page=${cars.number+1 }">다음</a>
				</c:when>
				<c:when test="${cars.last }">
				<a href="?page=${cars.number-1 }">이전</a>
				</c:when>
			</c:choose>
		
		
		<div>
			<form class="form-inline" action="/list" method="get">
				<select name="field" class="form-control mr-sm-1" >
				<option value="carNum">차번호</option>
				<option value="parkingType">주차 유형</option> 
				</select>
				
				<input type="text" name="word" class="form-control" placeholder="Search">
				<button class="btn btn-secondary">Search</button>
				
			</form>
		</div>
	</div>
	
	</div>
	</div>
	
	

