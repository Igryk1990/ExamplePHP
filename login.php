<?php session_start(); ?>
<?php
	require_once "db.php";
	require_once "function.php";
	
	if(!empty($_POST['login'])&& !empty($_POST['password'])){
		$login = mysql_entities_fix_string($conn,'login');
		$password = mysql_entities_fix_string($conn,'password');
		$salt1 = "qm&h*";
		$salt2 = "pg!@";
		$token = hash('ripemd128', "$salt1$password$salt2");
		$query = mysqli_query($conn,"SELECT * FROM users WHERE login = '".$login."'AND password='".$token."'");
	    $numrows=mysqli_num_rows($query);
		if($numrows!=0){
				$row=mysqli_fetch_array($query,MYSQLI_ASSOC);
				$dbstatus=$row['status'];
				if($dbstatus=='1'){
					$_SESSION['login']=$login;
					header('Location:/');
				}else {echo "Вы ещё не авторизировались в системе";}
		}else{
			echo "Неверный логин или пароль";
		}
	}
	$conn->close();
?>
<?php 
	include "header.php";
?>
<form action="/login.php" method="POST" id="form-authorization">
	<p>
		<p>
			<strong>Ваше имя</strong>:
			<input type="text" name="login" id="login-authorization">
		</p>
		<p>
			<strong>Ваш пароль</strong>:
			<input type="password" name="password" id="password-authorization">
		</p>
		<p>
			<button type="submit" name="avtoriz">Авторизация</button>
		</p>
	</p>
</form>
<div id="errors-authorization"></div>
<a href="index.php">Вернуться на главную</a>
<?php
	include "footer.php";
?>