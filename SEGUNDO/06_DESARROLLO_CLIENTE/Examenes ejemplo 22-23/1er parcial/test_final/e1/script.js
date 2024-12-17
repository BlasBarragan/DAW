let vector = ['valor1', 'valor2', 'valor3', 'valor4'];

window.onload = function () {

  let paragraf = document.createElement('p');
  paragraf.setAttribute('id', 'paragraf');
  document.body.appendChild(paragraf);

  vector.forEach(valor => {

    // casilla con nombre
    let casilla = document.createElement('input');
    casilla.setAttribute('id', valor);
    casilla.setAttribute('type', 'checkbox');
    casilla.setAttribute('value', valor);

    // boton casilla
    let botCasilla = document.createElement('input');
    botCasilla.setAttribute('type', 'button');
    botCasilla.setAttribute('id', 'bot_' + valor);
    botCasilla.setAttribute('value', valor);
    botCasilla.addEventListener('click', function () { funcionCasilla(this.value) });

    // se añade al body
    paragraf.appendChild(casilla);
    paragraf.appendChild(document.createTextNode(valor));
    paragraf.appendChild(botCasilla);

  });

  // boton mostrar
  let botMostrar = document.createElement('input');
  botMostrar.setAttribute('type', 'button');
  botMostrar.setAttribute('id', 'mostrar');
  botMostrar.setAttribute('name', 'mostrar');
  botMostrar.setAttribute('value', 'mostrar');
  botMostrar.addEventListener('click', function () { funcionMostrar(this.value) });
  document.body.appendChild(botMostrar);


  // boton marcar
  let botMarcar = document.createElement('input');
  botMarcar.setAttribute('type', 'button');
  botMarcar.setAttribute('id', 'marcar');
  botMarcar.setAttribute('name', 'marcar');
  botMarcar.setAttribute('value', 'marcar');
  botMarcar.addEventListener('click', function () { funcionMarcar(this.value) });
  document.body.appendChild(botMarcar);


  function funcionCasilla(valor) {
    console.log(valor);
  }

  function funcionMostrar(valor) {
    console.log('Mostrar: ' + valor);
  }

  function funcionMarcar(valor) {
    console.log('Marcar: ' + valor);

  }

}