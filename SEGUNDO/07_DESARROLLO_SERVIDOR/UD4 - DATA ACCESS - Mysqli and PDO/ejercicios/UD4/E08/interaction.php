<?php

session_start();
require_once 'connDb.php'; // DB connection

// SETUP SESSION
if (!isset($_SESSION['step'])) {
  $_SESSION['step'] = 1;
}
/* if (!isset($_SESSION['search'])) { // if $_SESSION is not set
  $_SESSION['search'] = ['type' => '', 'zone' => '', 'nRooms' => '', 'price' => '', 'extras' => '']; // create an empty array to storage values
} */

if ($_SERVER['REQUEST_METHOD'] == 'GET') { // store values in SESSION
  foreach ($_GET as $data => $value) { // for each POST value ($_POST['xxx (zone, price, etc)'])
    $_SESSION[$data] = $value; // get form values
    /* if (isset($_SESSION['search'][$data])) { // if SESSION have the POST value
      $_SESSION['search'][$data] = htmlspecialchars($value); // store data in SESSION ($_SESSION['search']['xxx (zone, price, etc)'] = URL value)
    } */
  }

  // SETUP STEP
  if (isset($_GET['step'])) { // get current step
    $step = $_GET['step'];
  } else {
    $step = 1;
  }
  // increase/decrease step value
  if (isset($_GET['next'])) {
    $step++;
    if ($step > 4) {
      $step = 'result';
    }
  } elseif (isset($_GET['back'])) {
    $step--;
    if ($step < 1) {
      $step = 1;
    }
  }

  if ($step == 'result') { // Make a DB query
    $sql = "SELECT * FROM houses WHERE type = ? AND zone = ? AND nrooms = ? AND price BETWEEN ? AND ? AND extras IN (?,?,?)";
    $stmt = $pdo->prepare($sql);

    $type = $_SESSION['search']['type'];
    $zona = $_SESSION['search']['zone'];
    $nRooms = $_SESSION['search']['nRooms'];
    $price1 = $_SESSION['search']['price1'];
    $price2 = $_SESSION['search']['price2'];
    $extra1 = $_SESSION['search']['extra1'];
    $extra2 = $_SESSION['search']['extra1'];
    $extra3 = $_SESSION['search']['extra1'];

    $stmt->execute([$type, $zone, $nRooms, $price1, $price2, $extra1, $extra2, $extra3]);

    // Resetear sesión
    $_SESSION['search'] = [];
    header("Location: E08.php?");
    exit;
  }

  // Redirigir al step correspondiente
  header("Location: E08.php?step=$step");
  exit;
}
