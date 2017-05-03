<?php
	require_once "db.php";
	require_once "function.php";

	$msg='';
	
	if(!empty($_POST['login'])&&isset($_POST['password'])&&
	isset($_POST['email'])){
		
		$login = mysql_entities_fix_string($conn,'login');
		$password = mysql_entities_fix_string($conn,'password');
		$email = mysql_entities_fix_string($conn,'email');
		
		$regex = '/^[_a-z0-9-]+(\.[_a-z0-9-]+)*@[a-z0-9-]+(\.[a-z0-9-]+)*(\.[a-z]{2,4})$/';
		$my_query = mysqli_query($conn,"SELECT * FROM users WHERE login = '".$login."'");
	    $numrows=mysqli_num_rows($my_query);
			$row=mysqli_fetch_array($my_query,MYSQLI_ASSOC);
			$dbusername=$row['login'];
			if($login==$dbusername){
				echo "Пользователь с таким именем уже существует, придумайте другое имя";
			}else{
				if(preg_match($regex,$email)){	
				
					$salt1 = "qm&h*";
					$salt2 = "pg!@";
					$token = hash('ripemd128', "$salt1$password$salt2");
					$activation = hash('ripemd128',"$salt1$email$salt2");
					$counter = mysqli_query($conn,"SELECT id FROM users WHERE email='$email'");
					if(mysqli_num_rows($counter)<1){
						$query = "INSERT INTO users (login, password, email,activation) VALUES ('$login', '$token', '$email','$activation')";
						$result = $conn->query($query);
						if (!$result){ 
							echo "Сбой при вставке данных: $query<br>" .
							$conn->error . "<br><br>";
						}else{
							include 'smtp/Send_Mail.php';
							$to=$email;
							$subject="Подтверждение электронной почты";
							$body='Здравствуйте! <br/> <br/> Вы проходили процедуру регистрации у нас на сайте. 
							Пожалуйста, подтвердите адрес вашей электронной почты, и можете начать использовать ваш аккаунт на сайте. 
							<br/> <br/> <a href="'.$base_url.'activation/'.$activation.'">'.$base_url.'activation/'.$activation.'</a>';;
							Send_Mail($to,$subject,$body);
							$msg= "Регистрация выполнена успешно, пожалуйста, проверьте электронную почту."; 
						}
					}else{
						$msg= 'Данный адрес электронный почты уже занят, пожалуйста, введите другой. '; }
				}else{
					$msg = 'Адрес, введенный вами, неверен. Пожалуйста, попробуйте еще раз.'; 
				}
			}
	}
	echo $msg;
	$conn->close();
?>
<?php 
	include "header.php";
?>
<form action="signup.php" method="POST" id="form-registration">
	<p>
		<strong>Ваше имя</strong>
		<input type="text" name="login" id="login">
	</p>
	<p>
		<strong>Придумайте пароль</strong>
		<input type="password" name="password" id="password">
	</p>
	<p>
		<strong>Введите ваш email</strong>
		<input type="email" name="email" id="email">
	</p>
	<p>
		<button type="submit" name="do_login">Регистрация</button>
	</p>
</form>
<div id="errors"></div>
<a href="index.php">Вернуться на главную</a>
<?php
	include "footer.php";
?>