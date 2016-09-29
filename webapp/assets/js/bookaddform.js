$(function(){
	$("#check-title").on("click", function(){
		console.log("check");
		
		$("#check-title").attr('disabled', true);
		
		//		$("#search-list").empty();

		var title = $("#title").val();

		$.ajax({
			url : "/readingbetter/admin/checkbook",
			type : "POST",
			data : {
				"title" : title
			},
//			dataType : "json",
			// contentType: "application/json",
			success : function() {
			},
			error : function(jqXHR, status, error) {
				console.error(status + " : " + error);
			}
		});
	});
	
	$("#title").change(function() {
		$("#check-title").attr('disabled', false);
	});
});