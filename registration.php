<?php
	$db = mysql_connect("localhost","Igor","root");
	mysql_select_db("newsite",$db);
	if(isset($_POST['button'])){
		$login = $_POST['login'];
		$password = $_POST['password'];
		$rpassword = $_POST['r-password'];
	}
	if($password==$rpassword){
		echo "Created";
		mysql_query("INSERT INTO users (login,password) VALUES ('$login','$password')");
	} else {
		echo "Passwords do not match";
	}
?>