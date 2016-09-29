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
		<h4>희망 도서 내용</h4>
		
		<form action="/readingbetter/admin/wishbooklist/wishbookview/accept" method="post">
			<input type="hidden" name="no" value="${param.no }">
			<table class="table" id="board">
				<tr>
					<td class="active">책제목</td>
					<td><input type="text" name="title" value="${vo.title }"></td>
					<td class="active">출판사</td>
					<td><input type="text" name="publisher" value="${vo.publisher }"></td>
					<td class="active">작성자</td>
					<td>${vo.name }</td>
				</tr>
	
				<tr>
					<td class="active">작성일</td>
					<td>${vo.regDate }</td>
					<td class="active">추천수</td>
					<td>${vo.recommend }</td>
					<td class="active">대기</td>
					<td>
						<c:choose>
							<c:when test="${vo.accept == 0 }">대기</c:when>
							<c:when test="${vo.accept == 1 }">승인</c:when>
							<c:when test="${vo.accept == 2 }">반려</c:when>
						</c:choose>
					</td>
				</tr>
				<tr>
					<td class="active" colspan="6">글내용</td>
				</tr>
				<tr>
					<td colspan="6">${vo.reason }</td>
				</tr>
			</table>
	
			<a class="btn btn-default" href="/readingbetter/admin/wishbooklist" role="button">목록</a> 
			<input type="submit" class="btn btn-default" value="승인">
			<a class="btn btn-default" href="/readingbetter/admin/wishbooklist/wishbookview/refuse?no=${param.no }" role="button">반려</a>
		</form>
		
		<div class="row">
			<div class="col-lg-6">
				<form action="/readingbetter/admin/wishbooklist/wishbookview?no=${param.no }" method="post">
					<label>출판사 찾기</label>
					<input type="hidden" name="bkwd" value="${param.bkwd }">
					<input type="text" name="kwd1" value="${param.kwd1 }">
					<input type="submit" value="찾기">
				</form>

				<c:forEach var="plist" items="${plist }">
					<p>${plist.title }</p>
				</c:forEach>
			</div>
			<div class="col-lg-6">
				<form action="/readingbetter/admin/wishbooklist/wishbookview?no=${param.no }" method="post">
					<label>책 찾기</label>
					<input type="hidden" name="kwd1" value="${param.kwd1 }">
					<input type="text" name="bkwd" value="${param.bkwd }">
					<input type="submit" value="찾기">
				</form>

				<c:forEach var="blist" items="${blist }">
					<p>${blist.title }</p>
				</c:forEach>
			</div>
		</div>
	</div>
</body>
</html>