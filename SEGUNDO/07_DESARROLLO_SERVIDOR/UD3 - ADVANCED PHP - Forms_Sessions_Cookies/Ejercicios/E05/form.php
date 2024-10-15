<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>UNIT 3 - E05</title>
</head>

<body>
  <?php session_start();

  if (isset($_SESSION["x"])) {
    $x = $_SESSION["x"];
  }

  if (isset($_SESSION["y"])) {
    $y = $_SESSION["y"];
  }

  if (isset($_SESSION["error"])) {
    echo "Error: " . $_SESSION['error'] . "<br>";
  }

  session_destroy();

  ?>

  <form action="validate.php" method="POST">
    <h3> Introduce figures for X and Y and press the dessired operation: </h3>
    <label for="x">Number X:</label>
    <input type="number" name="x" value="<?php if (isset($x)) {
                                            echo $x;
                                          } ?>" /><br>
    <label for="y">Number Y:</label>
    <input type="number" name="y" value="<?php if (isset($y)) {
                                            echo $y;
                                          } ?>" /><br>
    <br />

    <input type="submit" name="button" value="Addition">
    <input type="submit" name="button" value="Subtraction">
    <input type="submit" name="button" value="Multiplication">

  </form>

</body>

</html>