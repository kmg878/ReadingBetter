<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="/readingbetter/assets/dist/css/bootstrap.min.css" rel="stylesheet" type="text/css">
<link href="/readingbetter/assets/css/admin.css" rel="stylesheet" type="text/css">
<title>ReadingBetter_Admin</title>
</head>
<body>
	<c:import url='/WEB-INF/views/admin/header.jsp' />
	<br>
	<br>
	<h4>공지</h4>
	<div>
		<table id="board" class="table table-bordered table-hover tbl-notice-list">
			<thead>
				<tr>
					<th>번호</th>
					<th>제목</th>
					<th>작성일</th>
				</tr>
			</thead>
			<tbody>
				<c:set var="countList" value="${fn:length(list)}"/>
				<c:forEach var='vo' items='${list}' varStatus='s'>
				<tr>
					<td>${countList-s.index}</td>
					<td id="ntitle"><a href="/readingbetter/admin/noticeview/${vo.no }">${vo.title }</a></td>
					<td>${vo.regDate }</td>
				</tr>
				</c:forEach>
			</tbody>
		</table>
		<div id="buttons">
			<a href="/readingbetter/admin/noticewriteform" class="btn btn-default">추가</a>
		</div>
	</div>
</body>
</html>