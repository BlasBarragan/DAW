'use strict';

/******************************************************************
 * Operaciones matemáticas con conversiones, resultados infinitos, etc.
 ******************************************************************/
let n = "23";
console.log(+n + 12);
console.log(12 + +n);
console.log(true + null);
console.log(true * null);
console.log(3/0);
console.log(-3/0);

/**********************************************
 * Función con parámetro (nombre) por defecto
 **********************************************/

function f(name = "John") {
    console.log("Hello " + n);
}

f("Peter"); // "Hello Peter"
f(); // "Hello John"

/***********************
 * Reducir array
 ***********************/
let a = [1,2,3,4,5,6,7];
console.log(a);
a.length = 4;
console.log(a);
