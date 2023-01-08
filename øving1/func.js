//metode: counter
let counterbutton= document.getElementById("countbutton")

function counter() {
    
}

//A button that changes color between red and blue when pressed.
let colorbutton = document.getElementById("colorchangingbutton")

function changeColor() {
    if (colorbutton.style.backgroundColor === "red") {
        colorbutton.style.backgroundColor = "blue"
    } else {
        colorbutton.style.backgroundColor = "red"
    }

    colorbutton.innerHTML="Color changed!"
}

//Knapp med innholdsblock som skjuler/viser innhold

//Opprett array med tilfeldige stikkord og gjengi innholdet som en liste
//på nettsiden (ul og li  tags) kan være knapp eller ved kjøring av nettsiden