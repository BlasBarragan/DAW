<html>

<head>
  <title>convertor.php UNIT3 - E03</title>
</head>

<body>

  <?php

  $dollar = 1.05;
  $yen = 157.49;
  $franc = 0.95;
  $result = "";

  $euros = $_POST['euros'];

  if (empty($_POST['euros'])) {
    echo '<script>alert("Please, introduce an amount of Euros"); window.location.href="index.html";</script>';
  } else {

    $euros = str_replace(",", ".", $euros);

    $currency = $_POST['currency'];

    switch ($currency) {
      case 'dollar':
        $result = $euros * $dollar;
        break;

      case 'yen':
        $result = $euros * $yen;
        break;

      case 'franc':
        $result = $euros * $franc;
        break;

      default:
        break;
    }

    echo "The amount of " . $euros . "€ converted are: " . $result . " " . $currency;
  }

  ?>
</body>

</html>