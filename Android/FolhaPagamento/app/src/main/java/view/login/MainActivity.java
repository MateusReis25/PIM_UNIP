package view.login;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.folhapagamento.R;
import com.example.folhapagamento.dao.UserDAO;
import com.example.folhapagamento.model.User;

public class MainActivity extends AppCompatActivity {

    EditText inputUsuario, inputSenha;
    TextView textViewSenhaIncorreta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputUsuario = findViewById(R.id.inputCadastroUsuario);
        inputSenha = findViewById(R.id.inputCadastroUsuarioSenha);
        textViewSenhaIncorreta = findViewById(R.id.textViewSenhaIncorreta);
    }

    public void limpar() {
        inputSenha.setText("");
        inputUsuario.requestFocus();
    }

    public void login(View v) {
        String usuario = inputUsuario.getText().toString();
        String senha = inputSenha.getText().toString();

        User user = new UserDAO().selectUser(usuario, senha);

//        if (user != null) {
            Intent intent = new Intent(MainActivity.this, Menu.class);
            intent.putExtra("usuario", usuario);
            startActivity(intent);
            finish();
//        } else {
//            textViewSenhaIncorreta.setText("Usuário e/ou Senha incorreto!");
//            limpar();
//        }
    }
}
