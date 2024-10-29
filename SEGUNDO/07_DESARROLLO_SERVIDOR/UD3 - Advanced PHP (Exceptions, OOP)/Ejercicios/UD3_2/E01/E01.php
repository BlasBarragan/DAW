<html>

<head>
  <title>E01.php UNIT3_2 - E01</title>
</head>

<body>

  <?php
  session_start();

  if (!isset($_SESSION['students'])) {
    $_SESSION['students'] = array();
  }

  class Person //Person class
  {
    private $name;

    function __construct($name) // Creates a Person calling to Person("name")
    {
      $this->name = $name;
    }

    function setName($name) // Set name for Person
    {
      $this->name = $name;
    }

    function getName()  // Get name for Person
    {
      return $this->name;
    }
  }

  class Student extends Person //Student class
  {
    private $licNumber;
    private $marks = array();
    private $trimester;
    private $tMark;
    private $average;

    function __construct($name, $licNumber) // Creates an Student
    {
      parent::__construct($name);
      $this->licNumber = $licNumber;
    }

    function setMarks($trimester, $tMark)  // Saves the mark for the trimester
    {
      $this->marks[$trimester] = $tMark;
    }

    function getMark($trimester) // Returns the trimester mark
    {
      return $this->marks[$trimester];
    }

    function getAverage() // Returns the average of the 3 marks of the student
    {
      $total = 0;
      foreach ($this->marks as $x) {
        $total = $total + $x;
      }
      $average = $total / 3;
      return $average;
    }
  }

  ?>

  <form action="#" method="POST">
    <label for="name">Student Name:</label>
    <input type="text" name="name" id="name" required>
    <label for="license">License Number:</label>
    <input type="number" name="license" id="license" required>
    <br />
    <fieldset>
      <legend>Trimester Marks</legend>
      <label for="trimester1">First Trimester:</label>
      <input type="number" name="mark1" id="trimester1" max="10" min="0" required>
      <label for="trimester2">Second Trimester:</label>
      <input type="number" name="mark2" id="trimester2" max="10" min="0" required>
      <label for="trimester3">Third Trimester:</label>
      <input type="number" name="mark3" id="trimester3" max="10" min="0" required>
    </fieldset>
    <br />
    <input type="submit" name="button" value="Add">
  </form>

  <?php
  if ($_SERVER["REQUEST_METHOD"] == "POST" && isset($_POST["button"])) {

    if ($_POST["button"] == "Add") {

      $student = new Student($_POST["name"], $_POST["license"]);

      $student->setMarks(0, $_POST["mark1"]);
      $student->setMarks(1, $_POST["mark2"]);
      $student->setMarks(2, $_POST["mark3"]);

      $_SESSION['students'][] = $student;

      foreach ($_SESSION['students'] as $student) {

        echo 'Name: ' . $student->getName() . '<br>';
        echo 'Mark Trimester 1: ' . $student->getMark(0) . '<br>';
        echo 'Mark Trimester 2: ' . $student->getMark(1) . '<br>';
        echo 'Mark Trimester 3: ' . $student->getMark(2) . '<br>';
        echo 'Mark Average: ' . $student->getAverage() . '<br>';
        echo '<br>';
      }
    }
  }


  ?>

</body>

</html>