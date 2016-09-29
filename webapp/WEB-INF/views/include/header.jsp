<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div class="row">
	<div id="header" class="col-lg-12">
		<a href="/readingbetter/main">
			<img id="img"
				src="http://ec2-52-34-170-68.us-west-2.compute.amazonaws.com/images/rb_logo.png">
		</a>
		<ul id="headeritem1">
			<c:choose>
				<c:when test='${empty authUser }'>
					<li><a href="/readingbetter/member/loginform">로그인</a></li>
					<li><a href="/readingbetter/member/joinform">회원가입</a></li>
				</c:when>
				<c:otherwise>
					<li><a href="/readingbetter/mypage/modifyform">회원정보수정</a></li>
					<li><a href="/readingbetter/main/logout">로그아웃</a></li>
					<li>${authUser.name}님 반갑습니다 ^0^</li>
				</c:otherwise>
			</c:choose>
		</ul>
		<br> <br>
		<div>
			<a href="/readingbetter/book/booklist">독서활동</a>
			<a href="/readingbetter/ranking/summary">순위</a>
			<a href="/readingbetter/shop">상점</a>
			<c:if test="${not empty authUser }">
				<a href="/readingbetter/mypage/info">내정보</a>
			</c:if>
			<a href="/readingbetter/service/noticelist">고객센터</a>
		</div>
	</div>
</div>