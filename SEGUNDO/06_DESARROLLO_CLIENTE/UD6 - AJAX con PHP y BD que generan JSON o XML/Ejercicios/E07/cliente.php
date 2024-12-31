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

  if (isset($_REQUEST['scliente'])) {
    // variable inicio
    $cliente=$_REQUEST['scliente'];
    //executar consulta
    $sql= "SELECT matricula FROM `cotxe` WHERE id_client = '$cliente';";
    $result=$con->query($sql);
    if ($result->num_rows >0){//hi ha resultats
    //imprimir els resultats
      echo '<option value="-1"> selecciona una opcio';
      while ($fila=$result->fetch_assoc()) {
        echo '<option value='.$fila['matricula']. '>'.$fila['matricula'];
      }
    } else {
      echo '<option value="-1"> no hi ha resultats';
    }
  }
  //tancar connexio
  $con->close();
?>
