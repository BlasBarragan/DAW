<?php
session_start();
include 'connDb.php';

if (isset($_SESSION['type'], $_SESSION['zone'], $_SESSION['nrooms'], $_SESSION['price'])) {
  $type = $_SESSION['type'];
  $zone = $_SESSION['zone'];
  $nRooms = $_SESSION['nrooms'];
  $ciudad = $_SESSION['price'];

  // Insertar los datos en la base de datos
  /* $query = $pdo->prepare("INSERT INTO datos (nombre, email, edad, ciudad) VALUES (?, ?, ?, ?)");
  $query->execute([$nombre, $email, $edad, $ciudad]);
 */
  // Recuperar todos los registros
  $resultados = $pdo->query("SELECT * FROM houses")->fetchAll(PDO::FETCH_ASSOC);

  // Limpiar la sesión para reiniciar
  session_destroy();
} else {
  header('Location: index.php');
  exit;
}
?>
<!DOCTYPE html>
<html lang="es">

<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Resultados</title>
</head>

<body>
  <h1>Datos Registrados</h1>
  <table border="1">
    <tr>
      <th>ID</th>
      <th>Type</th>
      <th>Zone</th>
      <th>Address</th>
      <th>Rooms</th>
      <th>Price</th>
      <th>Size</th>
    </tr>
    <?php foreach ($resultados as $fila): ?>
      <tr>
        <td><?php echo $fila['id']; ?></td>
        <td><?php echo $fila['type']; ?></td>
        <td><?php echo $fila['zone']; ?></td>
        <td><?php echo $fila['address']; ?></td>
        <td><?php echo $fila['nrooms']; ?></td>
        <td><?php echo $fila['price']; ?></td>
        <td><?php echo $fila['size']; ?></td>
      </tr>
    <?php endforeach; ?>
  </table>
  <a href="index.php">Volver a empezar</a>
</body>

</html>