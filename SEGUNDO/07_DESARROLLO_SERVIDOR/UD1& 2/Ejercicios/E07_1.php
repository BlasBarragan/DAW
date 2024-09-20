<!DOCTYPE html>
<html>
	<head>
		<meta charset = "UTF-8">
		<title>Unit 2 - E07.1</title>
	</head>
	<body>
    	<h1>Euro dollar converter</h1>
  
		<?php
		
          $euro = 1;
          $dollar = 1.18;


          for ($i = 1; $i<= 10; $i++){
              echo "$euro €= " .$dollar * $euro. " dollars <br>";
              $euro ++;
          }
		?> 
	</body>
</html>