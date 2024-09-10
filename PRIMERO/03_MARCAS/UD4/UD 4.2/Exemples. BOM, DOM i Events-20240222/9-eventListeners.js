'use strict';

let div = document.getElementById('contenido');
let pclicks = document.getElementById('clicks');
let numClicks = 0;

// Añadimos un primer manejador de eventos  (click)
div.addEventListener('click', sayHello);

function sayHello(event) {
    console.log(event);
    alert('Hola');
}

// Añadimos un segundo manejador de eventos (click)
div.addEventListener('click', event => {
    pclicks.textContent = 'Clicks: ' + ++numClicks;
    // Le quitamos el eventListener que mostraba el alert la primera vez que haga click
    div.removeEventListener('click', sayHello);
});

function detectEvent(event) {
    if (event instanceof MouseEvent) {
        console.log("I'm a mouse event -> " + event.type);
    } else if (event instanceof KeyboardEvent) {
        console.log("I'm a keyboard event -> " + event.type);
    }
}

// Añadimos mismo manejador de eventos para 2 eventos diferentes
// En la función detectamos de qué tipo de evento se trata
let input = document.getElementById('input');
input.addEventListener('click', detectEvent);
input.addEventListener('keypress', detectEvent);
