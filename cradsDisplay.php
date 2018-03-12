<?php
	require "dbcon.php";
	

	// get selected quantity for 30 cards
	$qty20=(int)filter_input(INPUT_POST, "dis20");
	$qty50=(int)filter_input(INPUT_POST, "dis50");
	$qty100=(int)filter_input(INPUT_POST, "dis100");
	
	$qty500=(int)filter_input(INPUT_POST, "dis500");
	$qty1000=(int)filter_input(INPUT_POST, "dis1000");

	/*if($qty20==NULL){
		$qty20=(int)$qty20;
	}
	if($qty50==NULL){
		$qty50=(int)$qty50;
	}
	if($qty100==NULL){
		$qty100=(int)$qty100;
	}
	if($qty500==NULL){
		$qty500=(int)$qty500;
	}
	if($qty1000==NULL){
		$qty1000=(int)$qty1000;
	}
	*/
	//getting cards and display for card_30
	if($qty20>0 ){

		//query to get the count of 30 cards from card30 table
		$getCount20Query="select count(SerialNumber) from transferred_stock where type='20'";

		$resultCount20=mysqli_query($con, $getCount20Query);
		$rowCount20=mysqli_fetch_assoc($resultCount20);
		//get count from integer
		$count20 =(int)$rowCount20["count(SerialNumber)"];

		if($qty20<=$count20){

			//query to get 1st cerial number from card30 table
			$sql20= "select SerialNumber from transferred_stock where type='20' order by SerialNumber asc limit 1 "; 

			$result20=mysqli_query($con, $sql20);

			if(mysqli_num_rows($result20)>0 ){

				$row20 = mysqli_fetch_assoc($result20);
				//getting firts cerialNo from card30 table to $firstcard30
				$firstcard20 = (int)$row20["SerialNumber"];

				if($qty20==1){
					echo " 20_card ".$firstcard20." ";
				}
				else{
					   //getting last cerialNo that is wanted by FSE 
					$lastcard20 = $firstcard20 + $qty20 - 1;
					echo " 20_card from ".$firstcard20." to " .$lastcard20."\n ";
				}			
			}	
    		else{
				echo " getting 20_cards fail ";
    		}
		}
		else{
			echo " There is only ".$count20." cards in your card_20 in store ";
		}

	}

	//getting cards and display for card_50
	if($qty50>0){

		//query to get the count of 50_cards from card50 table
		$getCount50Query="select count(SerialNumber) from transferred_stock where type='50'";

		$resultCount50=mysqli_query($con, $getCount50Query);
		$rowCount50=mysqli_fetch_assoc($resultCount50);
		//get count from integer
		$count50 =(int)$rowCount50["count(SerialNumber)"];

		if($qty50<=$count50){

			//query to get 1st cerial number from card50 table
			$sql50= "select SerialNumber from transferred_stock where type='50' order by SerialNumber asc limit 1"; //order by SerialNumber asc limit 1

			$result50=mysqli_query($con, $sql50);

			if(mysqli_num_rows($result50)>0 ){

				$row50 = mysqli_fetch_assoc($result50);
				$firstcard50 = (int)$row50["SerialNumber"];				

				if($qty50==1){
					echo " 50_card  ".$firstcard50." ";
				}
				else{
					$lastcard50 = $firstcard50 + $qty50 - 1;
					echo " 50_card from ".$firstcard50." to " .$lastcard50." ";
				}

				
				
			}	
    		else{
				echo " getting 50_cards fail ";
    		}
		}
		else{
			echo " There is only ".$count50." cards in your card_50 in store ";
		}

	}

	//getting cards and display for card_100
	if($qty100>0){

		//query to get the count of 100 cards from card100 table
		$getCount100Query="select count(SerialNumber) from transferred_stock where type='100'";

		$resultCount100=mysqli_query($con, $getCount100Query);
		$rowCount100=mysqli_fetch_assoc($resultCount100);
		//get count from integer
		$count100 =(int)$rowCount100["count(SerialNumber)"];

		if($qty100<=$count100){

			//query to get 1st cerial number from card100 table
			$sql100= "select SerialNumber from transferred_stock where type='100'"; 

			$result100=mysqli_query($con, $sql100);

			if(mysqli_num_rows($result100)>0 ){

				$row100 = mysqli_fetch_assoc($result100);
				//getting firts cerialNo from card100 table to $firstcard100
				$firstcard100 = (int)$row100["SerialNumber"];
				
				if($qty100==1){
					echo " 100_card ".$firstcard100." ";
				}
				else{
					   //getting last cerialNo that is wanted by FSE 
					$lastcard100 = $firstcard100 + $qty100 - 1;
					echo " 100_card from ".$firstcard100." to " .$lastcard100." ";
				}
			}	
    		else{
				echo " getting 100_cards fail ";
    		}
		}
		else{
			echo " There is only ".$count100." cards in your card_100 store ";
		}

	}
 
	//getting cards and display for card_500
	if($qty500>0){

		//query to get the count of 500 cards from card500 table
		$getCount500Query="select count(SerialNumber) from transferred_stock where type='500'";

		$resultCount500=mysqli_query($con, $getCount500Query);
		$rowCount500=mysqli_fetch_assoc($resultCount500);
		//get count from integer
		$count500 =(int)$rowCount500["count(SerialNumber)"];

		if($qty500<=$count500){

			//query to get 1st cerial number from card500 table
			$sql500= "select SerialNumber from transferred_stock where type='500' order by SerialNumber asc limit 1"; 

			$result500=mysqli_query($con, $sql500);

			if(mysqli_num_rows($result500)>0 ){

				$row500 = mysqli_fetch_assoc($result500);
				//getting firts cerialNo from card500 table to $firstcard500
				$firstcard500 = (int)$row500["SerialNumber"];
				if($qty500==1){
					echo " 500_card ".$firstcard500." ";
				}
				else{
					   //getting last cerialNo that is wanted by FSE 
					$lastcard500 = $firstcard500 + $qty500 - 1;
					echo " 500_card from ".$firstcard500." to " .$lastcard500." ";
				}
			}	
    		else{
				echo " getting 500_cards fail ";
    		}
		}
		else{
			echo " There is only ".$count500." cards in your card_500 in store ";
		}

	}

	//getting cards and display for card_200
	if($qty1000>0){

		//query to get the count of 200 cards from card200 table
		$getCount1000Query="select count(SerialNumber) from transferred_stock where type='1000'";

		$resultCount1000=mysqli_query($con, $getCount1000Query);
		$rowCount1000=mysqli_fetch_assoc($resultCount1000);
		//get count from integer
		$count1000 =(int)$rowCount1000["count(SerialNumber)"];

		if($qty1000<=$count1000){

			//query to get 1st cerial number from card200 table
			$sql1000= "select SerialNumber from transferred_stock where type='1000' order by SerialNumber asc limit 1"; 

			$result1000=mysqli_query($con, $sql1000);

			if(mysqli_num_rows($result1000)>0 ){

				$row1000 = mysqli_fetch_assoc($result1000);
				//getting firts cerialNo from card200 table to $firstcard200
				$firstcard1000 = (int)$row1000["SerialNumber"];
				if($qty1000==1){
					echo " 1000_card ".$firstcard1000." ";
				}
				else{
					   //getting last cerialNo that is wanted by FSE 
					$lastcard1000 = $firstcard1000 + $qty1000 - 1;
					echo " 1000_card from ".$firstcard1000." to " .$lastcard1000." ";
				}
			}	
    		else{
				echo " getting 1000_cards fail ";
    		}
		}
		else{
			echo " There is only ".$count1000." cards in your card_1000 store ";
		}

	}

	mysqli_close($con);

?>