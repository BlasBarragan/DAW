<html>

<head>
  <title>UNIT 2 - E05</title>
</head>

<body>
  <?php

  $dia = array("Diumenge", "Dilluns", "Dimarts", "Dimecres", "Dijous", "Divendres", "Disabte");
  $mes = array("Gener", "Febrer", "Marc", "Abril", "Maig", "Juny", "Juliol", "Agost", "Setembre", "Octobre", "Novembre", "Desembre");

  $diaN = date("d");
  $year = date("Y");

  $diaVal = $dia[date("w")];
  $mesVal = $mes[date("n")];

  echo "Avui es $diaVal, $diaN de $mesVal de $year";

  ?>

</body>

</html>