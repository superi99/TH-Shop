<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="css/style.css" rel="stylesheet" type="text/css" />
<title>Lỗi</title>
</head>
<body>
	<%@include file="/common/header.jsp"%>

	<div class="wrap-content content">
		<div class="container flex-box pt-10">
			<div class="content-left ml-20">
				<div class="index" style="color: red">${error }</div>
				<!-- do something right here -->

			</div>
			<%@include file="/common/right-content.jsp"%>
		</div>
	</div>
	<%@include file="/common/footer.jsp"%>
</body>
</html>