//ajax kategori ekleme
$;(document).ready(function(){
	$('#btnadd').click (function(){
		var categorytitle=$('#categoryTitle').val();
		
		$.ajax ({
			url : '/admin/addCategory',
			type : 'POST',
			data : { 'categoryTitle' : categorytitle},
			
			success: function(row){
				if(row==""){
					alert("Category adding failed!");
				}else{
					
					$('#pcid').append(row);
					$('#cname').val('');
					$('#cname').focus();
				}
				
			}
			
		})
		
		
	})
	
})

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

