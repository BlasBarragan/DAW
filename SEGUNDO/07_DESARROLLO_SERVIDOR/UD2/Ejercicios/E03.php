<html>

<head>
  <title>UNIT 2 - E03</title>
</head>

<body>
  <?php

  $cad = "Barragán Román, Blas";
  $separator = ",";

  $str = explode($separator, $cad);

  $name = trim($str[1]);
  $surnames = trim($str[0]);

  echo '$name="' . $name . '";<br>';
  echo '$surnames="' . $surnames . '";';

  ?>

</body>

</html>