<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ include file="/WEB-INF/views/includes/header.jsp"%>



<div class="jumbotron jumbotron-fluid">
<div class="container mb-5">
<h1>회원 목록(${count })</h1>
</div>
  <div class="container">
<table class="table table-hover">
    <thead>
      <tr>
        	<th>아이디</th>
			<th>이메일</th>
			<th>등록일</th>

			
      </tr>
	</thead>
	<tbody>
	<c:forEach items="${members.content }" var="member" varStatus="st">
		<tr>
    	<td> <a href="/view/${member.id}">${member.username}</a></td>
    	<td>${member.email }</td>
    	<td><fmt:formatDate value="${member.regdate }" pattern="yyyy-MM-dd"/> </td>
    	</tr>
	</c:forEach>
	</tbody>
	</table>
		<div  class=" justify-content-between mt-5 mr-auto">
			<c:choose>
				<c:when test="${members.first }">
				[First]
				<a href="?page=${members.number+1 }">다음</a>
				</c:when>
				<c:when test="${members.last }">
				<a href="?page=${members.number-1 }">이전</a>
				</c:when>
			</c:choose>
		<br><br><br>
		
		<div>
			<form class="form-inline" action="/list" method="get">
				<input type="text" name="word" class="form-control" placeholder="아이디 Search">
				<button class="btn btn-secondary">Search</button>
			</form>
		</div>
	</div>
	
	</div>
	</div>
