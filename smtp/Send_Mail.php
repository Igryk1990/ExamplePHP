<?php
	function Send_Mail($to,$subject,$body){
		require 'class.phpmailer.php';
		 $from       = "Igoryok27@yandex.ru";
		 $mail       = new PHPMailer();
		 $mail->CharSet = "UTF-8";
		 $mail->IsSMTP(true);  
		 $mail->IsHTML(true);
		 $mail->SMTPAuth   = true;            
		 $mail->Host       = "tls://smtp.yandex.ru"; 
		 $mail->Port       =  465;               
		 $mail->Username   = "Igoryok27@yandex.ru";  
		 $mail->Password   = "veronika19902016";
		 $mail->SetFrom($from, 'Администрация сайта');
		 $mail->AddReplyTo($from,'Администрация сайта');
		 $mail->Subject    = $subject;
		 $mail->MsgHTML($body);
		 $address = $to;
		 $mail->AddAddress($address, $to);
		 $mail->Send(); 
	}
?>