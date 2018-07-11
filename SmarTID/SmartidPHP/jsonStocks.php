<?php
	require "dbcon.php";

	$fseid=(int)filter_input(INPUT_POST, "fseid");
	//$fseid=1;

	$sqlGetAmmount= "select Amount from reload_transferred_stock where FseId=$fseid"; 

	$result=mysqli_query($con, $sqlGetAmmount);

	if(mysqli_num_rows($result)>0 ){

		$ammount= mysqli_fetch_assoc($result);
		
	}else{
		$ammount=0;
	}

	$response=array();
	$response["reload"]=$ammount["Amount"];

	//echo json_encode(array("server_response"=>$response));

	$count20;
	$count50;
	$count100;
	$count500;
	$count1000;

	$getCount20Query="select count(SerialNumber) from transferred_stock where type='20' and FSEId=$fseid";
	$resultCount20=mysqli_query($con, $getCount20Query);
	if(mysqli_num_rows($resultCount20)>0 ){

		$rowCount20=mysqli_fetch_assoc($resultCount20);
		$count20 =(int)$rowCount20["count(SerialNumber)"];	
	}else{
		$count20=0;
	}

	$getCount50Query="select count(SerialNumber) from transferred_stock where type='50' and FSEId=$fseid";

	$resultCount50=mysqli_query($con, $getCount50Query);
	if(mysqli_num_rows($resultCount50)>0 ){

		$rowCount50=mysqli_fetch_assoc($resultCount50);
		$count50 =(int)$rowCount50["count(SerialNumber)"];	
	}
	else{
		$count50=0;
	}

	$getCount100Query="select count(SerialNumber) from transferred_stock where type='100' and FSEId=$fseid";

	$resultCount100=mysqli_query($con, $getCount100Query);
	if(mysqli_num_rows($resultCount100)>0 ){

		$rowCount100=mysqli_fetch_assoc($resultCount100);
		$count100 =(int)$rowCount100["count(SerialNumber)"];	
	}
	else{
		$count100=0;
	}

	$getCount500Query="select count(SerialNumber) from transferred_stock where type='500' and FSEId=$fseid";

	$resultCount500=mysqli_query($con, $getCount500Query);
	if(mysqli_num_rows($resultCount500)>0 ){

		$rowCount500=mysqli_fetch_assoc($resultCount500);
		
	    $count500 =(int)$rowCount500["count(SerialNumber)"];	
	}else{
		$count500=0;
	}

	$getCount1000Query="select count(SerialNumber) from transferred_stock where type='1000' and FSEId='$fseid'";

	$resultCount1000=mysqli_query($con, $getCount1000Query);
	if(mysqli_num_rows($resultCount1000)>0 ){

		$rowCount1000=mysqli_fetch_assoc($resultCount1000);
		
	$count1000 =(int)$rowCount1000["count(SerialNumber)"];	
	}else{
		$count1000=0;
	}

	$response["count20"]=(string)$count20;	
	$response["count50"]=(string)$count50;
	$response["count100"]=(string)$count100;
	$response["count500"]=(string)$count500;
	$response["count1000"]=(string)$count1000;

	echo json_encode(array("server_response"=>$response));

	mysqli_close($con);

?>