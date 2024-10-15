<html>

<head>
  <title>date.php UNIT3 - E02</title>
</head>

<body>

  <?php

  if (!isset($_POST['month']) || empty($_POST['year'])) {

    echo "You cannot leave any field in blank";
  } else {

    $month = $_POST['month'];
    $year = $_POST['year'];
    echo "IT IS " . strtoupper($month) . " " . $year;
  }

  ?>

</body>

</html>