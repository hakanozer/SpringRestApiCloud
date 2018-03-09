function fncDelete(id, idName , tableName) {
	//alert("silme işlemi " + id  + " " + tableName);
	var deleteStatu = confirm("Silmek istediğinizden eminsiniz ?");
	if (deleteStatu) {
		$.ajax({
			url : '/jsoncloud/ajaxDeleteRow',
			type: 'post',
			data: {'id': id, 'tableName':tableName, 'idName':idName},
			success : function(data) {
				if (data == "") {
					alert("Silme işleminde hata oluştu !");
				}else {
					$('tr#'+data).fadeOut("slow");
					pageCount();
				}
			}
		});
		
	}
	
}