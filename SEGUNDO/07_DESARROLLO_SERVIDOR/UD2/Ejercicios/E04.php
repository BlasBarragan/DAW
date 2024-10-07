<html>

<head>
  <title>UNIT 2 - E04</title>
</head>

<body>
  <?php

  $cad = "I am a student";
  $separator = " ";
  $reverse = "";
  $result = "";

  $str = explode($separator, $cad);

  foreach ($str as $word) {
    $reverse = strrev(trim($word));
    $result = $result . " " . $reverse;
  }

  echo '$cad="' . $cad . '";<br>';
  echo '$result="' . $result . '";';

  ?>

</body>

</html>