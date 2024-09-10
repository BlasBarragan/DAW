
// Ejercicio 1

function infoN(n){ // La funcion recibe parametro n.

    if (typeof n !== "number"){ // Comprobamos que sea numero.
        console.error("Error: El tipo de variable no es un numero"); // Si no, devolvemos error.
    } 
    else { // Si se cumple la condicion...
        let a = n*2;
        let b = n*3;
        let c = n*n;
        console.log("doble: " + a + " triple: " + b + " cuadrado: " + c)
    }
}

// Ejercicio 2 A

function ejercicio2A(nInici, nFi, nReferencia){ // La funcion recibe parametro n.

    for( let i = nInici; i < nFi; i++ ){
        if (i == nReferencia){
            console.log("Los numeros son iguales")
        }
        else if ( i > nReferencia){
            console.log("El numero es mayor que la referencia")
        }
        else if (i < nReferencia){
            console.log("El numero es menor que la referencia")
        }
        infoN(i);
    }

}

