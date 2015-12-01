var table;
$(document).ready(function() {
	drawPublic();
	$("#public").click(function() {
		drawPublic();
	});
	$("#private").click(function() {
		drawPrivate();
	});
	$("li").click(function() {
		$('.active').removeClass('active');
		$(this).addClass('active');
	});
});
function drawPublic() {
	if (table != undefined) {
		table.destroy();
	}
	table = $('#result_table').DataTable({
		retrieve : true,
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
}
function drawPrivate() {
	if (table != undefined) {
		table.destroy();
	}
	table = $('#result_table').DataTable({
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
}