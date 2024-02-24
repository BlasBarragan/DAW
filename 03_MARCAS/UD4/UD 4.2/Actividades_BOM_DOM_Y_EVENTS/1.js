const buttonElem = document.getElementById("button");
buttonElem.addEventListener('click', () => {
    const oldText = buttonElem.innerText;
    return button.innerText = oldText === "ON" ? "OFF" : "ON";
});
