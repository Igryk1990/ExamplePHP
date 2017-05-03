<?php session_start(); ?>
<?php
	require_once "db.php";
	
	unset($_SESSION['login']);
	header('Location:/');
?>