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


class DeleteQuery
{
  private $table;

  function __construct($table)
  {
    $this->table = $table;
  }

  function deleteQuery()
  {
    $query = "DELETE FROM $this->table WHERE hno = ?";
    return $query;
  }
}


if ($_SERVER['REQUEST_METHOD'] == 'GET') {

  $hotelNo = $_GET['hotel'];

  // reservation query
  //$sql = "DELETE FROM reservation WHERE hno = ?";
  $query = new DeleteQuery('reservation');
  $sql = $query->deleteQuery();
  // prepare query
  $stmt = $conn->prepare($sql);
  // bind parameters
  $stmt->bind_param('i', $hotelNo);
  // execute query
  $stmt->execute();

  // room query
  $query = new DeleteQuery('room');
  $sql = $query->deleteQuery();
  // prepare query
  $stmt = $conn->prepare($sql);
  // bind parameters
  $stmt->bind_param('i', $hotelNo);
  // execute query
  $stmt->execute();

  // hotel query
  $query = new DeleteQuery('hotel');
  $sql = $query->deleteQuery();
  // prepare query
  $stmt = $conn->prepare($sql);
  // bind parameters
  $stmt->bind_param('i', $hotelNo);
  // execute query
  $stmt->execute();
}

// get hotels list
$sql = "SELECT name, hno FROM hotel";
// prepare query
$stmt = $conn->prepare($sql);
// execute query
$stmt->execute();
// get results
$result = $stmt->get_result();
// get data array
$data = $result->fetch_all(MYSQLI_ASSOC);
