function formatarDataBrasileira(data) {
  const partes = data.split("-");
  if (partes.length === 3) {
    const [ano, mes, dia] = partes;
    return `${dia}/${mes}/${ano}`;
  }
  return data;
}

function exibirFuncionarios() {
  const tabela = document.querySelector("table tbody");
  const dadosFuncionarios =
    JSON.parse(localStorage.getItem("dadosFuncionarios")) || [];

  tabela.innerHTML = "";

  for (let i = 0; i < dadosFuncionarios.length; i++) {
    const funcionario = dadosFuncionarios[i];
    const row = document.createElement("tr");
    row.innerHTML = `
            <td>${i + 1}</td>
            <td>${funcionario.nome || "-"}</td>
            <td>${
              funcionario.dataNascimento
                ? formatarDataBrasileira(funcionario.dataNascimento)
                : "-"
            }</td>
            <td>${funcionario.cpf || "-"}</td>
            <td class="funcoes">
                <button><img src="../img/editar.png" alt="" width="100px"></button>
                <button class="btnExcluir" data-index="${i}"><img src="../img/excluir.png" alt=""></button>
            </td>
            <td><button style="font-size: 16px; text-decoration: underline;" class="btnMais" data-index="${i}">Mais ></button></td>
            `;

    const btnExcluir = row.querySelector(".btnExcluir");
    btnExcluir.addEventListener("click", function () {
      const indexExcluir = btnExcluir.getAttribute("data-index");
      const funcionarioNome =
      dadosFuncionarios[indexExcluir].nome || "Este Funcionário";
      
      const confirmacao = window.confirm(
        `Tem certeza que deseja excluir "${funcionarioNome}"?`
      );

      if (confirmacao) {
        dadosFuncionarios.splice(indexExcluir, 1);
        localStorage.setItem(
          "dadosFuncionarios",
          JSON.stringify(dadosFuncionarios)
        );
        alert("Funcionario Excluido com sucesso!");
        exibirFuncionarios();
      }
    });

    const btnMais = row.querySelector(".btnMais");
    btnMais.addEventListener("click", function () {
      const indexDetalhes = btnMais.getAttribute("data-index");
      const detalhesURL = `./detalhes/detalhes.html?index=${indexDetalhes}`;
      window.location.href = detalhesURL;
    });

    tabela.appendChild(row);
  }
}

exibirFuncionarios();
