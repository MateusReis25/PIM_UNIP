package view.funcionario;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.folhapagamento.R;
import com.example.folhapagamento.dao.FuncionarioDAO;
import com.example.folhapagamento.model.Funcionario;

import java.sql.SQLException;
import java.text.SimpleDateFormat;

public class DetalhesFuncionario extends AppCompatActivity {

    TextView textMatricula;
    TextView textViewNome;
    TextView textViewDataNascimento;
    TextView textViewNomeMae;
    TextView textViewSexo;
    TextView textViewNaturalidade;
    TextView textViewNacionalidade;
    TextView textViewEscolaridade;
    TextView textViewEmail;
    TextView textViewTelefone;
    TextView textViewEndereco;
    TextView textViewCidade;
    TextView textViewUF;
    TextView textViewNumeroPIS;
    TextView textViewNumeroCTPS;
    TextView textViewCPF;
    TextView textViewRG;
    TextView textViewNumeroReservista;
    TextView textViewNumeroTituloEleitor;
    TextView textViewZonaTituloEleitor;
    TextView textViewSecaoTituloEleitor;
    TextView textViewBanco;
    TextView textViewAgencia;
    TextView textViewConta;
    TextView textViewCargo;
    TextView textViewArea;
    TextView textViewDataAdmissao;
    TextView textViewHorario;
    TextView textViewEscala;
    TextView textViewSalario;
    TextView textViewHoraMes;
    TextView textViewTipoContrato;
    TextView textViewOpatanteSindical;

