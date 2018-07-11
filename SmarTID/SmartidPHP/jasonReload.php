<?php
	require "dbcon.php";

	$fseid=(int)filter_input(INPUT_POST, "fseid");
	//$fseid="fse1";

	$sqlGetAmmount= "select Amount from reload_transferred_stock where FseId=$fseid"; 

	$result=mysqli_query($con, $sqlGetAmmount);

	if(mysqli_num_rows($result)>0 ){

		$ammount= mysqli_fetch_assoc($result);
		
	}else{
		$ammount=0;
	}

	$response["exist"]=$ammount["Amount"];

	echo json_encode(array("server_response"=>$response));

	mysqli_close($con);

?>