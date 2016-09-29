$(function() {
	$("#recommend").click(function() {
		var no = $("#no").val();
		console.log(no);

		$.ajax({
			url : "/readingbetter/service/wishbookrecommend",
			type : "POST",
			data : {
				"no" : no
			},
			success : function() {
				$("#recommend").hide();
				alert("추천되었습니다");
			},
			error : function(jqXHR, status, error) {
				console.error(status + " : " + error);
			}
		});
	});
});