package nuvemapp.com.br.aula10_ifswitch;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText campoNumero;
    private EditText campoSenha;

    private TextView textoNumero;
    private TextView textoSenha;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        campoNumero = (EditText) findViewById(R.id.campoNumero);
        campoSenha = (EditText) findViewById(R.id.campoSenha);

        textoNumero = (TextView) findViewById(R.id.textoNumero);
        textoSenha = (TextView) findViewById(R.id.textoSenha);


    }

    public void clicaNumero(View view) {
        String valorEdit = campoNumero.getText().toString();
        int numEdit = Integer.parseInt(valorEdit);
        if (numEdit%2==0){
            textoNumero.setText("O número é par");
        } else {
            textoNumero.setText("O número é ímpar");
        }
    }

    public void clicaSenha(View view) {
        String senhaEdit = campoSenha.getText().toString();
        switch (senhaEdit){
            case "felpudo":
                textoSenha.setText("Senha Correta!");
                break;
            case "Felpudo":
                textoSenha.setText("Senha Correta!");
                break;
            case "FELPUDO":
                textoSenha.setText("Senha Correta!");
                break;
            case "Felpudinho":
                textoSenha.setText("Senha Correta!");
                break;
            default:
                textoSenha.setText("Senha Incorreta!");
                break;
        }
    }

}
