<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html;charset=utf-8">
		<title>Registration</title>
	</head>
	<body>
		<form action="registration.php" method="post">
			<p>Created your login</p>
			<input type="text" name="login" size="17" required>
			<p>Created password</p>
			<input type="password" name="password" size="17" required>
			<p>Repeat password</p>
			<input type="password" name="r-password" size="17" required>
			</br>
			<input type="submit" value="Registration" name="button">
		</form>
		</br></br>
		<p>Enter</p>
		<form action="login.php" method="post">
			<p>Enter your login</p>
			<input type="text" name="login" size="17" required>
			<p>Enter password</p>
			<input type="password" name="password" size="17" required>
			</br>
			<input type="submit" value="Enter" name="button">
		</form>
	</body>
</html>