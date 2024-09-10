'use strict';

console.log('*********** Elementos dentro de body ***********');
let bodyNodes = document.body.children;
for (let i = 0; i < bodyNodes.length; i++) {
    console.log(bodyNodes[i]);
}

console.log('******** Elemento con id p1 y su hermano ******');
let p1 = document.getElementById('p1');
console.log('p#' + p1.id + ' -> ' + p1.textContent);

let p2 = p1.nextElementSibling; // Siguiente elemento desde p1
console.log('p#' + p2.id + ' -> ' + p2.textContent);

console.log('******** Elementos con la clase par ******');
let paras = document.getElementsByClassName('par');
for (let i = 0; i < paras.length; i++) {
    console.log('p#' + paras[i].id + ' -> ' + paras[i].textContent);
}
