  function showAccounts() {
    $.ajax({
      url: '/example',
      type: 'GET',
      success: function(accounts) {
        $('#accounts-table tbody').empty();
        var result = accounts;
        $.each(accounts, function(i, account) {
          var tr = $('<tr>');
          tr.append($('<td>').text(account.name));
          tr.append($('<td>').text(account.address));
          $('#accounts-table tbody').append(tr);
        });
      },
      error: function() {
        alert('Error!');
      }
    });
  }