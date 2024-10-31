<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>UNIT3_2 - E02</title>
</head>

<body>

  <?php

  class Employee
  {
    private $name;
    private $salary;

    public function __construct($name, $salary)
    {
      $this->name = $name;
      $this->salary = $salary;
    }

    public function taxes()
    {
      if ($this->salary > 3000) {
        echo 'The employee ' . $this->name . ' have to pay taxes</br>';
      } else {
        echo 'The employee ' . $this->name . " don't have to pay taxes</br>";
      }
    }
  }

  $employee1 = new Employee("Blas", 1200);
  $employee2 = new Employee("Sandra", 3200);


  $employee1->taxes();
  $employee2->taxes();

  ?>

</body>

</html>