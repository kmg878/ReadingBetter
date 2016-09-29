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
<link href="/readingbetter/assets/css/admin.css" rel="stylesheet" type="text/css">
</head>
<body>
<h4>관리자 페이지</h4>
<div class="row">
	<div class="col-lg-3">
	</div>
	<div class="col-lg-3">
		<p><a href="/readingbetter/main" class="btn btn-default btn-block">ReadingBetter 홈페이지</a></p>
		<p><a href="/readingbetter/admin/booklist" class="btn btn-default btn-block">도서 관리</a></p>
		<p><a href="/readingbetter/admin/memberlist" class="btn btn-default btn-block">회원 관리</a></p>
		<p><a href="/readingbetter/admin/noticelist" class="btn btn-default btn-block">공지 관리</a></p>
		<p><a href="/readingbetter/admin/shoplist" class="btn btn-default btn-block">상점 관리</a></p>
		<p><a href="/readingbetter/admin/schoollist" class="btn btn-default btn-block">학교 관리</a></p>
	</div>
	<div class="col-lg-3">
		<p><a href="/readingbetter/admin/cardlist" class="btn btn-default btn-block">카드 관리</a></p>
		<p><a href="/readingbetter/admin/accusationlist" class="btn btn-default btn-block">신고 관리</a></p>
		<p><a href="/readingbetter/admin/wishbooklist" class="btn btn-default btn-block">희망도서 관리</a></p>
		<p><a href="/readingbetter/admin/quizlist" class="btn btn-default btn-block">퀴즈 관리</a></p>
		<p><a href="/readingbetter/admin/bookinfolist" class="btn btn-default btn-block">출판사/작가 관리</a></p>
	</div>
	<div class="col-lg-3"></div>
</div>
</body>
</html>