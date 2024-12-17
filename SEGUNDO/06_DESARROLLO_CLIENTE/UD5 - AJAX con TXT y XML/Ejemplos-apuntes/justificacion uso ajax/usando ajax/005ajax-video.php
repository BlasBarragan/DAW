<!doctype html>
<html lang="es">
<head>
<meta charset="utf-8">
<title>AJAX</title>
<meta name="description" content="descripcio">
<meta name="author" content="Jose Masip">
<link rel="stylesheet" href="css/estilos.css">
<script type="text/javascript">
var peticio_http;
function mostraContingut() {
// 0 No inicializado. 1 Cargando. 2 Cargado. 3 Interactivo. 4 Completado.
if(peticio_http.readyState == 4) {
if(peticio_http.status == 200) { //si tot OK
alert(peticio_http.responseText);
}
else{ //mostra el estat en format de text
alert("error: "+peticio_http.statusText);
}
}
}
function descarregaArxiu() {
// Obtener instancia objete XMLHttpRequest
if(window.XMLHttpRequest) {
peticio_http = new XMLHttpRequest();
}
else if(window.ActiveXObject) { //navegadors obsolets
peticio_http = new ActiveXObject("Microsoft.XMLHTTP");
}
// Prepara funcio rep dades del servidor
peticio_http.onreadystatechange = mostraContingut;
// Realizar peticio HTTP
peticio_http.open('GET', './holamon.txt', true);
//comence el proces. envies les dades
peticio_http.send(null);
}
</script>
</head>
<body>
<h1>pagina amb ajax</h1>
<a href="https://www.youtube.com/watch?v=xru5FreD97w"> https://www.youtube.com/watch?v=xru5FreD97w</a>
<p>
<iframe width="560" height="315" src="https://www.youtube.com/embed/xru5FreD97w" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
</p>
<p>Hola mon. LLegir un arxiu local txt on tenim el missatge a mostrar</p>
<p>al polsar el boto <input type="button" onclick="descarregaArxiu()" value="ajax"> </p>
</body>
</html>