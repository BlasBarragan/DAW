<?php

/* get login */
require_once 'login.php';

/* create new conn to the db */
$conn = new mysqli($servername, $username, $password, $dbname);
/* check the conn */
if ($conn->connect_error) {
  die("Fatal Error: " . $conn->connect_error); // script ends and print error
}
//echo "Connected to db <br>";

/* db query */
$query = 'SELECT city.name AS city_name,
                 city.zip,
                 hotel.name AS hotel_name,
                 hotel.address,
                 hotel.hno,
                 hotel.address
                 FROM city JOIN hotel ON city.zip = hotel.zip
                 ORDER BY city.zip'; // select from city the rows with zip in hotel table

$result = $conn->query($query); // get $result doing $conn with $query
if (!$result) die("Fatal Error"); // if $result empty = error

// if not
$data = $result->fetch_all(MYSQLI_ASSOC); // get table values
//$columnNames = array_keys($data[0]);


$result->close();
$conn->close();
