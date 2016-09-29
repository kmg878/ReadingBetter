$(document).ready(function() {
	$("#element").click(function() {
		$("#inputSchoolName").val(null);
		$("#inputSchoolGrade").val(null);
		$("#inputSchoolClass").val(null);
		$("#school-info").show();
	});

	$("#etc").click(function() {
		var school = "기타";
		var grade = 0;
		var classNo = 0;

		$("#inputSchoolName").val(school);
		$("#inputSchoolGrade").val(grade);
		$("#inputSchoolClass").val(classNo);
		$("#school-info").hide();
	});

	if ($("#element").is(":checked")) {
		console.log("element checked");
		$("#school-info").show();
	}

	if ($("#etc").is(":checked")) {
		console.log("etc checked");
		$("#school-info").hide();
	}
});

$(function() {

	$("#btn-searchschool").click(function() {
		$('div.modal').modal();
	});

	// 학교 검색
	$("#search").on(
			"click",
			function() {
				$("#search-list").empty();

				var kwd = $("#school-kwd").val();

				$.ajax({
					url : "/readingbetter/member/search",
					type : "POST",
					data : {
						"kwd" : kwd
					},
					dataType : "json",
					// contentType: "application/json",
					success : function(list) {
						for (var i = 0; i < list.length; i++) {
							$("#search-list").append(
									"<a class='search-result' data-dismiss='modal'>"
											+ list[i].title + "</a><br>");
						}
					},
					error : function(jqXHR, status, error) {
						console.error(status + " : " + error);
					}
				});
			});

	$("#search-list").on("click", ".search-result", function() {
		$("#inputSchoolName").val($(this).text());
	});

	// 이메일 중복체크
	$("#check-email").on("click", function() {
		var email = $("#inputEmail").val();
		var authUserEmail = $("#authUserEmail").val();

		if (email == "") {
			return;
		}

		if (email == authUserEmail) {
			$("#image-emailchecked").show();
			$("#check-email").hide();
			return;
		}

		$.ajax({
			url : "/readingbetter/member/checkemail",
			type : "POST",
			data : {
				"email" : email
			},
			dataType : "json",
			success : function(vo) {
				if (vo.email != "") {
					alert("이미 존재하는 이메일입니다");
					return;
				}

				$("#image-emailchecked").show();
				$("#check-email").hide();
			},
			error : function(jqXHR, status, error) {
				console.error(status + " : " + error);
			}
		});
	});

	$("#inputEmail").change(function() {
		$("#image-emailchecked").hide();
		$("#check-email").show();
	});

	// 폼 체크
	$("#modify-form").submit(function() {
		// 입력 체크
		if ($("#inputName").val() == "") {
			alert("이름은 필수 입력사항입니다.");
			$("#inputName").focus();
			return false;
		}

		if ($("#inputEmail").val() == "") {
			alert("이메일은 필수 입력사항입니다.");
			$("#inputEmail").focus();
			return false;
		}

		if ($("#inputPhone").val() == "") {
			alert("전화번호는 필수 입력사항입니다.");
			$("#inputPhone").focus();
			return false;
		}

		if ($("#inputSchoolName").val() == "") {
			alert("학교 이름은 필수 입력사항입니다.");
			$("#inputSchoolName").focus();
			return false;
		}

		if ($("#inputSchoolGrade").val() == "") {
			alert("학년은 필수 입력사항입니다.");
			$("#inputSchoolGrade").focus();
			return false;
		}

		if ($("#inputSchoolClass").val() == "") {
			alert("반은 필수 입력사항입니다.");
			$("#inputSchoolClass").focus();
			return false;
		}

		if ($("#image-emailchecked").is(":visible") == false) {
			alert("이메일 중복 체크를 해 주세요.");
			return false;
		}

		if ($("#inputPassword").val() != $("#inputPasswordConfirm").val()) {
			alert("비밀번호와 비밀번호 확인이 일치하지 않습니다.");
			return false;
		}

		return true;
	});
});