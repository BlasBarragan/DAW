<html>

<head>
  <title>welcome.php UNIT3 - E06</title>
</head>

<body>
  <?php
  session_start();

  echo "Welcome here " . $_SESSION['name'] . "!";

  session_destroy();

  ?>

</body>

</html>