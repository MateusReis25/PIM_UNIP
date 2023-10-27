function salvarFormulario() {
  const formulario = document.getElementById("funcionario-form");
  const formData = new FormData(formulario);
  const formObj = {};
  formData.forEach((value, key) => {
    formObj[key] = value;
  });

  const dadosExistentes =
    JSON.parse(localStorage.getItem("dadosFuncionarios")) || [];

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
  localStorage.setItem("dadosFuncionarios", JSON.stringify(dadosExistentes));

  alert("Funcionário Cadastrado com sucesso!");

  window.location.href = "../funcionario.html";
}

const btnSalvar = document.getElementById("btnCadastroFuncionario");
btnSalvar.addEventListener("click", salvarFormulario);
