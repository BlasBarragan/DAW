<?php
session_start();

// Inicializa la variable de pasos si no existe
if (!isset($_SESSION['pasos'])) {
  $_SESSION['pasos'] = [];
}

// Determina el paso actual
$paso_actual = isset($_GET['paso']) ? (int)$_GET['paso'] : 1;
if ($paso_actual < 1) {
  $paso_actual = 1;
}

// Almacena datos si se envió el formulario
if ($_SERVER['REQUEST_METHOD'] === 'POST') {
  $_SESSION['pasos'][$paso_actual] = $_POST; // Guarda los datos del paso actual
}

// Renderiza el formulario del paso actual
switch ($paso_actual) {
  case 1:
?>
    <form method="post" action="?paso=2">
      <label for="nombre">Nombre:</label>
      <input type="text" name="nombre" id="nombre" value="<?= $_SESSION['pasos'][1]['nombre'] ?? '' ?>">
      <button type="submit">Siguiente</button>
    </form>
  <?php
    break;

  case 2:
  ?>
    <form method="post" action="?paso=3">
      <label for="email">Correo electrónico:</label>
      <input type="email" name="email" id="email" value="<?= $_SESSION['pasos'][2]['email'] ?? '' ?>">
      <button type="submit" formaction="?paso=1">Atrás</button>
      <button type="submit">Siguiente</button>
    </form>
  <?php
    break;

  case 3:
  ?>
    <form method="post" action="?paso=4">
      <label for="busqueda">Consulta:</label>
      <input type="text" name="busqueda" id="busqueda" value="<?= $_SESSION['pasos'][3]['busqueda'] ?? '' ?>">
      <button type="submit" formaction="?paso=2">Atrás</button>
      <button type="submit">Finalizar</button>
    </form>
  <?php
    break;

  default:
    // Mostrar resumen
  ?>
    <h3>Resumen de datos</h3>
    <ul>
      <li>Nombre: <?= htmlspecialchars($_SESSION['pasos'][1]['nombre'] ?? 'No definido') ?></li>
      <li>Correo: <?= htmlspecialchars($_SESSION['pasos'][2]['email'] ?? 'No definido') ?></li>
      <li>Consulta: <?= htmlspecialchars($_SESSION['pasos'][3]['busqueda'] ?? 'No definido') ?></li>
    </ul>
    <a href="?paso=1">Volver al inicio</a>
<?php
    // Limpia la sesión al final si lo deseas
    session_destroy();
}
?>