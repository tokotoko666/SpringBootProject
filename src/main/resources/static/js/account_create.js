$(function() {
	
	// 作成ボタンアクション
	$('#createAccountModal').on('click', '#createBtn', function() {
		let newAccountId = $('#newAccountId').val();
		let newPassword = $('#newPassword').val();
		let newLastName = $('#newLastName').val();
		let newFirstName = $('#newFirstName').val();
		let newAge = $('#newAge').val();
		let newPositionCode = $('#newPositionCode').val();
		let newAddress = $('#newAddress').val();
		let newComment = $('#newComment').val();
		
		let newaccount = {
			"accountId": newAccountId,
			"password": newPassword,
			"lastName": newLastName,
			"firstName": newFirstName,
			"age": newAge,
			"positionCode": newPositionCode,
			"address": newAddress,
			"comment": newComment
		};
		
		$.ajax({
			url: '/account_create/save',
			type: 'POST',
			data: newaccount
		}).done(function(data) {

			if (data == 'success') {
				$('#message').html('登録が成功しました。');
			}
			
		}).fail(function() {
			$('#message').html('登録に失敗しました。');
		});
	});

	// ポジションリストの変更アクション	
	$('#createAccountModal').on('change', '#newPosition', function() {
		$('#newPositionCode').val($(this).val());		
	});
	
});

