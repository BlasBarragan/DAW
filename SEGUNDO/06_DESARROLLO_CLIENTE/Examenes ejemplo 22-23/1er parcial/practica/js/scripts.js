
let vector = [123, 'blas', 23, 'sandra'];

function crearCasilla(vector) {

  window.onload = function () { // aseguramos que la pagina este cargada antes de ejecutar
    let parrafo = document.createElement("p"); // creamos parrafo
    parrafo.setAttribute('id', 'parrafo'); // añade id al parrafo
    //const element = document.body // apuntamos al body
    console.log(parrafo);
    document.body.appendChild(parrafo); // añade parrafo a body

    for (let i = 0; i < vector.length; i++) {
      let casilla = document.createElement('input'); // crea un input
      casilla.setAttribute('type', 'checkbox'); // añade tipo check
      casilla.setAttribute('id', i); // añade id a check
      casilla.setAttribute('value', vector[i]); // añade value a check
      let valor = document.createTextNode(vector[i]); // creamos texto valor a check
      parrafo.appendChild(casilla); // añáde check al p
      parrafo.appendChild(valor); // añade texto al p (los input no admiten hijos directos)
      let boton = document.createElement('input'); // creamos input para el boton
      boton.setAttribute('type', 'button'); // añade tipo boton
      boton.setAttribute('id', 'boton ' + vector[i]);
      boton.setAttribute('class', 'boton');
      boton.setAttribute('value', vector[i]);
      boton.setAttribute('onClick', "pulsacion(value)"); // añade llamada a funcion de boton
      parrafo.appendChild(boton); // añade boton a body
    }

    // boton mostrar
    let mostrar = document.createElement('input');
    mostrar.setAttribute('type', 'button'); // añade tipo boton
    mostrar.setAttribute('id', 'mostrar');
    mostrar.setAttribute('class', 'boton');
    mostrar.setAttribute('value', 'mostrar');
    mostrar.setAttribute('onClick', "funcionMostrar()"); // añade llamada a funcion de boton
    document.body.appendChild(mostrar); // añade boton a body
    // boton marcar
    let marcar = document.createElement('input');
    marcar.setAttribute('type', 'button'); // añade tipo boton
    marcar.setAttribute('id', 'marcar');
    marcar.setAttribute('class', 'boton');
    marcar.setAttribute('value', 'marcar');
    marcar.setAttribute('onClick', "funcionMarcar()"); // añade llamada a funcion de boton
    document.body.appendChild(marcar); // añade boton a body
  }
}

function pulsacion(valor) {
  console.log(valor);
}

crearCasilla(vector);