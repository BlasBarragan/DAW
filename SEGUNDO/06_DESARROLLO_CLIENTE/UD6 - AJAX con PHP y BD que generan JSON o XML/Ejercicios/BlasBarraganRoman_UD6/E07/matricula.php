<?php
  $servername= "localhost";
  $username= "root";
  $password="";
  $dbname="parking_ajax";
  //crear la connexio
  $con= new mysqli($servername, $username, $password, $dbname);
  //Comprovar que hem connectat
  if ( $con->connect_error){
    die("ERROR DE CONNEXIO: ". $con->connect_error);
  }

  if (isset($_REQUEST['smatricula'])) {
    // variable inicio
    $matricula=$_REQUEST['smatricula'];
    $cliente=$_REQUEST['scliente'];

    //executar consulta
    $sql="SELECT * FROM cotxe JOIN client ON client.dni = cotxe.id_client WHERE cotxe.matricula='$matricula'";
    //echo $sql;
    $result=$con->query($sql);
    if ($result->num_rows >0){//hi ha resultats
      //crear xml
      $xml="<?xml version=\"1.0\"?>\n";
      $xml.="<coche>\n";
      //imprimir els resultats
      while ($fila=$result->fetch_assoc()){
        $xml.="<matricula>".$fila['matricula']."</matricula>\n";
        $xml.="<marca>".$fila['marca']."</marca>\n";
        $xml.="<model>".$fila['model']."</model>\n";
        $xml.="<color>".$fila['color']."</color>\n";
        $xml.="<dni>".$fila['dni']."</dni>\n";
        $xml.="<nom>".$fila['nom']."</nom>\n";
        $xml.="<direccio>".$fila['direccio']."</direccio>\n";
        $xml.="<poblacio>".$fila['poblacio']."</poblacio>\n";
        $xml.="<sexe>".$fila['sexe']."</sexe>\n";
      }
      $xml.="</coche>\n";
      header('Content-Type: text/xml');
    } else {
      echo "no hi ha resultats.";
    }
    echo($xml);
  }
//tancar connexio
$con->close();
?>