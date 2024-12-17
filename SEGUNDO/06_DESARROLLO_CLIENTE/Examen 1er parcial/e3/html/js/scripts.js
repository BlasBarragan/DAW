const banner = ["1.html", "2.html", "3.html", "4.html", "5.html", "6.html"];
let indice = 0;
let ventanas = [];

setInterval(abrirVentana, 2000);

function abrirVentana() {
  let ventana = window.open(banner[indice], "_blank", "width=400,height=300,menubar=yes,toolbar=yes,location=yes,status=yes");
  ventanas.push(ventana);
  timer(ventana);
  if (indice < banner.length-1) {
    indice++;
  } else {
    indice = 0;
  }
}

function timer(ventana) {
  setTimeout(cerrarVentana, 1500, ventana);
}
function cerrarVentana(ventana) {
  ventana.close();
}
