const buttonElem = document.getElementById("wrapper").children[1];
const inputElem = document.getElementById("wrapper").children[0];

buttonElem.addEventListener('click', () => {
    const oldText = inputElem.value;
    return inputElem.value = oldText === "ON" ? "OFF" : "ON";
});