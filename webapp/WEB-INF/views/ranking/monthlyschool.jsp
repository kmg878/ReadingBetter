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
<link href="/readingbetter/assets/css/ranking.css" rel="stylesheet"
	type="text/css">
</head>
<body>
	<div class="container-fluid">
		<c:import url='/WEB-INF/views/include/header.jsp' />
		<div class="row asideWrap">
			<div id="navigation" class="col-lg-2">
				<c:import url='/WEB-INF/views/include/navi_ranking.jsp' />
			</div>
			<div id="content" class="col-lg-6">
				<div id="monthlyschool">
					<div class="small-menu">
						<a href="/readingbetter/main">홈</a> > <a
							href="/readingbetter/ranking/summary">순위</a> > 이번 달 학교 순위
					</div>
					<div id="rank-table" class="col-lg-6">
						<P id="title">이번 달 학교 순위</P>
						<br>
						<table class="table table-striped">
							<colgroup>
								<col width="20%" />
								<col width="40%" />
								<col width="40%" />
							</colgroup>
							<tr>
								<th>순위</th>
								<th>학교명</th>
								<th>점수</th>
							</tr>
							<c:forEach items="${monthlySchool }" var="rankingvo">
								<tr>
									<td>${rankingvo.rank }</td>
									<td>${rankingvo.title }</td>
									<td>${rankingvo.schoolScore }</td>
								</tr>
							</c:forEach>
						</table>
						<br>
						<p id="title">우리 학교 순위</p>
						<br>
						<table class="table table-striped">
							<colgroup>
								<col width="20%" />
								<col width="40%" />
								<col width="40%" />
							</colgroup>
							<tr>
								<th>순위</th>
								<th>학교명</th>
								<th>점수</th>
							</tr>
							<c:choose>
								<c:when test="${not empty sessionScope.authUser}">
									<c:choose>
										<c:when test="${mySchoolRank ne null}">
											<tr>
												<td>${mySchoolRank.rank }위</td>
												<td>${mySchoolRank.title }</td>
												<td>${mySchoolRank.mySchoolScore }</td>
											</tr>
										</c:when>
										<c:otherwise>
											<tr>
												<td colspan=3>회원님의 학교 정보가 없습니다</td>
											</tr>
										</c:otherwise>
									</c:choose>
								</c:when>
								<c:otherwise>
									<td colspan=3>로그인이 필요한 기능입니다</td>
								</c:otherwise>
							</c:choose>
						</table>
						<br>
					</div>
				</div>
			</div>
		</div>
		<c:import url='/WEB-INF/views/include/footer.jsp' />
	</div>
</body>
</html>