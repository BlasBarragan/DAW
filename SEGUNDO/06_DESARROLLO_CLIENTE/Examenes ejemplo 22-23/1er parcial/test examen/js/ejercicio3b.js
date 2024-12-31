
const banner = ["../html/3/publi 1.html", "../html/3/publi 2.html", "../html/3/publi 3.html", "../html/3/publi 4.html", "../html/3/publi 5.html", "../html/3/publi 6.html", "../html/3/publi 7.html"];

let indice = 0; // indice para recorrer el array banner
let ventanas = []; // array de ventanas abiertas
let contador = 0; // contador de ventanas abiertas


setInterval(abrirVentana, 2500); // ejecuta abrirVentana cada 2,5s

function abrirVentana() { // abrimos ventanas de forma automatica

  let ventana = window.open(banner[indice], "_blank", "width=300,height=300,menubar=yes,toolbar=yes,location=yes,status=yes"); // obtiene la url del array y genera la ventana
  ventanas.push(ventana); // hacemos push de la ventana abierta a otro array para despues poder cerrarlas

  if (contador >= 3) { // Si hay 3 ventanas se cierra la mas antigua
    cerrarVentana(ventanas.shift()); // cierra la ventana mas antigua y la elimina del array de abiertas
  }

  if (indice < banner.length - 1) { // recorremos el array banner
    indice++;
  } else {
    indice = 0; // resetamos el indice para volver a recorrer el array banner
  }
  contador++;
}

function cerrarVentana(ventana) { // cierra la ventana
  ventana.close();
}