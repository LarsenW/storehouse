var table;
$(document).ready(function() {
	drawPublic();
	$("#public").click(function() {
		drawPublic();
	});
	$("#private").click(function() {
		drawPrivate();
	});
	$("#upload").click(function() {
		drawUpload();
	});
	$("#account_settings").click(function() {
		drawAccountSettings();
	});
	$("li").click(function() {
		$('.active').removeClass('active');
		$(this).addClass('active');
	});
	$('#result_table tbody').on('click', 'td.details-control', function() {
		var tr = $(this).closest('tr');
		var row = table.row(tr);
		if (row.child.isShown()) {
			row.child.hide();
			tr.removeClass('shown');
			tr.removeClass('info');
		} else {
			row.child(format(row.data())).show();
			tr.addClass('shown');
			tr.addClass('info');
		}
	});
	$('.btn-file :file').on('fileselect', function(event, numFiles, label) {
		$("#file_upload").val(label);
	});
});
function drawPublic() {
	$("#upload_form_wrapper").hide();
	$("#account_settings_form_wrapper").hide();
	if (table != undefined) {
		table.destroy();
	}
	table = $('#result_table').DataTable(
			{
				retrieve : true,
				"ajax" : {

					"url" : "getpublicfiles",
					"dataSrc" : ""
				},
				"columns" : [ {
					"data" : "name"
				}, {
					"data" : "fileCategory"
				}, {
					"data" : "created"
				}, {
					"className" : 'details-control',
					"orderable" : false,
					"data" : null,
					"defaultContent" : ''
				} ],
				"columnDefs" : [ {
					"targets" : 2,
					"data" : "createdDate",
					"render" : function(data, type, full, meta) {
						var date = new Date(data);
						return date.getDate() + '/' + (date.getMonth() + 1)
								+ '/' + date.getFullYear();
					}
				} ]
			});
}
function drawPrivate() {
	$("#upload_form_wrapper").hide();
	$("#account_settings_form_wrapper").hide();
	if (table != undefined) {
		table.destroy();
	}
	table = $('#result_table').DataTable(
			{
				"ajax" : {
					"url" : "getprivatefiles",
					"dataSrc" : ""
				},
				"columns" : [ {
					"data" : "name"
				}, {
					"data" : "fileCategory"
				}, {
					"data" : "created"
				}, {
					"className" : 'details-control',
					"orderable" : false,
					"data" : null,
					"defaultContent" : ''
				} ],
				"columnDefs" : [ {
					"targets" : 2,
					"data" : "createdDate",
					"render" : function(data, type, full, meta) {
						var date = new Date(data);
						return date.getDate() + '/' + (date.getMonth() + 1)
								+ '/' + date.getFullYear();
					}
				} ]
			});
}
function format(d) {
	return '<table id="subtable" cellpadding="5" cellspacing="0" border="0" style="padding-left:50px;">'
			+ '<tr>'
			+ '<td>Full name:</td>'
			+ '<td>'
			+ d.name
			+ '</td>'
			+ '</tr>'
			+ '<tr>'
			+ '<td>Description:</td>'
			+ '<td>'
			+ d.description
			+ '</td>'
			+ '</tr>'
			+ '<tr>'
			+ '<td><a href="'
			+ location.pathname
			+ '/download/'
			+ d.id
			+ '"'
			+ '>Download <a/><span class="glyphicon glyphicon-download"></span></td>'
			+ '</tr>' + '</table>';
}
function drawUpload() {
	$("#result_table_wrapper").hide();
	$("#account_settings_form_wrapper").hide();
	$("#upload_form_wrapper").show();
}
$(document)
		.on(
				'change',
				'.btn-file :file',
				function() {
					var input = $(this), numFiles = input.get(0).files ? input
							.get(0).files.length : 1, label = input.val()
							.replace(/\\/g, '/').replace(/.*\//, '');
					input.trigger('fileselect', [ numFiles, label ]);
				});
function drawAccountSettings() {
	$("#result_table_wrapper").hide();
	$("#upload_form_wrapper").hide();
	$("#account_settings_form_wrapper").show();
}