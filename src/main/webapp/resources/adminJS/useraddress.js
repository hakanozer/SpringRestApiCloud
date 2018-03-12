// Kullanıcı Adresi Kısmı Elif-Sinem

function pageOpen(itemCount) {
		$.ajax({
			url : '/jsoncloud/admin/ajaxAddressPage',
			type: 'post',
			data: {'itemCount': itemCount},
			success : function(data) {
				if (data == "") {
					alert("Data Getirmede hata oluştu !");
				}else {
					$('tr[role=sil]').remove();
					$('tr#rows').after(data);
				}
			}
		});
}
pageCount();
function pageCount() {
	$.ajax({
		url : '/jsoncloud/admin/ajaxPageCountt',
		type: 'post',
		success : function(data) {
			if (data == "") {
				alert("Sayfa Getirmede hata oluştu !");
			}else {
				$('ul#pages').html(data);
			}
		}
	});
}

function pageSearch(itemCount) {
	var ara = $('#ara').val();
	$.ajax({
		url : '/jsoncloud/admin/ajaxAddressSearch',
		type: 'post',
		data: {'ara': ara,
			   'itemCount': itemCount},
		success : function(data) {
			if (data == "") {
				alert("Data Getirmede hata oluştu !");
			}else {
				
				pageCountSearch();
				$('tr[role=sil]').remove();
				$('tr#rows').after(data);
				
			}
		}
	});
}

function pageCountSearch() {
	var ara = $('#ara').val();
$.ajax({
	url : '/jsoncloud/admin/ajaxPageCountSearchh',
	type: 'post',
	data: {'ara': ara},
	success : function(data) {
		if (data == "") {
			alert("Sayfa Getirmede hata oluştu !");
		}else {
			$('ul.pagination li').remove();
			$('ul.pagination').html(data);
		}
	}
});
}


