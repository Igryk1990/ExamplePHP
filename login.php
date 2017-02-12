<?php
	session_start();
	$db = mysql_connect("localhost","Igor","root");
	mysql_select_db("newsite",$db);
	if(isset($_POST['button'])){
		$login = $_POST['login'];
		$password = $_POST['password'];
	}
	$query = mysql_query("SELECT * from users WHERE login='$login'");
	$myrow = mysql_fetch_array($query);
	if($login == $myrow['login']){
		if($password==$myrow['password']){
			$_SESSION['login']=$login;
			echo "Hi ".$login;
		}else{
			echo "Password entered false";
		}
	}else{
		echo "Login entered false";
	}
?>