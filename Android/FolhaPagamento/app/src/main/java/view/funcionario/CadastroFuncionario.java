package view.funcionario;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.folhapagamento.R;
import com.example.folhapagamento.dao.FuncionarioDAO;
import com.example.folhapagamento.model.Funcionario;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class CadastroFuncionario extends AppCompatActivity {

    private EditText inputNome;
    private EditText inputDataNascimento;
    private EditText inputNomeMae;
    private Spinner spinnerSexo;
    private EditText inputNaturalidade;
    private EditText inputNacionalidade;
    private Spinner spinnerEscolaridade;
    private EditText inputEmail;
    private EditText inputTelefone;
    private EditText inputEndereco;
    private EditText inputCidade;
    private EditText inputUF;
    private EditText inputNumeroPIS;
    private EditText inputNumeroCTPS;
    private EditText inputCPF;
    private EditText inputRG;
    private EditText inputNumeroReservista;
    private EditText inputNumeroTituloEleitor;
    private EditText inputZonaTituloEleitor;
    private EditText inputSecaoTituloEleitor;
    private EditText inputBanco;
    private EditText inputAgencia;
    private EditText inputConta;
    private EditText inputCargo;
    private EditText inputArea;
    private EditText inputDataAdmissao;
    private EditText inputHorario;
    private EditText inputEscala;
    private EditText inputSalario;
    private EditText inputHoraMes;
    private Spinner spinnerTipoContrato;
    private Spinner spinnerOpatanteSindical;
    private TextView textViewTitulo;
    private TextView textMatriculaAtualizacao;
    private Button btnCadastrarFuncionario;
    private Button btnVoltarCadastroduncionario;

    Funcionario funcionarioEdit = null;

    SimpleDateFormat dateFormatBR = new SimpleDateFormat("dd/MM/yyyy");


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_funcionario);

        textViewTitulo = findViewById(R.id.textViewTitulo);
        textMatriculaAtualizacao = findViewById(R.id.textMatriculaAtualizacao);
        inputNome = findViewById(R.id.inputNome);
        inputDataNascimento = findViewById(R.id.inputDataNascimento);
        inputNomeMae = findViewById(R.id.inputNomeMae);
        spinnerSexo = findViewById(R.id.spinnerSexo);
        inputNaturalidade = findViewById(R.id.inputNaturalidade);
        inputNacionalidade = findViewById(R.id.inputNacionalidade);
        spinnerEscolaridade = findViewById(R.id.spinnerEscolaridade);
        inputEmail = findViewById(R.id.inputEmail);
        inputTelefone = findViewById(R.id.inputTelefone);
        inputEndereco = findViewById(R.id.inputEndereco);
        inputCidade = findViewById(R.id.inputCidade);
        inputUF = findViewById(R.id.inputUF);
        inputNumeroPIS = findViewById(R.id.inputNumeroPIS);
        inputNumeroCTPS = findViewById(R.id.inputNumeroCTPS);
        inputCPF = findViewById(R.id.inputCPF);
        inputRG = findViewById(R.id.inputRG);
        inputNumeroReservista = findViewById(R.id.inputNumeroReservista);
        inputNumeroTituloEleitor = findViewById(R.id.inputNumeroTituloEleitor);
        inputZonaTituloEleitor = findViewById(R.id.inputZonaTituloEleitor);
        inputSecaoTituloEleitor = findViewById(R.id.inputSecaoTituloEleitor);
        inputBanco = findViewById(R.id.inputBanco);
        inputAgencia = findViewById(R.id.inputAgencia);
        inputConta = findViewById(R.id.inputConta);
        inputCargo = findViewById(R.id.inputCargo);
        inputArea = findViewById(R.id.inputArea);
        inputDataAdmissao = findViewById(R.id.inputDataAdmissao);
        inputHorario = findViewById(R.id.inputHorario);
        inputEscala = findViewById(R.id.inputEscala);
        inputSalario = findViewById(R.id.inputSalario);
        inputHoraMes = findViewById(R.id.inputHoraMes);
        spinnerTipoContrato = findViewById(R.id.spinnerTipoContrato);
        spinnerOpatanteSindical = findViewById(R.id.spinnerOpatanteSindical);
        btnCadastrarFuncionario = findViewById(R.id.btnCadastrarFuncionario);
        btnVoltarCadastroduncionario = findViewById(R.id.btnVoltarCadastroduncionario);

        // Spinner de Sexo
        Spinner spinnerSexo = findViewById(R.id.spinnerSexo);
        List<String> opcoesSexo = new ArrayList<>();
        opcoesSexo.add("Selecione...");
        opcoesSexo.add("Masculino");
        opcoesSexo.add("Feminino");
        ArrayAdapter<String> adapterSexo = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, opcoesSexo);
        adapterSexo.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerSexo.setAdapter(adapterSexo);

        spinnerSexo.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                String sexoSelecionado = opcoesSexo.get(position);
                // Lidar com a seleção do sexo, se necessário
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // Lidar com a falta de seleção, se necessário
            }
        });

        // Spinner de Escolaridade
        Spinner spinnerEscolaridade = findViewById(R.id.spinnerEscolaridade);
        List<String> opcoesEscolaridade = new ArrayList<>();
        opcoesEscolaridade.add("Selecione...");
        opcoesEscolaridade.add("Ensino Fundamental");
        opcoesEscolaridade.add("Ensino Médio");
        opcoesEscolaridade.add("Graduação");
        opcoesEscolaridade.add("Pós-graduação");
        opcoesEscolaridade.add("Mestrado");
        opcoesEscolaridade.add("Doutorado");
        ArrayAdapter<String> adapterEscolaridade = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, opcoesEscolaridade);
        adapterEscolaridade.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerEscolaridade.setAdapter(adapterEscolaridade);

        spinnerEscolaridade.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                String escolaridadeSelecionada = opcoesEscolaridade.get(position);
                // Lidar com a seleção da escolaridade, se necessário
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // Lidar com a falta de seleção, se necessário
            }
        });

        // Spinner de Tipo de Contrato
        Spinner spinnerTipoContrato = findViewById(R.id.spinnerTipoContrato);
        List<String> opcoesTipoContrato = new ArrayList<>();
        opcoesTipoContrato.add("Selecione...");
        opcoesTipoContrato.add("CLT");
        opcoesTipoContrato.add("PJ");
        ArrayAdapter<String> adapterTipoContrato = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, opcoesTipoContrato);
        adapterTipoContrato.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerTipoContrato.setAdapter(adapterTipoContrato);

        spinnerTipoContrato.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                String tipoContratoSelecionado = opcoesTipoContrato.get(position);
                // Lidar com a seleção do tipo de contrato, se necessário
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // Lidar com a falta de seleção, se necessário
            }
        });

        // Spinner de Optante Sindical
        Spinner spinnerOptanteSindical = findViewById(R.id.spinnerOpatanteSindical);
        List<String> opcoesOptanteSindical = new ArrayList<>();
        opcoesOptanteSindical.add("Selecione...");
        opcoesOptanteSindical.add("Sim");
        opcoesOptanteSindical.add("Não");
        ArrayAdapter<String> adapterOptanteSindical = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, opcoesOptanteSindical);
        adapterOptanteSindical.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerOptanteSindical.setAdapter(adapterOptanteSindical);

        spinnerOptanteSindical.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                String optanteSindicalSelecionado = opcoesOptanteSindical.get(position);
                // Lidar com a seleção de optante sindical, se necessário
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // Lidar com a falta de seleção, se necessário
            }
        });


        btnCadastrarFuncionario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    salvar();

                } catch (ParseException e) {
                    throw new RuntimeException(e);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                } catch (ClassNotFoundException e) {
                    throw new RuntimeException(e);
                }
                alterarTela();
            }
        });

        btnVoltarCadastroduncionario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alterarTela();
            }
        });

        carregaBundle();
    }

    private void salvar() throws ParseException, SQLException, ClassNotFoundException {
        Funcionario funcionario = new Funcionario();

        if (funcionarioEdit != null){
            funcionario = funcionarioEdit;
        }

        funcionario.setNome(inputNome.getText().toString());
        funcionario.setDataNascimento(new java.sql.Date(dateFormatBR.parse(inputDataNascimento.getText().toString()).getTime()));
        funcionario.setNomeMae(inputNomeMae.getText().toString());
        funcionario.setSexo(spinnerSexo.getSelectedItem().toString());
        funcionario.setNaturalidade(inputNaturalidade.getText().toString());
        funcionario.setNacionalidade(inputNacionalidade.getText().toString());
        funcionario.setEscolaridade(spinnerEscolaridade.getSelectedItem().toString());
        funcionario.setEmail(inputEmail.getText().toString());
        funcionario.setTelefone(inputTelefone.getText().toString());
        funcionario.setEndereco(inputEndereco.getText().toString());
        funcionario.setCidade(inputCidade.getText().toString());
        funcionario.setUf(inputUF.getText().toString());
        funcionario.setCpf(inputCPF.getText().toString());
        funcionario.setRg(inputRG.getText().toString());
        funcionario.setNumeroCTPS(inputNumeroCTPS.getText().toString());
        funcionario.setNumeroPis(inputNumeroPIS.getText().toString());
        funcionario.setNumeroTituloEleitor(inputNumeroTituloEleitor.getText().toString());
        funcionario.setNumeroReservista(inputNumeroReservista.getText().toString());
        funcionario.setZonaTituloEleitor(inputZonaTituloEleitor.getText().toString());
        funcionario.setSecaoTituloEleitor(inputSecaoTituloEleitor.getText().toString());
        funcionario.setBanco(inputBanco.getText().toString());
        funcionario.setAgencia(Integer.parseInt(inputAgencia.getText().toString()));
        funcionario.setConta(Integer.parseInt(inputConta.getText().toString()));
        funcionario.setCargo(inputCargo.getText().toString());
        funcionario.setArea(inputArea.getText().toString());
        funcionario.setDataAdmisão(new java.sql.Date(dateFormatBR.parse(inputDataAdmissao.getText().toString()).getTime()));
        funcionario.setHorario(Integer.parseInt(inputHorario.getText().toString()));
        funcionario.setEscala(inputEscala.getText().toString());
        funcionario.setSalario(Double.parseDouble(inputSalario.getText().toString()));
        funcionario.setHoraMes(Integer.parseInt(inputHoraMes.getText().toString()));
        funcionario.setTipoContrato(spinnerTipoContrato.getSelectedItem().toString());
        funcionario.setOpatanteSindical(spinnerOpatanteSindical.getSelectedItem().toString());

        FuncionarioDAO dao = new FuncionarioDAO();

        if (funcionarioEdit != null){
            dao.atualizar(funcionario);
            Toast.makeText(this, funcionario.getNome() + " atualizado com sucesso!", Toast.LENGTH_SHORT).show();
        } else {
            dao.cadastrar(funcionario);
            Toast.makeText(this, funcionario.getNome() + " cadastrado com sucesso!", Toast.LENGTH_SHORT).show();
        }
    }

    private void alterarTela() {
        Intent intent = new Intent(CadastroFuncionario.this, FuncionariosActivity.class);
        startActivity(intent);
    }

    private void carregaBundle() {
        FuncionarioDAO dao = new FuncionarioDAO();
        Bundle bundle = getIntent().getExtras();

        if (bundle != null) {
            if (bundle.get("matricula") != null) {
                Long matricula = (Long) bundle.get("matricula");
                funcionarioEdit = dao.carregaPorId(matricula);
                if (funcionarioEdit != null) {
                    mostra(funcionarioEdit);
                }
            }
        }
    }

    private int obterIndiceItemSpinner(Spinner spinner, String valor) {
        ArrayAdapter<String> adapter = (ArrayAdapter<String>) spinner.getAdapter();
        if (adapter != null) {
            for (int i = 0; i < adapter.getCount(); i++) {
                if (adapter.getItem(i).equals(valor)) {
                    return i;
                }
            }
        }
        return 0;
    }

    private void mostra(Funcionario funcionario) {
        textViewTitulo.setText("Atualização de Funcionário");
        textMatriculaAtualizacao.setText(funcionario.getMatricula().toString());
        inputNome.setText(funcionario.getNome());
        inputDataNascimento.setText(dateFormatBR.format(funcionario.getDataNascimento()));
        inputNomeMae.setText(funcionario.getNomeMae());
        spinnerSexo.setSelection(obterIndiceItemSpinner(spinnerSexo, funcionario.getSexo()));
        inputNaturalidade.setText(funcionario.getNaturalidade());
        inputNacionalidade.setText(funcionario.getNacionalidade());
        spinnerEscolaridade.setSelection(obterIndiceItemSpinner(spinnerEscolaridade, funcionario.getEscolaridade()));
        inputEmail.setText(funcionario.getEmail());
        inputTelefone.setText(funcionario.getTelefone());
        inputEndereco.setText(funcionario.getEndereco());
        inputCidade.setText(funcionario.getCidade());
        inputUF.setText(funcionario.getUf());
        inputNumeroPIS.setText(funcionario.getNumeroPis());
        inputNumeroCTPS.setText(funcionario.getNumeroCTPS());
        inputCPF.setText(funcionario.getCpf());
        inputRG.setText(funcionario.getRg());
        inputNumeroReservista.setText(funcionario.getNumeroReservista());
        inputNumeroTituloEleitor.setText(funcionario.getNumeroTituloEleitor());
        inputZonaTituloEleitor.setText(funcionario.getZonaTituloEleitor());
        inputSecaoTituloEleitor.setText(funcionario.getSecaoTituloEleitor());
        inputBanco.setText(funcionario.getBanco());
        inputAgencia.setText(funcionario.getAgencia().toString());
        inputConta.setText(funcionario.getConta().toString());
        inputCargo.setText(funcionario.getCargo());
        inputArea.setText(funcionario.getArea());
        inputDataAdmissao.setText(dateFormatBR.format(funcionario.getDataAdmisão()));
        inputHorario.setText(funcionario.getHorario().toString());
        inputEscala.setText(funcionario.getEscala());
        inputSalario.setText(String.valueOf(funcionario.getSalario()).toString());
        inputHoraMes.setText(funcionario.getHoraMes().toString());
        spinnerTipoContrato.setSelection(obterIndiceItemSpinner(spinnerTipoContrato, funcionario.getTipoContrato()));
        spinnerOpatanteSindical.setSelection(obterIndiceItemSpinner(spinnerOpatanteSindical, funcionario.getOpatanteSindical()));

    }
}