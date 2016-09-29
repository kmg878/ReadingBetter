<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<!doctype html>
<html>
<head>
<title>문의 게시판</title>
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
			<div id="navigation" class="col-lg-2">
				<c:import url='/WEB-INF/views/include/navi_service.jsp' />
			</div>
			<div id="content" class="col-lg-10">
				<div id="questionview">
					<div class="small-menu">
						<a href="/readingbetter/main">홈</a> > 
						<a href="/readingbetter/service/noticelist">고객센터</a> > 
						<a href="/readingbetter/service/questionlist"> 문의 게시판 </a> > 글보기
					</div>

					<p class="menu-title">문의 게시판</p>
					<div id="board">
						<table id="board" class="table table-bordered">
							<tr>
								<th class="active">제목</th>
								<td>아이디랑 비밀번호를 잊어버렸어요</td>
							</tr>
							<tr>
								<th class="active" colspan=2>내용</th>
							</tr>
							<tr>
								<td id="content" colspan=2>
									비밀번호를 잊어버렸는데 이메일을 잊어버려서 임시 비밀번호를 받을 수가 없습니다.<br>도와줘요 헬프 미
								</td>
							</tr>
						</table>
						<div id="buttonalign">
							<a href="/readingbetter/service/questionlist" class="btn btn-default">목록</a><br><br>
						</div>
					</div>
				</div>
			</div>
		</div>
		<c:import url='/WEB-INF/views/include/footer.jsp' />
	</div>
</body>
</html>