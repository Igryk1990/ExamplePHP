<?php
	function get_post($conn, $var){
		if (get_magic_quotes_gpc()) $var = stripslashes($var);
		return mysqli_real_escape_string($conn, $_POST[$var]);
	}
	function mysql_entities_fix_string($conn, $string){
		return htmlentities(get_post($conn, $string));
	}
?>