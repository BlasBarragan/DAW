<html>
<style>
    table,
    th,
    td {
        border: 2px ridge grey;
        color: white;
        font-weight: normal;
    }

    th {
        background-color: grey;
    }

    td {
        background-color: blue;
    }
</style>

<head>
    <title>UNIT 2 - E02</title>
</head>

<body>
    <table>
        <?php

        $a = array(1, 2, 3, 4, 5, 6, 7);
        $weekDay = array();
        $startDay = strtotime("Monday");
        $endDay = strtotime("+6 days", $startDay);

        while ($startDay < $endDay) {
            foreach ($a as $day) {
                $weekDay[date("D", $startDay)] = date("l", $startDay);
                $startDay = strtotime("+1 day", $startDay);
            }
        }

        //print_r($weekDay);
        echo "<tr>";
        foreach ($weekDay as $day => $longDay) {
            echo "<th>$day</th>";
            //echo "<td>$weekDay[$day]</td>";
        }
        echo "</tr>";
        echo "<tr>";
        foreach ($weekDay as $day => $longDay) {
            //echo "<th>$day</th>";
            echo "<td>$weekDay[$day]</td>";
        }
        echo "</tr>";


        ?>
    </table>

</body>

</html>