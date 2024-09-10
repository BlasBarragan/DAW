

function completo(){

    const nombre = document.querySelectorAll("input")[0].value;
    const apellido = document.querySelectorAll("input")[1].value;

    alert(nombre + " " + apellido);
}

function profesion (nProfesion) {


    const nueva = document.querySelectorAll("input")[2];
    nueva.setAttribute("value",nProfesion);

} 

completo();
profesion("Arquitecto");
