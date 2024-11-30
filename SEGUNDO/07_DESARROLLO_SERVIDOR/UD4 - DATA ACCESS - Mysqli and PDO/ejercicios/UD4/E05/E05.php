<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>UNIT4 - E05</title>
</head>

<body>
  <form action="#" method="GET">
    New hotel: <br>

    <?php
    require_once 'interaction.php';

    $lastHno = count($hnoData) - 1; // get last hno position
    $newHno = (int)$hnoData[$lastHno]['hno'] + 10;

    echo '<br>' . $newHno . '<br>'; // new hotel hno

    echo '<input type="text" id="newHno" name="newHno" value="' . $newHno . '" hidden>'; // hidden input
    echo '<input type="text" id="name" name="name" required><br>';
    echo '<input type="text" id="address" name="address" required><br>';

    echo '<select name="city" id="city">'; // select with city(zip) values

    foreach ($cityData as $city) {
      $text = $city['name'] . ' - (' . $city['zip'] . ')';
      echo '<option id="' . htmlspecialchars($city['zip']) . '" value="' . htmlspecialchars($city['zip']) . '">' . $text . '</option>';
    }

    echo '</select><br>';
    ?>

    <button type="submit" name="button" value="insert">Insert New Hotel </button>
    <br>
  </form>

</body>

</html>