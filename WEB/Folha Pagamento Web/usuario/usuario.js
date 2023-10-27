document.addEventListener("DOMContentLoaded", function() {
    const novoUsuarioInput = document.getElementById("inputNovoUsuario");
    const novaSenhaInput = document.getElementById("inputNovaSenha");
    const novaSenhaInput2 = document.getElementById("inputNovaSenha2");
    const cadastrarUsuarioButton = document.getElementById("btnCadastrarUsuario");
    const errorText = document.getElementById("textViewSenhaIncorreta");

    cadastrarUsuarioButton.addEventListener("click", function() {
        const novoUsuario = novoUsuarioInput.value;
        const novaSenha = novaSenhaInput.value;
        const novaSenha2 = novaSenhaInput2.value;

        if (novoUsuario && novaSenha && novaSenha2) {
            if (novaSenha === novaSenha2) {
                const usuario = { username: novoUsuario, password: novaSenha };

                const usuarios = JSON.parse(localStorage.getItem("usuarios")) || [];
                usuarios.push(usuario);
                localStorage.setItem("usuarios", JSON.stringify(usuarios));

                alert("Usuário cadastrado com sucesso!");

                window.location.href = "../menu/menu.html";
            } else {
                errorText.textContent = "Senhas não conferem!";
            }
        } else {
            errorText.textContent = "Preencha os campos de usuário e senha.";
        }


        novaSenhaInput.value = "";
        novaSenhaInput2.value = "";
        novaSenhaInput.focus();
    });
});
