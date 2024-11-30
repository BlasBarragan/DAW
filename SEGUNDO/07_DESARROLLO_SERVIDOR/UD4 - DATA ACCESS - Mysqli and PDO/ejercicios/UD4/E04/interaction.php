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

  if ($_GET['button'] == 'Update') { // Update button is pressed

    $hotelValue = htmlspecialchars($_GET['hotel']);
    $hotelName = htmlspecialchars($_GET['name']);
    $hotelZip = htmlspecialchars($_GET['zip']);
    $hotelAddress = htmlspecialchars($_GET['address']);

    // update query
    $nameSql = 'UPDATE hotel SET name = ? WHERE hno = ?';
    $zipSql = 'UPDATE hotel SET zip = ? WHERE hno = ?';
    $addSql = 'UPDATE hotel SET address = ? WHERE hno = ?';

    // prepare query
    $nameStmt = $conn->prepare($nameSql);
    $zipStmt = $conn->prepare($zipSql);
    $addStmt = $conn->prepare($addSql);
    // bind parameters
    $nameStmt->bind_param('si', $hotelName, $hotelValue);
    $zipStmt->bind_param('ii', $hotelZip, $hotelValue);
    $addStmt->bind_param('si', $hotelAddress, $hotelValue);

    // execute query
    $nameStmt->execute();
    $zipStmt->execute();
    $addStmt->execute();
  };
};

// get hotels list
$sql = "SELECT * FROM hotel";
// prepare query
$stmt = $conn->prepare($sql);
// execute query
$stmt->execute();
// get results
$result = $stmt->get_result();
// get data array
$data = $result->fetch_all(MYSQLI_ASSOC);
