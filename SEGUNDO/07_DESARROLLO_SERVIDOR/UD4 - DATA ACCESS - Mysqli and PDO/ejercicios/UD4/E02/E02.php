<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>UNIT4 - E02</title>
  <style>
    select {
      margin-right: 5px;
      margin-bottom: 15px;
    }
  </style>
</head>

<body>
  <form action="#" method="POST">
    <?php
    session_start(); // start session for session variables

    require_once 'interaction.php';

    if (isset($_SESSION['selectedZip'])) { // if session variable is set
      $selectedZip = $_SESSION['selectedZip']; // get value from session variable
    } else {
      $selectedZip = Null;
    }

    function citiesSelect($data, $selectedZip) // write cities select
    {
      echo '<select name="cities" id="cities" required>';

      $previousZip = ""; // initialize previusZip to avoid duplicate cities

      foreach ($data as $city) { // for each city in $data
        if ($previousZip != $city['zip']) { // if city zip not repeats
          $text = htmlspecialchars($city['city_name']) . ' - ' . htmlspecialchars($city['zip']); // write city name - zip
          $select = ""; // initialize selected tag
          if ($selectedZip == $city['zip']) { // if we have a seleted zip (we filtered after) 
            $select = ' selected'; // selected tag is typed in option att. to show them
          }
          echo '<option value="' . htmlspecialchars($city['zip']) . '"' . $select . '>' . $text . '</option>'; // insert in the select an option tag
          $previousZip = $city['zip']; // get zip to check it after
        }
      }

      echo '</select>'; // select close tag

      echo  '<input type="submit" id="filtrar" name="button" value="Filtrar"><br>'; // insert submit button
    }

    function hotelsSelect($data, $zip)
    {
      echo '<select name="hotels" id="hotels" required>'; // open select tag for hotels available in this zip

      foreach ($data as $hotel) { // for each hotel in data
        if ($zip == $hotel['zip']) { // we get only the hotel with the same zip we have filtered
          $hotelText = htmlspecialchars($hotel['hotel_name']) . ' - ' . htmlspecialchars($hotel['zip']); // write hotel name - zip
          echo '<option value="' . htmlspecialchars($hotel['hno']) . '">' . $hotelText . '</option>'; // insert in the select an option
        }
      }

      echo '</select>'; // close select tag
      echo  '<input type="submit" id="mostrar" name="button" value="Mostrar"><br>'; // insert submit button
    }


    if ($_SERVER['REQUEST_METHOD'] == 'POST' && isset($_POST['button'])) { // if we get a submit
      $zip = $_POST['cities']; // get city zip submitted
      $_SESSION['selectedZip'] = $zip; // get session variable

      citiesSelect($data, $zip);
      if ($_POST['button'] == 'Filtrar') { // Filtrar button is pressed

        hotelsSelect($data, $zip);
      }

      if ($_POST['button'] == 'Mostrar') { // Mostrar button is pressed
        $hotelNo = $_POST['hotels']; // get city zip submitted

        foreach ($data as $hotel) { // for each hotel in data
          if ($hotelNo == $hotel['hno']) { // we get only the hotel with the same hno we have selected
            $detailsText = '<br>' . htmlspecialchars($hotel['hotel_name']) . ' <br> ' . htmlspecialchars($hotel['zip']) . ' - ' . htmlspecialchars($hotel['address']); // get hotel name and zip - hotel address
            echo $detailsText; // write details
          }
        }
      }
    } else {
      citiesSelect($data, $selectedZip);
    }

    ?>
  </form>

</body>

</html>