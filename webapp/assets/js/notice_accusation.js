$(function() {
	
	$("#review-accusation").submit(function() {
		if ($(".form-control").val() == "") {
			alert("신고 이유를 작성해 주세요");
			$(".form-control").focus();
			return false;
		}
		
		alert("신고가 접수 되었습니다");
		return true;
	});	
	
});