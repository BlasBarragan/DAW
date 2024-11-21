
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
    // texto valor
    let texto = document.createTextNode(vector[i]);
    // boton
    let boton = document.createElement('input');
    boton.setAttribute('id', 'botton' + i);
    boton.setAttribute('class', 'boton');
    boton.setAttribute('type', 'button');
    boton.setAttribute('value', vector[i]);
    boton.setAttribute('onclick', 'pasarValor(this.value)');
    boton.innerText = vector[i];

    // añadimos al body
    parrafo.appendChild(casilla);
    parrafo.appendChild(texto);
    parrafo.appendChild(boton);

  }

  // mostrar
  let botMostrar = document.createElement('button');
  botMostrar.setAttribute('id', 'mostrar');
  botMostrar.setAttribute('class', 'boton mostrar');
  botMostrar.innerText = 'Mostrar';
  botMostrar.addEventListener('click', funcionMostrar);


  // marcar
  let botMarcar = document.createElement('button');
  botMarcar.setAttribute('id', 'marcar');
  botMarcar.setAttribute('class', 'boton marcar');
  botMarcar.innerText = 'marcar';
  botMarcar.addEventListener('click', funcionMarcar);


  document.body.appendChild(botMostrar);
  document.body.appendChild(botMarcar);
}

function pasarValor(valor) {
  console.log(valor);
}

function funcionMostrar() {

}

function funcionMarcar() {

}
