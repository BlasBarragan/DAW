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
?>

<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Delete employees</title>
  <style>
    table,
    tr,
    td {
      border: 2px groove #000;
    }
  </style>
</head>

<body>

  <form action="#" method="get">
    <table>
      <thead>
        <tr>
          <td>EmpNo</td>
          <td>Name</td>
          <td>Job</td>
          <td>mgr</td>
          <td>hiredate</td>
          <td>salary</td>
          <td>comision</td>
          <td>deptno</td>
          <td>Delete</td>
        </tr>
      </thead>
      <tbody>

        <?php

        try { // get complete table values to show them
          $sql = "SELECT * FROM emp";
          $result = $pdo->query($sql);

          while ($row = $result->fetch()) {
            echo "<tr><td>" . $row['empno'] . "</td>";
            echo "<td>" . $row['ename'] . "</td>";
            echo "<td>" . $row['job'] . "</td>";
            echo "<td>" . $row['mgr'] . "</td>";
            echo "<td>" . $row['hiredate'] . "</td>";
            echo "<td>" . $row['sal'] . "</td>";
            echo "<td>" . $row['comm'] . "</td>";
            echo "<td>" . $row['deptno'] . "</td>";
            echo '<td><input type="checkbox" name="del[]" value=' . $row['empno'] . '></td></tr>';
          }
        } catch (PDOException $e) {
          echo 'Error: ' . $e->getMessage();
        }

        ?>
      </tbody>
    </table>
    <button type="submit" name="button"> Delete all</button>
  </form>

  <?php

  if (($_SERVER['REQUEST_METHOD'] == 'GET') && isset($_GET['button']) && isset($_GET['del'])) {
    $deleted = '';

    foreach ($_GET['del'] as $valor) {
      try { // delete each selected row in the table
        $sql = 'DELETE FROM emp WHERE CONCAT(emp.empno) = ' . $valor;
        $result = $pdo->exec($sql);
        $deleted .= $valor;
      } catch (PDOException $e) {
        echo 'ERROR:' . $e->getMessage();
      }
    }

    header('Location:E09.php'); // reload pago to get update table values
  }
  ?>

</body>

</html>