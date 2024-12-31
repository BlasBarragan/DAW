
let peticio_http;

function mostrarContenido() {
  //    0 No inicializado.    1 Cargando.    2 Cargado.    3 Interactivo.    4 Completado.
  if (peticio_http.readyState == 4) {
    if (peticio_http.status == 200) {  //si tot OK
      document.getElementById('resultado').innerHTML = '<h1> resultado </h1>';
      pintarEstadisticas(peticio_http.responseText);

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
  peticio_http.open('POST', 'arxiu.php', true);
  //indiquem que les dades estan codificades com un formulari
  peticio_http.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
  //comence el proces. envies les dades
  peticio_http.send('punts=' + punts);

}

function pintarEstadisticas(datos) {
  // contenedor para las barras
  let estadisticas = document.createElement('div');
  estadisticas.setAttribute('id', 'estadisticas');
  estadisticas.setAttribute('class', 'estadisticas');
  // separo puntuaciones almacenadas
  let votos = datos.split('\n')
  // elimino ultima posicion que esta vacia al hacer split
  votos.pop();

  // barra con total de votaciones
  let barraTotal = document.createElement('div');
  barraTotal.setAttribute('id', 'barraTotal');
  barraTotal.setAttribute('class', 'barra total');
  let porcen = document.createElement('span');
  porcen.innerText = '100%';
  let recuento = document.createElement('span');
  recuento.innerText = votos.length;

  barraTotal.appendChild(porcen);
  barraTotal.appendChild(recuento);
  estadisticas.appendChild(barraTotal);

  // contamos los votos
  const contador = {};
  // para cada voto en votos
  votos.forEach(voto => {
    // si voto ya existe en contador, incrementamos en 1 su valor contador[voto]
    if (contador[voto]) {
      contador[voto]++;
    } // si voto no existe aun, lo iniciamos a 1
    else {
      contador[voto] = 1;
    }
  });

  // para cada puntuacion (clave) en contador, creamos la barra correspondiente
  for (let clave in contador) {
    let barra = document.createElement('div');
    barra.setAttribute('id', 'barra' + clave);
    barra.setAttribute('class', 'barra');
    barra.setAttribute('style', 'width: ' + (contador[clave] / votos.length) * 100 + '%'); // calculamos el ancho

    let porcen = document.createElement('span');
    porcen.innerText = clave + ' puntos';
    let recuento = document.createElement('span');
    recuento.innerText = contador[clave] + ' votos';

    barra.appendChild(porcen);
    barra.appendChild(recuento);
    estadisticas.appendChild(barra);
  }

  document.getElementById('resultado').appendChild(estadisticas);

}


