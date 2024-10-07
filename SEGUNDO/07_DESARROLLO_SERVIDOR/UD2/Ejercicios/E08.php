<html>

<head>
  <title>UNIT 2 - E08</title>
</head>

<body>
  <?php



  function change(&$name, &$name2)
  {
    $help = $name;
    $name = $name2;
    $name2 = $help;
  }

  $name = "Antonio";
  $name2 = "Jose";
  echo "Me llamo " . $name . $name2 . "<br>";

  change($name, $name2);

  echo "Ahora me llamo " . $name . $name2;

  ?>

</body>

</html>