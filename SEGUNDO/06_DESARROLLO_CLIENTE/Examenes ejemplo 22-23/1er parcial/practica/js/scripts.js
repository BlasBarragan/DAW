
let vector = ['valor1', 'valor2', 'valor3', 'valor4'];

function crearP() {
  window.onload = function () { // aseguramos que la pagina este cargada para modificar el DOM
    // parrafo
    let parrafo = document.createElement('p'); // crea <p>
    parrafo.setAttribute('id', 'parrafo'); // añade id
    parrafo.setAttribute('class', 'parrafo'); // añade class
    document.body.appendChild(parrafo); // añade <p> a <body>

    // checkbox
    for (let i = 0; i < vector.length; i++) { // para cada valor de vector
      let casilla = document.createElement('input'); // crea <input>
      casilla.setAttribute('id', 'checkB' + i); // añade id
      casilla.setAttribute('value', vector[i]); // añade value segun valor de vector
      casilla.setAttribute('class', 'checkbox'); // añade class
      casilla.setAttribute('type', 'checkbox'); // añade type=checkbox

      // label valor
      let labValor = document.createTextNode(vector[i]); // añade texto con valor de vector

      // boton
      let boton = document.createElement('button'); //
      boton.setAttribute('id', 'boton' + i);
      boton.setAttribute('value', vector[i]);
      boton.setAttribute('class', 'boton');
      boton.setAttribute('onClick', 'setCookie(value)');
      boton.innerText = 'añadir ' + vector[i];

      // añadir al p
      parrafo.appendChild(casilla);
      parrafo.appendChild(labValor);
      parrafo.appendChild(boton);
    }

    // mostrar
    let botMostrar = document.createElement('button');
    botMostrar.setAttribute('id', 'mostrar');
    botMostrar.setAttribute('class', 'boton funcion');
    botMostrar.innerText = 'Mostrar';
    botMostrar.addEventListener('click', funcionMostrar);

    // marcar
    let botMarcar = document.createElement('button');
    botMarcar.setAttribute('id', 'marcar');
    botMarcar.setAttribute('class', 'boton funcion');
    botMarcar.innerText = 'Marcar';
    botMarcar.addEventListener('click', funcionMarcar);

    parrafo.appendChild(botMostrar);
    parrafo.appendChild(botMarcar);

    // test
    let test = document.createElement('button');
    test.setAttribute('id', 'test');
    test.setAttribute('class', 'boton funcion');
    test.innerText = 'Test';
    test.addEventListener('click', getCookie);

    parrafo.appendChild(test);

  }
}

function setCookie(value) {
  let cName = 'galletita';
  if (!document.cookie == "") {
    let galleta = getCookie();
    galleta = galleta + '-' + value;
    document.cookie = cName + '=' + galleta;
    console.log('lleno');
  } else {
    console.log(document.cookie);
    document.cookie = cName + '=' + value;
    console.log('vacio');
  }

}

function getCookie() {
  let galleta = document.cookie.split('=');
  let valores = galleta[1];

  return valores;
}

function funcionMostrar() {
  let mensaje;
  if (document.cookie == "") {
    mensaje = "La cookie no existe"
  } else {
    mensaje = getCookie();
  }
  alert(mensaje);
}

function funcionMarcar() {
  let valores = getCookie();
  console.log(valores);
  valores = valores.split('-');
  console.log(valores);

  for (let a = 0; a < valores.length; a++) {
    for (let j = 0; j < vector.length; j++) {
      console.log(valores[a]);
      console.log(vector[j]);

      if (valores[a] == vector[j]) {
        document.getElementById('checkB' + j).setAttribute('checked', '');
      }
    }
  }
}

crearP();
