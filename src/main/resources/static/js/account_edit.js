$(function() {
	
	// 更新ボタンアクション
	$('#updateBtn').click(function() {
		
		let id = $('#id').val();
		let accountId = $('#accountId').val();
		let lastName = $('#lastName').val();
		let firstName = $('#firstName').val();
		let age = $('#age').val();
		let positionCode = $('#positionCode').val();
		let address = $('#address').val();
		let comment = $('#comment').val();
			
		let updateForm = {
			"id": id,
			"accountId": accountId,
			"lastName": lastName,
			"firstName": firstName,
			"age": age,
			"positionCode": positionCode,
			"address": address,
			"comment": comment 
		};
			
		$.ajax({
			url: '/account_edit',
			type: 'POST',
			contentType: 'application/json',
			data: JSON.stringify(updateForm),
			dataType: 'json'
			
		}).done(function(data) {
			
		   	console.log('lastName' in data);
		   	
			$('#message').html('登録に成功しました。');
		}).fail(function() {
			$('#message').html('登録に失敗しました。');
		});
	});
	
	// ポジションリストの変更アクション
	$('#position').change(function() {
		$('#positionCode').val($(this).val());
	});
	
})
