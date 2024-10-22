<?php
$visit_history = [];
/*If the cookie exists, we store its value in an array using the
',' delimiter because a cookie cannot store arrays, only strings, and we need to manipulate it.*/
if (isset($_COOKIE['visit_data'])) {
    $visit_history = explode(',', $_COOKIE['visit_data']);
}


$visit_count = count($visit_history);

$current_visit = date('d-m-Y H:i:s');
$visit_history[] = $current_visit;

$cookie_value = implode(',', $visit_history); //We need to merge what we already had in the cookie with the current visit so that the future visit is displayed correctly
setcookie('visit_data', $cookie_value, time() +60*60);
/*the cookie only stores strings because it is a text file.
 I think it's necessary to understand how information is stored to solve the exercise.*/
?>

<!DOCTYPE html>
<html>
<body>
    <h2>You have visited this page <?php echo $visit_count + 1; ?> times.</h2>

    List of previous visits:
    <ul>
        <?php foreach ($visit_history as $index => $visit): ?>
            <li><?php echo ($index + 1) . " visit: " . $visit; ?></li>
        <?php endforeach; ?>
    </ul>
</body>
</html>