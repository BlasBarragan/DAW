
let peticio_http;

function mostrarMatricula() {
  //    0 No inicializado.    1 Cargando.    2 Cargado.    3 Interactivo.    4 Completado.
  if (peticio_http.readyState == 4) {
    if (peticio_http.status == 200) {  //si tot OK
      document.getElementById('smatricula').innerHTML = peticio_http.responseText;
      if (peticio_http.responseText == '<option value="-1"> no hi ha resultats') {
        document.getElementById('matricula').value = '';
        document.getElementById('marca').value = '';
        document.getElementById('model').value = '';
        document.getElementById('color').value = '';
        document.getElementById('dni').value = '';
        document.getElementById('nom').value = '';
        document.getElementById('direccio').value = '';
        document.getElementById('poblacio').value = '';
        document.getElementById('sexe').value = '';
      }
    }
    else {  //mostra el estat en format de text
      alert("error: " + peticio_http.statusText);
    }
  }
}
function mostrarDetalle() {
  //    0 No inicializado.    1 Cargando.    2 Cargado.    3 Interactivo.    4 Completado.

  document.getElementById('matricula').value = '';
  document.getElementById('marca').value = '';
  document.getElementById('model').value = '';
  document.getElementById('color').value = '';
  document.getElementById('dni').value = '';
  document.getElementById('nom').value = '';
  document.getElementById('direccio').value = '';
  document.getElementById('poblacio').value = '';
  document.getElementById('sexe').value = '';

  if (peticio_http.readyState == 4) {

    if (peticio_http.status == 200) {  //si tot OK

      let detalle = peticio_http.responseXML.getElementsByTagName('coche')[0]; // array con todos los datos del cliente y su coche
      let matricula = detalle.getElementsByTagName('matricula')[0];
      let marca = detalle.getElementsByTagName('marca')[0];
      let model = detalle.getElementsByTagName('model')[0];
      let color = detalle.getElementsByTagName('color')[0];
      let dni = detalle.getElementsByTagName('dni')[0];
      let nom = detalle.getElementsByTagName('nom')[0];
      let direccio = detalle.getElementsByTagName('direccio')[0];
      let poblacio = detalle.getElementsByTagName('poblacio')[0];
      let sexe = detalle.getElementsByTagName('sexe')[0];

      document.getElementById('matricula').value = matricula.textContent;
      document.getElementById('marca').value = marca.textContent;
      document.getElementById('model').value = model.textContent;
      document.getElementById('color').value = color.textContent;
      document.getElementById('dni').value = dni.textContent;
      document.getElementById('nom').value = nom.textContent;
      document.getElementById('direccio').value = direccio.textContent;
      document.getElementById('poblacio').value = poblacio.textContent;
      document.getElementById('sexe').value = sexe.textContent;
    }
    else {  //mostra el estat en format de text
      alert("error: " + peticio_http.statusText);
    }
  }

}


function leerCli(cli) {

  let cliente = cli;
  // Obtener  instancia objete XMLHttpRequest
  if (window.XMLHttpRequest) {
    peticio_http = new XMLHttpRequest();
  }
  else if (window.ActiveXObject) {
    peticio_http = new ActiveXObject('Microsoft.XMLHTTP');
  }
  // Prepara funcio rep dades del servidor
  peticio_http.onreadystatechange = function () {
    mostrarMatricula();
  };
  // Realizar peticion HTTP
  peticio_http.open('GET', 'cliente.php?scliente=' + cliente, true);
  //comence el proces. envies les dades
  peticio_http.send();
}

function leerMat(mat, cli) {

  let matricula = mat;
  let cliente = cli;

  // Obtener  instancia objete XMLHttpRequest
  if (window.XMLHttpRequest) {
    peticio_http = new XMLHttpRequest();
  }
  else if (window.ActiveXObject) {
    peticio_http = new ActiveXObject('Microsoft.XMLHTTP');
  }
  // Prepara funcio rep dades del servidor
  peticio_http.onreadystatechange = function () {
    mostrarDetalle();
  };
  // Realizar peticion HTTP
  peticio_http.open('GET', 'matricula.php?scliente=' + cliente + '&smatricula=' + matricula, true);
  //comence el proces. envies les dades
  peticio_http.send();
}

