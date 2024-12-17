let vector = ['valor1', 'valor2', 'valor3', 'valor4'];

window.onload = function () {
    

  for (let i = 0; i < vector.length; i++) {

        //parrafo
    let parrafo = document.createElement('p');
    parrafo.setAttribute('id', 'pContenedor'+ (i+1));
    parrafo.setAttribute('class', 'parrafo');
    document.body.appendChild(parrafo);

    // radio 1
    let radio1 = document.createElement('input');
    radio1.setAttribute('id', 'radio1' + (i+1));
    radio1.setAttribute('class', 'radio');
    radio1.setAttribute('type', 'radio');
    radio1.setAttribute('value', 'Activa');

     // radio 1
     let radio2 = document.createElement('input');
     radio2.setAttribute('id', 'radio2' + (i+1));
     radio2.setAttribute('class', 'radio');
     radio2.setAttribute('type', 'radio');
     radio2.setAttribute('value', 'No activa');
     radio2.setAttribute('checked', '');


    // texto valor
    let texto = document.createTextNode('Grupo ' + (i+1));
    let activo = document.createTextNode('Activo');
    let inactivo = document.createTextNode('Noactivo');
 
    // añadimos al parrafo
    parrafo.appendChild(texto);
    parrafo.appendChild(radio1);
    parrafo.appendChild(activo);
    parrafo.appendChild(radio2);
    parrafo.appendChild(inactivo);
    
  }

  // boton marcar
  let marcar = document.createElement('input');
  marcar.setAttribute('id', 'marcar');
  marcar.setAttribute('class', 'marcar');
  marcar.setAttribute('type', 'button');
  marcar.setAttribute('value', 'Marcar');
    
  marcar.addEventListener('click', function () {
    
  });

  // boton mostrar
  let mostrar = document.createElement('input');
  mostrar.setAttribute('id', 'mostrar');
  mostrar.setAttribute('class', 'mostrar');
  mostrar.setAttribute('type', 'button');
  mostrar.setAttribute('value', 'Mostrar');
    
  mostrar.addEventListener('click', function () {
    
  });
  
  // boton desar
  let desar = document.createElement('input');
  desar.setAttribute('id', 'desar');
  desar.setAttribute('class', 'desar');
  desar.setAttribute('type', 'button');
  desar.setAttribute('value', 'Desar');
  
  
  desar.addEventListener('click', function () {
    
  });  
  
  // boton reset
  let reset = document.createElement('input');
  reset.setAttribute('id', 'reset');
  reset.setAttribute('class', 'reset');
  reset.setAttribute('type', 'button');
  reset.setAttribute('value', 'Reset');
  
  
  reset.addEventListener('click', function () {
    
  });

  document.body.appendChild(marcar);
  document.body.appendChild(mostrar);
  document.body.appendChild(desar);
  document.body.appendChild(reset);
}



function addCookie() { 

  for (let j = 0; j < vector.length; j++) {
    let nombreCookie = 'grup'+(j+1);
    let valorCookie = '';
    let radActivo = document.getElementById('radio1'+(j+1));
    let radNoActivo = document.getElementById('radio2'+(j+1));

    if (radActivo.hasAttribute('checked')){
      valorCookie = 'si';
    } else {
      valorCookie = 'no';
    }

    let = document.getElementById('radio1'+j);
    let valorCookie2 = document.getElementById('radio2'+j);
    
  }

  document.cookie = nombreCookie + '=' + valorCookie;
}

function checkCookie() {

}

function mostrarCookie() {
  
}

function marcarRadio() {
  let marcas = checkCookie();
  if (marcas) {

    let galleta = marcas.split('-');
    for (let a = 0; a < galleta.length; a++) {
      console.log(galleta[a]);
      for (let b = 0; b < vector.length; b++) {
        if (galleta[a] == vector[b]) {
          console.log(galleta[a]);
          console.log(vector[b])
          document.getElementById('radio2' + b).setAttribute('checked', '');
        }
      }
    }
  }

}

function resetCookie(){

  let nombre = 'grup';
  let valores = checkCookie();
  let valor = document.cookie();

  if (valores != "") {
    // eliminamos valores de la cookie
    let arrayValores = valores.split(';');
    let nuevoArrayValores = [];

    for (let x = 0; x < arrayValores.length; x++) {
      if (arrayValores[x] != valor) {
        nuevoArrayValores.push(arrayValores[x]);
      }
    }

    document.cookie = nombre + '=' + nuevoArrayValores.join('-');
  }

}
