//ajax kategori ekleme
$(document).ready(function() {
	$('#btnadd').click(function() {

		var categorytitle = $('#categoryTitle').val();
		var categoryparentid = $('#categoryparentid').val();
		
		alert(categorytitle);
		alert(categoryparentid);
		
		$.ajax({
			url : '/jsoncloud/admin/addingCategory',
			type : 'POST',
			data : {'categorytitle' : categorytitle, 'categoryparentid' : categoryparentid},
			success : function(data) {
				if (data == "") {
					alert("Category adding failed!");
				} else {
					alert("Category adding succes!");
					$('#categoryparentid').append(data);
				}
			}
		});
	});
});

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

