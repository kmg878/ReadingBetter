<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<!doctype html>
<html>
<head>
<title>ReadingBetter_Admin</title>
<meta http-equiv="content-type" content="text/html; charset=utf-8">
<link href="/readingbetter/assets/dist/css/bootstrap.min.css"
	rel="stylesheet" type="text/css">
<link href="/readingbetter/assets/css/admin.css" rel="stylesheet"
	type="text/css">
<link href="/readingbetter/assets/css/board.css" rel="stylesheet"
	type="text/css">
</head>
<body>
	<div class="container-fluid">
		<c:import url='/WEB-INF/views/admin/header.jsp' />
		<br><br>
		<h4>퀴즈 관리</h4>

		<table class="table" id="board">
			<tr class="info">
				<td>번호</td>
				<td>제목</td>
				<td>상태</td>
			</tr>
			<c:set var="countList" value="${fn:length(list)}"/>
			<c:forEach var='vo' items='${list}' varStatus='s'>
			<tr>
				<td>${countList-s.index}</td>
				<td>${vo.title }</td>
				<td>
					<a href="/readingbetter/admin/quizview/${vo.no }">
						<c:choose>
							<c:when test="${vo.accept == 0 }">대기</c:when>
							<c:when test="${vo.accept == 1 }">승인</c:when>
							<c:when test="${vo.accept == 2 }">반려</c:when>
						</c:choose>
					</a>				
				</td>
			</tr>
			</c:forEach>
		</table>

		<a class="btn btn-default" href="/readingbetter/admin/quizaddbook" role="button">등록</a>

	</div>
</body>
</html>