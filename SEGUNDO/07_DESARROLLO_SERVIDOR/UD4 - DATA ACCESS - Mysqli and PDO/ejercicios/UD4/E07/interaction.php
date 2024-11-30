<?php
require_once 'login.php';

try { // try-catch for connect DB
  $pdo = new PDO('mysql:host=localhost;dbname=hotels', $username, $password);
  $pdo->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);
  $pdo->exec('SET NAMES "UTF8"');
} catch (PDOException $e) {
  echo 'Unable to connect: ' . $e->getMessage();
  exit();
}
//echo 'Database connection established <br>';

// DB interaction code

if (isset($_GET['begin'])) { // set begin value to get navigation position
  $begin = (int)$_GET['begin'];
} else { // 1st time get pos 0
  $begin = 0;
}

try {
  if (($_SERVER['REQUEST_METHOD'] == 'GET') && isset($_GET['link'])) {

    if ($_GET['link'] == 'next') { // if next was pressed
      $begin += 5;
    } elseif ($_GET['link'] == 'prev') { // if previous was pressed
      $begin -= 5;
    }

    if ($begin < 0) { // avoid negative values for begin
      $begin = 0;
    }

    //echo $begin;
  }

  if ($begin == 0) { // if begin is 0, previous link disabled
    $textPrev = 'style="color: grey; pointer-events: none; text-decoration: none;"';
    $textNext = '';
  } elseif ($begin == 20) { // if begin is 20, next link disabled
    $textPrev = '';
    $textNext = 'style="color: grey; pointer-events: none; text-decoration: none;"';
  } else { // both link enabled
    $textPrev = '';
    $textNext = '';
  }



  // write links
  echo '<a href="?link=prev&begin=' . $begin . '"; ' . $textPrev . '>Previous</a> ';
  echo '<a href="?link=next&begin=' . $begin . '"; ' . $textNext . '>Next</a>';

  // write table headers
  echo '<div style= margin-top:5px >
  <table style: border 1px;>
      <thead>
        <tr>
          <th>Zip</th><th>Name</th><th>State</th> 
        </tr>
      </thead>
      <tbody>';

  // get DB SELECT
  $num = 5; // number of showed values
  $sql = "SELECT * from city LIMIT $begin, $num"; // SELECT query to show values

  $result = $pdo->query($sql); // get query result

  while ($row = $result->fetch()) { // for each row write column values
    echo '<tr>';
    echo '<td>' . $row['zip'] . '</td>';
    echo '<td>' . $row['name'] . '</td>';
    echo '<td>' . $row['state'] . '</td>';
    echo '<tr>';
  }

  echo "</tbody>
    </table>
    </div>";
} catch (PDOException $e) { // if we have an query error
  echo '<br> SELECT Query Error:' . $e->getMessage() . '.<br> in: ' . $e->getFile() . ' : ' . $e->getLine();
}

// close
$pdo = null;
