<html>

<head>
  <title>UNIT 2 - E09</title>
</head>

<body>
  <?php

  // usuario ingresa dni con letra = bienvenido $nif
  // usuario ingresa dni din letra = calcula letra resisuo de $dni/23 y bienvenido
  // dni en blanco u otra cosa = Error de validacion

  $id = "20202020Q"; // correct id
  $id1 = "20202020s"; // incorrect id
  $id2 = "20200"; // Less than 8 numbers and no letter
  $id3 = "20202020"; // 8 numbers
  $id4 = "S"; // only letter

  function validacion($id)
  {

    $num = substr($id, 0, 8); //Sacamos el numero
    $letra = strtoupper(substr($id, 8, 9)); // Sacamos la letra

    if (is_numeric($num) && $letra == "") { // Solo ingresa numeros (calculamos letra)

      if (strlen($num) == 8) { // Si $num tiene 8 cifras

        $nif = $num . calc_letra($num);
        bienvenida($nif);
      } else { // Menos de 8 cifras

        error();
      }
    } elseif (is_numeric($num) && $letra != "" && !is_numeric($letra)) { // ID correcto 8n+1l
      if ($letra === calc_letra($num)) {
        bienvenida($id);
      } else {
        error();
      }
    } else { // Si $num no es numerico

      error();
    }
  }

  function calc_letra($id)
  {

    $result = $id % 23;
    $comp = "TRWAGMYFPDXBNJZSQVHLCK";
    $letter = $comp[$result];

    return $letter;
  }

  function bienvenida($nif)
  {
    echo "Welcome $nif <br>";
  }
  function error()
  {
    echo "Validation Error <br>";
  }

  validacion($id);
  validacion($id1);
  validacion($id2);
  validacion($id3);
  validacion($id4);

  ?>

</body>

</html>