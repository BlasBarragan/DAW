<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>UNIT4 - E03</title>
</head>

<body>
  <form action="#" method="GET">
    <select name="hotel" id="hotel">
      <?php
      require_once 'interaction.php';

      foreach ($data as $hName) {
        echo '<option value="' . htmlspecialchars($hName['hno']) . '">' . htmlspecialchars($hName['name']) . '</option>'; // get hotel name and hno value
      }
      ?>
    </select>
    <input type="submit" name="button" value="Delete">
  </form>

</body>

</html>