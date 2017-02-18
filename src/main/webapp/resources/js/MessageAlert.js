$(document).ready(function(){
	var textAlert = $('#messageAlert').text();
	if (textAlert != "") {
		$('#alertSuccess').show();
	} else {
		$('#alertSuccess').hide();
	}
});

