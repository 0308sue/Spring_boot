<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<sec:authorize access="isAnonymous()">
<a href="login">로그인</a>
</sec:authorize>
<sec:authorize access="isAuthenticated()">
<a href="logout">로그아웃</a>
principal:<sec:authentication property="principal"/> <br> <br>
Authentication:<sec:authentication property="principal.member"/><br> <br>
사용자 이름:<sec:authentication property="principal.member.username"/><br> <br>
사용자 ID:<sec:authentication property="principal.username"/><br> <br>
사용자 ID2:<sec:authentication property="principal.member.userid"/><br> <br>
</sec:authorize>
</body>
</html>