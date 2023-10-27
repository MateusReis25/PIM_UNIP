package view.usuario;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


import androidx.appcompat.app.AppCompatActivity;

import com.example.folhapagamento.R;
import com.example.folhapagamento.dao.UserDAO;

import view.login.Menu;

public class CadastroUsuario extends AppCompatActivity {

    EditText inputCadastroUsuario, inputCadastroSenha, inputCadastroSenha2;
    TextView textViewSenhaDiferente;
    Button btnCadastroUsuario, btnVoltarCadastroUsuario;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_usuario);

        inputCadastroUsuario = findViewById(R.id.inputCadastroUsuario);
        inputCadastroSenha = findViewById(R.id.inputCadastroUsuarioSenha);
        inputCadastroSenha2 = findViewById(R.id.inputCadastroUsuarioSenha2);

        textViewSenhaDiferente = findViewById(R.id.textViewSenhaDiferente);

        btnCadastroUsuario = findViewById(R.id.btnCadastroUsuario);
        btnVoltarCadastroUsuario = findViewById(R.id.btnVoltarCadastroUsuario);

        btnVoltarCadastroUsuario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                voltar();
            }
        });

        btnCadastroUsuario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cadastroUsuario();
            }
        });
    }

    public void voltar(){
        Intent intent = new Intent(CadastroUsuario.this, Menu.class);
        startActivity((intent));
    }

    public void limparSenha(){
        inputCadastroSenha.setText("");
        inputCadastroSenha2.setText("");
        inputCadastroSenha.requestFocus();
    }

    public void limparInput(){
        inputCadastroSenha.setText("");
        inputCadastroSenha2.setText("");
        inputCadastroUsuario.requestFocus();
    }

    public void cadastroUsuario(){

        String usuario = inputCadastroUsuario.getText().toString();
        String senha = inputCadastroSenha.getText().toString();
        String senha2 = inputCadastroSenha2.getText().toString();

        UserDAO userDAO = new UserDAO();

        if (senha.equals(senha2) ){
            if (userDAO.userExists(usuario) == false){
                userDAO.createUser(usuario, senha);
                Intent intent = new Intent(CadastroUsuario.this, Menu.class);
                intent.putExtra("usuario", usuario);
                startActivity((intent));
            } else {
                textViewSenhaDiferente.setText("Usuário já cadastrado!");
                limparInput();
            }
        } else {
            textViewSenhaDiferente.setText("Senhas não conferem!");
            limparSenha();
        }
    }
}