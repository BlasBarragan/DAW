<html>

<head>
  <title>sum.php UNIT3 - E05</title>
</head>

<body>

  <?php
  session_start();

  $x = $_SESSION['x'];
  $y = $_SESSION['y'];

  echo "The sum of " . $x . " and " . $y . " is: " . $x + $y;

  ?>

  <form action="form.php" method="POST">
    <br><input type="submit" name="return" value="Make another operation">
  </form>

</body>

</html>