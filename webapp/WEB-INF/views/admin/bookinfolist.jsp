<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<!doctype html>
<html>
<head>
<title>ReadingBetter_Admin</title>
<meta http-equiv="content-type" content="text/html; charset=utf-8">
<link href="/readingbetter/assets/dist/css/bootstrap.min.css" rel="stylesheet" type="text/css">
<link href="/readingbetter/assets/css/admin.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="http://code.jquery.com/jquery-1.7.2.min.js"></script>
</head>
<body>
	<div class="container-fluid">
		<c:import url='/WEB-INF/views/admin/header.jsp' />
		<div class="row asideWrap">
			<br>
			<br>
			<h4>출판사/작가 관리</h4>
			<div id="content" class="col-lg-6">
				<br>
				<form id="search_form" action="/readingbetter/admin/insert" method="post">
					<input type="text" id="publisher" name="title">
					<input type="submit" value="출판사추가">
				</form>
				<br>
				<form id="search_form" action="/readingbetter/admin/bookinfolist" method="get">
					<input type="text" id="kwd" name="kwd1" value="${param.kwd1 }">
					<input type="submit" value="출판사검색">
				</form>
				<br>
				<h5>출판사 관리</h5>
				<table class="tbl-ex">		
					<tr>
						<th>번호</th>
						<th>이름</th>
					</tr>				
					<c:set var="countList" value="${fn:length(publisherlist)}"/>
			  		<c:forEach var='publisherVo' items='${publisherlist}' varStatus='s'>
						<tr>
							<td>${countList-s.index}</td>
							<td>${publisherVo.title }</td>
						</tr>
			 		</c:forEach>
				</table>
			</div>
			
			<div id="content" class="col-lg-6">
				<br>
				<form id="search_form" action="/readingbetter/admin/insertauthor" method="post">
					<input type="text" id="author" name="name" >
					<input type="submit" value="작가추가">
				</form>
				<br>
				<form id="search_form" action="/readingbetter/admin/bookinfolist" method="get">
					<input type="text" id="kwd" name="kwd2" value="${param.kwd2 }">
					<input type="submit" value="작가검색">
				</form>
								
				<br>
				<h5>작가 관리</h5>
				<table class="tbl-ex">		
					<tr>
						<th>번호</th>
						<th>이름</th>
					</tr>				
					<c:set var="countList" value="${fn:length(authorlist)}"/>
			  		<c:forEach var='authorVo' items='${authorlist}' varStatus='s'>
						<tr>
							<td>${countList-s.index}</td>
							<td>${authorVo.name }</td>
						</tr>
			 		</c:forEach>
				</table>
			</div>
		</div>
		<div class="row"></div>
	</div>
</body>
</html>