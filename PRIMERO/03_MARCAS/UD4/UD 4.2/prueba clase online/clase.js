const listItems = document.getElementById("list").children

const listItemsByTag = document.getElementsByTagName("li")

const listItemsByQuerySelector = document.querySelectorAll("ul#list li")


const handleHover = (event) => {
return event.target.innerText = 'ON';
};
if(listItems.length > 1) {li}