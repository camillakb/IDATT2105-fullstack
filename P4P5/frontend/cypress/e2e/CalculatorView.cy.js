// https://docs.cypress.io/api/introduction/api.html

describe("Calculator gives correct results", () => {
    it ("Writes '3+3' and gets 6 as a result", () => {
        cy.visit("/")
        cy.contains("button", "3").click()
        cy.contains("button", "+").click()
        cy.contains("button", "3").click()
        cy.contains("button", "=").click()
        cy.get("input").should((verifyResult) => {
            expect(verifyResult).have.value("6")
        })
    }) 

    it ("Writes '3-3' and gets 0 as a result", () => {
        cy.visit("/")
        cy.contains("button", "3").click()
        cy.contains("button", "-").click()
        cy.contains("button", "3").click()
        cy.contains("button", "=").click()
        cy.get("input").should((verifyResult) => {
            expect(verifyResult).have.value("0")
        })
    }) 

    it ("Writes '3*3' and gets 9 as a result", () => {
        cy.visit("/")
        cy.contains("button", "3").click()
        cy.contains("button", "*").click()
        cy.contains("button", "3").click()
        cy.contains("button", "=").click()
        cy.get("input").should((verifyResult) => {
            expect(verifyResult).have.value("9")
        })
    }) 

    it ("Writes '3/3' and gets 1 as a result", () => {
        cy.visit("/")
        cy.contains("button", "3").click()
        cy.contains("button", "/").click()
        cy.contains("button", "3").click()
        cy.contains("button", "=").click()
        cy.get("input").should((verifyResult) => {
            expect(verifyResult).have.value("1")
        })
    }) 
})

describe("DEL and AC works", () => {
    it("Writes '333' and clicks DEL", () => {
        cy.visit("/")
        cy.contains("button", "3").click()
        cy.contains("button", "3").click()
        cy.contains("button", "3").click()
        cy.contains("button", "DEL").click()
        cy.get("input").should((verifyResult) => {
            expect(verifyResult).have.value("33")
        })
    })

    it("Writes '333' and clicks AC", () => {
        cy.visit("/")
        cy.contains("button", "3").click()
        cy.contains("button", "3").click()
        cy.contains("button", "3").click()
        cy.contains("button", "AC").click()
        cy.get("input").should((verifyResult) => {
            expect(verifyResult).have.value("")
        })
    })
})

describe("Gets error message if an invalid expression is entered", () => {
    it("Writes '3*/6' and clicks '='", () => {
        cy.visit("/")
        cy.contains("button", "3").click()
        cy.contains("button", "*").click()
        cy.contains("button", "/").click()
        cy.contains("button", "6").click()
        cy.contains("button", "=").click()
        cy.get("input").should((verifyResult) => {
            expect(verifyResult).have.value("ERROR: please press AC")
        })
    })
})