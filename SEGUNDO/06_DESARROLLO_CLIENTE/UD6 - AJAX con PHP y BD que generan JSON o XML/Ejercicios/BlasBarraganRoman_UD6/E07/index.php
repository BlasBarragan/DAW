<!doctype html>
<html lang="es">
<head>
  <meta charset="utf-8">
  <title>AJAX</title>
  <meta name="description" content="descripcio">
  <meta name="author" content="Jose Masip">
  <script src="scripts.js"></script>
  <link rel="stylesheet" href="estilos.css">
</head>
<body>
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
  ?>
  <h1 align="center">Gesti&oacute; d'un parking</h1>
  <form name="formulari">
    <table align="center">
      <tr>
        <td width="60">client</td>
        <td>
          <select id="sclient">
            <option value="-1"> selecciona una opcio
              <?php
                //executar consulta
                $sql= "SELECT DISTINCT dni FROM `client` ";
                $result=$con->query($sql);
                if ($result->num_rows >0){//hi ha resultats
                  //imprimir els resultats
                  while ($fila=$result->fetch_assoc()){
                    echo '<option value='.$fila['dni']. '>'.$fila['dni'];
                  }
                } else {
                  echo "no hi ha resultats.";
                }
              ?>
          </select>
          <input type="text" id="cclient" />
          <img src="ima/buscar.jpeg" alt="buscar client" id="fclient" width="18">
          <div id="mclient"></div>
        </td>
      </tr>
      <tr>
        <td width="60">matricula</td>
        <td>
          <select id="smatricula">
            <option value="-1"> selecciona una opcio
          </select>
          <input type="text" id="cmatricula" />
          <img src="ima/buscar.jpeg" alt="buscar matricula" id="fmatricula" width="18">
          <div id="mmatricula"></div>
        </td>
      </tr>
      <tr>
        <td>data</td>
        <td>
          <input type="text" id="data" size="40" disabled>
          <img src="ima/trianguloa.jpg" alt="mostrar detall" width="18" onmouseover="javascript:document.getElementById('detall').style.visibility='visible'; document.getElementById('detall').style.height=170">
          <img src="ima/triangulob.jpg" alt="ocultar detall" width="18" onmouseover="javascript:document.getElementById('detall').style.visibility='hidden'; document.getElementById('detall').style.height=10">
        </td>
      </tr>
    </table>
    <div id="detall">
      <table align="center">
        <tr>
          <td>matricula</td>
          <td>
            <input type="text" id="matricula" size="44" disabled>
          </td>
        </tr>
        <tr>
          <td>marca</td>
          <td>
            <input type="text" id="marca" size="44" disabled>
          </td>
        </tr>
        <tr>
          <td>model</td>
          <td>
            <input type="text" id="model" size="44" disabled>
          </td>
        </tr>
        <tr>
          <td>color</td>
          <td>
            <input type="text" id="color" size="44" disabled>
          </td>
        </tr>
        <tr>
          <td width="60">dni</td>
          <td>
            <input type="text" id="dni" size="44" disabled>
          </td>
        </tr>
        <tr>
          <td width="60">nom</td>
          <td>
            <input type="text" id="nom" size="44" disabled>
          </td>
        </tr>
        <tr>
          <td width="60">direccio</td>
          <td>
            <input type="text" id="direccio" size="44" disabled>
          </td>
        </tr>
        <tr>
          <td width="60">poblacio</td>
          <td>
            <input type="text" id="poblacio" size="44" disabled>
          </td>
        </tr>
        <tr>
          <td width="60">sexe</td>
          <td>
            <input type="text" id="sexe" size="44" disabled>
          </td>
        </tr>
      </table>
    </div>
    <center>
      <input type=button name="boto" value="entrada parking">
    </center>
  </form>

  <script>

    let seleccionCli = document.getElementById('sclient');
    console.log(seleccionCli);
    seleccionCli.addEventListener('change', function() {
      leerCli(seleccionCli.value);
    });

    let seleccionMat = document.getElementById('smatricula');
    console.log(seleccionMat);
    seleccionMat.addEventListener('change', function() {
      leerMat(seleccionMat.value, seleccionCli.value);
    });
  </script>
</body>
</html>