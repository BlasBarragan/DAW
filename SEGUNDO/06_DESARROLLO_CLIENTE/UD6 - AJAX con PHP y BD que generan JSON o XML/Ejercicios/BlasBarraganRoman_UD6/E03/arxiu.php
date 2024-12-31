<?php
//numero vots
$numvots = array(0,0,0,0,0,0,0,0,0,0,0);
//per a mostrar el vector
//var_dump($numvots);
//obrir arxiu
$f=fopen("vots.txt","a");
//escriure al document
fputs($f,$_REQUEST["punts"]."\n");
fclose($f);
//echo($_REQUEST["punts"]);
//obrir arxiu
$f=fopen("vots.txt","r");
//total de vots
$cont=0;
$l="";
//mentres queden linies
while (! feof($f))//contar un vot mes per al valor llegit
{
$l=$l . fgets($f);
}
echo($l);
//tancar arxiu
fclose($f);
//generar estadistiques en javascript.
?>