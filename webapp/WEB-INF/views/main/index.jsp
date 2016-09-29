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
<link href="/readingbetter/assets/css/remys.css" rel="stylesheet" type="text/css">
</head>
<body>
	<div class="container-fluid">
		<c:import url='/WEB-INF/views/include/header.jsp'/>
		<div class="row asideWrap">
			<div id="navigation" class="col-lg-2">
				<c:import url='/WEB-INF/views/include/navi.jsp'/>
			</div>
			<div id="content" class="col-lg-10">컨텐츠</div>
		</div>
		<c:import url='/WEB-INF/views/include/footer.jsp'/>
	</div>
</body>
</html>