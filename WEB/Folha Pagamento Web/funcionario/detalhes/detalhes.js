document.addEventListener("DOMContentLoaded", function () {
    function getIndexFromURL() {
      const urlParams = new URLSearchParams(window.location.search);
      const index = urlParams.get("index");
      return index;
    }
  
    function exibirDetalhesFuncionario() {
      const index = getIndexFromURL();
      const dadosFuncionarios = JSON.parse(localStorage.getItem("dadosFuncionarios")) || [];
  
      if (index !== null && index >= 0 && index < dadosFuncionarios.length) {
        const funcionario = dadosFuncionarios[index];
        const nome = funcionario.nome || "Este funcionário";
  
        const funcionarioNomeElement = document.getElementById("funcionarioNome");
        funcionarioNomeElement.textContent = nome;
  
        const dadosEmpresa = document.querySelector(".dados-funcionario");
        dadosEmpresa.innerHTML = `
          <label for=""><b>Matricula:</b> ${funcionario.id || "-"}</label>
          <label for=""><b>CPF:</b> ${funcionario.cpf || "-"}</label>
          <label for=""><b>Nome:</b> ${nome}</label>
          <label for=""><b>Data de Nascimento:</b> ${funcionario.dataNascimento || "-"}</label>
          <label for=""><b>Nome da Mãe:</b> ${funcionario.nomeMae || "-"}</label>
          <label for=""><b>RG:</b> ${funcionario.rg || "-"}</label>
          <label for=""><b>Telefone:</b> ${funcionario.telefone || "-"}</label>
          <label for=""><b>Endereço:</b> ${funcionario.endereco || "-"}</label>
          <label for=""><b>Cidade:</b> ${funcionario.cidade || "-"}</label>
          <label for=""><b>UF:</b> ${funcionario.uf || "-"}</label>
          <label for=""><b>Banco:</b> ${funcionario.banco || "-"}</label>
          <label for=""><b>Agência:</b> ${funcionario.agencia || "-"}</label>
          <label for=""><b>Conta:</b> ${funcionario.conta || "-"}</label>
          <label for=""><b>Cargo:</b> ${funcionario.cargo || "-"}</label>
          <label for=""><b>Salário:</b> ${funcionario.salario || "-"}</label>
          <label for=""><b>Área:</b> ${funcionario.area || "-"}</label>
          <label for=""><b>Tipo de Contrato:</b> ${funcionario.tipoContrato || "-"}</label>
          <label for=""><b>Data de Admissão:</b> ${funcionario.dataAdmissao || "-"}</label>
          <label for=""><b>Escolaridade:</b> ${funcionario.escolaridade || "-"}</label>
          <label for=""><b>Horário:</b> ${funcionario.horario || "-"}</label>
          <label for=""><b>Escala:</b> ${funcionario.escala || "-"}</label>
          <label for=""><b>Nacionalidade:</b> ${funcionario.nacionalidade || "-"}</label>
          <label for=""><b>Naturalidade:</b> ${funcionario.naturalidade || "-"}</label>
          <label for=""><b>Número da CTPS:</b> ${funcionario.numeroCTPS || "-"}</label>
          <label for=""><b>Número do PIS:</b> ${funcionario.numeroPis || "-"}</label>
          <label for=""><b>Número da Reservista:</b> ${funcionario.numeroReservista || "-"}</label>
          <label for=""><b>Número do Título de Eleitor:</b> ${funcionario.numeroTituloEleitor || "-"}</label>
          <label for=""><b>Seção do Título de Eleitor:</b> ${funcionario.secaoTituloEleitor || "-"}</label>
          <label for=""><b>Zona do Título de Eleitor:</b> ${funcionario.zonaTituloEleitor || "-"}</label>
          <label for=""><b>Patente Sindical:</b> ${funcionario.opatanteSindical || "-"}</label>
          <label for=""><b>Hora por Mês:</b> ${funcionario.horaMes || "-"}</label>
        `;
      } else {
        alert("Funcionário não encontrado");
        window.location.href = "./funcionario.html";
      }
    }
  
    exibirDetalhesFuncionario();
  });
  