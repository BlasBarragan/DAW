<?php
$servername= "localhost";
$username= "root";
$password="";
$dbname="comentaris_ajax";
//video del que mostre els comentaris
$vid=$_REQUEST['video'];
//crear la connexio
$con= new mysqli($servername, $username, $password, $dbname);
//Comprovar que hem connectat
if ( $con->connect_error){
die("ERROR DE CONNEXIO: ". $con->connect_error);
}
//executar consulta
$sql="SELECT * FROM `comentari` WHERE `id_video`=".$vid;
//echo $sql;
$result=$con->query($sql);
if ($result->num_rows >0){//hi ha resultats
//crear xml
$xml="<?xml version=\"1.0\"?>\n";
$xml.="<comentaris>\n";
//imprimir els resultats
while ($fila=$result->fetch_assoc())
{
$xml.="<comentari>\n";
$xml.="<autor>".$fila['autor']."</autor>\n";
$xml.="<comenta>".$fila['comentari']."</comenta>\n";
$xml.="</comentari>\n";
}
$xml.="</comentaris>\n";
header('Content-Type: text/xml');
}
else{
echo "no hi ha resultats.";
}
echo($xml);
//tancar connexio
$con->close();
?>