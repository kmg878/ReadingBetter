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
<link href="/readingbetter/assets/css/ranking.css" rel="stylesheet" type="text/css">
</head>
<body>
	<div class="container-fluid">
		<c:import url='/WEB-INF/views/include/header.jsp' />
		<div class="row asideWrap">
			<div id="navigation" class="col-lg-2">
				<c:import url='/WEB-INF/views/include/navi_ranking.jsp' />
			</div>
			<div id="content" class="col-lg-6">
				<div id="monthlytotal">
					<div class="small-menu">
						<a href="/readingbetter/main">홈</a> > 
						<a href="/readingbetter/ranking/summary">순위</a> > 이번 달 전체 순위
					</div>					
					<input type="hidden">
					
					<div id="rank-table" class="col-lg-6">
						<P id="title">이번 달 전체 순위</P><br>						
						<table class="table table-striped">
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
							<c:forEach items="${monthlyRank }" end="11" var="rankingvo">
								<tr>
									<td>${rankingvo.rank }</td>
									<td>${rankingvo.id }</td>
									<td>${rankingvo.monthlyScore }</td>
								<tr>
							</c:forEach>
						</table><br>
						
						<p id="title">나의 순위</p><br>
						<table class="table table-striped">
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

							<tr>
								<c:choose>
									<c:when test="${not empty sessionScope.authUser}">
										<td>${myMonthlyRank.rank }</td>
										<td>${myMonthlyRank.id }</td>
										<td>${myMonthlyRank.myMonthlyScore }</td>
									</c:when>
									<c:otherwise>
										<td colspan=3>로그인이 필요한 기능입니다</td>
									</c:otherwise>
								</c:choose>
							</tr>
						</table><br>
					</div>
				</div>
			</div>
		</div>
		<c:import url='/WEB-INF/views/include/footer.jsp' />
	</div>
</body>
</html>