'use strict';

console.log("----- Una forma de recorrer la primera lista ------");
let ul = document.getElementById("firstListElement").parentElement;
console.log(ul.children);
for(let i = 0; i < ul.children.length; i++) {
    let li = ul.children[i];
    console.log(li.textContent);
}

console.log("----- Elementos .item1 en la primera lista ------");
let ul1 = document.getElementsByClassName("ul1")[0];
let items = ul1.getElementsByClassName("item1"); // Elementos .item1 dentro de .ul1
for(let i = 0; i < items.length; i++) {
    console.log(items[i].textContent);
}

console.log("----- Igual que antes pero con querySelectorAll ------");
let itemsSel = document.querySelectorAll("ul.ul1 > li.item1");
for(let i = 0; i < itemsSel.length; i++) {
    console.log(itemsSel[i].textContent);
}
console.log("----- Elementos de lista .ul2 que no tengan clase .item1 ------");
let itemsSel = document.querySelectorAll("ul.ul2 > li:not(.item1)");
for(let i = 0; i < itemsSel.length; i++) {
    console.log(itemsSel[i].textContent);
}
console.log("---- <input> cuyo atributo value empiece por 'input' -----");
let inputs = document.querySelectorAll("input[value^='input']");
inputs.forEach(function(input) {
        console.log(input);
});
