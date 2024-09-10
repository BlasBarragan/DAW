const listItems = document.querySelectorAll("ul li");
const handleHover = (event) => {
    return event.target.innerText = 'ON';
};
if (listItems.length > 1) {
    listItems.forEach(item => item.addEventListener('mouseover', handleHover));
}