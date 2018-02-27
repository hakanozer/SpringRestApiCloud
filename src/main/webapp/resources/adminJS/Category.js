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

