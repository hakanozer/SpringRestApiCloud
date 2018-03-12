

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



