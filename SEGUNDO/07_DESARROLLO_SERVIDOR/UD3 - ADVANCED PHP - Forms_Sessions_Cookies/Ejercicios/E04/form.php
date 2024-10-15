<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>UNIT 3 - E04</title>
</head>

<body>
  <?php session_start();

  if (isset($_SESSION["month"])) {
    $monthNum = $_SESSION["month"];
  }

  if (isset($_SESSION["year"])) {
    $year = $_SESSION["year"];
  }

  if (isset($_SESSION["error"])) {
    echo "Error: " . $_SESSION['error'] . "<br>";
  }

  ?>

  <form action="follow.php" method="POST">
    <label for="month">Month:</label>
    <input type="number" name="month" min="1" max="12" value="<?php if (isset($monthNum)) {
                                                                echo $monthNum;
                                                              } ?>" /><br />
    <label for="year">Year (4 figures):</label>
    <input type="text" name="year" pattern="[0-9]{4}" value="<?php if (isset($year)) {
                                                                echo $year;
                                                              } ?>" /><br />
    <input type="submit" name="button" value="Send">
  </form>

</body>

</html>