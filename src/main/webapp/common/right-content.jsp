<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:useBean id="art" class="com.digitalnews.beans.ArticleBean" />

<div class="content-right ml-20">
	
		<div class="index">${art.newest.title}</div>
		<p>${art.newest.shortContent }...</p>
		
	
	<div class="index">Search</div>
	<form class="flex-box" action="tim-kiem" method="POST">
		<input required class="text" type="text" name="textSearch"
			value="${model.textSearch }" /> <input class="btn-submit text-bold"
			type="submit" value="Go" />
	</form>

	<c:if test="${not empty art.articles}">
		<div class="index">Last Articles</div>
		<ul class="list">
			<c:forEach var="a" items="${art.articles}">
				<c:url var="article" value="chi-tiet">
					<c:param name="id" value="${a.id }" />
				</c:url>
				<li class="item"><a href="${article}">${a.title}</a></li>
			</c:forEach>
		</ul>
	</c:if>
</div>