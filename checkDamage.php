<?php
	require "dbcon.php";
	
	$serial=(int)filter_input(INPUT_POST, "serial");
	//$serial=100508;

	$sqlCheckDamage= "select serialNo from damagecheck where serialNo=$serial";

	$resultCheckDamage=mysqli_query($con, $sqlCheckDamage);

	if(mysqli_num_rows($resultCheckDamage)>0 ){
		//echo "testing";
		echo " Card Checking True ";
	}else{
		echo " Card Checking False ";
	}

	mysqli_close($con);

?>