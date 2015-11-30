$(document).ready(function() {
	$("li").click(function() {
		$('.active').removeClass('active');
		$(this).addClass('active');
	});
	$("#private").click(function() {
		$.ajax({
			type : "GET",
			url : "getprivatefiles",
			dataType : "json",
			success : function(data, status) {
				console.log("Data: " + data + "\nStatus: " + status);
			}
		});
		// var data = "somedata"
		// $.get("getprivatefiles", function(data, status) {
		// console.log("Data: " + data + "\nStatus: " + status);
		// console.log(data.name);
		// });

	});
});