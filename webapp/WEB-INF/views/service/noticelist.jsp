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
			<div id="content" class="col-lg-10">
				<div id="notice">
					<div class="small-menu">
						<a href="/readingbetter/main">홈</a> > 
						<a href="/readingbetter/service/noticelist">고객센터</a> > 공지
					</div>
					<p class="menu-title">공지</p>

					<div id="board">
						<table class="tbl-ex">
							<tr>
								<th>번호</th>
								<th>제목</th>
								<th>글쓴이</th>
								<th>조회수</th>
								<th>작성일</th>
							</tr>
							<c:set var="countList" value="${fn:length(list)}"/>
							<c:forEach var='vo' items='${list}' varStatus='s'>
							<tr>
								<td>${countList-s.index}</td>
								<td><a href="/readingbetter/service/noticeview/${vo.no }">${vo.title }</a></td>
								<td>${vo.name }</td>
								<td>${vo.viewCount }</td>
								<td>${vo.regDate }</td>
							</tr>
							</c:forEach>
						</table>

						<!-- begin:paging -->
		            	<div class="pager">
		            	<br>
		               		<ul>
		               			<c:if test='${beginPage>1}'>
		               				<li><a href="/readingbetter/service/noticelist?noticePage=${beginPage-1}">◀</a></li>
		               			</c:if>
		                  		<c:forEach begin='${beginPage}' end='${endPage}' step='1' var='i'>
		                  			<c:choose>
		                  				<c:when test='${currentPage == i}'>
		                  					<li class="selected">${i}</li>
		                  				</c:when>
		                  				<c:otherwise>
		                  					<li><a href="/readingbetter/service/noticelist?noticePage=${i}">${i}</a></li>
		                  				</c:otherwise>
		                  			</c:choose>
		                  		</c:forEach>
		                  		<c:if test='${endPage<totalPage}'>
		                  			<li><a href="/readingbetter/service/noticelist?noticePage=${endPage+1}">▶</a></li>
		                  		</c:if>               		
		               		</ul>
		            	</div>
		            	<!-- end:paging -->
						
					</div>
				</div>
			</div>
		</div>
		<c:import url='/WEB-INF/views/include/footer.jsp' />
	</div>
</body>
</html>