// https://docs.cypress.io/api/introduction/api.html

describe("Submit-button is deactivated when  there are empty fields", () => {
    it ("Does not fill out all fields", () => {
        cy.visit("/feedback")
        cy.get("input[id='name']").type("FirstName LastName")
        cy.get("button").should("be.disabled")

        cy.get("input[id='email']").type("email@mail.com")
        cy.get("button").should("be.disabled")
    })
})

describe("Submit-button is enabled when all fields are filled", () => {
    it ("Fills in all fields", ()  => {
        cy.visit("/feedback")
        cy.get("input[id='name']").type("FirstName LastName")
        cy.get("input[id='email']").type("email@mail.com")
        cy.get("textarea[id='feedback']").type("Feedback")
        cy.get("button").should("not.be.disabled")
    })
})

describe("User should get 'Feedback submitted!' as a response when successfully submitting feedback", () => {
    it ("Submits feeback", () => {
        cy.visit("/feedback")
        cy.get("input[id='name']").type("FirstName LastName")
        cy.get("input[id='email']").type("email@mail.com")
        cy.get("textarea[id='feedback']").type("Feedback")

        cy.get("button").should("not.be.disabled").click()
        cy.get('p').should("contain.text", "Feedback submitted!") 
    })
})

