'use strict';

let div1 = document.getElementById('div1');
let div2 = document.getElementById('div2');

// Prueba a deshabilitar la propagación

document.body.addEventListener('click', () => {
    console.log('Click on body');
});

div1.addEventListener('click', event => {
    console.log('Click on div1');
    //event.stopPropagation();
});
div2.addEventListener('click', event => {
    console.log('Click on div2');
    //event.stopPropagation()
});
