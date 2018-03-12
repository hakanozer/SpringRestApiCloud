function pageOpen(itemCount) {
	$.ajax({
		url : '/jsoncloud/admin/ajaxCustomerPage',
		type : 'post',
		data : {
			'itemCount' : itemCount
		},
		success : function(data) {
			if (data == "") {
				alert("Data Getirmede hata oluştu !");
			} else {
				$('tr[role=sil]').remove();
				$('tr#rows').after(data);
			}
		}
	});
}

pageCount();
function pageCount() {
	$.ajax({
		url : '/jsoncloud/admin/ajaxCustomerPageCount',
		type : 'post',
		success : function(data) {
			if (data == "") {
				alert("Sayfa Getirmede hata oluştu !");
			} else {
				$('ul#pages').html(data);
			}
		}
	});
}

// Customer delete operation
function fncCustomerDelete(id, idName, tableName) {
	// alert("silme işlemi " + id + " " + tableName);
	var deleteStatu = confirm("Silmek istediğinizden eminsiniz ?");
	if (deleteStatu) {
		$.ajax({
			url : '/jsoncloud/ajaxDeleteRow',
			type : 'post',
			data : {
				'id' : id,
				'tableName' : tableName,
				'idName' : idName
			},
			success : function(data) {
				if (data == "") {
					alert("Silme işleminde hata oluştu !");
				} else {
					$('tr#' + data).fadeOut("slow");
					pageCount();
				}
			}
		});

	}
}
