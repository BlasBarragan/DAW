<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>UNIT4 - E04</title>
</head>

<body>
  <form action="#" method="GET">
    <select name="hotel" id="hotel">
      <?php
      require_once 'interaction.php';

      foreach ($data as $hRow) { // get hotel rows
        if (isset($_GET['button']) && ($_GET['button'] == 'Modify')) { // get a previous selected hotel 

          $hotel = $_GET['hotel']; // get selected hotel

          if ($hotel == $hRow['hno']) { // for selected hotel, write selected att
            echo '<option value="' . htmlspecialchars($hRow['hno']) . '" selected>' . htmlspecialchars($hRow['name']) . '</option>'; // get selected hotel for select value
          } else {
            echo '<option value="' . htmlspecialchars($hRow['hno']) . '">' . htmlspecialchars($hRow['name']) . '</option>'; // get rest of hotel list
          }
        } else {
          echo '<option value="' . htmlspecialchars($hRow['hno']) . '">' . htmlspecialchars($hRow['name']) . '</option>'; // get hotel name and hno value

        }
      };
      ?>
    </select>
    <input type="submit" name="button" value="Modify">
    <br>
    <div>
      <?php
      if (($_SERVER['REQUEST_METHOD'] == 'GET') && isset($_GET['button'])) {

        if ($_GET['button'] == 'Modify') { // Modify button is pressed

          $hotel = $_GET['hotel']; // get selected hotel

          foreach ($data as $hRow) {
            if ($hotel == $hRow['hno']) {

              // write hotel data
              echo htmlspecialchars($hRow['hno']) . ' - ' . htmlspecialchars($hRow['name']) . '<br>';
              echo htmlspecialchars($hRow['zip']) . ' - ' . htmlspecialchars($hRow['address']) . '<br>';

              echo '-----------------------------------------------------------------<br> Introduce los datos que deseas modificar<br>';

              // input fields
              echo '<input type="text" id="hno" name="hno" value="' . htmlspecialchars($hRow['hno']) . '" readonly><br>';
              echo '<input type="text" id="name" name="name" value="' . htmlspecialchars($hRow['name']) . '" required><br>';
              echo '<input type="number" id="zip" name="zip" value="' . htmlspecialchars($hRow['zip']) . '"required><br>';
              echo '<input type="text" id="address" name="address" value="' . htmlspecialchars($hRow['address']) . '"required><br>';

              // update button
              echo '<input type="submit" name="button" value="Update">';
            };
          };
        };

        if ($_GET['button'] == 'Modify') { // Update button is pressed



        };
      };

      ?>

    </div>


  </form>

</body>

</html>