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
<link href="/readingbetter/assets/css/main.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="/readingbetter/assets/js/jquery/jquery-1.9.0.js"></script>
<script type="text/javascript" src="/readingbetter/assets/js/main.js"></script>
</head>
<body>
	<div class="container-fluid">
		<c:import url='/WEB-INF/views/include/header.jsp' />
		<div class="row asideWrap">
			<div class="col-lg-2" id="navigation">
				<c:import url='/WEB-INF/views/include/navi_main.jsp' />
			</div>
			<div id="content" class="col-lg-10">
				<div id="main">
					<div class="col-lg-6" >
						<div id="today_book_box">
							<h4>오늘의 책</h4>
							<div class="tab-box">
								<div>컨텐츠</div>
								<ul>
									<li></li>
									<li></li>
									<li></li>
									<li></li>
								</ul>
							</div>
						</div>

						<div id="notice_box">
							<h4>공지</h4>
							<ul id="notice_list">
								<li><a href="">공지입니다</a></li>
							</ul>
						</div>
					</div>

					<div class="col-lg-6">
						<div id="ranking_box" class="tab-box2">
							<h4>순위</h4>
							<div id="total_rank">
								<label>이번 달 전체 순위</label>
								<table id="ltable" class="table table-striped">
									<tr>
										<td id="mtrtext">순위</td>
										<td id="mtrtext">아이디</td>
										<td id="mtrtext">점수</td>
									</tr>
									<c:forEach items="${monthlyMainRank }" var="scoresvo">
 										<tr>
 											<td>${scoresvo.rank }</td>
 											<td>${scoresvo.id }</td>
 											<td>${scoresvo.monthlyScore }</td>
										</tr>
 									</c:forEach>
								</table>
							</div>
							<div id="honor_rank">
								<label>명예의 전당 순위</label>
								<table id="ltable" class="table table-striped">
									<tr>
										<td id="mtrtext">순위</td>
										<td id="mtrtext">아이디</td>
										<td id="mtrtext">점수</td>
									</tr>
									<c:forEach items="${mainHonor }" var="scoresvo">
 										<tr>
 											<td>${scoresvo.rank }</td>
 											<td>${scoresvo.id }</td>
 											<td>${scoresvo.totalScore }</td>
 										</tr>
 									</c:forEach>
								</table>
								<ul>
									<li></li>
									<li></li>
								</ul>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<c:import url='/WEB-INF/views/include/footer.jsp' />
	</div>
</body>
</html>