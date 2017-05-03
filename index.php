<?php session_start(); ?>
<?php
	require_once "db.php";
?>
<?php
	include "header.php";
?>
<script type="text/javascript">
	$(function() {
		$("#send").click(function(){
			if("<?php echo $_SESSION['login']?>"){
			var author = "<?php echo $_SESSION['login']?>";
			var message = $("#message").val();
			if(message!=''){
				$.ajax({
					dataType: "html",
					type: "POST",
					url: "sendMessage.php",
					data: {"author": author, "message": message},
					cache: false,						
					success: function(response){
							$("#author").val("");
							$("#message").val("");
							respond = jQuery.parseJSON(response);
							$(".addComment").append("<div><strong>"+respond.author+":</strong> "+respond.message+"</div>");					
							$("#resp").text("Сообщение отправлено").show().delay(1500).fadeOut(800);
					},
					error: function(response) {
						$("#resp").text("Сообщение не отправлено").show().delay(1500).fadeOut(800);
					}
				});
			} else {$("#resp").text('Нельзя отправлять пустые сообщения').show().delay(1500).fadeOut(800);}
			}else{
				$("#resp").text("Для отправки сообщения авторизируйтесь в системе").show().delay(1500).fadeOut(800);
			}
			return false;
					
		});
	});
</script>
<?php if( isset($_SESSION['login'])):?>
	Вы авторизированы в системе<br />
	Привет, <?php echo $_SESSION['login'];?>
	<hr>
	<a href="/logout.php">Выйти</a>
<?php else: ?>
	<p><a href="signup.php">Регистрация</a></p>
	<p><a href="login.php">Авторизация</a></p>
<?php endif; ?>
<div class="form">
	<form action="" method="post" name="form">
		<p>
			Текст сообщения:<br>
			<textarea name="message" rows="5" cols="50" id="message"></textarea>
		</p>
		<p>
			<input name="button" type="submit" value="Отправить" id="send"> <span id="resp"></span>
		</p>
	</form>
</div>
<div class="comments">
	<div id="commentBlock">
		<?php
			$result = mysqli_query($conn,"SELECT * FROM messages");
			$comment = mysqli_fetch_array($result,MYSQLI_ASSOC);
			$rows =$result->num_rows;
			if($rows!=0){
				do{
					echo "<div><strong>".$comment['author'].":</strong> ".$comment['message']."</div>";
				}
				while($comment = mysqli_fetch_array($result,MYSQLI_ASSOC));
			}
			$conn->close();
		?>
	</div>
		<div class="addComment"></div>
</div>
<?php
	include "footer.php";
?>