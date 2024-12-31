<?php
$servername= "localhost";
$username= "root";
$password="";
$dbname="";

//crear la connexio
$con= new mysqli($servername, $username, $password, $dbname);

//Comprovar que hem connectat
if ( $con->connect_error){
	die("ERROR DE CONNEXIO: ". $con->connect_error);
}

//executar consulta
$sql= "";
$result=$con->query($sql);

if ($result->num_rows >0){//hi ha resultats
	//imprimir els resultats
	while ($fila=$result->fetch_assoc())
	{

	}	
}
else{
	echo "no hi ha resultats.";
}

//tancar connexio
$con->close();

?>

