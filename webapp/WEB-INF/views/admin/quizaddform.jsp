<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<!doctype html>
<html>
<head>
<title>ReadingBetter_Admin</title>
<meta http-equiv="content-type" content="text/html; charset=utf-8">
<link href="/readingbetter/assets/dist/css/bootstrap.min.css" rel="stylesheet" type="text/css">
<link href="/readingbetter/assets/css/admin.css" rel="stylesheet" type="text/css">
<link href="/readingbetter/assets/css/board.css" rel="stylesheet" type="text/css">
</head>
<body>
	<div class="container-fluid">
		<c:import url='/WEB-INF/views/admin/header.jsp'/>
		<br><br>
		<h4>퀴즈 등록</h4>
		<form method="post" action="../quizadd">
		<input type="hidden" name="bookNo" value="${bookVo.no }">
			<table class="table" id="board">
				<tr>
					<td class="active">책제목</td>
					<td colspan="5">${bookVo.title }</td>
				</tr>         
				<tr>
					<td class="active">작가</td>
					<td colspan="2">${bookVo.authorName }</td>
					<td class="active">출판사</td>
					<td colspan="2">${bookVo.publisherTitle }</td>
					</tr>
				<tr>
					<td class="active" colspan="6">문제</td>
				</tr>
				<tr>
					<td colspan="6">
						<textarea class="form-control" rows="3" name="quiz"></textarea>
					</td>
				</tr>
				<tr>
					<td class="active"  colspan="6">보기</td>
				</tr>
				<tr>
					<td class="active">1</td>
					<td colspan="5"><input type="text" class="form-control" name="ex1" placeholder="보기1"></td>
				</tr>
		        <tr>
					<td class="active">2</td>
					<td colspan="5"><input type="text" class="form-control" name="ex2" placeholder="보기2"></td>
				</tr>
				<tr>
					<td class="active">3</td>
					<td colspan="5"><input type="text" class="form-control" name="ex3" placeholder="보기3"></td>
				</tr>
				<tr>
					<td class="active">4</td>
					<td colspan="5"><input type="text" class="form-control" name="ex4" placeholder="보기4"></td>
				</tr>
				<tr>
					<td class="active">정답</td>
					<td colspan="5"><input type="text" class="form-control" name="answer" placeholder="정답"></td>
				</tr>
			</table>
				
			<a class="btn btn-default" href="/readingbetter/admin/quizlist" role="button">목록</a>
			<button class="btn btn-default" type="submit">등록</button>
		</form>
	</div>
</body>
</html>