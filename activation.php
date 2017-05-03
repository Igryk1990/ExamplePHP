<?php
	include 'db.php';
	$msg='';
	if(!empty($_GET['code']) && isset($_GET['code'])){
		$code=$_GET['code'];
		$c=mysqli_query($conn,"SELECT id FROM users WHERE activation='$code'");
		if(mysqli_num_rows($c) > 0){
			$countAct=mysqli_query($conn,"SELECT id FROM users WHERE activation='$code' and status='0'");

			if(mysqli_num_rows($countAct) == 1){
				mysqli_query($conn,"UPDATE users SET status='1' WHERE activation='$code'");
				$msg="Ваш аккаунт успешно активирован";
			}else{
				$msg ="Ваш аккаунт уже активирован, нет необходимости активировать его снова.";
			}
		 }else{
			$msg ="Неверный код активации.";
		 }
	 }
?>
<?php include 'header.php'?>
<?php echo $msg; ?>
<br />
<a href="/index.php">Перейти на главную страницу</a>
<?php include 'footer.php'?>