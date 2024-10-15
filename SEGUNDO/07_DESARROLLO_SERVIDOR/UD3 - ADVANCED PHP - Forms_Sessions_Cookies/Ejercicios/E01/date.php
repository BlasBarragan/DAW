<html>

<head>
  <title>date.php UNIT3 - E01</title>
</head>

<body>

  <?php
  $monthNum = $_POST['month'];
  $year = $_POST['year'];

  $month = array("January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December");

  if (empty($monthNum) || empty($year)) {

    echo "You cannot leave any field in blank";
  } else {

    echo "IT IS " . strtoupper($month[$monthNum - 1]) . " " . $year;
  }

  ?>

</body>

</html>