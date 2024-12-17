<?php
session_start();

require_once 'login.php';

try {
    $pdo = new PDO("mysql:host=$servername;dbname=$dbname", $username, $password);
    $pdo->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);
    $pdo->exec('SET NAMES "utf8"');
} catch (PDOException $e) {
    die('Error: ' . $e->getMessage());
}
echo 'Db Connected';

if (isset($_GET['button'])) {
    if ($_GET['button'] == 'Delete') {
        $page = 3;
    } elseif ($_GET['button'] == 'Accept') {
        $page = 2;
    } elseif ($_GET['button'] == 'Back') {
        header('Location:index.php');
    }
} else {
    $page = 1;
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

    <form action="#" method="get">
        <?php if ($page == 1) : // dept search 
        ?>
            <h1>Choose Department</h1>
            <br>
            <select name="department" id="dept">

                <?php
                $sql = "SELECT * FROM dept";
                $result = $pdo->query($sql);
                while ($row = $result->fetch()) {
                    //var_dump($row);
                    echo '<option value="' . $row['deptno'] . '">' . $row['dname'] . '</option>';
                }
                ?>

                <input type="submit" name="button" value="Accept">
            </select>


        <?php elseif ($page == 2) : // emp search 
        ?>
            <h1>Choose Department</h1>
            <br>
            <select name="department" id="dept">
                <?php
                $selected = $_GET['department'];

                $sql = "SELECT * FROM dept";
                $result = $pdo->query($sql);
                while ($row = $result->fetch()) {
                    //var_dump($row);
                    if ($row['deptno'] == $selected) {
                        echo '<option value="' . $row['deptno'] . '" selected>' . $row['dname'] . '</option>';
                    } else {
                        echo '<option value="' . $row['deptno'] . '">' . $row['dname'] . '</option>';
                    }
                }
                ?>
                <input type="submit" name="button" value="Accept">
            </select>

            <h1>Choose an Employee to delete</h1>
            <br>
            <select name="employee" id="emp">
                <?php

                $sql = "SELECT * FROM emp WHERE $selected = deptno";
                $result = $pdo->query($sql);
                while ($row = $result->fetch()) {
                    var_dump($row);
                    echo '<option value="' . $row['empno'] . '">' . $row['ename'] . '</option>';
                }
                ?>
                <input type="submit" name="button" value="Delete">
            </select>
        <?php elseif ($page == 3) : // emp delete 
        ?>
            <?php

            $selected = $_GET['department'];
            $empNumber = htmlspecialchars($_GET['employee']);

            $sql = 'DELETE FROM emp WHERE CONCAT(`emp`.`empno`) = :empNumber';
            $stmt = $pdo->prepare($sql);
            $stmt->bindValue(':empNumber', $empNumber);
            $stmt->execute();
            //$result = $pdo->query($sql);


            ?>

            <h1>One employee deleted</h1>

            <input type="submit" name="button" value="Back">


        <?php endif; ?>

    </form>
</body>

</html>