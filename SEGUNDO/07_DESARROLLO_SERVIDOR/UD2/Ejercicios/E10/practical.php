<html>

<head>
  <title>UNIT 2 - E10</title>
</head>

<body>
  <?php
  include 'string.php';

  $extension = string_file_extension("curriculum.pdf");
  echo $extension . "<br>";

  $type = string_file_type("PDF");
  echo $type . "<br>";

  $extension = string_file_extension("string.php");
  echo $extension . "<br>";

  $type = string_file_type("php");
  echo $type . "<br>";


  ?>

</body>

</html>