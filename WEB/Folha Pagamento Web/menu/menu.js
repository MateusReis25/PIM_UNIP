document.addEventListener("DOMContentLoaded", function() {

    const storedUsername = sessionStorage.getItem("username");
    if (storedUsername) {
        const usernameDisplay = document.getElementById("usernameDisplay");
        usernameDisplay.textContent = storedUsername;
    }

    const logoutButton = document.getElementById("logoutButton");
    logoutButton.addEventListener("click", function() {
        sessionStorage.removeItem("username");
        window.location.href = "../login/login.html";
    });
});
