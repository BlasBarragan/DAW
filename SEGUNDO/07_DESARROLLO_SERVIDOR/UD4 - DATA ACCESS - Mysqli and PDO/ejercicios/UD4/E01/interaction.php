<?php

/* get login */
require_once 'login.php';

/* create new conn to the db */
$conn = new mysqli($servername, $username, $password, $dbname);
/* check the conn */
if ($conn->connect_error) {
  die("Fatal Error: " . $conn->connect_error); // script ends and print error
}
echo "Connected to db <br>";

/* db query */
$query = 'SELECT * FROM hotel ORDER BY name'; // select from hotel table ordered by name
$result = $conn->query($query); // get $result doing $conn with $query
if (!$result) die("Fatal Error"); // if $result empty = error

    // if not
$data = $result->fetch_all(MYSQLI_ASSOC); // get table values
$columnNames = array_keys($data[0]); // get array with column names from $data[0]

$result->close();
$conn->close();

?>
