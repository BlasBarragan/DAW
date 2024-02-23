'use strict';

let info = document.getElementById("info");
info.textContent = "Estoy en la página Inicial";

// Evento para capturar cuando se va hacia atrás en la navegación
window.addEventListener('popstate', event => {
    if(event.state) { // Datos de navegación? (no es página inicial)
        info.textContent = "Estoy en la página " + event.state.page +
                            ". Dato guardado: " + event.state.name;
        document.getElementById("name").value = event.state.name;
    } else { // Página de inicio
        info.textContent = "Estoy en la página Inicial";
        document.getElementById("name").value = "";
    }
});

let page = 1;
function goBack() {
    history.back();
}

document.getElementById("prev").addEventListener("click", goBack);

function goNext() {
    // history.state == null si es la primera página
    let nombre = document.getElementById("name").value;
    document.getElementById("name").value = '';
    let pageNum = history.state?history.state.page + 1:1;
    history.pushState({page: pageNum, name: nombre}, "");
    info.textContent = "Estoy en la página " + pageNum + 
                        ". Dato guardado: " + nombre;
}

document.getElementById("next").addEventListener("click", goNext);
