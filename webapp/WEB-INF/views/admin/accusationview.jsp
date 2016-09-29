<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ReadingBetter_Admin</title>
<link href="/readingbetter/assets/dist/css/bootstrap.min.css" rel="stylesheet" type="text/css">
<link href="/readingbetter/assets/css/admin.css" rel="stylesheet" type="text/css">
<link href="/readingbetter/assets/css/board.css" rel="stylesheet" type="text/css">
</head>
<body>
	<c:import url='/WEB-INF/views/admin/header.jsp' />
	<br>
	<br>
	<h4>신고 글 내용</h4>
	<br>
	<div>
	<form method="post" action="../update">
	<input type="hidden" name="no" value="${vo.no }">
		<table id="board" class="table table-bordered">
			<tr>
				<th class="active">신고자</th>
				<td colspan=2>${vo.id }</td>
				<th class="active">피신고자</th>
				<td colspan=2>
				<c:choose>
                        <c:when test="${vo.identity == 1}">${reviewvo.id }</c:when>
                        <c:when test="${vo.identity == 2}">${commentsvo.id }</c:when>
               </c:choose>
				</td>
			</tr>
			<tr>
				<th class="active">종류</th>
				<td>
					<c:choose>
                        <c:when test="${vo.identity == 1}">리뷰</c:when>
                        <c:when test="${vo.identity == 2}">댓글</c:when>
                     
                     </c:choose>
				</td>
				<th class="active">승인 여부</th>
				<td>
				 <c:choose>
                        <c:when test="${vo.accept == 0}">대기</c:when>
                        <c:when test="${vo.accept == 1}">승인</c:when>
                        <c:when test="${vo.accept == 2}">반려</c:when>
                     </c:choose>
				</td>
				<th class="active">신고일</th>
				<td>${vo.regDate }</td>
			</tr>
			<tr>
				<th  class="active" colspan=6>글 내용</th>
			</tr>
			<tr>
				<td id="content" colspan=6>
				<c:choose>
                        <c:when test="${vo.identity == 1}">${reviewvo.review }</c:when>
                        <c:when test="${vo.identity == 2}">${commentsvo.content }</c:when>
               </c:choose>
				</td>
			</tr>
			<tr>
				<th  class="active" colspan=6>신고 이유</th>
			</tr>
			<tr>
				<td id="content" colspan=6>${vo.reason }</td>
			</tr>
			<c:if test="${vo.accept == 0}">
				<tr>
	            	<td class="active">승인여부</td>
	            	<td colspan="5">
	               		<label class="radio-inline">
	                    	<input type="radio" name="accept" value=1>승인
	               		</label>
	               		<label class="radio-inline">
	                    	<input type="radio" name="accept" value=2>반려
	               		</label>
	            	</td>
	         	</tr>
         	</c:if>
		</table>
			
		<div id="buttons">
			<a href="/readingbetter/admin/accusationlist" class="btn btn-default">목록</a>
			<c:if test="${vo.accept == 0}">
				<input class="btn btn-default" type="submit" value="완료">
			</c:if>
		</div>
	</form>
	</div>
</body>
</html>