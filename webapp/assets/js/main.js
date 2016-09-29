$(function() {
	$(".tab-box li").click(function() {
		var $li = $(this);

		$(".tab-box li.selected").removeClass("selected");
		$li.addClass("selected");
	});

	$(".tab-box2 li").click(function() {
		var $li = $(this);

		$(".tab-box2 li.selected").removeClass("selected");
		$li.addClass("selected");
	});
});