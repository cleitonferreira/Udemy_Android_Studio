package nuvemapp.com.br.aulas_android_sqlite;

import android.support.v7.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class EnterPatientActivity extends AppCompatActivity {

    private Paciente paciente = new Paciente();
    private EditText nomeEt;
    private EditText emailEt;
    private EditText senhaEt;
    private Button salvarBt;
    private Button editarBt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inserir_paciente);

        nomeEt = (EditText) findViewById(R.id.editTextNome);
        emailEt = (EditText) findViewById(R.id.editTextEmail);
        senhaEt = (EditText) findViewById(R.id.editTextSenha);
        salvarBt = (Button) findViewById(R.id.buttonSalvar);
        editarBt = (Button) findViewById(R.id.buttonEditar);

        Intent intent = getIntent();
        if(intent != null){
            Bundle bundle = intent.getExtras();
            if(bundle != null){

                paciente.setId(bundle.getLong("id"));
                paciente.setNome(bundle.getString("nome"));
                paciente.setEmail(bundle.getString("email"));

                nomeEt.setText(paciente.getNome());
                emailEt.setText(paciente.getEmail());

                senhaEt.setVisibility(View.INVISIBLE);
                salvarBt.setVisibility(View.INVISIBLE);
                editarBt.setVisibility(View.VISIBLE);

            }
        }
    }

    public void salvar(View view){
        paciente.setNome(nomeEt.getText().toString());
        paciente.setEmail(emailEt.getText().toString());
        paciente.setSenha(senhaEt.getText().toString());

        DataBase bd = new DataBase(this);
        bd.inserir(paciente);

        Toast.makeText(this, "Paciente inserido com sucesso!", Toast.LENGTH_SHORT).show();
    }


    public void editar(View view){
        paciente.setNome(nomeEt.getText().toString());
        paciente.setEmail(emailEt.getText().toString());

        DataBase bd = new DataBase(this);
        bd.atualizar(paciente);

        Toast.makeText(this, "Paciente \""+paciente.getNome()+"\" atualizado com sucesso.", Toast.LENGTH_SHORT).show();
    }

}



