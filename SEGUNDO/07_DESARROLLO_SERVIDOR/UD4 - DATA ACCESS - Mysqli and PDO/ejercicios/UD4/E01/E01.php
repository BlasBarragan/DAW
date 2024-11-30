<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>UNIT4 - E01</title>

  <style>
    table,
    th,
    td {
      border: 2px groove #000;
    }
  </style>

</head>

<body>

  <?php

  require_once 'interaction.php';

  echo "<table>
        <thead>
          <tr>";

  foreach ($columnNames as $column) { // print table headers with column names
    echo "<th>" . htmlspecialchars($column) . "</th>";
  }

  echo "</tr>
    </thead>
    <tbody>";

  foreach ($data as $row) { // print table data from each row
    echo "<tr>";
    foreach ($columnNames as $column) { // print cell values from each column
      echo "<td>" . htmlspecialchars($row[$column]) . "</td>";
    }
    echo  "</tr>";
  }

  echo "</tbody>
    </table>";

  ?>

</body>

</html>