<html>

<head>
  <title>validate.php UNIT3 - E05</title>
</head>

<body>

  <?php
  session_start();

  $x = $_POST['x'];
  $y = $_POST['y'];
  $_SESSION['x'] = $x;
  $_SESSION['y'] = $y;

  $button = $_POST['button'];

  if (empty($x) || empty($y)) {

    $_SESSION['error'] = "You cannot leave any field in blank";
    header("Location:form.php");
  } else {

    switch ($button) {
      case 'Addition':
        header("Location:sum.php");
        break;
      case 'Subtraction':
        header("Location:subtraction.php");
        break;
      case 'Multiplication':
        header("Location:multiplication.php");
        break;

      default:
        break;
    }
  }

  ?>

</body>

</html>