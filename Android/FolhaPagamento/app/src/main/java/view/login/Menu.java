package view.login;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.folhapagamento.DetalhesPagamento;
import com.example.folhapagamento.Pagamento;
import com.example.folhapagamento.R;

import view.fornecedor.Fornecedores;
import view.funcionario.FuncionariosActivity;
import view.usuario.CadastroUsuario;

public class Menu extends AppCompatActivity {

    TextView textViewUser;

    Button btnSairMenu, btnFuncionarios, btnCadastroUsuario, btnFornecedores, btnPagamentoMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        textViewUser = findViewById(R.id.textViewUser);
        btnSairMenu = findViewById(R.id.btnSairMenu);
        btnFuncionarios = findViewById(R.id.btnFuncionariosMenu);
        btnCadastroUsuario = findViewById(R.id.btnCadastrarUsuarioMenu);
        btnFornecedores = findViewById(R.id.btnFornecedoresMenu);
        btnPagamentoMenu = findViewById(R.id.btnPagamentoMenu);

        btnCadastroUsuario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Menu.this, CadastroUsuario.class);
                startActivity((intent));
                finish();
            }
        });

        btnSairMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Menu.this, MainActivity.class);
                startActivity(intent);
                finishAffinity();
            }
        });

        btnFuncionarios.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Menu.this, FuncionariosActivity.class);
                startActivity(intent);
            }
        });

        btnFornecedores.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Menu.this, Fornecedores.class);
                startActivity(intent);
            }
        });

        btnPagamentoMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Menu.this, Pagamento.class);
                startActivity(intent);
            }
        });

        Intent intent = getIntent();
        if (intent != null) {
            String nomeUsuario = intent.getStringExtra("usuario");
            if (nomeUsuario != null) {
                textViewUser.setText(nomeUsuario);
            }
        }
    }
}