<?php
	require "dbcon.php";

	$shop=filter_input(INPUT_POST, "shop");
	//$shop="Thilak Stores";

	$sqlGetshop= "select Name from shop where Name='$shop' "; 

	$response=array();

	$resultCheckShop = mysqli_query($con,$sqlGetshop);

	if(mysqli_num_rows($resultCheckShop)>0 ){
		//echo "testing";
		$response["shop"]="1";
	}else{
		$response["shop"]="0";
	}
    

	echo json_encode(array("server_response"=>$response));

	mysqli_close($con);

?>