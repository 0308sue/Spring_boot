<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<body>
<h3>list</h3>

<c:forEach items="${lists.content}" var="member">
번호 : ${member.id } <br>
이름 : ${member.name } <br>
주소 : ${member.addr } <br>
이메일 : ${member.email } <br>
<a href="detail/${member.id }">상세보기</a>
<button type="button" onclick="funDelete(${member.id })">삭제</button><br><br>
</c:forEach>
<%-- <a href="?page=${lists.number-1 }">이전</a>
<a href="?page=${lists.number+1 }">다음</a> --%>
<c:choose>
<c:when test="${lists.first }">
[First]
<a href="?page=${lists.number+1 }">다음</a>
</c:when>
<c:when test="${lists.last }">
<a href="?page=${lists.number-1 }">이전</a>
</c:when>
</c:choose>
<script>

function funDelete(id){
	$.ajax({
		type : "DELETE",
		url : "/delete/"+id
		})
		.done( function(resp) {
				alert(resp+"삭제완료")
				location.href = "/list"
				})
				.fail(function(e){
					alert("삭제실패")
				})
}

</script>
</body>
</html>