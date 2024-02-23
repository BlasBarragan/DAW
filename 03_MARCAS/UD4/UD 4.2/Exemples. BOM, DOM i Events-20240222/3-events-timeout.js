'use strict';

let timeout = null;

document.getElementById("start").addEventListener("click", () => {
    timeout = setTimeout(function() {
        let info = document.getElementById("info");
        let nombre = document.getElementById("nombre").value;
        let edad = document.getElementById("edad").value;
        info.textContent = nombre + " - " + edad;
    }, 3000);
});

document.getElementById("stop").addEventListener("click", () => {
    console.log("Stop!!");
    clearTimeout(timeout);
});

