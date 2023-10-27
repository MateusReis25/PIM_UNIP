function exibirFornecedores() {
  const tabela = document.querySelector("table tbody");
  const dadosFornecedores =
    JSON.parse(localStorage.getItem("dadosFornecedores")) || [];

  tabela.innerHTML = "";

  for (let i = 0; i < dadosFornecedores.length; i++) {
    const fornecedor = dadosFornecedores[i];
    const row = document.createElement("tr");
    row.innerHTML = `
            <td>${i + 1}</td>
            <td>${fornecedor.cnpj || "-"}</td>
            <td>${fornecedor.nomeFantasia || "-"}</td>
            <td class="funcoes">
                <button><img src="../img/editar.png" alt="" width="100px"></button>
                <button class="btnExcluir" data-index="${i}"><img src="../img/excluir.png" alt=""></button>
            </td>
            <td><button style="font-size: 16px; text-decoration: underline;" class="btnMais" data-index="${i}">Mais ></button></td>

        `;

    const btnExcluir = row.querySelector(".btnExcluir");
    btnExcluir.addEventListener("click", function () {
      const indexExcluir = btnExcluir.getAttribute("data-index");
      const fornecedorNome =
        dadosFornecedores[indexExcluir].nomeFantasia || "Este fornecedor";

      const confirmacao = window.confirm(
        `Tem certeza que deseja excluir "${fornecedorNome}"?`
      );

      if (confirmacao) {
        dadosFornecedores.splice(indexExcluir, 1);
        localStorage.setItem(
          "dadosFornecedores",
          JSON.stringify(dadosFornecedores)
        );
        alert("Fornecedor Excluido com sucesso!");
        exibirFornecedores();
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

exibirFornecedores();
