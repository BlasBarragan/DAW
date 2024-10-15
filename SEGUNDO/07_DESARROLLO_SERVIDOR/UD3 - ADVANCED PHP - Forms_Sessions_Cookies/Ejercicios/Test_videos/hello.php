<html>

<head>
  <title>Hello.php</title>
</head>

<body>
  <?php

  $name = $_POST['name'];
  echo "Hello, $name";

  if (empty($name)) {
    echo "You cannot leave the name blank";
  }

  ?>

</body>

</html>