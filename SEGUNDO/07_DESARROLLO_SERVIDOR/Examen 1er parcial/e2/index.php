<?php

if (isset($_COOKIE['visitor'])) { // if cookie exists
    $galleta = $_COOKIE['visitor']; // get last cookie value
    $visitas = explode(';', $_COOKIE['visitor']); // get visit number
    $visitNum = count($visitas);
    $cookieText =  date('d-F-Y G:i') . ';';

    setcookie('visitor', $cookieText, time() + 60 * 60);
} else {
    $visitNum = 1;
    $cookieText = $visitNum . ' visit: ' . date('d-F-Y G:i');
    setcookie('visitor', $cookieText, time() + 60 * 60);
}
?>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>

<body>
    <?php
    if (isset($_COOKIE['visitor'])) {
        $lastvisit = count($visitas) - 1;
        echo 'Your last visit was ' . $_COOKIE['visitor'] . ' <br>';
    }

    ?>
</body>

</html>