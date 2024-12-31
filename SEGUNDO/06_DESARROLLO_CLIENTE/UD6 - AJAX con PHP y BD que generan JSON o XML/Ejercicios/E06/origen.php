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

  if (isset($_REQUEST['origen'])) {
  // variable inicio
  $origen=$_REQUEST['origen'];

  if ($origen != -1) {

    //executar consulta
    $sql= "SELECT DISTINCT desti FROM `rodalies` WHERE origen = '$origen';";
    $result=$con->query($sql);
    if ($result->num_rows >0){//hi ha resultats
    //imprimir els resultats
      echo '<option value="-1"> selecciona una opcio';
      while ($fila=$result->fetch_assoc())
      {
        echo '<option value="'.$fila['desti'].'">'.$fila['desti'];
      }
    }else{
      echo "no hi ha resultats.";
    }
  } else {
    echo '<option value="-1"> selecciona una opcio';
  }
}
  //tancar connexio
  $con->close();
?>