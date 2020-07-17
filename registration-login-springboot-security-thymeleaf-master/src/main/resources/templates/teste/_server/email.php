<?php
//if "email" variable is filled out, send email
  if (isset($_REQUEST['con_email']))  {   //Email information
  $admin_email = "info@msn3twork.com";
  $con_email  = $_REQUEST['con_email'];
  $con_name  = $_REQUEST['con_name'];
  $con_phone  = $_REQUEST['con_phone'];
  $con_company  = $_REQUEST['con_company']; 
  $con_msg  = $_REQUEST['con_msg'];  //send email
  mail($admin_email, $subject, $message, $headers, "From:" . $con_name);   //Email response
  echo "Thank you for contacting us!";
  }   //if "con_email" variable is not filled out, display the form
?>