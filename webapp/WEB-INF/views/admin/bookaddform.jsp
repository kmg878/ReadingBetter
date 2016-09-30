<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ReadingBetter_Admin</title>
<link href="/readingbetter/assets/dist/css/bootstrap.min.css" rel="stylesheet" type="text/css">
<link href="/readingbetter/assets/css/board.css" rel="stylesheet" type="text/css">
<link href="/readingbetter/assets/css/admin.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="/readingbetter/assets/js/jquery/jquery-3.1.0.js"></script>
<script type="text/javascript" src="/readingbetter/assets/dist/js/bootstrap.js"></script>
<script type="text/javascript" src="/readingbetter/assets/js/bookaddform.js"></script>
</head>
<body>
	<c:import url='/WEB-INF/views/admin/header.jsp'></c:import>
	<h4>도서 추가</h4>
	<div id="board">
		<form id="bookadd-form" method="post" action="insertbook">
			<table class="tbl-ex tbl-addbook">
				<tr>
					<th></th>
					<th></th>
				</tr>
				<tr>
					<td class="left-label">제목</td>
						<td>
							<label for="title"></label>
							<input type="text" class="form-control" id="title" value="" name=title>
							<button class="btn btn-primary" id="check-title" type="button">검색</button>
							<div id="search-title-result">
								<a>검색결과</a>
							</div>
						</td>
					</tr>
				<tr>
					<td class="left-label">작가</td>
					<td>
						<label for="author_no"></label>
						<input type="text" class="form-control" id="authorNo" value="" name="authorNo">
						<button id="btn_writerModal" value="" type="button" class="btn btn-primary " data-toggle="modal" data-target=".writer-modal" >찾기</button>
					</td>
				<tr>
					<td class="left-label">출판사</td>
					<td>
						<input type="text" class="form-control" id="publisher" value="" name="publisherNo">
						<button id="btn_publisherModal" type="button" class="btn btn-primary" data-toggle="modal" data-target=".publisher-modal" >찾기</button>
					</td>
				</tr>
				<tr>
					<td class="left-label">추천학년</td>
					<td>
						<select class="form-control" name=recommend>
							<option>1</option>
							<option>2</option>
							<option>3</option>
							<option>4</option>
							<option>5</option>
							<option>6</option>
						</select>
					</td>
				</tr>
				<tr>
					<td class="left-label">사진</td>
					<td>
						<label for=""></label>
						<input type="text" class="form-control" id="cover" name="cover">
					</td>
				</tr>
			</table>
	
			<a href="/readingbetter/admin/booklist" class="btn btn-default">목록</a>
			<button type="submit" class="btn btn-default">등록</button>
		</form>
	</div>
</body>
</html>


<!-- 작가검색모달 -->
<div id="writerModal" class="modal fade writer-modal" tabindex="-1" role="dialog" aria-labelledby="mySmallModalLabel" aria-hidden="true">
	<div class="modal-dialog modal-sm">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
				<h4 class="modal-title">작가 검색</h4>
			</div>
			<div class="modal-body">
				<input type="text" name="title" id="writerTitle" value=""> 
				<a class="btn btn-default" role="button" id="btn-writer" >찾기</a>
				<div id="search-author-result">
					<a>검색결과</a>
				</div>
				<div id="author-input" style="display: none;">
					<input type="text" name="kwd">
					<button class="btn btn-default">확인</button>
				</div>
			</div>
		</div><!-- /.modal-content -->
	</div><!-- /.modal-dialog -->
</div><!-- /.modal -->

<!-- 출판사검색모달 -->
<div id="publisherModal" class="modal fade publisher-modal" tabindex="-1" role="dialog" aria-labelledby="mySmallModalLabel" aria-hidden="true">
	<div class="modal-dialog modal-sm">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
				<h4 class="modal-title">출판사 검색</h4>
			</div>
			<div class="modal-body">
				<input type="text" name="kwd2" id="publisher" value=""> 
				<a class="btn btn-default" role="button" id="btn-publisher" >찾기</a>
				<div id="search-publisher-result">
					<a>검색결과</a>
				</div>
				<div id="publisher-input" style="display: none;">
					<input type="text" name="kwd1">
					<button class="btn btn-default">확인</button>
				</div>
			</div>
		</div><!-- /.modal-content -->
	</div><!-- /.modal-dialog -->
</div><!-- /.modal -->