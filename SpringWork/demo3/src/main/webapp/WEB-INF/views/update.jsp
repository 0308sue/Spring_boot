<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<body>
<h3>update</h3>
id 		: <input type="text" name="id" id="id" value="${member.id }" readonly="readonly"> <br> <br>
Name	: <input type="text" name="name" id="name" value="${member.name }"> <br> <br>
Password: <input type="password" name="password" id="password"> <br> <br>
Email	: <input type="text" name="email" id="email" size="30" value="${member.email }"> <br> <br>
Addr	: <input type="text" name="addr" id="addr" size="30" value="${member.addr }"> <br> <br>
Memo	: <textarea rows="5" cols="50" name="memo" id="memo" >${member.memo }</textarea> <br> <br>
<button type="button" id="btnUpdate">수정하기</button>
<script src="/js/member.js"></script>
</body>
</html>