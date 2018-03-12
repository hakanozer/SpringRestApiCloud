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


//ilçe dropdown doldurma
function fncUserTown() {
	var cityid = $('#cityid').val();

	$.ajax({
		url : '/jsoncloud/admin/useraddresstown',
		type : 'POST',
		data : {
			'cityid' : cityid
		},

		success : function(data) {
			if (data == "") {
				alert("Town fetch failed");
			} else {
				$('#townid').html(data);
			}
		}
	})
}

//mahalle dropdown doldurma
function fncUserNeighborhood() {
	var townid = $('#townid').val();
	$.ajax({
		url : '/jsoncloud/admin/useraddressneighborhood',
		type : 'POST',
		data : {
			'townid' : townid
		},

		success : function(data) {
			if (data == "") {
				alert("Neighborhood fetch failed");
			} else {
				$('#neighborhoodid').html(data);
			}
		}
	})
}

//cadde-sokak dropdown doldurma
function fncUserStreet() {
	var neighborhoodid = $('#neighborhoodid').val();
	$.ajax({
		url : '/jsoncloud/admin/useraddressstreet',
		type : 'POST',
		data : {
			'neighborhoodid' : neighborhoodid
		},

		success : function(data) {
			if (data == "") {
				alert("Street fetch failed");
			} else {
				$('#streetid').html(data);
			}
		}
	})
}

$('#reset').click(function(){

	$('select#adresscustomerid').val("-1").change();
	$('select#cityid').val("-1").change();
	$('#townid').html("<option selected=\"selected\">Please select your town</option>");
	$('#neighborhoodid').html("<option selected=\"selected\">Please select your town</option>");
	$('#streetid').html("<option selected=\"selected\">Please select your town</option>");
})

