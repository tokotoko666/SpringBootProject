$('#the-form').submit(function(event) {
	
	var $form= $(this);
	
	$.ajax({
		url: $form.attr('action'),
		type: $form.attr('method'),
		timeout: 60000,
		data: $form.serialize()
	}).done(function() {
		alert('success');
	}).fail(function() {
		alert('fail');
	});
});

function addClick() {
	$.ajax({
		url: '/init/hoge',
		type: 'GET',
		dataType: 'json',
		data: {name: $('#name').val(),
				age : $('#age').val()}
	}).done(function(data) {
		$(".result").append('<div>${data}</div>');
		alert('success');
	}).fail(function() {
		alert('fail');
	});
}