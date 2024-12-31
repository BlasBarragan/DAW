<!doctype html>
<html lang="es">
<head>
  <meta charset="utf-8">
  <title>AJAX</title>
  <meta name="description" content="descripcio">
  <meta name="author" content="Jose Masip">
  <script src="scripts.js"></script>
  <style>
    table, td {
      border: 1px solid #000;
    }
  </style>
</head>

<body>
  <h1>Origen - Desti estacio de tren</h1>
  origen
  <select id="origen">
    <option value="-1"> selecciona una opcio
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
        //executar consulta
        $sql= "SELECT DISTINCT origen FROM `rodalies` ";
        $result=$con->query($sql);
        if ($result->num_rows >0){//hi ha resultats
        //imprimir els resultats
          while ($fila=$result->fetch_assoc())
          {
            echo '<option value="'.$fila['origen'].'">'.$fila['origen'];
          }
        }else{
          echo "no hi ha resultats.";
        }
        //tancar connexio
        $con->close();
      ?>
  </select>
  desti
  <select id="desti">
    <option value="-1"> selecciona una opcio
  </select>
  <div id="horaris"></div>
</body>
<script>

  let seleccionOrigen = document.getElementById('origen');
  console.log(seleccionOrigen);
  seleccionOrigen.addEventListener('change', function() {
    leerOrigen(seleccionOrigen.value)
  });
  let seleccionDesti = document.getElementById('desti');
  console.log(seleccionDesti);
  seleccionDesti.addEventListener('change', function() {
    leerDesti(seleccionDesti.value, seleccionOrigen.value);
  });

</script>
</html>
