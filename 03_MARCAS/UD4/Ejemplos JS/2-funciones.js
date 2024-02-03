'use strict';

/*************************
 * Funciones
 *************************/
function sayHello(name) {
    console.log("Hello " + name);
}

let sayHello2 = sayHello; // Los 2 nombres referencian misma función

sayHello("World!");
sayHello();
console.log(typeof sayHello);
sayHello2("Peter");
/************************************** 
 * Funciones con valor de retorno
**************************************/
function sum(n1, n2) {
    return n1 + n2;
}

let r = sum(3, 6);
console.log(r);

/*****************************************************
 * Función anónima (y paso de función por parámetro)
******************************************************/
let callFunc = function(func, param) {
    func(param);
};

// El primer parámetro es una función y el segundo parámetro se envía
// como parámetro de dicha función (ver callFunc)
callFunc( 
    function(name) {
        console.log("Hello " + name);
    }, 
    "Mary"
); // Imprime "Hello Mary"