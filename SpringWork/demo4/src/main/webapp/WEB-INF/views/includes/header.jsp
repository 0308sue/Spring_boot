<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
     <%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
  <script src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>

</head>
<sec:authorize access="isAuthenticated()">
<sec:authentication property="principal" var="principal"/>
</sec:authorize>
<div align="center">
<h1>Security JPA Board</h1>
</div>
<!-- 왼 -->
<nav class="navbar navbar-expand-sm bg-success navbar-dark mb-5">
<div class="container">
  <!-- Links -->
  <ul class="navbar-nav mr-auto">
    <li class="nav-item">
      <a class="navbar-brand" href="/board/list">Board List</a>
    </li>
    <li class="nav-item">
      <a class="navbar-brand" href="/board/insert">Board Insert</a>
    </li> 
    <li class="nav-item">
      <a class="navbar-brand" href="/file/insert">File Insert</a>
    </li>
    <li class="nav-item">
      <a class="navbar-brand" href="/file/fileList">File List</a>
    </li>
  
  </ul>

<ul class="navbar-nav">
			<sec:authorize access="isAnonymous()">
				<li class="nav-item"><a class="navbar-brand"
					href="/register">회원가입</a></li>
					<li class="nav-item"><a class="navbar-brand"
					href="/login">로그인</a></li>	
		   </sec:authorize>
			<sec:authorize access="isAuthenticated()">
				<li class="nav-item">
				<a class="navbar-brand" 	href="/logout">
				   로그아웃(${principal.user.username}) 
					/<sec:authentication property="principal.user.username"/> </a></li>	
			</sec:authorize>
			</ul>


</div>
</nav>