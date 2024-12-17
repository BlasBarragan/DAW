let vector = ['valor1', 'valor2', 'valor3', 'valor4'];

window.onload = function () {
    

  for (let i = 0; i < vector.length; i++) {

        //parrafo
    let parrafo = document.createElement('p');
    parrafo.setAttribute('id', 'pContenedor');
    parrafo.setAttribute('class', 'parrafo');
    document.body.appendChild(parrafo);

    // radio 1
    let radio1 = document.createElement('input');
    radio1.setAttribute('id', 'radio1' + i);
    radio1.setAttribute('class', 'radio');
    radio1.setAttribute('type', 'radio');
    radio1.setAttribute('value', 'Activa');

     // radio 1
     let radio2 = document.createElement('input');
     radio2.setAttribute('id', 'radio2' + i);
     radio2.setAttribute('class', 'radio');
     radio2.setAttribute('type', 'radio');
     radio2.setAttribute('value', 'No activa');
     radio2.setAttribute('checked', '');

    // texto valor
    let texto = document.createTextNode('Grupo ' + i);
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