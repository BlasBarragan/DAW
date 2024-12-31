
let peticio_http;

function mostrarContenido() {
  //    0 No inicializado.    1 Cargando.    2 Cargado.    3 Interactivo.    4 Completado.
  if (peticio_http.readyState == 4) {
    if (peticio_http.status == 200) {  //si tot OK
      /* document.getElementById('resultado').innerHTML = "<h1> Comentarios: </h1><br> header('Content - Type: text / xml')" + peticio_http.responseText; */

      let comentarios = peticio_http.responseXML.getElementsByTagName('comentari'); // array con todas las noticias
      document.getElementById('resultado').innerHTML = ""; // Borramos contenido del contenedor antes de actualizar comentarios
      for (let i = 0; i < comentarios.length; i++) { // recorremos el array

        let aut = comentarios[i].getElementsByTagName('autor'); // obtenemos autor
        let autor = '';
        if (!aut[0]) { // si autor no aparece lo definimos como Anonim
          autor = 'Anonim';
        } else {
          autor = aut[0].firstChild.data;
        } // obtenemos datos autor
        console.log(autor);
        let com = comentarios[i].getElementsByTagName('comenta'); // obtenemos comentario
        let comentario = com[0].firstChild.data; // obtenemos datos comentario

        let articulo = document.createElement('div'); // creamos div para el articulo
        articulo.setAttribute('id', 'articulo ' + i); // añadimos id de articulo con numero i
        articulo.innerHTML = '<h1>autor:' + autor + '</h1><p>' + comentario + '</p>'; // añadimos contenido
        document.getElementById('resultado').appendChild(articulo); // añadimos articulo a div contenedor
      }

    }
    else {  //mostra el estat en format de text
      alert("error: " + peticio_http.statusText);
    }
  }
}

function leerDatos() {
  // Obtener  instancia objete XMLHttpRequest
  if (window.XMLHttpRequest) {
    peticio_http = new XMLHttpRequest();
  }
  else if (window.ActiveXObject) {
    peticio_http = new ActiveXObject('Microsoft.XMLHTTP');
  }

  //let videoId = event;

  // Prepara funcio rep dades del servidor
  peticio_http.onreadystatechange = mostrarContenido;
  // Realizar peticion HTTP
  peticio_http.open('GET', 'arxiu.php?video=1', true);
  //indiquem que les dades estan codificades com un formulari
  peticio_http.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
  //comence el proces. envies les dades
  peticio_http.send();
}



