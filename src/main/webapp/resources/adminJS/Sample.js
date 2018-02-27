function pageOpen(itemCount) {
		$.ajax({
			url : '/jsoncloud/admin/ajaxSamplePage',
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
		url : '/jsoncloud/admin/ajaxPageCount',
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
		url : '/jsoncloud/admin/ajaxSampleSearch',
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
	url : '/jsoncloud/admin/ajaxPageCountSearch',
	type: 'post',
	data: {'ara': ara},
	success : function(data) {
		if (data == "") {
			alert("Sayfa Getirmede hata oluştu !");
		}else {
			$('ul.pagination li').remove();
			$('ul.pagination').html(data);
			//$('ul#pages').html(data);
		}
	}
});
}
