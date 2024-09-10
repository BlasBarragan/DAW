'use strict';

let novale = document.getElementById('novale');
let pInfo = document.getElementById('info');
let inputName = document.getElementById('name');
let form = document.getElementById('form');

novale.addEventListener('click', event => {
    console.log('No puedes ir a google desde aquí');
    event.preventDefault(); // Evitamos comportamiento por defecto del enlace
});

inputName.addEventListener('focus', event => {
    console.log("Ahora puedes escribir en 'name'");
    inputName.className = '';
});

inputName.addEventListener('keypress', event => {
    if (event.keyCode === 13) {
        // Enter
        event.preventDefault(); // No enviamos el formulario (comportamiento por defecto)
        pInfo.textContent = inputName.value;
    }
});

// Al perder el foto el campo, comprobamos que ha introducido algo
inputName.addEventListener('blur', event => {
    console.log("'name' ha perdido el foco");
    if (inputName.value === '') {
        pInfo.textContent = 'El campo no puede estar vacío';
        inputName.className = 'not-valid';
    } else {
        pInfo.textContent = inputName.value;
    }
});

// Si el nombre está vacío, impedimos que se envíe el formulario
form.addEventListener('submit', () => {
    if (inputName.value === '') {
        event.preventDefault();
        console.log('El nombre está vacío');
    }
});
