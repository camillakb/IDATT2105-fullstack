//A counter for how many times the button is clicked.
let counterbutton= document.getElementById("countbutton")
var clicks = 0

function counter() {
    clicks += 1;
    document.getElementById("clicks").innerHTML = clicks
}

//A button that changes color between red and blue when clicked.
let colorbutton = document.getElementById("colorchangingbutton")

function changeColor() {
    if (colorbutton.style.backgroundColor === "red") {
        colorbutton.style.backgroundColor = "blue"
    } else {
        colorbutton.style.backgroundColor = "red"
    }

    colorbutton.innerHTML="Color changed!"
}

//A button that shows a block with text when clicked.
let secret = document.getElementById("showbutton")

function showSecret() {
    var secret = document.getElementById("theSecret")

    if (secret.style.display === "none") {
        secret.style.display = "block"
    } else {
        secret.style.display = "none"
    }
}

//Array of words to use as list elements in HTML.
let list = document.getElementById("myList")

function makeList() {
    let data = ['History', 'Contact']

    data.forEach((item)=>{
        let listElement = document.createElement("listElement")
        listElement.innerText = item
        list.appendChild(listElement)
    })
}

//Opprett array med tilfeldige stikkord og gjengi innholdet som en liste
//på nettsiden (ul og li  tags) kan være knapp eller ved kjøring av nettsiden