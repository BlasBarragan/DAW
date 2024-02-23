'use strict';

/********************
 * screen y window
 ********************/

console.log("Ancho pantalla: " + screen.width + "px");
console.log("Alto pantalla: " + screen.height + "px");

console.log("Ancho disponible: " + screen.availWidth + "px");
console.log("Alto disponible: " + screen.availHeight + "px");

console.log("Ancho ventana: " + window.outerWidth + "px");
console.log("Alto ventana: " + window.outerHeight + "px");

console.log("Ancho interno ventana: " + window.innerWidth);
console.log("Alto interno ventana: " + window.innerHeight);

function printPos(position) { // Sólo funciona en un servidor web mediante https!!
    console.log("Latitud: " + position.coords.latitude + ", Longitud: " + position.coords.longitude);
}

navigator.geolocation.getCurrentPosition(printPos);


