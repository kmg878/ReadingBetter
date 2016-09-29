$(function() {
	$(".balls").on("click", function() {
		var bookNo = $("#bookNo").val();
		var count = $("#count").val();
		var skill = $("#skill").val();
		var bonus = $("#bonus").val();
		var complete = $("#complete").val();

		// certification insert, history insert, scores update
		$.ajax({
			url : "/readingbetter/book/quizResultAction",
			type : "POST",
			data : {
				"bookNo" : bookNo,
				"count" : count,
				"skill" : skill,
				"bonus" : bonus,
				"complete" : complete
			},
			dataType : "json",
			success : function(result) {
				$("#certResult").html(result[0]);
				$("#point").html(result[1]);
				$("#score").prepend(result[2]);
				$("#complete").val(result[3]);
			},
			error : function(jqXHR, status, error) {
				console.error(status + " : " + error);
			}
		});

		$("#balls").hide();
		$("#result-table").show();
		$("#button-group").show();

		$("div.modal").modal();
	});
});