<html>

<head>
  <title>follow.php UNIT3 - E04</title>
</head>

<body>

  <?php
  session_start();

  $monthNum = $_POST['month'];
  $year = $_POST['year'];
  $_SESSION['month'] = $monthNum;
  $_SESSION['year'] = $year;


  $monthLet = array("January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December");

  if (empty($monthNum) || empty($year)) {

    $_SESSION['error'] = "You cannot leave any field in blank";
    header("Location:form.php");
  } else {

    echo "IT IS " . strtoupper($monthLet[$monthNum - 1]) . " " . $year;
    session_destroy();
  }


  ?>

</body>

</html>