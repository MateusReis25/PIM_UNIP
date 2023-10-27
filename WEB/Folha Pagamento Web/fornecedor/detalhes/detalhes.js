document.addEventListener("DOMContentLoaded", function () {
  
  function getIndexFromURL() {
    const urlParams = new URLSearchParams(window.location.search);
    const index = urlParams.get("index");
    return index;
  }

  function exibirDetalhesFornecedor() {
    const index = getIndexFromURL();
    const dadosFornecedores = JSON.parse(localStorage.getItem("dadosFornecedores")) || [];

    if (index !== null && index >= 0 && index < dadosFornecedores.length) {
      const fornecedor = dadosFornecedores[index];
      const nomeFantasia = fornecedor.nomeFantasia || "Este fornecedor";

      const fornecedorNomeElement = document.getElementById("fornecedorNome");
      fornecedorNomeElement.textContent = nomeFantasia;

      const dadosEmpresa = document.querySelector(".dados-empresa");
      dadosEmpresa.innerHTML = `
        <label for=""><b>CNPJ:</b> ${fornecedor.cnpj || "-"}</label>
        <label for=""><b>Nome fantasia:</b> ${nomeFantasia}</label>
        <label for=""><b>Razão social:</b> ${fornecedor.razaoSocial || "-"}</label>
        <label for=""><b>Inscrição estadual:</b> ${fornecedor.inscricaoEstadual || "-"}</label>
        <label for=""><b>Email:</b> ${fornecedor.email || "-"}</label>
        <label for=""><b>Telefone:</b> ${fornecedor.telefone || "-"}</label>
        <label for=""><b>Endereco:</b> ${fornecedor.endereco || "-"}</label>
        <label for=""><b>Cidade:</b> ${fornecedor.cidade || "-"}</label>
        <label for=""><b>UF:</b> ${fornecedor.uf || "-"}</label>
        <label for=""><b>Banco para pagamento:</b> ${fornecedor.banco || "-"}</label>
        <label for=""><b>Agencia:</b> ${fornecedor.agencia || "-"}</label>
        <label for=""><b>Conta:</b> ${fornecedor.conta || "-"}</label>
      `;
    } else {
      alert("Fornecedor não encontrado");
      window.location.href = "./fornecedor.html"; 
    }
  }

  exibirDetalhesFornecedor();
});
