<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>MongoDB Update</h2>
	<form action="update" method="post">
		empno:<input type="text" name="empno" value="${emp.empno}" readonly="readonly"/><br/>
		ename:<input type="text" name="ename" value="${emp.ename}"/><br/>
		job:<input type="text" name="job" value="${emp.job}"/><br/>
		deptno:<input type="text" name="deptno" value="${emp.deptno}"/><br/>
		<input type="submit" value="수정" >
		<input type="reset" value="취소" >
	</form>
</body>
</html>