    Button btnVoltarDetalhesFuncionario, btnAtualizarFuncionario, btnDeletarFuncionario;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhes_funcionario);

        textMatricula = findViewById(R.id.textMatricula);
        textViewNome = findViewById(R.id.textViewCnpj);
        textViewDataNascimento = findViewById(R.id.textViewDataNascimento);
        textViewNomeMae = findViewById(R.id.textViewNomeMae);
        textViewSexo = findViewById(R.id.textViewSexo);
        textViewNaturalidade = findViewById(R.id.textViewNaturalidade);
        textViewNacionalidade = findViewById(R.id.textViewNacionalidade);
        textViewEscolaridade = findViewById(R.id.textViewEscolaridade);
        textViewEmail = findViewById(R.id.textViewEmail);
        textViewTelefone = findViewById(R.id.textViewTelefone);
        textViewEndereco = findViewById(R.id.textViewEndereco);
        textViewCidade = findViewById(R.id.textViewCidade);
        textViewUF = findViewById(R.id.textViewUF);
        textViewNumeroPIS = findViewById(R.id.textViewNumeroPIS);
        textViewNumeroCTPS = findViewById(R.id.textViewNumeroCTPS);
        textViewCPF = findViewById(R.id.textViewCPF);
        textViewRG = findViewById(R.id.textViewRG);
        textViewNumeroReservista = findViewById(R.id.textViewNumeroReservista);
        textViewNumeroTituloEleitor = findViewById(R.id.textViewNumeroTituloEleitor);
        textViewZonaTituloEleitor = findViewById(R.id.textViewZonaTituloEleitor);
        textViewSecaoTituloEleitor = findViewById(R.id.textViewSecaoTituloEleitor);
        textViewBanco = findViewById(R.id.textViewBanco);
        textViewAgencia = findViewById(R.id.textViewAgencia);
        textViewConta = findViewById(R.id.textViewConta);
        textViewCargo = findViewById(R.id.textViewCargo);
        textViewArea = findViewById(R.id.textViewArea);
        textViewDataAdmissao = findViewById(R.id.textViewDataAdmissao);
        textViewHorario = findViewById(R.id.textViewHorario);
        textViewEscala = findViewById(R.id.textViewEscala);
        textViewSalario = findViewById(R.id.textViewSalario);
        textViewHoraMes = findViewById(R.id.textViewHoraMes);
        textViewTipoContrato = findViewById(R.id.textViewTipoContrato);
        textViewOpatanteSindical = findViewById(R.id.textViewOpatanteSindical);
        btnVoltarDetalhesFuncionario = findViewById(R.id.btnVoltarDetalhesFuncionario);
        btnAtualizarFuncionario = findViewById(R.id.btnAtualizarFuncionario);
        btnDeletarFuncionario = findViewById(R.id.btnDeletarFornecedor);

        btnVoltarDetalhesFuncionario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DetalhesFuncionario.this, FuncionariosActivity.class);
                startActivity((intent));
            }
        });


        long matricula = getIntent().getLongExtra("funcionario", 0);

        if (matricula != 0) {
            preenche(matricula);
        } else {
            Toast.makeText(this, "Funcionário não encontrado", Toast.LENGTH_SHORT).show();
        }

        btnAtualizarFuncionario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DetalhesFuncionario.this, CadastroFuncionario.class);
                intent.putExtra("matricula", matricula);
                startActivity((intent));
            }
        });

        btnDeletarFuncionario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                excluir(matricula);
            }
        });


    }

    private void preenche(Long matricula) {
        FuncionarioDAO funcionarioDAO = new FuncionarioDAO();

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

        Funcionario funcionario = funcionarioDAO.carregaPorId(matricula);

        if (funcionario != null) {
            textMatricula.setText(matricula.toString());
            textViewNome.setText(funcionario.getNome());
            textViewDataNascimento.setText(dateFormat.format(funcionario.getDataNascimento()));
            textViewNomeMae.setText(funcionario.getNomeMae());
            textViewSexo.setText(funcionario.getSexo());
            textViewNaturalidade.setText(funcionario.getNaturalidade());
            textViewNacionalidade.setText(funcionario.getNacionalidade());
            textViewEscolaridade.setText(funcionario.getEscolaridade());
            textViewEmail.setText(funcionario.getEmail());
            textViewTelefone.setText(funcionario.getTelefone());
            textViewEndereco.setText(funcionario.getEndereco());
            textViewCidade.setText(funcionario.getCidade());
            textViewUF.setText(funcionario.getUf());
            textViewNumeroPIS.setText(funcionario.getNumeroPis());
            textViewNumeroCTPS.setText(funcionario.getNumeroCTPS());
            textViewCPF.setText(String.format("%s.%s.%s-%s", funcionario.getCpf().substring(0, 3), funcionario.getCpf().substring(3, 6), funcionario.getCpf().substring(6, 9), funcionario.getCpf().substring(9, 11)));
            textViewRG.setText(String.format("%s.%s.%s-%s", funcionario.getRg().substring(0, 2), funcionario.getRg().substring(2, 5), funcionario.getRg().substring(5, 8), funcionario.getRg().substring(8)));
            textViewNumeroReservista.setText(funcionario.getNumeroReservista());
            textViewNumeroTituloEleitor.setText(funcionario.getNumeroTituloEleitor());
            textViewZonaTituloEleitor.setText(funcionario.getZonaTituloEleitor());
            textViewSecaoTituloEleitor.setText(funcionario.getSecaoTituloEleitor());
            textViewBanco.setText(funcionario.getBanco());
            textViewAgencia.setText(funcionario.getAgencia().toString());
            textViewConta.setText(funcionario.getConta().toString());
            textViewCargo.setText(funcionario.getCargo());
            textViewArea.setText(funcionario.getArea());
            textViewDataAdmissao.setText(dateFormat.format(funcionario.getDataAdmisão()));
            textViewHorario.setText(funcionario.getHorario().toString());
            textViewEscala.setText(funcionario.getEscala());
            textViewSalario.setText(String.format("R$ %.2f", funcionario.getSalario()));
            textViewHoraMes.setText(funcionario.getHoraMes().toString());
            textViewTipoContrato.setText(funcionario.getTipoContrato());
            textViewOpatanteSindical.setText(funcionario.getOpatanteSindical());
        }
    }

    private void excluir(Long matricula) {

        if ( matricula != 0) {
            Funcionario funcionario = new Funcionario();

            AlertDialog.Builder alert = new AlertDialog.Builder(this);
            alert.setTitle("Remover");
            alert.setMessage( "Deseja realmente excluir esse funcionário?");
            alert.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    FuncionarioDAO dao = new FuncionarioDAO();
                    try {
                        dao.deletar(matricula);
                        dialogInterface.dismiss();

                        Intent intent = new Intent(DetalhesFuncionario.this, FuncionariosActivity.class);
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