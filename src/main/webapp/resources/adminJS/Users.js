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



function pageCountSearchh() {
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
			//$('ul#pages').html(data);
		}
	}
});



}


function pageSearchh(itemCount) {
	var ara = $('#ara').val();
	$.ajax({
		url : '/jsoncloud/admin/ajaxCustomerSearchh',
		type: 'post',
		data: {'ara': ara,
			   'itemCount': itemCount},
		success : function(data) {
			if (data == "") {
				alert("Daaata Getirmede hata oluştu !");
			}else {
				
				pageCountSearchh();
				$('tr[role=sil]').remove();
				$('tr#rows').after(data);
				
			}
		}
	});
}



function userAdd() {
	var customercompanyid = $('#customercompanyid').val();
	var customermail = $('#customermail').val();
	var customername = $('#customername').val();
	var customerpassword = $('#customerpassword').val();
	var customerpassword1 = $('#customerpassword1').val();
	var customerphone = $('#customerphone').val();
	var customersurname = $('#customersurname').val();

	$.ajax({
		url : '/jsoncloud/admin/usersAdd',
		type: 'POST',
		data: {
			'customercompanyid': customercompanyid,
			'customermail': customermail,
			'customername': customername,
			'customerpassword': customerpassword,
			'customerpassword1': customerpassword1,
			'customerphone': customerphone,
			'customersurname': customersurname
			   },
		success : function(data) {
			if (data != "") {	
				$('#alert').html(data);
			}
		}
	});
}

