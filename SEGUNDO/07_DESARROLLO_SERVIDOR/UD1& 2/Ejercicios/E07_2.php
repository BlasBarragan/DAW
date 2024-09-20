<!DOCTYPE html>
<html>
<style>
table, td {
  border:1px solid black;
}
</style>
	<head>
		<meta charset = "UTF-8">
		<title>Unit 2 - E07.2</title>
	</head>
	<body>
    	<h1>Euro dollar converter</h1>
  		<table>
        	<tr>
            	<td>Euros</td>
                <td>Dollars</td>
            </tr>
          <?php
            $euro = 1;
            $dollar = 1.18;


            for ($i = 1; $i<= 10; $i++){
            	if ($i%2 == 0){
                echo "<tr><td>$euro €</td><td>$" .$dollar * $euro."</td></tr>";
                $euro ++;
            }else{
            	echo "<tr><td>$euro €</td><td>$" .$dollar * $euro."</td></tr>";
                $euro ++;
            }
            }
          ?> 
         </table>
	</body>
</html>