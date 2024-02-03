'use strict';

/******************************************
 * Estructuras condicionales
 ******************************************/

let edad = 78;

if(edad < 18) {
    console.log("Menor");
} else if(edad < 65) {
    console.log("Adulto");
} else {
    console.log("Jubilado");
}

let opcion = 1;

switch(opcion) {
    case 1:
        console.log("Has elegido la opción 1");
        break;
    case 2:
        console.log("Has elegido la opción 2");
        break;
    case 3:
        console.log("Has elegido la opción 3");
        break;
    default:
        console.log("Opción no válida");
}

// Estructura switch comprobando cadenas
let cadena = "h";
switch(cadena) {
    case "h":
        console.log("Ha elegido h");
        break;
}

// Estructura switch comprobando condiciones (entra en la primera que sea true)
let age = 32;
switch(true) {
    case age < 18:
        console.log("Demasiado joven para entrar");
        break;
    case age < 65:
        console.log("Puedes entrar");
        break;
    default:
        console.log("Demasiado mayor para entrar");
}

/*********************************
 * Bucles (todos cuentan de 1 a 5)
 *********************************/

/*let i = 1;
while(i <= 5) {
    console.log(i++);
}

let i=1;
do {
    console.log(i++);
} while(i <= 5); */

for(let i = 1; i <= 5; i++) {
    console.log(i);
}

/********************************************
 * Iterando por arrays (3 formas diferentes)
*********************************************/
let array = new Array(23, 5, "Hello", new Date());
/*for(let i = 0; i < array.length; i++) {
    console.log(array[i]);
}*/

/*for(let index in array) {
    console.log(array[index]);
}*/

array.forEach((item) => console.log(item));

/********************************************
 * Iterando por las propiedades de un objeto
 ********************************************/

let person = {
    name: "Peter",
    age: 34,
    dateBirth: new Date("1982-05-16"),
    sayHello: function() {
        console.log("Hello!, my name is " + this.name);
    }
};

for(let prop in person) {
    if(typeof person[prop] !== "function") // Sólo muestra la propiedad si no es una función
        console.log(prop + ": " + person[prop]);
}

person.sayHello(); // Llama al método sayHello() del objeto person


