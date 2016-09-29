<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<!doctype html>
<html>
<head>
<title>ReadingBetter</title>
<meta http-equiv="content-type" content="text/html; charset=utf-8">
<link href="/readingbetter/assets/css/ranking.css" rel="stylesheet" type="text/css">
<link href="/readingbetter/assets/dist/css/bootstrap.min.css" rel="stylesheet" type="text/css">
</head>
<body>
	<div class="container-fluid">
		<c:import url='/WEB-INF/views/include/header.jsp' />
		<div class="row asideWrap">
			<div id="navigation" class="col-lg-2">
				<c:import url='/WEB-INF/views/include/navi_ranking.jsp' />
			</div>
			<div id="content" class="col-lg-10">
				<div id="honor">
					<div class="small-menu">
						<a href="/readingbetter/main">홈</a> > <a
							href="/readingbetter/ranking/summary">순위</a> > 명예의 전당
					</div>
					<div id="top3" class="col-lg-6">
						<p id="title">★ Reading Better Top 3 ★</p>
						<div>
							<table id="top3text">
								<tr>
									<td colspan="2" class="top3line">--------------------</td>
								</tr>
								<c:forEach items="${totalTopRanker }" var="rankingvo">
									<tr>
										<th><mark><strong>${rankingvo.rank }위</strong></mark></th>
										<td><small> : ${rankingvo.id }</small></td>
									</tr>
									<tr>
										<td colspan="2" class="top3line">--------------------</td>
									</tr>
								</c:forEach>
							</table>
						</div>
						<img id="top3-image"
							src="http://ec2-52-34-170-68.us-west-2.compute.amazonaws.com/images/top3.png">
					</div>

					<!-- table -->
					<div id="honor-table" class="col-lg-6">
						<p id="title">명예의 전당 - Top 10</p>
						<br>
						<table id="rtable" class="table table-striped">
							<colgroup>
								<col width="20%" />
								<col width="40%" />
								<col width="40%" />
							</colgroup>
							<tr>
								<th>순위</th>
								<th>아이디</th>
								<th>점수</th>
							</tr>
							<c:forEach items="${honor }" end="10" var="rankingvo">
								<tr>
									<td>${rankingvo.rank }</td>
									<td>${rankingvo.id }</td>
									<td>${rankingvo.totalScore }</td>
								<tr>
							</c:forEach>
						</table>
						<br> <br>
					</div>
					<div>
						<p id="title">나의 순위</p>
						<br>
						<table id="myhonor" class="table table-striped">
							<colgroup>
								<col width="20%" />
								<col width="40%" />
								<col width="40%" />
							</colgroup>
							<tr>
								<th>순위</th>
								<th>아이디</th>
								<th>점수</th>
							</tr>
							<c:choose>
								<c:when test="${not empty sessionScope.authUser}">
									<tr>
										<td>${myTotalRank.rank }</td>
										<td>${myTotalRank.id }</td>
										<td>${myTotalRank.myTotalScore }</td>
									</tr>
								</c:when>
								<c:otherwise>
									<td colspan=3>로그인이 필요한 기능입니다</td>
								</c:otherwise>
							</c:choose>
						</table>
						<br> <br>
					</div>
				</div>
			</div>
		</div>
		<c:import url='/WEB-INF/views/include/footer.jsp' />
	</div>
</body>
</html>