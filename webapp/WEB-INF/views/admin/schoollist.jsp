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
<link href="/readingbetter/assets/css/board.css" rel="stylesheet" type="text/css">
<link href="/readingbetter/assets/css/admin.css" rel="stylesheet" type="text/css">
</head>
<body>
	<div class="container-fluid">
		<c:import url='/WEB-INF/views/admin/header.jsp' />
		<br><br>
		<h4>학교</h4>		
		<form id="search_form" action="/readingbetter/admin/schoollist/insert" method="post">
			<input type="text" id="add" name="add" value="">
			<input type="submit" value="추가">
		</form>
		
		<form id="search_form" action="/readingbetter/admin/schoollist">
			<input type="text" id="kwd" name="kwd" value="${param.kwd }">
			<input type="submit" value="찾기">
		</form>
		
		<!-- table -->
		<table class="table table-striped" id="board">
			<tr class="info">
				<td>번호</td>
				<td>이름</td>
			</tr>
			<c:set var="countList" value="${fn:length(list)}" />
			<c:forEach var='vo' items='${list }' varStatus='s'>
				<tr>
					<td>${countList-s.index}</td>
					<td>${vo.title }</td>
				</tr>
			</c:forEach>
		</table>
		<!-- table end -->
	</div>
</body>
</html>