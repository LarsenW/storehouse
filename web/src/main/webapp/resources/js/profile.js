$(document).ready(function() {

	$("#public").click(function() {
		$('#result_table').DataTable({
			"ajax" : {
				"url" : "getpublicfiles",
				"dataSrc" : ""
			},
			"columns" : [ {
				"data" : "name"
			}, {
				"data" : "description"
			}, {
				"data" : "created"
			} ]
		});
	});
	$("li").click(function() {
		$('.active').removeClass('active');
		$(this).addClass('active');
	});
	$("#private").click(function() {
		$('#result_table').DataTable({
			"ajax" : {
				"url" : "getprivatefiles",
				"dataSrc" : ""
			},
			"columns" : [ {
				"data" : "name"
			}, {
				"data" : "description"
			}, {
				"data" : "created"
			} ]
		});
	});
});