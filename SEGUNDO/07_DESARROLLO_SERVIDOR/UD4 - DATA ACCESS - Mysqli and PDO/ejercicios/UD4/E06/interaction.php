<?php
// get login
require_once 'login.php';

// connect to db
$conn = new mysqli($servername, $username, $password, $dbname);
if ($conn->connect_error) { // check connection
  die('Fatal Error: ' . $conn->connect_error);
}
/*  else {
  echo 'DB Connection OK';
}
 */
if (($_SERVER['REQUEST_METHOD'] == 'GET') && isset($_GET['button'])) {
  if ($_GET['button'] == 'insert') {
    if ($_GET['password'] == $_GET['password2']) {

      $name = htmlspecialchars($_GET['name']);
      $user = htmlspecialchars($_GET['login']);
      $password = htmlspecialchars($_GET['password']);
      $strongpass = password_hash($password, PASSWORD_DEFAULT);
      $birth = htmlspecialchars($_GET['birth']);

      // update query
      $sql = 'INSERT INTO user (name, user, password, birthday) VALUES (?,?,?,?);';

      // prepare query
      $stmt = $conn->prepare($sql);

      // bind parameters
      $stmt->bind_param('ssss', $name, $user, $strongpass, $birth);

      // execute query
      if ($stmt->execute()) {
        echo 'User added';
      } else {
        echo 'Error to insert user: ' . $stmt->error;
      }

      // close conn
      $stmt->close();
    };
  } elseif ($_GET['button'] == 'show') {
    // update query
    $query = 'SELECT * FROM user ORDER BY id';
    $result = $conn->query($query); // get $result doing $conn with $query
    if (!$result) {
      die("Fatal Error"); // if $result empty = error
    }

    // if not
    $data = $result->fetch_all(MYSQLI_ASSOC); // get table values


    // close conn
    $conn->close();
  };
};
