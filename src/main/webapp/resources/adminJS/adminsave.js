fnchide();

$(function () {
    $('#profilimgfileupload').fileupload({
        dataType: 'json',
        
        done: function (e, data) {
        	
            $.each(data.result, function (index, file) {
            	
            	$("#profilimg").html("<img class=\"profile-user-img img-responsive img-circle\" src='http://localhost:8080/Profilimages/"+file.fileName+"'  alt=\"User profile picture\">"	);
            }); 
        },
    });
});


function fnchide() {
	$('#secondstep').hide();
	$('#thirdstep').hide();
};
function fncnext() {
	var name = $('#aname').val();
	var surname = $('#asurname').val();
	var phone = $('#aphone').val();
	var email = $('#amail').val();
	var password = $('#apassword').val();
	var password1 = $('#apassword1').val();


			$.ajax({
				url : '/jsoncloud/admin/next',
				type : 'POST',
				data : {
					'aname' : name,
					'asurname' : surname,
					'aphone' : phone,
					'amail' : email,
					'apassword' : password,
					'apassword1' : password1
				},

				success : function(data) {
					if (data == "success") {
						$('#firststep').hide();
						$('#secondstep').show();
						$('#thirdstep').hide();
					} else {
						$('#error').html(data);
					}
				}
			});


};

function fncsave() {
	var companyname = $('#companyname').val();
	var companyfax = $('#companyfax').val();
	var companyphone = $('#companyphone').val();
	var companymail = $('#companymail').val();
	
	var adresstitle = $('#adresstitle').val();
	var adresscityid = $('#cityid').val();
	var adresstownid = $('#townid').val();
	var adressdescription = $('#description').val();
	var adressneighborhoodid = $('#neighborhoodid').val();
	var adressstreetid = $('#streetid').val();
	var adressinformation = $('#information').val();
	
	$.ajax({
		url : '/jsoncloud/admin/save',
		type : 'POST',
		data : {
			'companyname' : companyname,
			'companyfax' : companyfax,
			'companyphone' : companyphone,
			'companymail' : companymail,
			
			'adresscityid' : adresscityid,
			'adresstownid' : adresstownid,
			'adressdescription' : adressdescription,
			'adressneighborhoodid' : adressneighborhoodid,
			'adressstreetid' : adressstreetid,
			'adressinformation' : adressinformation,
			'adresstitle' : adresstitle,

		},
		success : function(data) {
			if (data.length == 8) {
				$('#firststep').hide();
				$('#secondstep').hide();
				$('#thirdstep').show();
				$('#api').html(data);
			}else{
				$('#error1').html(data);
			}
		}

	});

};

function fncsave() {
	var companyname = $('#companyname').val();
	var companyfax = $('#companyfax').val();
	var companyphone = $('#companyphone').val();
	var companymail = $('#companymail').val();
	$.ajax({
		url : '/jsoncloud/admin/save',
		type : 'POST',
		data : {
			'companyname' : companyname,
			'companyfax' : companyfax,
			'companyphone' : companyphone,
			'companymail' : companymail
			

		},
		success : function(data) {
			if (data.length == 32) {
				$('#firststep').hide();
				$('#secondstep').hide();
				$('#thirdstep').show();
				$('#api').html(data);
			}else{
				$('#error1').html(data);
			}
		}

	});

};





