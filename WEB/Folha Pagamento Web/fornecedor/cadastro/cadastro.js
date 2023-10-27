function salvarFormulario() {
    const formulario = document.getElementById("fornecedor-form");
    const formData = new FormData(formulario);
    const formObj = {};
    formData.forEach((value, key) => {
        formObj[key] = value;
    });

    const dadosExistentes = JSON.parse(localStorage.getItem("dadosFornecedores")) || [];

    // Encontre o último ID
    let ultimoID = 0;
    if (dadosExistentes.length > 0) {
        const ultimaEntrada = dadosExistentes[dadosExistentes.length - 1];
        if (ultimaEntrada.id) {
            ultimoID = ultimaEntrada.id;
        }
    }

    // Incrementa o ID para o novo funcionário
    formObj.id = ultimoID + 1;

    dadosExistentes.push(formObj);
    localStorage.setItem("dadosFornecedores", JSON.stringify(dadosExistentes));

    alert("Fornecedor Cadastrado com sucesso!");

    window.location.href = "../fornecedor.html";
}


const btnSalvar = document.getElementById("btnCadastroFornecedor");
btnSalvar.addEventListener("click", salvarFormulario);
