<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="css/style.css" rel="stylesheet" type="text/css" />
<title>Tìm kiếm</title>
</head>
<body>
	<%@include file="/common/header.jsp"%>
	<div class="wrap-content content">
		<div class="container flex-box">
			<div class="content-left ml-20">
				
				<c:if test="${empty model }">
					<div class="index" style="color: red">${error}</div>
				</c:if>
				<c:if test="${not empty model.totalItem }">
					<c:forEach var="m" items="${model.listResult }">

						<div class="article-item">
							<div class="index">
								<c:url var="article" value="chi-tiet">
									<c:param name="id" value="${m.id }" />
								</c:url>
								<a href="${article }" class="text-green none-decorator">${m.title }</a>
							</div>
							<div>
								<div class="pr-10">
									<img class="small-img fl-l"  alt="title" src="${m.image }" />
								</div>
								
								<p class="mg-0" >${m.shortContent}...</p>
							
									
								
								<div class="clear"></div>
							</div>
						</div>
					</c:forEach>

				</c:if>


				<form action="tim-kiem" method="post">
					<input type="hidden" name="page" value="" id="page" /> <input
						type="hidden" name="maxPageItem" value="2" /> <input
						type="hidden" name="textSearch" value="${model.textSearch }" />

					<ul class="flex-box page-list">
						<c:forEach var="page" begin="1" end="${model.totalPage}" step="1">
							<li><a onclick="nextPage(${page});" href="#"
								${model.page == page? "class = 'active'":"" }>${page}</a></li>
						</c:forEach>

					</ul>
				</form>
			</div>
			<!-- do something right here -->


			<%@include file="/common/right-content.jsp"%>
		</div>
	</div>
	<%@include file="/common/footer.jsp"%>
	<script type="text/javascript">
		function nextPage(page) {
			document.getElementById("page").value = page;
			document.forms[0].submit();
		}
	</script>
</body>
</html>
