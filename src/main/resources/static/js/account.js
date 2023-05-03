$(function() {
	
	// 検索処理
	$('#search').click(function() {
		
		$('#message').val('');
		$('#detailArea tbody').empty();
		
		let accountId = $('#accountId').val();
		let lastName = $('#lastName').val();
		let firstName = $('#firstName').val();
		let age = $('#age').val();
		let positionCode = $('#positionCode').val();
		let address = $('#address').val();
		
		let accountSearchForm = {
			"accountId": accountId,
			"lastName": lastName,
			"firstName": firstName,
			"age": age,
			"positionCode": positionCode,
			"address": address
		};
		
		$.ajax({
			url: '/account',
			type: 'POST',
			contentType: 'application/json',
			data: JSON.stringify(accountSearchForm),
			dataType: 'json'
			
		}).done(function(data) {
			
			$.each(data, function(i, account) {
				let tr = $('<tr>');
				tr.append($('<td>').text(account.accountId));
				tr.append($('<td>').text(account.lastName));
				tr.append($('<td>').text(account.firstName));
				tr.append($('<td>').text(account.age));
				tr.append($('<td>').text(account.positionCode));
				tr.append($('<td>').text(account.address.length > 10 ? account.address.substring(0, 10) + '...' : account.address));
				tr.append($('<td>').text(account.comment));
				let id = account.id;
				tr.append($('<td>').append($(`<a>`).text('編集').attr('href', '/account_edit?id=' + id)));
				$('#detailArea tbody').append(tr);
			});
				
		}).fail(function() {
			$('#message').val('検索に失敗しました。');
		});
	});
	
	//　クリアボタン処理
	$('#clear').click(function() {
		$('#message').html('');
		$('#accountId').val('');
		$('#lastName').val('');
		$('#firstName').val('');
		$('#age').val('');
		$('#positionCode').val('');
		$('#address').val('');
		$('#detail').html('');
	});
	
	// ダウンロード処理
	$('#download').click(function() {
		
		let accountId = $('#accountId').val();;
		let lastName = $('#lastName').val();;
		let firstName = $('#firstName').val();
		let age = $('#age').val();
		let positionCode = $('#positionCode').val();
		let address = $('#address').val();
		
		let accountSearchForm = {
			"accountId": accountId,
			"lastName": lastName,
			"firstName": firstName,
			"age": age,
			"positionCode": positionCode,
			"address": address
		}
		
		$.ajax({
			url: '/account/download',
			type: 'POST',
			data: JSON.stringify(accountSearchForm),
			contentType: 'application/json'
			
		}).done(function(data) {
				
			if (data != "") {
				
				let downloadData = new Blob([data], {type: "text/csv"});
				let filename ="download.csv";
				
				//ファイルのダウンロードにはブラウザ毎に処理を分けます
				if (window.navigator.msSaveBlob) { // for IE
					window.navigator.msSaveBlob(downloadData, filename);
				} else {
					let downloadUrl  = (window.URL || window.webkitURL).createObjectURL(downloadData);
					let link = document.createElement("a");
					link.href = downloadUrl;
					link.download = filename;
					link.click();
					(window.URL || window.webkitURL).revokeObjectURL(downloadUrl);
				}
			}
			
		}).fail(function() {
			$('#message').val('err');
		});
	});
	
	// ポジションリストの変更
	$('#positionCode').change(function() {
		$('#positionCode').val($(this).val());
	});
	
	//　新規登録ボタン
    $('#createAccountModal').on('show.bs.modal', function (event) {
        var modal = $(this);
        modal.find('#modal-content').load('/account_create');	
    })
	
});
