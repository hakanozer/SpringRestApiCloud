function pageOpen(itemCount) {
		$.ajax({
			url : '/jsoncloud/admin/ajaxProductPage',
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
		url : '/jsoncloud/admin/ajaxProductPageCount',
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

function pageProductSearch(itemCount) {
	var ara = $('#ara').val();
	$.ajax({
		url : '/jsoncloud/admin/ajaxProductSearch',
		type: 'post',
		data: {'ara': ara,
			   'itemCount': itemCount},
		success : function(data) {
			if (data == "") {
				alert("Data Getirmede hata oluştu !");
			}else {
				
				pageProductCountSearch();
				$('tr[role=sil]').remove();
				$('tr#rows').after(data);
				
			}
		}
	});
}

function pageProductCountSearch() {
	var ara = $('#ara').val();
$.ajax({
	url : '/jsoncloud/admin/ajaxPagePrpductCountSearch',
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

function productinsert() {
	
	var baslik =   $('#producttitle').val();
	var kategori = $('#productcategoryid').val();
	var aciklama = $('#productDescription').val();
	var fiyat =    $('#productprice').val();
	var tip =      $('#producttype').val();
	var kampanya = $('#productcampaignid').val();
	var detay =    CKEDITOR.instances.editor1.getData();

	$.ajax({
		url : '/jsoncloud/admin/productInsert',
		type: 'post',
		data: {'producttitle': baslik,
			'productcategoryid': kategori.toString(),
			'productdescription': aciklama,
			'productprice': fiyat,
			'producttype': tip,
			'productcampaignid': kampanya,
			'productdetail': detay},
		success : function(data) {
			if (data == "") {
				alert("Data Getirmede hata oluştu !");
			}else {
				alert("kayit basarili")
			}
		}
	});
}

function productupdate() {
	
	var baslik =   $('#producttitle').val();
	var kategori = $('#productcategoryid').val();
	var aciklama = $('#productDescription').val();
	var fiyat =    $('#productprice').val();
	var tip =      $('#producttype').val();
	var kampanya = $('#productcampaignid').val();
	var detay =    CKEDITOR.instances.editor1.getData();
  
	$.ajax({
		url : '/jsoncloud/admin/productUpdate',
		type: 'post',
		data: {'producttitle': baslik,
			'productcategoryid': kategori.toString(),
			'productdescription': aciklama,
			'productprice': fiyat,
			'producttype': tip,
			'productcampaignid': kampanya,
			'productdetail': detay},
		success : function(data) {
			if (data == "") {
				alert("Data Getirmede hata oluştu !");
			}else {
				window.location.href = "http://localhost:8095/jsoncloud/admin/product";
			}
		}
	});
}
