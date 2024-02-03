'use strict';

/********************************************
 * Trabajando con números
*********************************************/

let n = 3.345657;
console.log(n.toFixed(2));
console.log(4.63475745.toFixed(2));
console.log((5).toFixed(2));

console.log(Number.MIN_VALUE);
console.log(Number.MAX_VALUE);

let bigNum = Number.MAX_VALUE * 2;
console.log(bigNum);
console.log(isFinite(bigNum));
console.log(isFinite(n));

console.log(3 * 5);
console.log(3 * "5");

let res = 3 * "ASDF";
console.log(res);
console.log(isNaN(res));
console.log(isNaN(parseInt("hola")));
