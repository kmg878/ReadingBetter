<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>ReadingBetter_Admin</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="/readingbetter/assets/dist/css/bootstrap.min.css" rel="stylesheet" type="text/css">
<link href="/readingbetter/assets/css/admin.css" rel="stylesheet" type="text/css">
</head>
<body>
	<c:import url='/WEB-INF/views/admin/header.jsp' />
	<br>
	<br>
	<h4>공지 쓰기</h4>
	<div>
	<form action="noticewrite" method="post">
		<input type="hidden" name="memberNo" value="${authUser.no }">
		<table id="board" class="table table-bordered">
			<tr>
				<th>제목</th>
				<td><input type="text" class="form-control" name="title"></td>
			</tr>
			<tr>
				<th colspan=2>내용</th>
			</tr>
			<tr>
				<td id="content" colspan=2>
					<textarea id="content" name="content" class="form-control"></textarea>
				</td>
			</tr>
		</table>
		<div id="buttons">
			<a href="/readingbetter/admin/noticelist" class="btn btn-default">목록</a>
			<button type="submit" class="btn btn-default">제출</button>
		</div>
	</form>
	</div>
</body>
</html>