/*
* Apartado 1
* Crea una función que reciba 2 cadenas por parámetro. Esta función imprimirá por consola qué cadena
* tiene mayor longitud. Si el tipo de algún parámetro no es string (typeof param !== "string"),
* tienes que imprimir un error.
* Llamamiento a la función 3 veces con diferentes parámetros. En uno de esos llamamientos pásale por parámetro un valor que no sea string.
*/

function dosCadenas(cadena1, cadena2){ // La funcion recibe 2 parametros.
    if (typeof cadena1 !== "string" || typeof cadena2 !== "string"){ // Comprobamos que los parametros recividos sean de tipo string.
        console.error("Error: El tipo de variable no es String"); // Si no, devolvemos error.
    } else { // Si se cumple la condicion...
        if (cadena1.length > cadena2.length){ // Comparamos la longuitud de las cadenas y devolvemos la mayor.
            console.log(cadena1);
        }else{
            console.log(cadena2);
        }
    }
}

dosCadenas("Esta cadena es menor", "Esta cadena es mayor que la otra cadena"); // La segunda cadena es mayor.
dosCadenas("Blas Barragán Román", 123456); // La segunda cadena, no cumple la condicion string.
dosCadenas("Blas Barragán Román", "Mi nombre es: "); // La primera cadena es mayor.

/*
* Apartado 2
* Crea una función que reciba 2 números por parámetro, el primer número indicará cuántas veces debemos imprimir el segundo
* por pantalla, pero en cada iteración muestra el valor anterior multiplicado por 2.
* Ejemplo: Si recibimos 4 y 6 imprimiremos: 6 12 24 48
* Llama a la función varias veces.
*/

function losNumeros(numero1,numero2){ // La funcion recibe dos parametros.
    for (let i = 0; i < numero1; i++){ // Realizamos el bucle tantas veces como nos indique el primer parametro.
        console.log(numero2);
        numero2 = numero2*2;
    }
}

console.log("Llamada uno:")
losNumeros(4,6);
console.log("Llamada dos:")
losNumeros(3,5);
console.log("Llamada tres:")
losNumeros(5,1);


/*
* Apartado 3
* Crea una función que reciba 2 parámetros. El primero será una cadena y el segundo otra cadena que contendrá un carácter.
* Convierte ambos parámetros a cadena y comprueba que efectivamente, el segundo parámetro tiene una longitud de 1.
* Tienes que mostrar cuántas veces aparece el carácter recibido en la cadena.
* Ejemplo: Si recibimos "carcasa" y "a", debemos indicar que aparece 3 veces esta letra en la cadena.
* Llamamiento a la función varias veces.
*/

function buscaLetras(cadena,letra){ // La funcion recibe dos parametros.
    cadena = String(cadena); // Convertimos el primer parametro en string.
    letra = String(letra); // Convertimos el segundo parametro en string.

    if (letra.length == 1){ // Comprobamos que el segundo parametro solo contenga un caracter.
        cadena = cadena.trim(); // Eliminamos todos los espacios en blanco de "cadena".
        let contador = 0; // Inicializamos un contador.
        const myArr = cadena.split(""); // Creamos un array con cada uno de los caracteres de "cadena".
        for (let j = 0; j<myArr.length; j++){ // Recorremos cada una de las posiciones del array.
            if (myArr[j] == letra){ // Si el valor de la posicion "j" en el array es igual a "letra"...
                contador = contador + 1; // Sumamos 1 a "contador".
            }
        }
        console.log("La letra "+ letra + " aparece "+ contador+ " veces."); // Devolvemos el resultado.
    }else{
        console.error("Error: Solo es posible buscar una letra.") // Devolvemos error si se busca mas de 1 caracter.
    }
}

console.log("Mi nombre sin tildes: ");
buscaLetras("Blas Barragan Roman", "a");
console.log("Mi nombre con tildes: ");
buscaLetras("Blas Barragán Román", "á");
console.log("Buscando mayusculas: ");
buscaLetras("Blas BArragán Román", "A");
console.log("Buscando más de un caracter: ");
buscaLetras("Blas BArragán Román", "aA");

/*
* Apartado 4
* Crea una función que reciba 3 parámetros (nombre de producto, precio e impuesto en porcentaje sobre 100).
* Esta función hará lo siguiente:
* - Los parámetros tendrán que tener un valor por defecto por si no los recibe que deben ser: "Producto genérico", 100 y 21.
* - Convierte el nombre de producto a string (por si acaso) y los otros 2 a número. Si el precio o el impuesto no son
* numéros válidos (NaN) muestra un error. Si son válidos, muestra por consola el nombre del producto y el precio final contando impuestos.
* - Llamamiento a la función varias veces, omitiendo parámetros, con todos los parámetros, y pasando algún valor no númerico en el precio o impuesto.
*/

function precioProducto(nombre = "Producto generico",precio = 100,impuesto = 21){ // La funcion recibe 3 parametros o en su defecto toma los valores definidos.
    nombre = String(nombre); // Convertimos en string.
    precio = Number(precio);
    impuesto = Number(impuesto); // Convertimos en numero

    if (isNaN(precio) || isNaN(impuesto)){ // Si el valor es igual a NaN.
        console.error("Error: Precio o Impuesto no son numeros validos"); // Devolvemos error.
    }else{ // En caso contrario...
        console.log(nombre + ": " + (precio += (precio*impuesto/100))); // Devuelve el nombre y el precio total.
    }
}

precioProducto(); // Valores omitidos, obtiene por defecto.
precioProducto("Naranja",1,10); // Todos los parametros.
precioProducto("Coche",20000,"l0"); // Valor no numerico en impuesto.
precioProducto("Moto","l0000",21); // Valor no numerico en precio.

/*
* Apartado 5
* Crea una función de tipo flecha (arrow function) que reciba 2 parámetros. Una cadena completa y un pedazo de cadena a buscar.
* La función debe comprobar si el pedazo de cadena de búsqueda se encuentra dentro de la cadena completa e imprimir
* por consola un mensaje indicando si ha encontrado coincidencia o no.
* La búsqueda no debe ser sensible a mayúsculas o minúsculas, por lo que debes comparar ambas cadenas previa transformación
* a minúsculas (o a mayúsculas). Ej: La cadena "Santiago de Compostela" contiene la cadena de búsqueda "COMPO".
* Llamamiento a la función varias veces.
*/

let funcionFlecha = (completa, pedazo) =>{ // Variable con funcion flecha de dos parametros.
    let texto = completa.toLowerCase(); // Convertimos a minusculas.
    let busqueda = pedazo.toLowerCase();
    let respuesta = "";
    if (texto.includes(busqueda)) { // Si "texto" contiene "busqueda"...
        respuesta = 'La cadena "' + completa + '" contiene la cadena de busqueda "' + pedazo + '".'
    }else{ // En caso contrario..
        respuesta = '"'+ pedazo + '" no se encentra en el texto.'
    };
    return console.log(respuesta); // Devuelve "respuesta".
}

funcionFlecha("Blas Barragan Roman", "an"); // Busqueda en minusculas.
funcionFlecha("Pablito clavo un clavito, que clavito clavo Pablito?", "CLAVO"); // Busqueda en mayusculas.
funcionFlecha("Pablito clavo un clavito, que clavito clavo Pablito?", "calvo"); // Texto no encontrado.