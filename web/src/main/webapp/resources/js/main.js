$(document).ready(function() {
	$('#nav').localScroll(800);

	// .parallax(xPosition, speedFactor, outerHeight) options:
	// xPosition - Horizontal position of the element
	// inertia - speed to move relative to vertical scroll. Example: 0.1 is one
	// tenth the speed of scrolling, 2 is twice the speed of scrolling
	// outerHeight (true/false) - Whether or not jQuery should use it's
	// outerHeight option to determine when a section is in the viewport
	$('#intro').parallax("50%", 0.1);
	$('#second').parallax("50%", 0.1);
	// $('.bg').parallax("50%", 0.4);
	$('#third').parallax("50%", 0.1);

})
function sticky_relocate() {
	var window_top = $(window).scrollTop();
	var div_top = $('#sticky-anchor').offset().top;
	if (window_top > div_top) {
		$('#sticky').addClass('stick');
	} else {
		$('#sticky').removeClass('stick');
	}
}

$(function() {
	$(window).scroll(sticky_relocate);
	sticky_relocate();
});
$(document).ready(function(e) {
	$('.search-panel .dropdown-menu').find('a').click(function(e) {
		e.preventDefault();
		var param = $(this).attr("href").replace("#", "");
		var concept = $(this).text();
		$('.search-panel span#search_concept').text(concept);
		$('.input-group #search_param').val(param);
	});
});