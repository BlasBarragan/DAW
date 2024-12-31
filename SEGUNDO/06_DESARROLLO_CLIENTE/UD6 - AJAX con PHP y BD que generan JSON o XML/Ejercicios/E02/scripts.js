
let peticio_http;

function mostrarContenido() {
  //    0 No inicializado.    1 Cargando.    2 Cargado.    3 Interactivo.    4 Completado.
  if (peticio_http.readyState == 4) {
    if (peticio_http.status == 200) {  //si tot OK
      document.getElementById('resultado').innerHTML = peticio_http.responseText;
    }
    else {  //mostra el estat en format de text
      alert("error: " + peticio_http.statusText);
    }
  }
}

function leerDatos(event) {
  // Obtener  instancia objete XMLHttpRequest
  if (window.XMLHttpRequest) {
    peticio_http = new XMLHttpRequest();
  }
  else if (window.ActiveXObject) {
    peticio_http = new ActiveXObject('Microsoft.XMLHTTP');
  }

  let punts = event;

  // Prepara funcio rep dades del servidor
  peticio_http.onreadystatechange = mostrarContenido;
  // Realizar peticion HTTP
  peticio_http.open('GET', 'arxiu.php?punts=' + punts, true);
  //indiquem que les dades estan codificades com un formulari
  //peticio_http.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
  //comence el proces. envies les dades
  peticio_http.send();

}


