<?php
session_start();
include 'connDb.php';

if (!isset($_SESSION['step'])) { // step setup
  $_SESSION['step'] = 1;
}

if ($_SERVER['REQUEST_METHOD'] == 'GET') { // set values with get

  // store get valeus in _session
  foreach ($_GET as $key => $value) {
    $_SESSION[$key] = $value;
  }

  // nav buttons
  if (isset($_GET['next'])) { // next button increase step
    $_SESSION['step']++;
  } elseif (isset($_GET['back'])) { // back button decrease step
    $_SESSION['step']--;
  }
}
?>

<!DOCTYPE html>
<html lang="es">

<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Housing search</title>
  <style>
    .search {
      border: 1px solid #000;
      padding: 10px;
      width: 600px;
      height: 300px;
    }

    select {
      margin-bottom: 5px;
      background-color: #fff;
    }
  </style>
</head>

<body>
  <div class="search">
    <h1>Housing search</h1>
    <form method="GET" action="index.php">
      <?php if ($_SESSION['step'] == 1): // step 1 - type
      ?>
        <label>Step 1: Choose the type of housing</label><br><br>
        <label>Type: </label>
        <select name="type" required>
          <?php if (isset($_SESSION['type'])) {
            $type = $_SESSION['type'];
          } else {
            $type = '';
          } ?>
          <option value="Flat" <?php if ($type == 'Flat') {
                                  echo 'selected';
                                } ?>>Flat</option>
          <option value="Townhouse" <?php if ($type == 'Townhouse') {
                                      echo 'selected';
                                    } ?>>Townhouse</option>
          <option value="Villa" <?php if ($type == 'Villa') {
                                  echo 'selected';
                                } ?>>Villa</option>
          <option value="House" <?php if ($type == 'House') {
                                  echo 'selected';
                                } ?>>House</option>
        </select>
      <?php elseif ($_SESSION['step'] == 2): // step 2 - zone
      ?>
        <label>Step 2: Choose the zone of housing</label><br><br>
        <label>Zone: </label>
        <select name="zone" required>
          <?php if (isset($_SESSION['zone'])) {
            $zone = $_SESSION['zone'];
          } else {
            $zone = '';
          } ?>
          <option value="Center" <?php if ($zone == 'Center') {
                                    echo 'selected';
                                  } ?>>Center</option>
          <option value="Richiland" <?php if ($zone == 'Richiland') {
                                      echo 'selected';
                                    } ?>>Richiland</option>
          <option value="Mid-City" <?php if ($zone == 'Mid-City') {
                                      echo 'selected';
                                    } ?>>Mid-City</option>
        </select>
      <?php elseif ($_SESSION['step'] == 3): // step 3 - roomNo and price
      ?>
        <label>Step 3: Choose the room and prize of housing</label><br><br>
        <div class="rooms">
          <?php if (isset($_SESSION['nrooms'])) {
            $nrooms = $_SESSION['nrooms'];
          } else {
            $nrooms = 1;
          } ?>
          <label>Rooms: </label>
          <input type="radio" id="1" name="nrooms" value=1 <?php if ($nrooms == 1) {
                                                              echo 'checked';
                                                            } ?> required>
          <label for="1">1</label>
          <input type="radio" id="2" name="nrooms" value=2 <?php if ($nrooms == 2) {
                                                              echo 'checked';
                                                            } ?> required>
          <label for="2">2</label>
          <input type="radio" id="3" name="nrooms" value=3 <?php if ($nrooms == 3) {
                                                              echo 'checked';
                                                            } ?> required>
          <label for="3">3</label>
          <input type="radio" id="4" name="nrooms" value=4 <?php if ($nrooms == 4) {
                                                              echo 'checked';
                                                            } ?> required>
          <label for="4">4</label>
          <input type="radio" id="5" name="nrooms" value=5 <?php if ($nrooms == 5) {
                                                              echo 'checked';
                                                            } ?> required>
          <label for="5">5</label>
        </div>
        <div class="price">
          <?php if (isset($_SESSION['price'])) {
            $price = $_SESSION['price'];
          } else {
            $price = 1;
          } ?>
          <label>Price: </label>
          <input type="radio" id="1" name="price" value=1 <?php if ($price == 1) {
                                                            echo 'checked';
                                                          } ?> required>
          <label for="1">&lt;100.000 </label>
          <input type="radio" id="2" name="price" value=2 <?php if ($price == 2) {
                                                            echo 'checked';
                                                          } ?> required>
          <label for="2">100.000 - 200.000</label>
          <input type="radio" id="3" name="price" value=3 <?php if ($price == 3) {
                                                            echo 'checked';
                                                          } ?> required>
          <label for="3">200.000 - 300.000</label>
          <input type="radio" id="4" name="price" value=4 <?php if ($price == 4) {
                                                            echo 'checked';
                                                          } ?> required>
          <label for="4">&gt;300.000</label>
        </div> <br>

      <?php elseif ($_SESSION['step'] == 4): // step 4 - extras 
      ?>
        <label>Step 4: Choose extras of housing</label><br><br>
        <div class="extras">
          <?php if (isset($_SESSION['extras1'])) {
            $extras1 = $_SESSION['extras1'];
          } else {
            $extras1 = '0';
            $_SESSION['extras1'] = $extras1;
          }
          if (isset($_SESSION['extras2'])) {
            $extras2 = $_SESSION['extras2'];
          } else {
            $extras2 = '0';
            $_SESSION['extras2'] = $extras2;
          }
          if (isset($_SESSION['extras3'])) {
            $extras3 = $_SESSION['extras3'];
          } else {
            $extras3 = '0';
            $_SESSION['extras3'] = $extras3;
          } ?>
          <label>Extras: </label>
          <input type="checkbox" id="1" name="extras1" value='Pool' <?php if ($extras1 == 'Pool') {
                                                                      echo 'checked';
                                                                    } ?>>
          <label for="1">Pool</label>
          <input type="checkbox" id="2" name="extras2" value='Garage' <?php if ($extras2 == 'Garage') {
                                                                        echo 'checked';
                                                                      } ?>>
          <label for="2">Garage</label>
          <input type="checkbox" id="3" name="extras3" value='Garden' <?php if ($extras3 == 'Garden') {
                                                                        echo 'checked';
                                                                      } ?>>
          <label for="3">Garden</label>
        </div>
      <?php elseif ($_SESSION['step'] == 5): // step 4 - extras 
      ?>

        <?php
        if (isset($_SESSION['type'], $_SESSION['zone'], $_SESSION['nrooms'], $_SESSION['price'], $_SESSION['extras1'], $_SESSION['extras2'], $_SESSION['extras3'])) {
          $type = htmlspecialchars($_SESSION['type']);
          $zone = htmlspecialchars($_SESSION['zone']);
          $nRooms = htmlspecialchars($_SESSION['nrooms']);
          $price = htmlspecialchars($_SESSION['price']);

          if ($_SESSION['extras1'] == '0') {
            $extras1 = '';
          } else {
            $extras1 = htmlspecialchars($_SESSION['extras1']);
          }
          if ($_SESSION['extras2'] == '0') {
            $extras2 = '';
          } else {
            $extras2 = htmlspecialchars($_SESSION['extras2']);
          }
          if ($_SESSION['extras3'] == '0') {
            $extras3 = '';
          } else {
            $extras3 = htmlspecialchars($_SESSION['extras3']);
          }

          switch ($price) {
            case 1:
              $min = 0;
              $max = 100000;
              break;
            case 2:
              $min = 100000;
              $max = 200000;
              break;
            case 3:
              $min = 200000;
              $max = 300000;
              break;
            case 4:
              $min = 300000;
              $max = 1000000;
              break;
          }

          // query select
          $sql = "SELECT * FROM houses WHERE type = '$type' AND zone = '$zone' AND nrooms = $nRooms AND price BETWEEN $min AND $max AND extras IN ('$extras1','$extras2','$extras3')";
          $resultados = $pdo->query($sql)->fetchAll(PDO::FETCH_ASSOC);

          session_destroy(); // clean session values
        } else {
          exit;
        }

        ?>

        <h1>Houses found:</h1>
        <table border="1">
          <tr>
            <th>Type</th>
            <th>Zone</th>
            <th>Rooms</th>
            <th>Price</th>
            <th>Size</th>
            <th>Extras</th>
          </tr>
          <?php foreach ($resultados as $fila): ?>
            <tr>
              <td><?php echo $fila['type']; ?></td>
              <td><?php echo $fila['zone']; ?></td>
              <td><?php echo $fila['nrooms']; ?></td>
              <td><?php echo $fila['price']; ?></td>
              <td><?php echo $fila['size']; ?></td>
              <td><?php echo $fila['extras']; ?></td>
            </tr>
          <?php endforeach; ?>
        </table>
        <a href="index.php">Search again</a>
      <?php endif; ?>

      <div>
        <?php if (($_SESSION['step'] > 1) && ($_SESSION['step'] != 5)): ?>
          <button type="submit" name="back">Back</button>
        <?php endif; ?>

        <?php if ($_SESSION['step'] < 5): ?>
          <button type="submit" name="next">Next</button>
        <?php elseif ($_SESSION['step'] > 4): ?>
        <?php endif; ?>
      </div>
    </form>
  </div>
</body>

</html>