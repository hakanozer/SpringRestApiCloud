//ajax kategori ekleme
$(document).ready(function() {
	$('#btnadd').click(function() {

		var categorytitle = $('#categoryTitle').val();
		var categoryparentid = $('#categoryparentid').val();
		var categorydescription=$('#categorydescription').val();
		var categorysort=$('#categorysort').val();
		$.ajax({
			url : '/jsoncloud/admin/addingCategory',
			type : 'POST',
			data : {'categorytitle' : categorytitle, 'categoryparentid' : categoryparentid,'categorysort':categorysort, 'categorydescription':categorydescription},
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

