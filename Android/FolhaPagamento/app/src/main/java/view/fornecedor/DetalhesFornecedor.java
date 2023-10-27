package view.fornecedor;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.folhapagamento.R;
import com.example.folhapagamento.dao.FornecedorDAO;
import com.example.folhapagamento.model.Fornecedor;

import java.sql.SQLException;

import view.funcionario.CadastroFuncionario;
import view.funcionario.DetalhesFuncionario;
import view.funcionario.FuncionariosActivity;

public class DetalhesFornecedor extends AppCompatActivity {

    private TextView textId;
    private TextView textViewCnpj;
    private TextView textViewNomeFantasia;
    private TextView textViewRazaoSocialDetalhes;
    private TextView textViewRazaoSocial;
    private TextView textViewInscricaoEstadualDetalhes;
    private TextView textViewInscricaoEstadual;
    private TextView textViewEmailDetalhes;
    private TextView textViewEmail;
    private TextView textViewTelefoneDetalhes;
    private TextView textViewTelefone;
    private TextView textViewEnderecoDetalhes;
    private TextView textViewEndereco;
    private TextView textViewCidadeDetalhes;
    private TextView textViewCidade;
    private TextView textViewUFDetalhes;
    private TextView textViewUF;
    private TextView textViewBanco;
    private TextView textViewConta;
    private TextView textViewAgencia;
    private Button btnVoltarDetalhesFornecedor;
    private Button btnAtualizarFornecedor;
    private Button btnDeletarFornecedor;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhes_fornecedor);

        textId = findViewById(R.id.textId);
        textViewCnpj = findViewById(R.id.textViewCnpj);
        textViewNomeFantasia = findViewById(R.id.textViewNomeFantasia);
        textViewRazaoSocialDetalhes = findViewById(R.id.textViewRazaoSocialDetalhes);
        textViewRazaoSocial = findViewById(R.id.textViewRazaoSocial);
        textViewInscricaoEstadualDetalhes = findViewById(R.id.textViewInscricaoEstadualDetalhes);
        textViewInscricaoEstadual = findViewById(R.id.textViewInscricaoEstadual);
        textViewEmailDetalhes = findViewById(R.id.textViewEmailDetalhes);
        textViewEmail = findViewById(R.id.textViewEmail);
        textViewTelefoneDetalhes = findViewById(R.id.textViewTelefoneDetalhes);
        textViewTelefone = findViewById(R.id.textViewTelefone);
        textViewEnderecoDetalhes = findViewById(R.id.textViewEnderecoDetalhes);
        textViewEndereco = findViewById(R.id.textViewEndereco);
        textViewCidadeDetalhes = findViewById(R.id.textViewCidadeDetalhes);
        textViewCidade = findViewById(R.id.textViewCidade);
        textViewUFDetalhes = findViewById(R.id.textViewUFDetalhes);
        textViewUF = findViewById(R.id.textViewUF);
        textViewBanco = findViewById(R.id.textViewBanco);
        textViewConta = findViewById(R.id.textViewConta);
        textViewAgencia = findViewById(R.id.textViewAgencia);

        btnVoltarDetalhesFornecedor = findViewById(R.id.btnVoltarDetalhesFornecedor);
        btnAtualizarFornecedor = findViewById(R.id.btnAtualizarFornecedor);
        btnDeletarFornecedor = findViewById(R.id.btnDeletarFornecedor);

        btnVoltarDetalhesFornecedor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DetalhesFornecedor.this, Fornecedores.class);
                startActivity((intent));
            }
        });

        long id = getIntent().getLongExtra("fornecedor", 0);

        if (id != 0) {
            preenche(id);
        } else {
            Toast.makeText(this, "Fornecedor não encontrado", Toast.LENGTH_SHORT).show();
        }

        btnAtualizarFornecedor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DetalhesFornecedor.this, CadastroFornecedor.class);
                intent.putExtra("id", id);
                startActivity((intent));
            }
        });

        btnDeletarFornecedor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                excluirFornecedor(id);
            }
        });

    }

    private void preenche(Long id) {
        FornecedorDAO fornecedorDAO = new FornecedorDAO();

        Fornecedor fornecedor = fornecedorDAO.carregaFornecedorPorId(id);

        if (fornecedor != null) {
            textId.setText(String.valueOf(fornecedor.getId()));
            textViewCnpj.setText(fornecedor.getCnpj());
            textViewNomeFantasia.setText(fornecedor.getNomeFantasia());
            textViewRazaoSocial.setText(fornecedor.getRazaoSocial());
            textViewInscricaoEstadual.setText(fornecedor.getInscricaoEstadual());
            textViewEmail.setText(fornecedor.getEmail());
            textViewTelefone.setText(fornecedor.getTelefone());
            textViewEndereco.setText(fornecedor.getEndereco());
            textViewCidade.setText(fornecedor.getCidade());
            textViewUF.setText(fornecedor.getUf());
            textViewBanco.setText(fornecedor.getBanco());
            textViewAgencia.setText(fornecedor.getAgencia());
            textViewConta.setText(fornecedor.getConta());
        }
    }

    private void excluirFornecedor(Long id) {
        if (id != 0) {
            Fornecedor fornecedor = new Fornecedor();

            AlertDialog.Builder alert = new AlertDialog.Builder(this);
            alert.setTitle("Remover");
            alert.setMessage("Deseja realmente excluir esse fornecedor?");
            alert.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    FornecedorDAO dao = new FornecedorDAO();
                    try {
                        dao.deletarFornecedor(id);
                        dialogInterface.dismiss();

                        Intent intent = new Intent(DetalhesFornecedor.this, Fornecedores.class);
                        startActivity(intent);
                    } catch (SQLException e) {
                        throw new RuntimeException(e);
                    } catch (ClassNotFoundException e) {
                        throw new RuntimeException(e);
                    }
                }
            });

            alert.setNegativeButton("Não", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.dismiss();
                }
            });

            alert.show();
        }
    }
}