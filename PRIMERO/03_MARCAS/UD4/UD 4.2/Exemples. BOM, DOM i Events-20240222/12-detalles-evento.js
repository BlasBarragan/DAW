'use strict';

let div = document.getElementById("div");
div.addEventListener('click', event => {
    console.log("Botón: " + (event.button === 0?'left':
                                    event.button === 1?'middle':'right'));
    console.log("Coordenadas navegador: " + event.clientX + ", " + event.clientY);
    console.log("Coordenadas document: " + event.pageX +  ", " + event.pageY);
    console.log("Coordenadas pantalla: " + event.screenX + ", " + event.screenY);
    console.log("Clicks (simple, doble,...): " + event.detail);
});
