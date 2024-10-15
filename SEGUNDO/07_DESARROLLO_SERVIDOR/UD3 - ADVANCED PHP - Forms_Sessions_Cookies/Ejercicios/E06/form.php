<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>UNIT 3 - E06</title>
</head>

<body>
  <?php session_start();

  if (isset($_SESSION["name"])) {
    $name = $_SESSION["name"];
  }

  if (isset($_SESSION["pass"])) {
    $pass = $_SESSION["pass"];
  }

  if (isset($_SESSION["error"])) {
    echo "Error: " . $_SESSION['error'] . "<br>";
  }

  if (isset($_SESSION["try"])) {
    $try = $_SESSION["try"];
    echo "Attempts pending: " . $_SESSION["try"];
  }

  session_destroy();

  ?>

  <form action="validate.php" method="GET">
    <h3> Login: </h3>
    <input type="hidden" name="try" value="<?php if (isset($try)) {
                                              echo $try;
                                            } else {
                                              echo 3;
                                            } ?>" />
    <label for="name">Name:</label>
    <input type="text" name="name" value="<?php if (isset($name)) {
                                            echo $name;
                                          } ?>" />
    <label for="y">Password:</label>
    <input type="text" name="pass" value="<?php if (isset($pass)) {
                                            echo $pass;
                                          } ?>" /><br>
    <br />
    <input type="submit" name="button" value="Log in">

  </form>

</body>

</html>