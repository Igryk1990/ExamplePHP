<?php
	session_start();
	if(isset($_SESSION['login'])){
		echo "This text users";
	}else{
		echo "This text not users";
	}
?>