<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>UNIT4 - E08</title>
  <style>

  </style>
</head>

<body>

  <?php

  require_once 'interaction.php';
  ?>

  <h1>Step 1: Type of Housing</h1>
  <p>Step 1 of 4</p>
  <form action="interaction.php" method="get">
    <label for="type">Type:</label>
    <select name="type" id="type" required>
      <option value="Flat">Flat</option>
      <option value="Townhouse">Townhouse</option>
      <option value="Villa">Villa</option>
      <option value="House">House</option>
    </select>
    <button type="submit">Next ></button>
  </form>

</body>

</html>