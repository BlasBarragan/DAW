
// exercici2 - no podria desmarcar una casella
// Hay que corregir que no se puede eliminar una casilla al desmarcar, siempre vuelve, (hay que modificar la cookie para que se reescriba cada vez?)
// Añadir a los checkbox un addeventlistener para que si se marca, añada el valor a la cookie o se elimine al desmarcar
// crear una funcion que elimine valor de la cookie
// de paso revisar que no puedan escribirse duplicados en la cookie

let vector = ['valor1', 'valor2', 'valor3', 'valor4'];

window.onload = function () {

  // parrafo
  let parrafo = document.createElement('p');
  parrafo.setAttribute('id', 'pContenedor');
  parrafo.setAttribute('class', 'parrafo');
  document.body.appendChild(parrafo);


  for (let i = 0; i < vector.length; i++) {
    // checkbox
    let casilla = document.createElement('input');
    casilla.setAttribute('id', 'checkB' + i);
    casilla.setAttribute('class', 'checkbox');
    casilla.setAttribute('type', 'checkbox');
    casilla.setAttribute('value', vector[i]);
    casilla.addEventListener('change', function () {
      if (this.checked) {
        // si marcamos casilla, se añade el valor
        anadirACookie(this.value);
      } else {
        // si desmarcamos casilla, se elimina valor
        eliminarDeCookie(this.value);
      }
    })
    // texto valor
    let texto = document.createTextNode(vector[i]);
    // boton
    let boton = document.createElement('input');
    boton.setAttribute('id', 'botton' + i);
    boton.setAttribute('class', 'boton');
    boton.setAttribute('type', 'button');
    boton.setAttribute('value', vector[i]);
    boton.addEventListener('click', function () {
      anadirACookie(this.value)
    });
    //boton.addEventListener('click', () => anadirACookie(vector[i]));

    // añadimos al body
    parrafo.appendChild(casilla);
    parrafo.appendChild(texto);
    parrafo.appendChild(boton);
  }

  // mostrar
  let botMostrar = document.createElement('button');
  botMostrar.setAttribute('id', 'mostrar');
  botMostrar.setAttribute('class', 'boton mostrar');
  botMostrar.appendChild(document.createTextNode('Mostrar'));
  botMostrar.addEventListener('click', function () {
    alert(getCookie());
  });


  // marcar
  let botMarcar = document.createElement('button');
  botMarcar.setAttribute('id', 'marcar');
  botMarcar.setAttribute('class', 'boton marcar');
  let textoMarcar = document.createTextNode('Marcar');
  botMarcar.appendChild(textoMarcar);
  botMarcar.addEventListener('click', funcionMarcar);


  document.body.appendChild(botMostrar);
  document.body.appendChild(botMarcar);
}

function anadirACookie(valor) { // setCookie
  let nombre = 'galletita';
  let valores = checkCookie();

  if (valores != "") {
    // evitamos valores duplicados
    if (!valores.includes(valor)) {
      valores = valores + '-' + valor; // añadimos valor a cookie
    }
  } else {
    valores = valor;
  }
  document.cookie = nombre + '=' + valores;
}
function eliminarDeCookie(valor) { // setCookie
  let nombre = 'galletita';
  let valores = checkCookie();

  if (valores != "") {
    // eliminamos valores de la cookie
    let arrayValores = valores.split('-');
    let nuevoArrayValores = [];

    for (let x = 0; x < arrayValores.length; x++) {
      if (arrayValores[x] != valor) {
        nuevoArrayValores.push(arrayValores[x]);
      }
    }

    document.cookie = nombre + '=' + nuevoArrayValores.join('-');
  }
}

function funcionMarcar() {
  let marcas = checkCookie();
  if (marcas) {

    let tosta = marcas.split('-');
    for (let a = 0; a < tosta.length; a++) {
      console.log(tosta[a]);
      for (let b = 0; b < vector.length; b++) {
        if (tosta[a] == vector[b]) {
          console.log(tosta[a]);
          console.log(vector[b]);
          document.getElementById('checkB' + b).setAttribute('checked', '');
        }
      }
    }
  }
}

function checkCookie() {
  let cookies = document.cookie.split('; ');

  for (let y = 0; y < cookies.length; y++) {
    let galleta = cookies[y].split('=');
    if (galleta[0] == 'galletita') {
      return galleta[1];
    }
  }
  return '';
}

function getCookie() {
  let galleta = document.cookie;

  if (galleta == "") {
    return 'La cookie esta vacia';
  } else {
    return checkCookie();
  }
}

