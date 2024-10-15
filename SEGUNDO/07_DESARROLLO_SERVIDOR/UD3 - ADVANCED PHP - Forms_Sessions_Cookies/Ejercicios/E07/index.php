<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>UNIT 3 - E07</title>
</head>

<?php session_start();

if (isset($_SESSION['counter'])) {
  $_SESSION['counter']++;
} else {
  $_SESSION['counter'] = 0;
}

$lastvisit = date("d-m-Y H:i:s");
setcookie($_SESSION['counter'] + 1, $_SESSION['counter'] + 1 . " visit: " . $lastvisit, time() + 60 * 60);

echo "<h1>You have visited this page " . $_SESSION['counter'] . " times</h1>";
if (isset($_SESSION['counter'])) {
  echo "List of the last visits<br>";
  echo "<ul>";
  for ($i = 1; $i <= $_SESSION['counter']; $i++) {
    echo "<li>" . $_COOKIE[$i] . "</li>";
  }
  echo "</ul>";
}

?>

<body>

</body>

</html>