<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/includes/header.jsp"%>
<div class="container mt-5">
		<div class="form-group">
		<a href="fileInsert"><button class="btn btn-secondary bt-sm">파일 글쓰기</button></a>
		
		</div>
		<div class="row">
			<c:forEach items="${files }" var="fboard">
				<div class="col">
					<div class="card" style="width: 200px">
						<img class="card-img-top" src="/resources/img/${fboard.fileimage }"
							alt="Card image" style="width: 100%" >
						<div class="card-body">
							<h4 class="card-title">title : ${fboard.title }</h4>
							<p class="card-text">writer : ${fboard.writer }</p>
							 <p class="card-text">content : ${fboard.content }</p>
						</div> <!-- card-body -->
					</div> <!-- card -->
				</div> <!-- col -->
			</c:forEach>
		</div> <!-- row -->

	</div>
