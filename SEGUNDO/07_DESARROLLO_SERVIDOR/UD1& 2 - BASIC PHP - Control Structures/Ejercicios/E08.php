<!DOCTYPE html>
<html>
	<head>
		<meta charset = "UTF-8">
		<title>Unit 2 - E08</title>
	</head>
	<body>
		<?php
		
        	$num_Day = 5;
                        
            switch ($num_Day) {
   				
                case 1:
                	echo "Day number $num_Day is Monday";
                	break;
                
                case 2:
                	echo "Day number $num_Day is Tuesday";
                	break;
                
                case 3:
                	echo "Day number $num_Day is Wednesday";
                	break;
          
                case 4:
                	echo "Day number $num_Day is Thursday";
                	break;
                
                case 5:
                	echo "Day number $num_Day is Friday";
                	break;
                
                case 6:
                	echo "Day number $num_Day is Saturday";
                	break;
                
                case 7:
                	echo "Day number $num_Day is Sunday";
                	break;
                
            	default: 
                	echo " Please, enter a number between 1 to 7";
                	break;
            
            }
        
		?> 
	</body>
</html>
