describe("Auth", () => {
    it("login", () => {
        // Verify page
        cy.visit("localhost:5500");
        cy.get("title").should("contain", "Login");

        // Type in input
        cy.get("#email").type("example@gmail.com");
        cy.get("#password").type("password123");

        // Submit Login
        cy.get("button").should("contain", "Login").click({ timeout: 1000 });
    });

    it("register", () => {
        // Verify page
        cy.visit("localhost:5500/pages/register.html");
        cy.get("title").should("contain", "Register");

        // Type in input
        cy.get("#email").type("example@gmail.com");
        cy.get("#password").type("password123");
        cy.get("#re-password").type("password123");

        // Submit register
        cy.get("button").should("contain", "Register").click({ timeout: 1000 });
    });
});

describe("Todo functionality", () => {
    beforeEach(() => {
        cy.visit("localhost:5500/pages/todo.html");
    });

    it("displays two todo items by default", () => {
        cy.get(".todoList li").should("have.length", 2);

        cy.get(".todoList li").first().should("have.text", "Buy milk");
        cy.get(".todoList li").last().should("have.text", "Drink water");
    });

    it("add new task", () => {
        cy.get("input").type("New task from CYPRESS");
        cy.get("button i").should("contain.class", "fa-plus").parent().click();
    });
});
