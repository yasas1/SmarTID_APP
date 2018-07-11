<?php
	require "dbcon.php";
	
	$fseid=(int)filter_input(INPUT_POST, "fseid");
	$shopname=filter_input(INPUT_POST, "shopname");
	
	$qty20=(int)filter_input(INPUT_POST, "qty20");
	$start20=filter_input(INPUT_POST, "start20");

	$qty50=(int)filter_input(INPUT_POST, "qty50");
	$start50=filter_input(INPUT_POST, "start50");

	$qty100=(int)filter_input(INPUT_POST, "qty100");
	$start100=filter_input(INPUT_POST, "start100");

	$qty500=(int)filter_input(INPUT_POST, "qty500");
	$start500=filter_input(INPUT_POST, "start500");

	$qty1000=(int)filter_input(INPUT_POST, "qty1000");
	$start1000=filter_input(INPUT_POST, "start1000");

	/*$fseid=1;
	$shopname="shop1";
	$qty20=2;
	$start20="100500";*/

	$date=date("Y.m.d");
	$rate=0.96;

	//get last invoice number
	$getLastInvoice="select invoiceNo from cardsales order by salesid DESC limit 1";
	$resultinvoice=mysqli_query($con, $getLastInvoice);

	if(mysqli_num_rows($resultinvoice)>0 ){
		//echo "testing";
		$rowinvoice=mysqli_fetch_assoc($resultinvoice);
		$lastInvoice =(int)$rowinvoice["invoiceNo"]+1;	
	}else{
		$lastInvoice=1;
	}
	echo $lastInvoice." ";


	if($qty20!=0 or $qty20!=NULL){
		$end20=$start20+$qty20-1;

		$price20=(float)($qty20*(20*$rate));

		//echo $qty20." ".$start20." ".$lastInvoice." ".$date." ".$end20." ".$price20." ".$fseid." ".$shopname;

		$query20="insert into cardsales(invoiceNo,fseid,shopname,date,cardtype,quantity,start,end,price) values($lastInvoice,$fseid,'$shopname','$date','20','$qty20','$start20','$end20',$price20)  ";

		$row20=mysqli_query($con, $query20);
		if($row20==1){
			echo "sell card 20 ";

			for($r20=(int)$start20;$r20<=(int)$end20;$r20++){

				$queryDelete20="delete from transferred_stock where FSEId=$fseid and SerialNumber='$r20' ";
				$rowdelete20=mysqli_query($con, $queryDelete20);
				//if($rowdelete20==1){
					//echo "sell card 20 ";
				//}
				//else{echo "Error testing delete 20";}
			}
			for($rd20=(int)$start20;$rd20<=(int)$end20;$rd20++){
				$sqldamage20="insert into damagecheck(serialNo) values($rd20)";
				$rowdamage20=mysqli_query($con, $sqldamage20);
			}		
		}else{
			echo "ERROR";
		}

	}
	if($qty50!=0 or $qty50!=NULL){
		$end50=$start50+$qty50-1;

		$price50=(float)($qty50*(50*$rate));

		$query50="insert into cardsales(invoiceNo,fseid,shopname,date,cardtype,quantity,start,end,price) values($lastInvoice,$fseid,'$shopname','$date','50','$qty50','$start50','$end50',$price50)  ";

		$row50=mysqli_query($con, $query50);
		if($row50==1){
			echo "sell card 50 ";

			for($r50=(int)$start50;$r50<=(int)$end50;$r50++){
				$queryDelete50="delete from transferred_stock where FSEId=$fseid and SerialNumber='$r50' ";
				$rowdelete50=mysqli_query($con, $queryDelete50);
				//if($rowdelete20==1){
					//echo "sell card 20 ";
				//}
				//else{echo "Error testing delete 20";}
			}
			for($rd50=(int)$start50;$rd50<=(int)$end50;$rd50++){
				$sqldamage50="insert into damagecheck(serialNo) values($rd50)";
				$rowdamage50=mysqli_query($con, $sqldamage50);
			}	
		}
	}
	if($qty100!=0 or $qty100!=NULL){
		$end100=$start100+$qty100-1;

		$price100=(float)($qty100*(100*$rate));

		$query100="insert into cardsales(invoiceNo,fseid,shopname,date,cardtype,quantity,start,end,price) values($lastInvoice,$fseid,'$shopname','$date','100','$qty100','$start100','$end100',$price100)  ";

		$row100=mysqli_query($con, $query100);
		if($row100==1){
			echo "sell card 100 ";

			for($r100=(int)$start100;$r100<=(int)$end100;$r100++){
				$queryDelete100="delete from transferred_stock where FSEId=$fseid and SerialNumber='$r100' ";
				$rowdelete100=mysqli_query($con, $queryDelete100);
				//if($rowdelete20==1){
					//echo "sell card 20 ";
				//}
				//else{echo "Error testing delete 20";}
			}
			for($rd100=(int)$start100;$rd100<=(int)$end100;$rd100++){
				$sqldamage100="insert into damagecheck(serialNo) values($rd100)";
				$rowdamage100=mysqli_query($con, $sqldamage100);
			}	
		}
	}
	if($qty500!=0 or $qty500!=NULL){
		$end500=$start500+$qty500-1;

		$price500=(float)($qty500*(500*$rate));

		$query500="insert into cardsales(invoiceNo,fseid,shopname,date,cardtype,quantity,start,end,price) values($lastInvoice,$fseid,'$shopname','$date','500','$qty500','$start500','$end500',$price500)  ";

		$row500=mysqli_query($con, $query500);
		if($row500==1){
			echo "sell card 500 ";

			for($r500=(int)$start500;$r500<=(int)$end500;$r500++){
				$queryDelete500="delete from transferred_stock where FSEId=$fseid and SerialNumber='$r500' ";
				$rowdelete500=mysqli_query($con, $queryDelete500);
				//if($rowdelete20==1){
					//echo "sell card 20 ";
				//}
				//else{echo "Error testing delete 20";}
			}
			for($rd500=(int)$start500;$rd500<=(int)$end500;$rd500++){
				$sqldamage500="insert into damagecheck(serialNo) values($rd500)";
				$rowdamage500=mysqli_query($con, $sqldamage500);
			}
		}
	}
	if($qty1000!=0 or $qty1000!=NULL){
		$end1000=$start1000+$qty1000-1;

		$price1000=(float)($qty1000*(1000*$rate));

		$query1000="insert into cardsales(invoiceNo,fseid,shopname,date,cardtype,quantity,start,end,price) values($lastInvoice,$fseid,'$shopname','$date','1000','$qty1000','$start1000','$end1000',$price1000)  ";

		$row1000=mysqli_query($con, $query1000);
		if($row1000==1){
			echo "sell card 1000 ";

			for($r1000=(int)$start1000;$r1000<=(int)$end1000;$r1000++){
				$queryDelete1000="delete from transferred_stock where FSEId=$fseid and SerialNumber='$r1000' ";
				$rowdelete1000=mysqli_query($con, $queryDelete1000);
				//if($rowdelete20==1){
					//echo "sell card 20 ";
				//}
				//else{echo "Error testing delete 20";}
			}
			for($rd1000=(int)$start1000;$rd1000<=(int)$end1000;$rd1000++){
				$sqldamage1000="insert into damagecheck(serialNo) values($rd1000)";
				$rowdamage1000=mysqli_query($con, $sqldamage1000);
			}
		}
	}


?>