/* exercici 1 -
no pots fer=> boton.setAttribute('onclick', 'pasarValor(this.value)');
cal fer addEventListener

no pots fer=> botMostrar.innerText = 'Mostrar';
no se puede hacer innerText (Mala semantica?).
Criterio del profesor hay que crear un textNodeChild como hijo
*/

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

    //  *** ERROR 1 ***
    //boton.setAttribute('onclick', 'pasarValor(this.value)');
    /* no pots fer boton.setAttribute('onclick', 'pasarValor(this.value)'); cal fer addEventListener */
    boton.addEventListener('click', function () {
      pasarValor(this.value)
    });
    // tambien podemos usar:
    //boton.addEventListener('click', () => pasarValor(vector[i]));

    //  *** ERROR extra ***
    //boton.innerText = vector[i];
    /* en etiquetas input, no hay que añadir texto, ya que lo que se muestra es el atributo value (linea 33),
    por lo que añadir texto ya sea con inner o textNode en un ,input> no sirve de nada */


    // añadimos al parrafo
    parrafo.appendChild(casilla);
    parrafo.appendChild(texto);
    parrafo.appendChild(boton);

  }

  // mostrar
  let botMostrar = document.createElement('button');
  botMostrar.setAttribute('id', 'mostrar');
  botMostrar.setAttribute('class', 'boton mostrar');

  //  *** ERROR 2 ***
  //botMostrar.innerText = 'Mostrar';
  /* no se puede hacer innerText según criterio del profesor (Mala semantica?). Hay que crear un textNodeChild como hijo */
  let textoMostrar = document.createTextNode('Mostrar');
  botMostrar.appendChild(textoMostrar);
  // tambien podemos usar:
  //botMostrar.appendChild(document.createTextNode('Mostrar'));

  botMostrar.addEventListener('click', funcionMostrar);


  // marcar
  let botMarcar = document.createElement('button');
  botMarcar.setAttribute('id', 'marcar');
  botMarcar.setAttribute('class', 'boton marcar');
  //  *** ERROR 2 ***
  //botMarcar.innerText = 'marcar';
  let textoMarcar = document.createTextNode('Marcar');
  botMarcar.appendChild(textoMarcar);
  // tambien podemos usar:
  //botMarcar.appendChild(document.createTextNode('Marcar'));
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
