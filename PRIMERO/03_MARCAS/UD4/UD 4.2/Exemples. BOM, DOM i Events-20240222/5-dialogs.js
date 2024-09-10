'use strict';

let buttonAlert = document.getElementById("showAlert");

buttonAlert.addEventListener("click", () => {
    alert("Hello!, I'm an alert message.");
    console.log("Alert was closed");
});

let buttonConfirm = document.getElementById("showConfirm");

buttonConfirm.addEventListener("click", () => {
    let response = confirm("Do you want more money?");
    if(response) {
        console.log("Get a better job");
    } else {
        console.log("Are you sure? OK...");
    }
});

let buttonPrompt = document.getElementById("showPrompt");

buttonPrompt.addEventListener("click", () => {
    let response = prompt("What's your name", "Elvis");
    
    if(response) {
        console.log("Your name is " + response);
    } else {
        console.log("Tell me your name!!");
    }
});
