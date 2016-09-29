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
<h4>희망도서 관리</h4>
	<div id="board">
		<table class="tbl-ex">
			<tr>
				<th>번호</th>
				<th>제목</th>
				<th>작성자</th>
				<th>추천수</th>
				<th>승인 여부</th>
			</tr>
			
			<c:forEach var="vo" items="${list }">
				<tr>
					<td>${vo.no }</td>
					<td><a href="/readingbetter/admin/wishbooklist/wishbookview?no=${vo.no }">${vo.title }</a></td>
					<td>${vo.name }</td>
					<td>${vo.recommend }</td>
					<td>
						<c:choose>
							<c:when test="${vo.accept == 0 }">대기</c:when>
							<c:when test="${vo.accept == 1 }">승인</c:when>
							<c:when test="${vo.accept == 2 }">반려</c:when>
						</c:choose>
					</td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>