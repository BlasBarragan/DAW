'use strict';

let i = 1;

function hello() {
    console.log("Hello timeout " + i++);
    if(i < 10) {
        timeout = setTimeout(hello,2000); // Repetimos timeout
    }
}

let timeout = setTimeout(hello,2000); // Timeout con función existente cada 2s

let j = 1;
let interval = setInterval(() => { // Interval con función anónima (lambda)
    console.log("Hello interval " + j++);
    if(j > 9) {
        clearInterval(interval); // Paramos repetición automática
    }
},2000);

console.log("Start!!");
