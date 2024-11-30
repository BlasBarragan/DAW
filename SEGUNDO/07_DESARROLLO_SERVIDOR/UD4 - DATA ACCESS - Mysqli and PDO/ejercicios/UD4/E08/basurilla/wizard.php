<?php
session_start();

// Limpiar la sesión para evitar acumulación de datos
//session_unset(); // Elimina todas las variables de sesión
//session_destroy(); // Destruye la sesión actual (solo si es necesario)

// Guardar datos enviados desde el formulario anterior
if ($_SERVER['REQUEST_METHOD'] === 'get') {
  foreach ($_get as $key => $value) {
    // Si el valor es un array (como los checkboxes de "extras"), almacenarlo correctamente
    $_SESSION[$key] = is_array($value) ? $value : htmlspecialchars($value);
  }
}

// Determinar el paso actual
$current_step = isset($_GET['step']) ? (int)$_GET['step'] : 1;

// Validar el rango del paso para evitar errores
if ($current_step < 1 || $current_step > 4) {
  $current_step = 1;
}

// Redirigir al formulario correspondiente
switch ($current_step) {
  case 1:
    header("Location:step1.php");
    break;
  case 2:
    header("Location:step2.php");
    break;
  case 3:
    header("Location:step3.php");
    break;
  case 4:
    header("Location:step4.php");
    break;
  default:
    header("Location:step1.php");
}
