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

