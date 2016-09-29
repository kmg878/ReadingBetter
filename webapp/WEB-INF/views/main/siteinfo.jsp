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
<link href="/readingbetter/assets/css/main.css" rel="stylesheet"
	type="text/css">
</head>
<body>
	<div class="container-fluid">
		<c:import url='/WEB-INF/views/include/header.jsp' />
		<div class="row asideWrap">
			<div id="navigation" class="col-lg-2"></div>
			<div id="content" class="col-lg-10">
				<div id="siteinfo">
					<p class="menu-title">소개</p>
					<div id="radio-group-information">
						<p>
							<strong>ReadingBetter</strong><br><br>
							ReadingBetter는 초등학생을 대상으로 하는 독서퀴즈 웹사이트 입니다. 퀴즈를 풀거나 내는 활동을
							통해 보상을 제공하여 독서에 대한 흥미를 증진시킵니다 이를 통해 독서를 꾸준히 할 수 있도록 도와 줍니다.
						</p>
						<br>
						<address>
							<strong>Sungkyul, Seoul.</strong><br> 309-710 horam-ro<br>
							Gwankak-gu,samsungdong<br> <abbr title="Phone">P:</abbr>
							(010)-7274-3349
						</address>
						<address>
							<strong>Kim MinJeong</strong><br> <a href="mailto:#">gogokmg5@gmail.com</a>
						</address>
					</div>
				</div>
			</div>
		</div>
		<c:import url='/WEB-INF/views/include/footer.jsp'/>
	</div>
</body>
</html>