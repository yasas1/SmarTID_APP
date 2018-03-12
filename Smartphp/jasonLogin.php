<?php
	require "dbcon.php";

	$username=filter_input(INPUT_POST, "username");
	$password=filter_input(INPUT_POST, "password");

	//$username="yasas";
	//$password="123";

	$sqlCheck="select Id from user where UserName='$username' and Password='$password'";

	$result=mysqli_query($con, $sqlCheck);

	if(mysqli_num_rows($result)>0 ){

		$id= mysqli_fetch_assoc($result);
		
	}else{
		$id["Id"]="0";
	}
	$response["id"]=$id["Id"];

	echo json_encode(array("server_response"=>$response));

	mysqli_close($con);

?>