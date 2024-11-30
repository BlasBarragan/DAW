<?php
require_once 'login.php';

try { // try-catch for connect DB
  $pdo = new PDO('mysql:host=localhost;dbname=ies', $username, $password);
  $pdo->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);
  $pdo->exec('SET NAMES "UTF8"');
} catch (PDOException $e) {
  echo 'Unable to connect: ' . $e->getMessage();
  exit();
}
echo 'Database conected';
