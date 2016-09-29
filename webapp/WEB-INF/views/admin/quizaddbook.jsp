<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ReadingBetter_Admin</title>
<link href="/readingbetter/assets/dist/css/bootstrap.min.css" rel="stylesheet" type="text/css">
<link href="/readingbetter/assets/css/board.css" rel="stylesheet" type="text/css">
<link href="/readingbetter/assets/css/admin.css" rel="stylesheet" type="text/css">
</head>
<body>
<c:import url='/WEB-INF/views/admin/header.jsp'></c:import>
<br><br>
<h4>도서 관리</h4>
	<div id="board">	
		<table class="tbl-ex">		
			<tr>
				<th>번호</th>
				<th>제목</th>
				<th>작가</th>
				<th>출판사</th>
				<th>사진</th>
				<th>선택</th>
			</tr>
		 	<c:set var="countList" value="${fn:length(bookList)}"/>
	 	 	<c:forEach var='vo' items='${bookList}' varStatus='s'>
				<tr>
					<td>${countList-s.index }</td>
					<td>${vo.title }</td>
					<td>${vo.authorName }</td>
					<td>${vo.publisherTitle }</td>
					<td><img class="img-thumbnail" src="${vo.cover }"></td>
					<td><a href="/readingbetter/admin/quizaddform/${vo.no }" class="btn btn-default">선택</a></td>
				</tr>
	  		</c:forEach>
		</table>
	</div>
</body>
</html>