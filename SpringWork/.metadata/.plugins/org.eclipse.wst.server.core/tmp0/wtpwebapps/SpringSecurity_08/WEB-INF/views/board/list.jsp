<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ include file="../includes/header.jsp"%>



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
	<c:forEach items="${boards }" var="board" varStatus="st">
		<tr>
		<td>${board.num}</td>
    	<td> <a href="view/${board.num}">${board.title }(${board.replyCnt })</a></td>
    	<td>${board.writer }</td>
    	<td><fmt:formatDate value="${board.regdate }" pattern="yyyy-MM-dd"/> </td>
    	<td>${board.hitcount }</td>
    	</tr>
	</c:forEach>
	</tbody>
	</table>
	
<%-- 	<div class="d-flex justify-content-between">
	<ul class="pagination mt-3">
  <c:if test="${p.startPage > p.blockPage}">
    <li class="page-item"><a class="page-link" 
    href="list?pageNum=${p.startPage-p.blockPage}&field=${param.field }&word=${param.word }">Previous</a>
    <a class="page-link" 
    href="list?pageNum=${p.startPage-p.blockPage}&field=${p.field }&word=${p.word }">Previous</a></li>
    </c:if>
   
    
    <c:forEach begin="${p.startPage }" end="${p.endPage }" var="i">
     <c:if test="${p.currentPage!=i}">
    <li class="page-item"><a class="page-link" href="list?pageNum=${i}&field=${param.field }&word=${param.word }">${i }</a>
    <a class="page-link" href="list?pageNum=${i}&field=${p.field }&word=${p.word }">${i }</a></li>
    </c:if>
    <c:if test="${p.currentPage==i}">
    <li class="page-item active"><a class="page-link" href="#">${i }</a></li>
     </c:if>
    </c:forEach>
    
	<c:if test="${p.endPage < p.totPage}">
    <li class="page-item">
    <a class="page-link" href="list?pageNum=${p.endPage+1 }&field=${param.field }&word=${param.word }">Next</a>
    <a class="page-link" href="list?pageNum=${p.endPage+1 }&field=${p.field }&word=${p.word }">Next</a></li>
    </c:if>
  </ul>
   --%>
  <form class="form-inline" action="/app07/list" method="get">
    <select class="form-control" id="field" name="field">
        <option value="content">내용</option>
        <option value="writer">작성자</option>
      </select>
    
	<input type="text" class="form-control"  name="word" id="word" placeholder="search">
	<button type="submit" class="btn btn-success">Search</button>
				
  </form>
  </div>
	</div>
	</div>
	
