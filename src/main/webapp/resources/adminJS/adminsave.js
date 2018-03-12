fnchide();

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

