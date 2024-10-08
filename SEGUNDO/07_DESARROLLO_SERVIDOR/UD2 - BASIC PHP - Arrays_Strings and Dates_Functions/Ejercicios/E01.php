<html>

<head>
    <title>UNIT 2 - E01</title>
</head>

<body>
    <?php

    $a = array(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

    $average = array_sum($a) / count($a);
    echo 'Average for the Array $a is: ' . $average . "<br>";

    $higher = 0;
    $lower = 0;
    $equal = 0;

    foreach ($a as $number) {
        if ($number > $average) {
            $higher++;
        } elseif ($number < $average) {
            $lower++;
        } elseif ($number == $average) {
            $equal++;
        }
    }

    echo $higher . " numers in Array are higher than average.<br>";
    echo $lower . " numers in Array are lower than average.<br>";
    echo $equal . " numers in Array are equal than average.";

    ?>

</body>

</html>