<html>

<head>
  <title>validate.php UNIT3 - E06</title>
</head>

<body>

  <?php
  session_start();

  $name = $_GET['name'];
  $pass = $_GET['pass'];
  $_SESSION['name'] = $name;
  $_SESSION['pass'] = $pass;
  $try = $_GET['try'];
  $_SESSION['try'] = $try;

  if (empty($name) || empty($pass)) {

    $_SESSION['error'] = "You cannot leave any field in blank";
    header("Location:form.php");
  } elseif (($name == "Blas") && ($pass == "123")) {
    header("Location:welcome.php");
  } else {
    if ($try == 1) {

      session_destroy();
      header("Location:error.php");
    } else {
      $_SESSION['error'] = "Wrong Name or Password";
      $try--;
      $_SESSION['try'] = $try;
      header("Location:form.php");
    }
  }

  ?>

</body>

</html>