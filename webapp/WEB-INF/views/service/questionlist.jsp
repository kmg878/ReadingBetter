<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<!doctype html>
<html>
<head>
<title>ReadingBetter</title>
<meta http-equiv="content-type" content="text/html; charset=utf-8">
<link href="/readingbetter/assets/dist/css/bootstrap.min.css"
	rel="stylesheet" type="text/css">
<link href="/readingbetter/assets/css/board.css" rel="stylesheet"
	type="text/css">
</head>
<body>
	<div class="container-fluid">
		<c:import url='/WEB-INF/views/include/header.jsp' />
		<div class="row asideWrap">
			<div class="col-lg-2" id="navigation">
				<c:import url='/WEB-INF/views/include/navi_service.jsp' />
			</div>
			<div id="content" class="col-lg-10">
				<div id="question">
					<div class="small-menu">
						<a href="/readingbetter/main">홈</a> > 
						<a href="/readingbetter/service/noticelist">고객센터</a> > 문의 게시판
					</div>
					<p class="menu-title">문의 게시판</p>
					
					<form id="search_form" action="/mysite/board" method="post">
						<input type="text" id="kwd" name="kwd" value="${kwd }">
						<input type="submit" value="찾기">
					</form>

					<div id="board">
						<table class="tbl-ex">
							<tr>
								<th>번호</th>
								<th>제목</th>
								<th>글쓴이</th>
								<th>조회수</th>
								<th>작성일</th>
								<th>답변</th>
							</tr>
							<tr>
								<td>3</td>
								<td><a href="/readingbetter/service/questionview">제목</a></td>
								<td>작성자</td>
								<td>3</td>
								<td>2016-09-07</td>
								<td>안 돼 돌아가</td>
							</tr>
							<tr>
								<td>2</td>
								<td><a href="">제목</a></td>
								<td>작성자</td>
								<td>3</td>
								<td>2016-09-07</td>
								<td>승인</td>
							</tr>
							<tr>
								<td>1</td>
								<td><a href="">제목</a></td>
								<td>작성자</td>
								<td>3</td>
								<td>2016-09-07</td>
								<td>대기</td>
							</tr>
						</table>
						<div id="button-set">
							<a class="btn btn-default" href="/readingbetter/service/questionwrite" role="button">글쓰기</a>
						</div>

						<!-- begin:paging -->
						<div class="pager">
							<ul>
								<li>
								<li><a href="">◀</a></li>
								<li><a href="">1</a></li>
								<li><a href="">2</a></li>
								<li><a href="">3</a></li>
								<li><a href="">4</a></li>
								<li><a href="">5</a></li>
								<li><a href="">▶</a></li>
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