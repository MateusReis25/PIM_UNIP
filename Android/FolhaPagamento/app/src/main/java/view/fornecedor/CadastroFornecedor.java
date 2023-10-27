package view.fornecedor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.os.Bundle;
import android.text.Editable;
import android.text.Selection;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.folhapagamento.R;
import com.example.folhapagamento.dao.FornecedorDAO;
import com.example.folhapagamento.model.Fornecedor;

import java.sql.SQLException;

import view.funcionario.CadastroFuncionario;
import view.funcionario.FuncionariosActivity;

public class CadastroFornecedor extends AppCompatActivity {

    private EditText inputCNPJ;
    private EditText inputNomeFantasia;
    private EditText inputRazaoSocial;
    private EditText inputInscricaoEstadual;
    private EditText inputEmail;
    private EditText inputTelefone;
    private EditText inputEndereco;
    private EditText inputCidade;
    private EditText inputUF;
    private EditText inputBanco;
    private EditText inputAgencia;
    private EditText inputConta;
    private TextView textViewTitulo;
    private TextView textViewValidacao;
    private Button btnCadastrarFornecedor;
    private Button btnVoltarCadastroFornecedor;

    Fornecedor fornecedoresEdit = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_fornecedor);

        inputCNPJ = findViewById(R.id.inputCnpj);
        inputNomeFantasia = findViewById(R.id.inputNomeFantasia);
        inputRazaoSocial = findViewById(R.id.inputRazaoSocial);
        inputInscricaoEstadual = findViewById(R.id.inputInscricaoEstadual);
        inputEmail = findViewById(R.id.inputEmail);
        inputTelefone = findViewById(R.id.inputTelefone);
        inputEndereco = findViewById(R.id.inputEndereco);
        inputCidade = findViewById(R.id.inputCidade);
        inputUF = findViewById(R.id.inputUF);
        inputBanco = findViewById(R.id.inputBanco);
        inputAgencia = findViewById(R.id.inputAgencia);
        inputConta = findViewById(R.id.inputConta);
        textViewTitulo = findViewById(R.id.textViewTitulo);
        textViewValidacao = findViewById(R.id.textViewValidacaoFornecedor);
        btnCadastrarFornecedor = findViewById(R.id.btnCadastrarFornecedor);
        btnVoltarCadastroFornecedor = findViewById(R.id.btnVoltarCadastroFornecedor);

        btnCadastrarFornecedor.setEnabled(false);


        inputCNPJ.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (charSequence.length() == 18) {
                    btnCadastrarFornecedor.setEnabled(true);
                    btnCadastrarFornecedor.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorHabilitado)));
                    textViewValidacao.setText("");
                } else {
                    btnCadastrarFornecedor.setEnabled(false);
                    btnCadastrarFornecedor.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorDesabilitado)));
                    textViewValidacao.setText("CNPJ Inválido!");
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {
                String text = editable.toString();

                if (text.length() == 2 && text.charAt(1) != '.') {
                    editable.insert(2, ".");
                } else if (text.length() == 6 && text.charAt(5) != '.') {
                    editable.insert(6, ".");
                } else if (text.length() == 10 && text.charAt(9) != '/') {
                    editable.insert(10, "/");
                } else if (text.length() == 15 && text.charAt(13) != '-') {
                    editable.insert(15, "-");
                }
            }
        });

        inputInscricaoEstadual.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (charSequence.length() == 13) {
                    btnCadastrarFornecedor.setEnabled(true);
                    btnCadastrarFornecedor.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorHabilitado)));
                    textViewValidacao.setText("");
                } else {
                    btnCadastrarFornecedor.setEnabled(false);
                    btnCadastrarFornecedor.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorDesabilitado)));
                    textViewValidacao.setText("Inscrição Estadual Inválido!");
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {
                String text = editable.toString();

                if (text.length() == 3 && text.charAt(2) == '.') {
                    editable.delete(2, 3);
                } else if (text.length() == 7 && text.charAt(6) == '.') {
                    editable.delete(6, 7);
                } else if (text.length() == 11 && text.charAt(10) == '.') {
                    editable.delete(10, 11);
                }

                // Insere pontos se o usuário não apagar
                if (text.length() == 4 && text.charAt(3) != '.') {
                    editable.insert(3, ".");
                } else if (text.length() == 8 && text.charAt(7) != '.') {
                    editable.insert(7, ".");
                } else if (text.length() == 12 && text.charAt(11) != '.') {
                    editable.insert(11, ".");
                }
            }

        });

        inputTelefone.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (charSequence.length() >= 14) {
                    btnCadastrarFornecedor.setEnabled(true);
                    btnCadastrarFornecedor.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorHabilitado)));
                    textViewValidacao.setText("");
                } else {
                    btnCadastrarFornecedor.setEnabled(false);
                    btnCadastrarFornecedor.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorDesabilitado)));
                    textViewValidacao.setText("Telefone Inválido!");
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {
                if (editable.length() == 1) {
                    editable.insert(0, "(");
                } else if (editable.length() == 3) {
                    editable.insert(3, ") ");
                } else if (editable.length() == 10 ) {
                    editable.insert(10, "-");
                }
            }
        });

        btnCadastrarFornecedor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    salvar();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                } catch (ClassNotFoundException e) {
                    throw new RuntimeException(e);
                }
                alterarTela();
            }
        });

        btnVoltarCadastroFornecedor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alterarTela();
            }
        });

        carregaBundle();

    }

    private void salvar() throws SQLException, ClassNotFoundException {
        Fornecedor fornecedor = new Fornecedor();

        if (fornecedoresEdit != null) {
            fornecedor = fornecedoresEdit;
        }

        fornecedor.setCnpj(inputCNPJ.getText().toString());
        fornecedor.setNomeFantasia(inputNomeFantasia.getText().toString());
        fornecedor.setRazaoSocial(inputRazaoSocial.getText().toString());
        fornecedor.setInscricaoEstadual(inputInscricaoEstadual.getText().toString());
        fornecedor.setEmail(inputEmail.getText().toString());
        fornecedor.setTelefone(inputTelefone.getText().toString());
        fornecedor.setEndereco(inputEndereco.getText().toString());
        fornecedor.setCidade(inputCidade.getText().toString());
        fornecedor.setUf(inputUF.getText().toString());
        fornecedor.setBanco(inputBanco.getText().toString());
        fornecedor.setAgencia(inputAgencia.getText().toString());
        fornecedor.setConta(inputConta.getText().toString());

        FornecedorDAO dao = new FornecedorDAO();



        if (fornecedoresEdit != null) {
            dao.atualizarFornecedor(fornecedor);
            Toast.makeText(this, fornecedor.getNomeFantasia() + " atualizado com sucesso!", Toast.LENGTH_SHORT).show();
        } else {
            dao.cadastrarFornecedor(fornecedor);
            Toast.makeText(this, fornecedor.getNomeFantasia() + " cadastrado com sucesso!", Toast.LENGTH_SHORT).show();
        }
    }

    private void carregaBundle() {
        FornecedorDAO dao = new FornecedorDAO();
        Bundle bundle = getIntent().getExtras();

        if (bundle != null) {
            if (bundle.get("id") != null) {
                Long id = (Long) bundle.get("id");
                fornecedoresEdit = dao.carregaFornecedorPorId(id);
                if (fornecedoresEdit != null) {
                    mostra(fornecedoresEdit);
                }
            }
        }
    }

    private void mostra(Fornecedor fornecedor) {
        textViewTitulo.setText("Atualização de Fornecedor");
        inputCNPJ.setText(fornecedor.getCnpj());
        inputNomeFantasia.setText(fornecedor.getNomeFantasia());
        inputRazaoSocial.setText(fornecedor.getRazaoSocial());
        inputInscricaoEstadual.setText(fornecedor.getInscricaoEstadual());
        inputEmail.setText(fornecedor.getEmail());
        inputTelefone.setText(fornecedor.getTelefone());
        inputEndereco.setText(fornecedor.getEndereco());
        inputCidade.setText(fornecedor.getCidade());
        inputUF.setText(fornecedor.getUf());
        inputBanco.setText(fornecedor.getBanco());
        inputAgencia.setText(fornecedor.getAgencia());
        inputConta.setText(fornecedor.getConta());
    }

    private void alterarTela(){
        Intent intent = new Intent(CadastroFornecedor.this, Fornecedores.class);
        startActivity(intent);
    }
}