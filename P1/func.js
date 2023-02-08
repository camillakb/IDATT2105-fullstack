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
        colorbutton.style.borderColor = "blue"
    } else {
        colorbutton.style.backgroundColor = "red"
        colorbutton.style.borderColor = "red"
    }

    colorbutton.innerHTML="Color changed!"
}

//A button that shows additional links when clicked.
let listbutton = document.getElementById("showbutton")
let data = "Hello Hallo Bonjour Hola Salve".split(" ")
let visibleList = false;

function showList() {
    if (!visibleList) {
        let list = document.createElement("ul")

        data.forEach((item) => {
            let listElement = document.createElement("li")
            listElement.innerHTML = item
            list.appendChild(listElement)
        })

        listbutton.insertAdjacentElement("afterend", list)
        visibleList = true;
    }
}

