const button = document.getElementById('button');
const txtBox = document.getElementById("fullName");
const nombre = document.getElementById("firstName").value;
const apellido = document.getElementById("lastName").value;
button.addEventListener('click', () => {
    // txtBox.classList.add("value");
    txtBox.value = nombre + " " + apellido;
});