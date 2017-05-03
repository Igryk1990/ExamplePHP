<?php session_start(); ?>
<?php
	require_once "db.php";
	require_once "function.php";
	
	
	if(isset($_SESSION['login'])){
		if(($_POST['message'])!=''){
			$author=mysql_entities_fix_string($conn,'author');
			$message = mysql_entities_fix_string($conn,'message');
			$query = "INSERT INTO messages (author, message) VALUES ('$author', '$message')";
			$result = $conn->query($query);
			$queryOne = mysqli_query($conn,"SELECT * FROM messages WHERE author = '".$author."'AND message='".$message."'");
			$row=mysqli_fetch_array($queryOne,MYSQLI_ASSOC);
			$dbauthor=$row['author'];
			$dbmessage=$row['message'];
			$json = array('author' => $dbauthor, 'message' => $dbmessage);
			echo json_encode($json);
			if (!$result) echo "Сбой при вставке данных: $query<br>" .
				$conn->error . "<br><br>";
		}
	}
	$conn->close();
?>