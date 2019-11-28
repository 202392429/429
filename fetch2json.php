<?php

include_once('conn.php');
	if(!$conn) die("Connection problem, try again later");


	$sql = "select * from users;";
	$result = $conn->query($sql);
	$array = array();
	while($row = $result->fetch_assoc()){
		array_push($array,$row);
	}
	echo json_encode($array);
?>
