$( document ).ready(function() {
    $("#form-registration").submit(function(){
		if ($('#login').val() == '' || $('#password').val() == '' || $('#email').val()==''){
			$('#errors').text('Пожалуйста заполните все поля');
			return false
		}
	});
	$("#form-authorization").submit(function(){
		if ($('#login-authorization').val() == '' || $('#password-authorization').val() == ''){
			$('#errors-authorization').text('Пожалуйста заполните все поля');
			return false
		}
	});
});