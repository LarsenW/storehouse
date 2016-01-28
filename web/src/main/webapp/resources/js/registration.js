$(document).ready(function() {
	$('#password_confirmation').focusout(function() {
		if ($('#password').val() != $('#password_confirmation').val()) {
			$('#password_confirm_error').css("display", "inline");
		}else{
			$('#password_confirm_error').css("display", "none");
		}
	});
});