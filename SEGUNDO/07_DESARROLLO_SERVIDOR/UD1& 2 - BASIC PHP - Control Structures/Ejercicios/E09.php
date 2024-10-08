<!DOCTYPE html>
<html>
	<head>
		<meta charset = "UTF-8">
		<title>Unit 2 - E09</title>
	</head>
	<body>
		<?php
		
        	$x = 4;
                        
            for ($i=1; $i<=10; $i++){
            	$y = 4;
            	for ($j=1; $j<$i; $j++){
                	$y*= 4; 
                    }
            	echo "4^$i = $y<br>" ; 
            }
		?> 
	</body>
</html>