<?php
// get login
require_once 'login.php';

// connect to db
$conn = new mysqli($servername, $username, $password, $dbname);
if ($conn->connect_error) { // check connection
  die('Fatal Error: ' . $conn->connect_error);
} else {
  echo 'DB Connection OK';
}

if (($_SERVER['REQUEST_METHOD'] == 'GET') && isset($_GET['button'])) {

  if ($_GET['button'] == 'insert') { // Update button is pressed

    $hotelValue = htmlspecialchars($_GET['newHno']);
    $hotelName = htmlspecialchars($_GET['name']);
    $hotelZip = htmlspecialchars($_GET['city']);
    $hotelAddress = htmlspecialchars($_GET['address']);

    // update query
    $sql = 'INSERT INTO hotel (hno, name, zip, address) VALUES (?,?,?,?);';

    // prepare query
    $stmt = $conn->prepare($sql);

    // bind parameters
    $stmt->bind_param('isis', $hotelValue, $hotelName, $hotelZip, $hotelAddress);

    // execute query
    $stmt->execute();
  };
};

// get city list
$sql = "SELECT zip, name FROM city";
// prepare query
$stmt = $conn->prepare($sql);
// execute query
$stmt->execute();
// get results
$result = $stmt->get_result();
// get data array
$cityData = $result->fetch_all(MYSQLI_ASSOC);

// get hotel hno
$sql = "SELECT hno FROM hotel ORDER BY hotel.hno ASC ";
$stmt = $conn->prepare($sql);
// execute query
$stmt->execute();
// get results
$result = $stmt->get_result();
// get data array
$hnoData = $result->fetch_all(MYSQLI_ASSOC);
