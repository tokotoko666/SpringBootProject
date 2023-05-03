$(function() {
	
	$('#upload').click(function() {
		
		let formData = new FormData(
			$('#account_form').get()[0]
		);
		
		$.ajax({
			url: '/account_upload',
			type: 'POST',
			contentType: false,
			processData: false,
			data: formData
		}).done(function(data) {
			
		}).fail(function(data) {
			
		});
	});
	
});