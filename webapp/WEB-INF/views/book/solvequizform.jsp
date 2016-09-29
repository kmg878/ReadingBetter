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
<link href="/readingbetter/assets/css/book.css" rel="stylesheet" type="text/css">
</head>
<body>
	<div class="container-fluid">
		<c:import url='/WEB-INF/views/include/header.jsp' />
		<div class="row asideWrap">
			<div id="navigation" class="col-lg-2">
				<c:import url='/WEB-INF/views/include/navi_book.jsp' />
			</div>
			<div id="content" class="col-lg-10">
				<div id="solvequiz">
					<div class="small-menu">
						<a href="/readingbetter/main">홈</a> > 
						<a href="/readingbetter/book/booklist">독서활동</a> > 
						<a href="/readingbetter/book/booklist">책 목록</a> > 문제 풀기
					</div>
					<p class="menu-title">문제 풀기</p>
					<form class="form-horizontal" action="/readingbetter/book/resultquiz" method="post">
						<div class="form-group">
							<div class="col-sm-6">
								<img id="img-solvequiz" class="img-thumbnail"
									src="${vo.cover }"><br>
								<table id="table-solve" class="table">
									<tr>
										<td>제목</td>
										<br>
										<td>${vo.title }</td>
									</tr>
									<tr>
										<td>출판사</td>
										<br>
										<td>${vo.publisherTitle }</td>
									</tr>
									<tr>
										<td>추천 학년</td>
										<br>
										<td>${vo.recommend }학년</td>
									</tr>
								</table>
							</div>
							<div class="col-sm-6">
								<c:forEach begin='${count }' end='${maxcount }' step='1' var='i'>
									<div id="radio-group">
										<h4>문제${i+1 } : ${list[i].quiz }</h4>
										<div class="radio">
											<label>
												<input type="radio" name="selectedRadio${i }" 
												id="options${i }Radios1" value="${list[i].ex1 }">${list[i].ex1 }
											</label>
										</div>
										<div class="radio">
											<label> 
												<input type="radio" name="selectedRadio${i }"
												id="options${i }Radios2" value="${list[i].ex2 }">${list[i].ex2 }
											</label>
										</div>
										<div class="radio">
											<label> 
												<input type="radio" name="selectedRadio${i }"
												id="options${i }Radios3" value="${list[i].ex3 }">${list[i].ex3 }
											</label>
										</div>
										<div class="radio">
											<label> 
												<input type="radio" name="selectedRadio${i }"
												id="options${i }Radios4" value="${list[i].ex4 }">${list[i].ex4 }
											</label>
										</div>
										<input type="hidden" type="text" name="no${i }" value="${list[i].no }">
									</div>
								</c:forEach>
								<input type="hidden" name="no" value="${param.no }">
								<button class="btn btn-default" type="submit">결과보기</button>
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>
		<c:import url='/WEB-INF/views/include/footer.jsp' />
	</div>
</body>
</html>