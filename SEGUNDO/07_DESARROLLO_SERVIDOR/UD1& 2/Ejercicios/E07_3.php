<!DOCTYPE html>
<html>
<style>
table, th, td {
  	border:1px solid black;
}
th {
	background-color: #FEC0CB;
    font-weight: normal;
}
tr:nth-child(even) {
  	background-color: #FFFE31;
}
tr:nth-child(odd) {
  	background-color: #808080;
}

</style>
	<head>
		<meta charset = "UTF-8">
		<title>Unit 2 - E07.3</title>
	</head>
	<body>
    	<h1>Euro dollar converter</h1>
  		<table>
        	<tr>
            	<th>Euros</th>
                <th>Dollars</th>
            </tr>
          <?php
            $euro = 1;
            $dollar = 1.18;


            for ($i = 1; $i<= 10; $i++){
                echo "<tr><td>$euro €</td><td>$" .$dollar * $euro."</td></tr>";
                $euro ++;
            }
          ?> 
         </table>
	</body>
</html>