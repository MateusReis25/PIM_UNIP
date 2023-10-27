package view.fornecedor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.example.folhapagamento.R;
import com.example.folhapagamento.adapter.ListaFornecedorAdapter;
import com.example.folhapagamento.dao.FornecedorDAO;
import com.example.folhapagamento.model.Fornecedor;

import java.util.List;

import view.login.Menu;

public class Fornecedores extends AppCompatActivity {

    TextView inputPesquisaFornecedor;
    Button btnPesquisarFornecedor;
    ListView listViewFornecedores;
    ListaFornecedorAdapter adapter;
    List<Fornecedor> lista;
    Button btnCadastrarFornecedor, btnVoltarFornecedor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fornecedores);

        inputPesquisaFornecedor = findViewById(R.id.inputPesquisaPagamento);
        btnPesquisarFornecedor = findViewById(R.id.btnPesquisarPagamento);
        listViewFornecedores = findViewById(R.id.listViewPagamento);
        btnCadastrarFornecedor = findViewById(R.id.btnCadastrarFuncionario);
        btnVoltarFornecedor = findViewById(R.id.btnVoltarFornecedor);

        preenche("");

        btnPesquisarFornecedor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                preenche(inputPesquisaFornecedor.getText().toString());
            }
        });

        btnCadastrarFornecedor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Fornecedores.this, CadastroFornecedor.class);
                startActivity(intent);
            }
        });

        btnVoltarFornecedor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Fornecedores.this, Menu.class);
                startActivity(intent);
            }
        });

       listViewFornecedores.setOnItemClickListener(new AdapterView.OnItemClickListener() {
           @Override
           public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
               Intent intent = new Intent(Fornecedores.this, DetalhesFornecedor.class);

               Fornecedor fornecedor = (Fornecedor) adapterView.getItemAtPosition(i);

               intent.putExtra("fornecedor", fornecedor.getId());
               startActivity(intent);
           }
       });
    }

    private void preenche(String busca) {
        FornecedorDAO fornecedorDAO = new FornecedorDAO();

        if (busca.isEmpty()) {
            lista = fornecedorDAO.getAllFornecedores();
        } else {
            lista = fornecedorDAO.getFornecedoresByNome(busca);
        }

        adapter = new ListaFornecedorAdapter(lista, this);
        listViewFornecedores.setAdapter(adapter);
    }
}