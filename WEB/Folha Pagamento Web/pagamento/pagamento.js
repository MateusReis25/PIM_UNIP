document.addEventListener("DOMContentLoaded", function () {
  function buscarFuncionarioPorId(id) {
    const dadosFuncionarios =
      JSON.parse(localStorage.getItem("dadosFuncionarios")) || [];

    const funcionarioEncontrado = dadosFuncionarios.find(
      (funcionario) => funcionario.id === id
    );

    return funcionarioEncontrado;
  }

  function formatarData(data) {
    const dataObj = new Date(data);
    const dia = String(dataObj.getDate()).padStart(2, "0");
    const mes = String(dataObj.getMonth() + 1).padStart(2, "0");
    const ano = dataObj.getFullYear();
    return `${dia}/${mes}/${ano}`;
  }

  function formatarTelefone(telefone) {
    const telefoneFormatado = telefone.replace(
      /(\d{2})(\d{5})(\d{4})/,
      "($1) $2-$3"
    );
    return telefoneFormatado;
  }

  function exibirDetalhesFuncionario() {
    const inputPesquisa = document.getElementById("inputPesquisa");
    const detalhesFuncionario = document.getElementById("detalhesFuncionario");
    const container2 = document.getElementById("container2");
    const impressora = document.getElementById("impressora");

    if (inputPesquisa.value === "") {
      alert("Por favor, insira um ID de funcionário válido.");
      return;
    }

    const idPesquisado = parseInt(inputPesquisa.value, 10);
    const funcionario = buscarFuncionarioPorId(idPesquisado);

    if (funcionario) {
      impressora.style.display = "flex";
      container2.style.display = "block";

      const fgts = funcionario.salario - 10;

      detalhesFuncionario.innerHTML = `
      
        <table>
        <thead>
        <div class="matriculaId">
            <p>Matricula: <b>${funcionario.id}</b></p>
        </div> 
        <tr>
            <th>Nome:</th>
            <td>${funcionario.nome || "-"}</td>
            <th>CPF:</th>
            <td>${funcionario.cpf || "-"}</td>
            <th>Telefone:</th>
            <td>${formatarTelefone(funcionario.telefone) || "-"}</td>
        </tr>
        <tr>
            <th>Cargo:</th>
            <td>${funcionario.cargo || "-"}</td>
            <th>Área:</th>
            <td>${funcionario.area || "-"}</td>
            <th>Data de admissão:</th>
            <td>${formatarData(funcionario.dataAdmissao) || "-"}</td>
        </tr>
        <tr>
            <th>Hora Mês:</th>
            <td>${funcionario.horaMes || "-"}</td>
            <th>Salário:</th>
            <td>${funcionario.salario || "-"}</td>
            <th>Tipo de contrato:</th>
            <td>${funcionario.tipoContrato || "-"}</td>
        </tr>
        </thead>
        </table>
        <table>
        <thead>
        <tr>
            <th>Cod.</th>
            <th>Descrição</th>
            <th>QTDE.</th>
            <th>Vencimentos</th>
            <th>Descontos</th>
        </tr>
        <tr>
            <td>1</td>
            <td>Salario Mensal</td>
            <td>31.00</td>
            <td>${funcionario.salario || "-"}</td>
            <td></td>
        </tr>
        <tr>
            <td>15</td>
            <td>I.N.S.S</td>
            <td>12.00</td>
            <td></td>
            <td>R$ 346,83</td>
        </tr>
        <tr>
            <td>181</td>
            <td>Vale transporte</td>
            <td>6.00</td>
            <td></td>
            <td>R$ 173,41</td>
        </tr>
        <tr>
            <td id="color">l</td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
        </tr>
        <tr>
            <td class="tdLimpo"></td>
            <th class="tdLimpo">Totais</th>
            <td></td>
            <td>${funcionario.salario || "-"}</td>
            <td>R$ 520,24</td>
        </tr>
        </thead>
        </table>

        <table>
        <thead>
        <tr>
            <th class="dadosBancarios">Banco</th>
            <th class="dadosBancarios">Agência</th>
            <th class="dadosBancarios">Conta</th>
            <th id="dadosBancarios">Liquído:</th>
            <td>${funcionario.salario || "-"}</td>
        </tr>
        <tr>
            <td class="tdLimpo">${funcionario.banco || "-"}</td>
            <td class="tdLimpo">${funcionario.agencia || "-"}</td>
            <td class="tdLimpo">${funcionario.conta || "-"}</td>
            <th id="tdLimpo">Data de Pagamento:</th>
            <td>30/05/2023</td>
        </tr>
        </thead>
        </table>
        <div class="footer">
        <table>
        <thead>
            <tr>
            <th class="dadosBancarios">Base INSS:</th>
            <td class="dadosBancarios">${funcionario.salario || "-"}</td>
            <th class="dadosBancarios">Base FGTS:</th>
            <td class="dadosBancarios">${funcionario.salario || "-"}</td>
            </tr>
            <tr>
            <th class="tdLimpo">Base IRRF:</th>
            <td class="tdLimpo">${funcionario.salario || "-"}</td>
            <th class="tdLimpo">Valor FGTS:</th>
            <td class="tdLimpo">${funcionario.salario || "-"}</td>
            </tr>
        </thead>
        </table>
        <table>
        <thead>
            <tr>
            <th>
                <p>Company Drink’s S.A.</p>
                <p>83.383.004/0001-23</p>
                <p>(11) 4585-8758 / (11) 95868-8578</p>
            </th>
            </tr>
        </thead>
        </table>
`;
    } else {
      alert("Funcionário não encontrado. Verifique o ID inserido.");
    }
  }

  const btnPesquisar = document.getElementById("btnPesquisar");
  btnPesquisar.addEventListener("click", exibirDetalhesFuncionario, );
});
