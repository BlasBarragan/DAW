'use strict';

/**
 * Vamos a ver como resaltar (y viceversa) los elementos de una lista con clases CSS
 */
let items = document.querySelectorAll('#list li');

// ponemos o quitamos la clase del elemento cada vez que se haga click
function activate(event) {
    if (!event.target.className) {
        event.target.className = 'active';
    } else {
        event.target.className = '';
    }
}

// Agregamos el manejador a todos los elementos de la lista
items.forEach(item => item.addEventListener('click', activate));

/**
 * Como añadir y quitar clases a un elemento cuando tiene varias
 */
console.log('Clases iniciales del elemento #list:');
let classes = document.getElementById('list').classList;
classes.forEach(c => console.log('Class: ' + c));
classes.remove('c2');
classes.add('c3');
console.log('Después de modificarlas:');
classes.forEach(c => console.log('Class: ' + c));
