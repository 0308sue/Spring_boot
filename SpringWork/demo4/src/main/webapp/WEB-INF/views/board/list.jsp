<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ include file="/WEB-INF/views/includes/header.jsp"%>



<div class="jumbotron jumbotron-fluid">
<div class="container mb-5">
<h1>게시글 목록(${count })</h1>
</div>
  <div class="container">
<table class="table table-hover">
    <thead>
      <tr>
        	<th>번호</th>
			<th>제목</th>
			<th>작성자</th>
			<th>작성일</th>
			<th>조회수</th>
			
      </tr>
	</thead>
	<tbody>
	<c:forEach items="${boards.content }" var="board" varStatus="st">
		<tr>
		<td>${board.num}</td>
    	<td> <a href="/board/view/${board.num}">${board.title }</a></td>
    	<td>${board.writer }</td>
    	<td><fmt:formatDate value="${board.regdate }" pattern="yyyy-MM-dd"/> </td>
    	<td>${board.hitcount }</td>
    	</tr>
	</c:forEach>
	</tbody>
	</table>
		<div  class="d-flex justify-content-between mt-5 mr-auto">
			<c:choose>
				<c:when test="${boards.first }">
				[First]
				<a href="?page=${boards.number+1 }">다음</a>
				</c:when>
				<c:when test="${boards.last }">
				<a href="?page=${boards.number-1 }">이전</a>
				</c:when>
			</c:choose>
		
		
		<div>

			<form class="form-inline" action="/board/list" method="get">
				<select name="field" class="form-control mr-sm-1">
				<option value="title">제목</option>
				<option value="content">내용</option> 
				</select>
				<input type="text" name="word" class="form-control" placeholder="Search">
				<button class="btn btn-secondary">Search</button>
			</form>
		</div>
	</div>
	
	</div>
	</div>
