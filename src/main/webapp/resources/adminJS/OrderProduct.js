function pageOpen(itemCount) {
		$.ajax({
			url : '/jsoncloud/admin/ajaxOrderPage',
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
		url : '/jsoncloud/admin/ajaxOrderPageCount',
		type: 'post',
		success : function(data) {
			if (data == "") {
				alert("Sayfa Getirmede hata oluştu !");
			}else {
				$('ul#pageorder').html(data);
			}
		}
	});
}


pageCount();
function pageSearch(itemCount) {
	var ara = $('#ordercall').val();
	$.ajax({
		url : '/jsoncloud/admin/ajaxOrderSearch',
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
	var ara = $('#ordercall').val();
$.ajax({
	url : '/jsoncloud/admin/ajaxOrderPageCountSearch',
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

function ajaxShoppingCart() {
	var customerid=$('#customer').val();

	$.ajax({
		url : '/jsoncloud/admin/cartAdd',
		type: 'post',
		data: {'id': customerid},
		success : function(data) {
			if (data != 0) {
				$('span#cartcount').html(data);
				//var link = $('#Link');
				//link.attr('href', link.attr('href') +"/"+customerid );
			}else{
				$('span#cartcount').html("");
			}
		}
	});
}
//Shopping Cart Add
function ShoppingCartAdd(id,count) {
	var customerid=$('#customer').val();
	var productcount=count;
	if(customerid==0){
		alert("Lütfen Önce Müşteri Seçiniz");
	}else{
		$.ajax({
			url : '/jsoncloud/admin/cartProductAdd',
			type: 'post',
			data: {'customerid': customerid,
				'productid' : id,
				'productcount':productcount},
			success : function(data) {
				if (data == "Basarili") {
					ajaxShoppingCart();
				}
				else {
					alert("Not add product cart")
				}
			}
		});
	}
	
}

function fncShoppingCart() {
	var customerid=$('#customer').val();
	if(customerid == 0) {
		alert("kişi seç");
	}else {
		window.location.href = 'http://localhost:8080/jsoncloud/admin/shoppingCart/'+customerid;
	}
	
		
}

function ProductCartRemove(id){
	var yanit = confirm("Are you sure you want to delete?");
	if(yanit == true) {
	$.ajax({
		url : '/jsoncloud/admin/productRemove',
		type : 'POST',
		data : { 'bid' : id },
		success : function(gelen) {
			if(gelen =="") {
				alert("Silme Başarısız Oldu");
			}else {
				alert("silme basarili");
				alert(gelen);
				
				$('tr#'+id).fadeOut();
				$('#total').html(gelen);
			}
		}
	});
	}
}


function fncOrderOpen(custid) {
	alert(custid);
	
		window.location.href = '/jsoncloud/admin/orderss/'+custid;
	
	
		
}

function pageOpenOrder(itemCount) {
	$.ajax({
		url : '/jsoncloud/admin/ajaxOrderLsPage',
		type: 'post',
		data: {'itemCount': itemCount},
		success : function(data) {
			if (data == "") {
				alert("Data Getirmede hata oluştu !");
			}else {
				$('tr[role=sil]').remove();
				$('tr#orderrows').after(data);
			}
		}
	});
}

pageCount();
function pageCount() {
$.ajax({
	url : '/jsoncloud/admin/ajaxOrderLsCount',
	type: 'post',
	success : function(data) {
		if (data == "") {
			alert("Sayfa Getirmede hata oluştu !");
		}else {
			$('ul#pageLsorder').html(data);
		}
	}
});
}

function fncStatusChange(orderId) {
	$.ajax({
		url : '/jsoncloud/admin/ajaxStatusChange',
		type: 'post',
		data: {'orderId': orderId},
		success : function(data) {
			if (data == "") {
				alert("Data Getirmede hata oluştu !");
			}else {
				$('tr[role=sil]').remove();
				$('tr#orderrows').after(data);
			}
		}
	});
}

