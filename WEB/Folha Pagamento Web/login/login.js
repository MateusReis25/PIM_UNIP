document.addEventListener("DOMContentLoaded", function() {
    const usernameInput = document.getElementById("inputUsuario");
    const passwordInput = document.getElementById("inputSenha");
    const errorText = document.getElementById("textViewSenhaIncorreta");
    const loginButton = document.getElementById("btnCadastroUsuario");

    loginButton.addEventListener("click", function() {
        const enteredUsername = usernameInput.value;
        const enteredPassword = passwordInput.value;

        if (localStorage.getItem("firstLogin") !== "done") {
            if (enteredUsername === "mateus" && enteredPassword === "123") {

                localStorage.setItem("firstLogin", "done");
                sessionStorage.setItem("username", enteredUsername);
                window.location.href = "../menu/menu.html";
            } else {
                errorText.textContent = "Usuário ou senha incorretos!";
            }
        } else {
            const storedUsers = JSON.parse(localStorage.getItem("usuarios")) || [];
            const userFound = storedUsers.find(user => user.username === enteredUsername && user.password === enteredPassword);

            if (userFound) {
                sessionStorage.setItem("username", enteredUsername);
                window.location.href = "../menu/menu.html";
            } else {
                errorText.textContent = "Usuário ou senha incorretos!";
            }
        }
    });
});
