document.addEventListener("DOMContentLoaded", function () {
    // Verifica se há um funcionário selecionado no localStorage
    const funcionarioSelecionado = JSON.parse(localStorage.getItem("funcionarioSelecionado"));

    if (funcionarioSelecionado) {
        // Preenche os campos do formulário com os dados do funcionário
        document.getElementById("inputNome").value = funcionarioSelecionado.nome || "";
        document.getElementById("inputNomeMae").value = funcionarioSelecionado.nomeMae || "";
        document.getElementById("inputNacionalidade").value = funcionarioSelecionado.nacionalidade || "";
        document.getElementById("inputEmail").value = funcionarioSelecionado.email || "";
        document.getElementById("inputEndereco").value = funcionarioSelecionado.endereco || "";
        document.getElementById("inputDataNascimento").value = funcionarioSelecionado.dataNascimento || "";
        document.getElementById("inputNaturalidade").value = funcionarioSelecionado.naturalidade || "";
        document.getElementById("inputEscolaridade").value = funcionarioSelecionado.escolaridade || "";
        document.getElementById("inputTelefone").value = funcionarioSelecionado.telefone || "";
        document.getElementById("inputCidade").value = funcionarioSelecionado.cidade || "";
        document.getElementById("inputUf").value = funcionarioSelecionado.uf || "";

        document.getElementById("inputNumeroPis").value = funcionarioSelecionado.numeroPis || "";
        document.getElementById("inputNumeroCTPS").value = funcionarioSelecionado.numeroCTPS || "";
        document.getElementById("inputCpf").value = funcionarioSelecionado.cpf || "";
        document.getElementById("inputRg").value = funcionarioSelecionado.rg || "";
        document.getElementById("inputNumeroReservista").value = funcionarioSelecionado.numeroReservista || "";
        document.getElementById("inputNumeroTituloEleitor").value = funcionarioSelecionado.numeroTituloEleitor || "";
        document.getElementById("inputZonaTituloEleitor").value = funcionarioSelecionado.zonaTituloEleitor || "";
        document.getElementById("inputSecaoTituloEleitor").value = funcionarioSelecionado.secaoTituloEleitor || "";

        document.getElementById("inputBanco").value = funcionarioSelecionado.banco || "";
        document.getElementById("inputAgencia").value = funcionarioSelecionado.agencia || "";
        document.getElementById("inputConta").value = funcionarioSelecionado.conta || "";

        document.getElementById("inputCargo").value = funcionarioSelecionado.cargo || "";
        document.getElementById("inputArea").value = funcionarioSelecionado.area || "";
        document.getElementById("inputDataAdmissao").value = funcionarioSelecionado.dataAdmissao || "";
        document.getElementById("inputHorario").value = funcionarioSelecionado.horario || "";
        document.getElementById("inputEscala").value = funcionarioSelecionado.escala || "";
        document.getElementById("inputSalario").value = funcionarioSelecionado.salario || "";
        document.getElementById("inputHoraMes").value = funcionarioSelecionado.horaMes || "";
        document.getElementById("inputTipoContrato").value = funcionarioSelecionado.tipoContrato || "";
        document.getElementById("inputOpatanteSindical").value = funcionarioSelecionado.opatanteSindical || "";
    }

    btnAtualizarFuncionario.addEventListener("click", function (e) {
        e.preventDefault(); // Evita que o formulário seja enviado
    
        // Coleta os valores dos campos do formulário
        const funcionarioAtualizado = {
           nome: document.getElementById("inputNome").value,
            nomeMae: document.getElementById("inputNomeMae").value,
            nacionalidade: document.getElementById("inputNacionalidade").value,
            email: document.getElementById("inputEmail").value,
            endereco: document.getElementById("inputEndereco").value,
            dataNascimento: document.getElementById("inputDataNascimento").value,
            naturalidade: document.getElementById("inputNaturalidade").value,
            escolaridade: document.getElementById("inputEscolaridade").value,
            telefone: document.getElementById("inputTelefone").value,
            cidade: document.getElementById("inputCidade").value,
            uf: document.getElementById("inputUf").value,
            numeroPis: document.getElementById("inputNumeroPis").value,
            numeroCTPS: document.getElementById("inputNumeroCTPS").value,
            cpf: document.getElementById("inputCpf").value,
            rg: document.getElementById("inputRg").value,
            numeroReservista: document.getElementById("inputNumeroReservista").value,
            numeroTituloEleitor: document.getElementById("inputNumeroTituloEleitor").value,
            zonaTituloEleitor: document.getElementById("inputZonaTituloEleitor").value,
            secaoTituloEleitor: document.getElementById("inputSecaoTituloEleitor").value,
            banco: document.getElementById("inputBanco").value,
            agencia: document.getElementById("inputAgencia").value,
            conta: document.getElementById("inputConta").value,
            cargo: document.getElementById("inputCargo").value,
            area: document.getElementById("inputArea").value,
            dataAdmissao: document.getElementById("inputDataAdmissao").value,
            horario: document.getElementById("inputHorario").value,
            escala: document.getElementById("inputEscala").value,
            salario: document.getElementById("inputSalario").value,
            horaMes: document.getElementById("inputHoraMes").value,
            tipoContrato: document.getElementById("inputTipoContrato").value,
            opatanteSindical: document.getElementById("inputOpatanteSindical").value,
        };
    
        // Atualiza os dados do funcionário no localStorage
        const funcionarioSelecionado = JSON.parse(localStorage.getItem("funcionarioSelecionado"));
    
        if (funcionarioSelecionado) {
            // Atualiza os campos do funcionário selecionado
            for (const key in funcionarioAtualizado) {
                funcionarioSelecionado[key] = funcionarioAtualizado[key];
            }
    
            // Salva o funcionário atualizado de volta no localStorage
            localStorage.setItem("funcionarioSelecionado", JSON.stringify(funcionarioSelecionado));
    
            // Redireciona de volta para a página principal
            window.location.href = "../funcionario.html";
        }
    });
    
});
