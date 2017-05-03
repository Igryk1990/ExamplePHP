<?php
	$host = 'localhost';
	$db = 'db_site';
	$user = 'root';
	$pw = '';
	
	$conn = new mysqli($host, $user, $pw, $db);
	if($conn->connect_error) die ($conn->connect_error);
	$base_url='http://mustang90.000webhostapp.com/';
?>