<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>UNIT4 - E06</title>
  <style>
    .pass__div {
      margin: 5px;
      margin-left: 0;
    }

    .advert {
      color: #f00;
    }
  </style>
</head>

<body>
  <form action="#" method="GET">
    New user: <br>

    <input type="text" name="name" id="name" placeholder="Name" required>
    <input type="date" name="birth" id="birth" placeholder="Birthday" required>

    <div id="pass_div" class="pass__div">
      <input type="text" name="login" id="login" placeholder="Login" required>
      <br>
      <input type="password" name="password" id="password" placeholder="Password" required><br>
      <input type="password" name="password2" id="password2" placeholder="Repeat Password" required>

      <?php
      require_once 'interaction.php';

      if (($_SERVER['REQUEST_METHOD'] == 'GET') && isset($_GET['button'])) {
        if ($_GET['button'] == 'insert') {
          if ($_GET['password'] == $_GET['password2']) {
          } else {
            echo '<label for="password" id="advert" class="advert"> Please check password </label>';
          }
        }
      }
      ?>

    </div>

    <button type="submit" name="button" value="insert">Create New User</button>
    <br>
  </form>

  <form action="#" method="GET">

    <button type="submit" name="button" value="show">Show Users</button>
    <br>

    <?php
    require_once 'interaction.php';

    if (($_SERVER['REQUEST_METHOD'] == 'GET') && isset($_GET['button'])) {
      if ($_GET['button'] == 'show') { // show button action
        if (empty($data)) {
          echo '<p>No users in DB</p>';
        } else {
          // create a table to show user values
          echo "<table> 
                    <thead>
                      <tr>";
          foreach (array_keys($data[0]) as $column) { // print table headers with column names
            echo "<th>" . htmlspecialchars($column) . "</th>";
          }
          echo "</tr>
                    </thead>
                    <tbody>";
          foreach ($data as $row) { // print table data from each row

            $date = new DateTime($row['birthday']);
            $date = $date->format('d/m/Y');

            echo '<tr>';
            echo '<td>' . htmlspecialchars($row['id']) . '</td>';
            echo '<td>' . htmlspecialchars($row['name']) . '</td>';
            echo '<td>' . htmlspecialchars($row['user']) . '</td>';
            echo '<td>' . htmlspecialchars($row['password']) . '</td>';
            echo '<td>' . $date . '</td>';
            echo '</tr>';
          }
          echo "</tbody>
                  </table>";
        }
      }
    }
    ?>

  </form>

</body>

</html>