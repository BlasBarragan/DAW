'use strict';

let div = document.getElementById('contenido');

// Creamos 2 párrafos
let p1 = document.createElement('p');
let p2 = document.createElement('p');

// Se los añadimos al <div id="contenido">
div.appendChild(p1);
div.appendChild(p2);

// 2 formas de asignarle texto al párrafo
p1.textContent = 'Soy el primer párrafo creado';
p2.appendChild(document.createTextNode('Soy el segundo párrafo creado'));

// Creamos otro párrafo que insertaremos entre los 2 anteriores
let p3 = document.createElement('p');
p3.textContent = 'Soy el tercero. Me han insertado entre los 2 párrafos';
div.insertBefore(p3, p2);

let a = document.querySelector('#pie a');
//a.remove(); // Funciona!!, como en JQuery (experimental, solo en navegadores modernos)
//a.parentElement.removeChild(a); // Forma de borrarlo clásica a partir del padre

// Acceder y modificar atributos y estilos (ver resultado en consola e inspeccionando HTML)
a.title = 'Another title...';
console.log(a.id);
a.className = 'a2';
console.log(a.hasAttribute('href'));
console.log(a.hasAttribute('value'));
console.log(a.getAttribute('class'));
a.setAttribute('class', 'a3');
console.log(a.className);

div.style.boxSizing = 'border-box';
div.style.maxWidth = '300px';
div.style.padding = '50px';
div.style.color = 'white';
div.style.backgroundColor = 'red';
