<?php
//obrir arxiu
$f=fopen($_REQUEST["arxiu"],"r");
//llegir 1 linia arxiu
$l=fgets($f);
echo($l);
fclose($f);
?>
