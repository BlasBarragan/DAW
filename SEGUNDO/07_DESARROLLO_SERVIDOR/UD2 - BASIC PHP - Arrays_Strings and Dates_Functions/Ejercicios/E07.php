<html>

<head>
  <title>UNIT 2 - E07</title>
</head>

<body>
  <?php

  function sum()
  {
    $num = func_num_args();
    $args = func_get_args();
    $sum = 0;
    $param = "";

    for ($i = 0; $i < $num; $i++) {
      $sum = $sum + $args[$i];
      $param = $param . " " . $args[$i];
    }

    return "The sum of $param is $sum";
  }

  echo sum(1, 2, 3);

  ?>

</body>

</html>