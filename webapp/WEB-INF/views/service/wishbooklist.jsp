<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<!doctype html>
<html>
<head>
<title>ReadingBetter</title>
<meta http-equiv="content-type" content="text/html; charset=utf-8">
<link href="/readingbetter/assets/dist/css/bootstrap.min.css" rel="stylesheet" type="text/css">
<link href="/readingbetter/assets/css/board.css" rel="stylesheet" type="text/css">
</head>
<body>
	<div class="container-fluid">
		<c:import url='/WEB-INF/views/include/header.jsp' />
		<div class="row asideWrap">
			<div class="col-lg-2" id="navigation">
				<c:import url='/WEB-INF/views/include/navi_service.jsp' />
			</div>
			<div class="col-lg-10">
				<div class="small-menu">
					<a href="/readingbetter/main">홈</a> > 
					<a href="/readingbetter/service/noticelist">고객센터</a> > 희망도서 신청
				</div>
				<p class="menu-title">희망도서 신청</p>
				<form id="search_form" action="" method="get">
					<input type="text" id="wKwd" name="wKwd" value="${wKwd}">
					<input type="submit" value="찾기">
				</form>
				
				<div id="board">
					<table class="tbl-ex">
						<tr>
							<th>번호</th>
							<th>제목</th>
							<th>글쓴이</th>
							<th>추천수</th>
							<th>작성일</th>
							<th>승인</th>
						</tr>
						<c:forEach var='vo' items='${listpage }'>
							<tr>
								<td>${vo.no }</td>
								<td><a href="/readingbetter/service/wishbookview?no=${vo.no }">${vo.title }</a></td>
								<td>${vo.name }</td>
								<td>${vo.recommend }</td>
								<td>${vo.regDate }</td>
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
					
					<c:if test="${authUser != null }">
						<div id="button-set">
							<a class="btn btn-default" href="/readingbetter/service/wishbookwriteform" role="button">글쓰기</a>
						</div>
					</c:if>
					
					<!-- begin:paging -->
					<div class="pager">
						<ul>
							<c:if test="${beginPage>1 }">
								<li>
									<a href="/readingbetter/service/wishbooklist?pageNo=${beginPage-1 }&wKwd=${wKwd}">◀</a>
									<input type="hidden" name="pageNo" value="${beginPage-1 }">
								</li>
							</c:if>
							<c:forEach begin='${beginPage }' end='${endPage }' step='1' var='i'>
								<c:choose>
									<c:when test='${currentPage == i }'>
										<li class="selected">${i }</li>
									</c:when>
								<c:otherwise>
									<li>
										<a href="/readingbetter/service/wishbooklist?pageNo=${i }&wKwd=${wKwd}">${i }</a>
										<input type="hidden" name="pageNo" value="${i}">
									</li>
								</c:otherwise>
								</c:choose>
							</c:forEach>
						
							<c:if test='${endPage<total }'>
								<li>
									<a href="/readingbetter/service/wishbooklist?pageNo=${endPage+1 }&wKwd=${wKwd}">▶</a>
									<input type="hidden" name="pageNo" value="${endPage+1}">
								</li>
							</c:if>
						</ul>
					</div>
					<!-- end:paging -->

				</div>
			</div>
		</div>
		<div class="row">
			<div id="footer" class="col-lg-12">
				<c:import url='/WEB-INF/views/include/footer.jsp' />
			</div>
		</div>
	</div>
</body>
</html>