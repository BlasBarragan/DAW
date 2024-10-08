<!DOCTYPE html>
<html>
	<head>
		<meta charset = "UTF-8">
		<title>Unit 2 - E10</title>
	</head>
	<body>
		<?php
		
        	$n = 10;
        	$sum = 0;
            $sel = 0;
                        
            for ($i=0; $i<=$n; $i++){
            	if ($sel == 1) {
                	$sum = $sum + $i;
                    $sel = 0;
                }else {
                	$sum = $sum - $i;
                    $sel = 1;
                }
            }
            
            echo "$sum" ; 
		?> 
	</body>
</html>