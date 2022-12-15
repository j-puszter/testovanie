// getting all required elements
const errMsg = document.querySelector("#errMsg");

function validateInput(value, method, repassword) {
    var msg = "";
    var result = true;
    // Blank fields
    if (value.length == 0) {
        msg = "All fields are required.";
        result = false;
    }
    if (value.length < 5) {
        msg = "Email or password is too short (min 5 characters).";
        result = false;
    }
    if (value == "registered@gmail.com" && method == "register") {
        msg = "Email is already taken.";
        result = false;
    }
    if (method == "register" && repassword) {
        if (value != repassword) {
            msg = "Passwords do not match!";
            result = false;
        }
    }

    errMsg.innerHTML = msg;
    return result;
}

function validateEmail(input) {
    var validRegex = /^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\.[a-zA-Z0-9-]+)*$/;

    if (input.match(validRegex)) {
        return true;
    } else {
        errMsg.innerHTML = "Email is not valid.";
        return false;
    }
}

function login() {
    // getting all required elements
    const email = document.querySelector("#email").value;
    const password = document.querySelector("#password").value;

    if (validateInput(email) && validateInput(password)) {
        // Validate email
        if (validateEmail(email)) {
            window.location.pathname = "/pages/todo.html";
            // Window.location.href = "https://google.com";
        }
    }
}

function register() {
    // getting all required elements
    const email = document.querySelector("#email").value;
    const password = document.querySelector("#password").value;
    const repassword = document.querySelector("#re-password").value;

    if (validateInput(email) && validateInput(password) && validateInput(repassword)) {
        // Validate email
        if (validateEmail(email) && validateInput(email, register)) {
            // Check if password matches
            if (validateInput(password, register, repassword)) {
                alert("ok");
            }
        }
    }
}
