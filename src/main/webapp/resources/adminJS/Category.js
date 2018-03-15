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
					$('#error').html("<div class=\"alert alert-warning alert-dismissible\">\r\n" + 
							"                <button type=\"button\" class=\"close\" data-dismiss=\"alert\" aria-hidden=\"true\">×</button>\r\n" + 
							"                <h4><i class=\"icon fa fa-warning\"></i> Uyarı!</h4>\r\n" + 
							"               Kategori alanları dolu olmalıdır.\r\n" + 
							"              </div>");
				} else {
					alert("Category adding succes!");
					$('#categoryparentid').append(data);
				}
			}
		});
	});
});

