

function adminLogin() {
	var formData = $('#login_form').serialize();
	$.ajax({
		url : 'authentication',
		method : 'POST',
		data : formData,
		success : function(data) {
			if (data == 'Welcome') {
				location.href = "access";
			} else {
				failureMessage(data);
			}
		}
	})
}

(function() {


	$('#login_form').submit('click', function() {
		event.preventDefault();
		adminLogin();
	});

})();