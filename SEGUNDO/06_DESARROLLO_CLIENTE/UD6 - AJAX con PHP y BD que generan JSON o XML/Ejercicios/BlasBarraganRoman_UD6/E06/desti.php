<?php
  $servername= "localhost";
  $username= "root";
  $password="";
  $dbname="tren_ajax";
  //crear la connexio
  $con= new mysqli($servername, $username, $password, $dbname);
  //Comprovar que hem connectat
  if ( $con->connect_error){
    die("ERROR DE CONNEXIO: ". $con->connect_error);
  }

  if (isset($_REQUEST['desti']) && isset($_REQUEST['origen'])) {
  // variable inicio
  $origen=$_REQUEST['origen'];
  $desti=$_REQUEST['desti'];

  if ($desti != -1) {

    //executar consulta
    $sql= "SELECT * FROM `rodalies` WHERE origen = '$origen' AND desti = '$desti';";
    $result=$con->query($sql);
    if ($result->num_rows >0){//hi ha resultats
    //imprimir els resultats
    $cadenaJson ='[';

      while ($fila=$result->fetch_assoc())
      {
        $cadenaJson .= '{"id":"'.$fila['id'].'", "origen":"'.$fila['origen'].'", "desti":"'.$fila['desti'].'", "horaEixida":"'.$fila['horaEixida'].'", "horaArribada":"'.$fila['horaArribada'].'"},';
      }
    $cadenaJson = substr($cadenaJson, 0 , -1);
    $cadenaJson .=']';

      echo ($cadenaJson);
    }else{
      echo "no hi ha resultats.";
    }
  }
}
  //tancar connexio
  $con->close();
?>