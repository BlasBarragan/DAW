<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>UNIT3_2 - E03</title>
</head>

<body>

  <?php

  class Table
  {

    private $titles = array();
    private const bgcolorheader = "blue";
    private static $bgcolorall;

    private $data = array(array());

    function __construct($titles, $data)
    {
      $this->titles = $titles;
      $this->data = $data;
    }

    static function setColor($bgcolorall)
    {
      self::$bgcolorall = $bgcolorall;
    }

    function drawHeader()
    {

      for ($columnTitle = 0; $columnTitle < count($this->titles); $columnTitle++) {
        echo "<th style='border:2px solid #05f; background-color: " . self::bgcolorheader . "; color: #fff'>" . $this->titles[$columnTitle] . "</th>";
      }
    }

    function drawData()
    {

      for ($row = 0; $row < count($this->data); $row++) {
        echo "<tr>";
        for ($col = 0; $col < count($this->data[$row]); $col++) {
          echo "<td style='border: 2px solid #05f; padding-right: 100px; color: blue; background-color: " . self::$bgcolorall . " '>" . $this->data[$row][$col] . "</td>";
        }
        echo "</tr>";
      }
    }

    function drawTable()
    {
      echo "<table style='border-collapse: collapse'>";
      echo "<thead>";
      $this->drawHeader();
      echo "</thead>";
      echo "<tbody>";
      $this->drawData();
      echo "</tbody>";
      echo "</table>";
    }
  }

  //Change the bgcolor of all our tables, create the setcolor method
  Table::setcolor("white");
  $titles = array("First Name", "Last name", "Email", "Phone");
  $data = array(
    array("Jose", "González", "josegonzalez@gmail.com", "962324234"),
    array("Alba", "Sanz", "albasanz@gmail.com", "666123123"),
    array("Ana", "Blanes", "anablanes@gmail.com", "677656755")
  );
  $table = new Table($titles, $data);
  $table->drawTable();

  ?>

</body>

</html>