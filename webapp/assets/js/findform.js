$(function(){
	$("#findId").on("click", function(){
		var name = $("#inputName").val();
		var email = $("#inputEmail").val();
		

		if (name == "") {
			alert("이름을 입력해주세요");
			$("#inputName").focus();
			return false;
		}
		
		if (email == "") {
			alert("이름을 입력해주세요");
			$("#inputEmail").focus();
			return false;
		}
		
//		$.ajax({
//			url : "/readingbetter/member/findId",
//			type : "POST",
//			data : {
//				"id" : id
//			},
//			dataType : "json",
//			success : function(vo) {
//				if (vo.id != "") {
//					alert("이미 존재하는 아이디입니다");
//					return;
//				}
//
//				$("#image-checked").show();
//				$("#check-id").hide();
//			},
//			error : function(jqXHR, status, error) {
//				console.error(status + " : " + error);
//			}
//		});
	});
});