<?php
session_start(); // Para mantener los datos entre pasos
include 'connDb.php';

// Inicializar los pasos
if (!isset($_SESSION['step'])) {
  $_SESSION['step'] = 1;
}

// Manejo de los datos al avanzar o retroceder
if ($_SERVER['REQUEST_METHOD'] == 'POST') {
  // Guardar los datos del formulario actual
  foreach ($_POST as $key => $value) {
    $_SESSION[$key] = $value;
  }

  // Control de navegación
  if (isset($_POST['siguiente'])) {
    $_SESSION['step']++;
  } elseif (isset($_POST['atras'])) {
    $_SESSION['step']--;
  }
}
?>
<!DOCTYPE html>
<html lang="es">

<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Formulario Paso a Paso</title>
</head>

<body>
  <h1>Housing search
    <?php echo $_SESSION['step']; ?>
  </h1>
  <form method="POST" action="index.php">
    <?php if ($_SESSION['step'] == 1): ?>
      <label>Step 1: Choose the type of housing</label><br>
      <select name="type" value="type" required>
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
    <?php elseif ($_SESSION['step'] == 2): ?>
      <label>Step 2: Choose the zone of housing</label><br>
      <select name="zone" value="zone" required>
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
    <?php elseif ($_SESSION['step'] == 3): ?>
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
        <label for="1">
          <100.000 </label>
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
            <label for="4">>300.000</label>
      </div> <br>

    <?php elseif ($_SESSION['step'] == 4): ?>
      <label>Step 4: Choose extras of housing</label><br><br>
      <div class="extras">
        <?php if (isset($_SESSION['extra'])) {
          $extra = $_SESSION['extra'];
        } else {
          $extra = '';
        } ?>
        <label>Es: </label>
        <input type="checkbox" id="1" name="extra" value='Pool' <?php if ($extra == 'Pool') {
                                                                  echo 'checked';
                                                                } ?> required>
        <label for="1">Pool</label>
        <input type="checkbox" id="2" name="extra" value='Garage' <?php if ($extra == 'Garage') {
                                                                    echo 'checked';
                                                                  } ?> required>
        <label for="2">Garage</label>
        <input type="checkbox" id="3" name="extra" value=3 <?php if ($extra == 'Garden') {
                                                              echo 'checked';
                                                            } ?> required>
        <label for="3">Garden</label>
      </div>
    <?php endif; ?>

    <div>
      <?php if ($_SESSION['step'] > 1): ?>
        <button type="submit" name="atras">Atrás</button>
      <?php endif; ?>

      <?php if ($_SESSION['step'] < 4): ?>
        <button type="submit" name="siguiente">Siguiente</button>
      <?php else: ?>
        <button type="submit" formaction="procesar.php">Finalizar</button>
      <?php endif; ?>
    </div>
  </form>
</body>

</html>