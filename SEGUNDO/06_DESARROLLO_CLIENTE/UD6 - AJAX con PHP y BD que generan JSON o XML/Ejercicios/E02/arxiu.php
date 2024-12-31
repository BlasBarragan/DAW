<?php
//obrir arxiu
$f=fopen("vots.txt","a");
//escriure al document
fputs($f,$_REQUEST["punts"]."\n");
fclose($f);
//echo($_REQUEST["punts"]);
//obrir arxiu
$f=fopen("vots.txt","r");
$l="";
//mentres queden linies
while (! feof($f))
{
$l=$l . fgets($f) . "<br/>";
}
echo($l);
//tancar arxiu