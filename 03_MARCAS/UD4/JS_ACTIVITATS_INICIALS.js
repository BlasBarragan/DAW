/*
* Apartado 1
* Crea una función que reciba 2 cadenas por parámetro. Esta función imprimirá por consola qué cadena
* tiene mayor longitud. Si el tipo de algún parámetro no es string (typeof param !== "string"),
* tienes que imprimir un error.
* Llamamiento a la función 3 veces con diferentes parámetros. En uno de esos llamamientos pásale por parámetro un valor que no sea string.
*/

function DosCadenas(cadena1, cadena2){
    if (typeof cadena1 !== "string" || typeof cadena2 !== "string"){
        console.error("Error: El tipo de variable no es String");
    } else {
        if (cadena1.length > cadena2.length){
            console.log(cadena1);
        }else{
            console.log(cadena2);
        }
    }
}

DosCadenas("Esta cadena es menor", "Esta cadena es mayor que la otra cadena");
DosCadenas("Blas Barragán Román", 123456);
DosCadenas("Blas Barragán Román", "Mi nombre es: ");


/*
* Apartado 2
* Crea una función que reciba 2 números por parámetro, el primer número indicará cuántas veces debemos imprimir el segundo
* por pantalla, pero en cada iteración muestra el valor anterior multiplicado por 2.
* Ejemplo: Si recibimos 4 y 6 imprimiremos: 6 12 24 48
* Llama a la función varias veces.
*/

function LosNumeros(numero1,numero2){
    for (let i = 0; i < numero1; i++){
        console.log(numero2);
        numero2 = numero2*2;
    }
}

console.log("Llamada uno:")
LosNumeros(4,6);
console.log("Llamada dos:")
LosNumeros(3,5);
console.log("Llamada tres:")
LosNumeros(5,1);


/*
* Apartado 3
* Crea una función que reciba 2 parámetros. El primero será una cadena y el segundo otra cadena que contendrá un carácter.
* Convierte ambos parámetros a cadena y comprueba que efectivamente, el segundo parámetro tiene una longitud de 1.
* Tienes que mostrar cuántas veces aparece el carácter recibido en la cadena.
* Ejemplo: Si recibimos "carcasa" y "a", debemos indicar que aparece 3 veces esta letra en la cadena.
* Llamamiento a la función varias veces.
*/

function BuscaLetras(cadena,letra){
    cadena = String(cadena);
    letra = String(letra);
    let contador = 0;

    if (letra.length = 1){
        cadena = cadena.trim();
        let contador = 0;
        const myArr = cadena.split("");
        for (let j = 0; j<myArr.length; j++){
            if (myArr[j] == letra){
                console.log(myArr[j]);
                contador = contador + 1;
            }
        }
        console.log(typeof cadena);
        console.log(typeof letra);
        console.log(contador);
    }else{
        console.error("Error: Solo es posible buscar una letra.")
    }
}

console.log("Mi nombre sin tildes: ");
BuscaLetras("Blas Barragan Roman", "a");
console.log("Mi nombre con tildes: ");
BuscaLetras("Blas Barragán Román", "a");
console.log("Buscando mayusculas: ");
BuscaLetras("Blas BArragán Román", "A");
/*
* Apartado 4
* Crea una función que reciba 3 parámetros (nombre de producto, precio e impuesto en porcentaje sobre 100).
* Esta función hará lo siguiente:
* - Los parámetros tendrán que tener un valor por defecto por si no los recibe que deben ser: "Producto genérico", 100 y 21.
* - Convierte el nombre de producto a string (por si acaso) y los otros 2 a número. Si el precio o el impuesto no son
* numéros válidos (NaN) muestra un error. Si son válidos, muestra por consola el nombre del producto y el precio final contando impuestos.
* - Llamamiento a la función varias veces, omitiendo parámetros, con todos los parámetros, y pasando algún valor no númerico en el precio o impuesto.
*/




/*
* Apartado 5
* Crea una función de tipo flecha (arrow function) que reciba 2 parámetros. Una cadena completa y un pedazo de cadena a buscar.
* La función debe comprobar si el pedazo de cadena de búsqueda se encuentra dentro de la cadena completa e imprimir
* por consola un mensaje indicando si ha encontrado coincidencia o no.
* La búsqueda no debe ser sensible a mayúsculas o minúsculas, por lo que debes comparar ambas cadenas previa transformación
* a minúsculas (o a mayúsculas). Ej: La cadena "Santiago de Compostela" contiene la cadena de búsqueda "COMPO".
* Llamamiento a la función varias veces.
*/