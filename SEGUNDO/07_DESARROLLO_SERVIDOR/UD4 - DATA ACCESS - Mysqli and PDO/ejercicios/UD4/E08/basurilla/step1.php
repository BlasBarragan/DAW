<?php
// Iniciar sesión y limpiar las variables previas
session_start();

// Verificar si hay datos previos y preseleccionar valores
$type = isset($_SESSION['type']) ? $_SESSION['type'] : 'Flat';

?>
<h1>Step 1: Type of Housing</h1>
<p>Step 1 of 4</p>
<form action="step2.php" method="get">
  <label for="type">Type:</label>
  <select name="type" id="type" required>
    <option value="Flat" <?= $type == 'Flat' ? 'selected' : '' ?>>Flat</option>
    <option value="Townhouse" <?= $type == 'Townhouse' ? 'selected' : '' ?>>Townhouse</option>
    <option value="Villa" <?= $type == 'Villa' ? 'selected' : '' ?>>Villa</option>
    <option value="House" <?= $type == 'House' ? 'selected' : '' ?>>House</option>
  </select>
  <button type="submit">Next ></button>
</form>