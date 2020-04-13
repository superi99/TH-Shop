<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="css/style.css" rel="stylesheet" type="text/css" />
<title>Trang chủ</title>
</head>
<body>
	<%@include file="/common/header.jsp"%>

	<div class="wrap-content content">
		<div class="container flex-box">
			<div class="content-left ml-20">
				<c:if test="${empty article }">
					<div class="index" style="color: red">${error}</div>
				</c:if>
				<c:if test="${not empty article }">
					<div class="index">${article.title}</div>
					<img class="img-article" alt="title" src="${article.image }" />
					<p>${article.content }</p>
					<p class="author-inf">By ${article.author }  | ${article.date}</p>
				</c:if>
			</div>

			<!-- do something right here -->


			<%@include file="/common/right-content.jsp"%>
		</div>
	</div>
	<%@include file="/common/footer.jsp"%>
</body>
</html>