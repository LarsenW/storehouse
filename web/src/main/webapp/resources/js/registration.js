(function($, W, D) {
	var JQUERY4U = {};

	JQUERY4U.UTIL = {
		setupFormValidation : function() {
			// form validation rules
			$("#user-form")
					.validate(
							{
								rules : {
									username : "required",
									email : {
										required : true,
										email : true
									},
									password : {
										required : true,
										minlength : 6
									},
									password_confirmation : {
										equalTo : "#password"
									}
								},
								messages : {
									username : "Please enter your name",
									password : {
										required : "Please provide a password",
										minlength : "Your password must be at least 6 characters long"
									},
									email : "Please enter a valid email address",
								},
								submitHandler : function(form) {
									form.submit();
								}
							});
		}
	}

	// when the dom has loaded setup form validation rules
	$(D).ready(function($) {
		JQUERY4U.UTIL.setupFormValidation();
	});

})(jQuery, window, document);