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
	$('#result_table tbody').on('click', 'td.details-control', function () {
        var tr = $(this).closest('tr');
        var row = table.row( tr );
 
        if ( row.child.isShown() ) {
            row.child.hide();
            tr.removeClass('shown');
        }
        else {
            row.child( format(row.data()) ).show();
            tr.addClass('shown');
        }
    } );
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
		}, {
			"className" : 'details-control',
			"orderable" : false,
			"data" : null,
			"defaultContent" : ''
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
		}, {
			"className" : 'details-control',
			"orderable" : false,
			"data" : null,
			"defaultContent" : ''
		} ],
	});
}
function drawButtons() {

}
function format ( d ) {
    // `d` is the original data object for the row
    return '<table cellpadding="5" cellspacing="0" border="0" style="padding-left:50px;">'+
        '<tr>'+
            '<td>Full name:</td>'+
            '<td>'+d.name+'</td>'+
        '</tr>'+
        '<tr>'+
            '<td>Extension number:</td>'+
            '<td>'+d.extn+'</td>'+
        '</tr>'+
        '<tr>'+
            '<td>Extra info:</td>'+
            '<td>And any further details here (images etc)...</td>'+
        '</tr>'+
    '</table>';
}