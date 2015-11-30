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
				for(var i in data){
					$('#result_table > tbody:last-child').append('<tr><td>'+ data[i].name +'</td>'+
							'<td>'+ data[i].name +'</td><td>'
								+new Date(data[i].created).toLocaleDateString() +'</td></tr>');
				}
			}
		});
	});
});