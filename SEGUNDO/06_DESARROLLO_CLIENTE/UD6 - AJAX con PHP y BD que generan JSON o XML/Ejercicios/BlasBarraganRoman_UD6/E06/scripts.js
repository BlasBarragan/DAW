
let peticio_http;

function mostrarContenido() {
  //    0 No inicializado.    1 Cargando.    2 Cargado.    3 Interactivo.    4 Completado.
  if (peticio_http.readyState == 4) {
    if (peticio_http.status == 200) {  //si tot OK
      document.getElementById('desti').innerHTML = peticio_http.responseText;
    }
    else {  //mostra el estat en format de text
      alert("error: " + peticio_http.statusText);
    }
  }
}
function mostrarHorario(origen, desti) {
  //    0 No inicializado.    1 Cargando.    2 Cargado.    3 Interactivo.    4 Completado.
  if (peticio_http.readyState == 4) {

    if (peticio_http.status == 200) {  //si tot OK
      let vjson = JSON.parse(peticio_http.responseText);

      let tablaHead = "<table><tr><td>Hora salida</td><td>Hora llegada</td></tr>";
      let tablaBody = '';

      vjson.forEach(horario => {
        if (horario.origen === origen && horario.desti === desti) {
          tablaBody += `<tr><td>${horario.horaEixida}</td><td>${horario.horaArribada}</td></tr>`;
        }
      });

      document.getElementById('horaris').innerHTML = tablaHead + tablaBody;
    }
    else {  //mostra el estat en format de text
      alert("error: " + peticio_http.statusText);
    }
  }

}

function leerOrigen(ori) {

  let origen = ori;
  // Obtener  instancia objete XMLHttpRequest
  if (window.XMLHttpRequest) {
    peticio_http = new XMLHttpRequest();
  }
  else if (window.ActiveXObject) {
    peticio_http = new ActiveXObject('Microsoft.XMLHTTP');
  }
  // Prepara funcio rep dades del servidor
  peticio_http.onreadystatechange = mostrarContenido;
  // Realizar peticion HTTP
  peticio_http.open('GET', 'origen.php?origen=' + origen, true);
  //comence el proces. envies les dades
  peticio_http.send();
}

function leerDesti(dest, ori) {

  let desti = dest;
  let origen = ori;
  // Obtener  instancia objete XMLHttpRequest
  if (window.XMLHttpRequest) {
    peticio_http = new XMLHttpRequest();
  }
  else if (window.ActiveXObject) {
    peticio_http = new ActiveXObject('Microsoft.XMLHTTP');
  }
  // Prepara funcio rep dades del servidor
  peticio_http.onreadystatechange = function () {
    mostrarHorario(origen, desti);
  };
  // Realizar peticion HTTP
  peticio_http.open('GET', 'desti.php?origen=' + origen + '&desti=' + desti, true);
  //comence el proces. envies les dades
  peticio_http.send();

}

