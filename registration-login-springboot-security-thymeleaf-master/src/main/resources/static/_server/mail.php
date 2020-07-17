<?php
$con_name    = $_POST['con_name'];
$con_phone   = $_POST['con_phone'];
$con_email   = $_POST['con_email'];
$con_company = $_POST['con_company'];
$con_msg     = $_POST['con_msg'];

echo $con_name;

$mailto = "info@msn3twork.com";
$subject = 'Patrocínio';

$message  = "<strong>Nome :    </strong> $con_name    <br/><br/>";
$message .= "<strong>Telefone :</strong> $con_phone   <br/><br/>";
$message .= "<strong>Empresa : </strong> $con_company <br/><br/>";
$message .= "<strong>E-mail :  </strong> $con_email   <br/><br/>";
$message .= "$con_msg <br/>";

//$headers = "MIME-Version: 1.0" . "\r\n";
//$headers .= "Content-type:text/html;charset=UTF-8" . "\r\n";
//$headers .= 'From: <' . $con_name '>' . "\r\n";

$header = "From: $con_email Reply-to: $con_email";
$header .= "Content-Type: text-html; charset=utf-8";

if(mail($mailto, $subject, $message, $header))
{
    header("location:index.php");
}
else
{
    echo "Erro ao enviar a mensagem";
}


print_r($message);


?>
		
