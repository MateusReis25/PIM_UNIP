package view.funcionario;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.folhapagamento.R;
import com.example.folhapagamento.adapter.ListaFuncionarioAdapter;
import com.example.folhapagamento.dao.FuncionarioDAO;
import com.example.folhapagamento.model.Funcionario;

import java.util.List;

import view.login.Menu;

public class FuncionariosActivity extends AppCompatActivity {

    TextView inputPesquisaFuncionario;
    Button btnPesquisarFuncionario;
    ListView listViewFuncionario;
    ListaFuncionarioAdapter adapter;
    List<Funcionario> lista;
    Button btnCadastrarFuncionario, btnVoltarFuncionario;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_funcionarios);

        inputPesquisaFuncionario = findViewById(R.id.inputPesquisaPagamento);
        btnPesquisarFuncionario = findViewById(R.id.btnPesquisarPagamento);
        listViewFuncionario = findViewById(R.id.listViewPagamento);
        btnCadastrarFuncionario=findViewById(R.id.btnCadastrarFuncionario);
        btnVoltarFuncionario = findViewById(R.id.btnVoltarFornecedor);

        preenche("");

        btnPesquisarFuncionario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                preenche(inputPesquisaFuncionario.getText().toString());
            }
        });

        btnCadastrarFuncionario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FuncionariosActivity.this, CadastroFuncionario.class);
                startActivity((intent));
            }
        });

        btnVoltarFuncionario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FuncionariosActivity.this, Menu.class);
                startActivity((intent));
            }
        });

        listViewFuncionario.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(FuncionariosActivity.this, DetalhesFuncionario.class);

                Funcionario funcionario = (Funcionario) adapterView.getItemAtPosition(i);

                intent.putExtra("funcionario", funcionario.getMatricula());
                startActivity((intent));
            }
        });
    }

    private void preenche(String busca) {
        FuncionarioDAO funcionarioDAO = new FuncionarioDAO();

        if (busca.isEmpty()){
            lista = funcionarioDAO.getAllFuncionarios();
        } else {
            lista = funcionarioDAO.getAllFuncionarios(busca);
        }

        adapter = new ListaFuncionarioAdapter(lista, this);
        listViewFuncionario.setAdapter(adapter);
    }
}