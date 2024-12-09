let vector = ['valor1', 'valor2', 'valor3', 'valor4'];

window.onload = function () {
  // Crear párrafo contenedor
  let parrafo = document.createElement('p');
  parrafo.id = 'pContenedor';
  parrafo.className = 'parrafo';
  document.body.appendChild(parrafo);

  for (let i = 0; i < vector.length; i++) {
    // Checkbox
    let casilla = document.createElement('input');
    casilla.id = 'checkB' + i;
    casilla.className = 'checkbox';
    casilla.type = 'checkbox';
    casilla.value = vector[i];

    // Texto valor
    let texto = document.createTextNode(vector[i]);

    // Botón
    let boton = document.createElement('button');
    boton.id = 'boton' + i;
    boton.className = 'boton';
    boton.addEventListener('click', () => pasarValor(vector[i]));
    boton.appendChild(document.createTextNode(vector[i])); // Crear nodo de texto como hijo

    // Añadir elementos al párrafo
    parrafo.appendChild(casilla);
    parrafo.appendChild(texto);
    parrafo.appendChild(boton);
  }

  // Botón mostrar
  let botMostrar = document.createElement('button');
  botMostrar.id = 'mostrar';
  botMostrar.className = 'boton mostrar';
  botMostrar.appendChild(document.createTextNode('Mostrar'));
  botMostrar.addEventListener('click', funcionMostrar);

  // Botón marcar/desmarcar
  let botMarcar = document.createElement('button');
  botMarcar.id = 'marcar';
  botMarcar.className = 'boton marcar';
  botMarcar.appendChild(document.createTextNode('Marcar/Desmarcar'));
  botMarcar.addEventListener('click', funcionMarcar);

  // Añadir botones al body
  document.body.appendChild(botMostrar);
  document.body.appendChild(botMarcar);
};

function pasarValor(valor) {
  let valores = getCookie('galletita') || '';
  let valoresArray = valores.split('-');
  if (!valoresArray.includes(valor)) {
    valoresArray.push(valor);
  } else {
    valoresArray = valoresArray.filter(v => v !== valor); // Eliminar si ya está en la cookie
  }
  setCookie('galletita', valoresArray.join('-'));
}

function funcionMostrar() {
  alert(getCookie('galletita') || 'La cookie está vacía');
}

function funcionMarcar() {
  let valores = getCookie('galletita');
  if (!valores) return;
  let valoresArray = valores.split('-');

  vector.forEach((valor, index) => {
    let casilla = document.getElementById('checkB' + index);
    if (valoresArray.includes(valor)) {
      casilla.checked = !casilla.checked; // Alternar marcado
    }
  });
}

function setCookie(name, value) {
  document.cookie = `${name}=${value}; path=/`;
}

function getCookie(name) {
  const cookies = document.cookie.split('; ');
  for (const cookie of cookies) {
    const [key, val] = cookie.split('=');
    if (key === name) return val;
  }
  return '';
}
