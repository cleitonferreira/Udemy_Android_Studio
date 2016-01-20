package nuvemapp.com.br.aula06_imagebuttonalerta;

import android.app.AlertDialog;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void alertaNormal(View view){

        //mostrar caixa de mensagem
        AlertDialog alertDialog;
        alertDialog = new AlertDialog.Builder(this).create();
        alertDialog.setTitle("Funcionou");
        alertDialog.setMessage("Botão Alerta 1");
        alertDialog.show();
    }


    public void alertaX(View view){

        //acessar botao
        Button b = (Button)view;

        //preparar mensagem
        String mensagem = "Você apertou o ";

        //adicionar o nome do botao a mensagem
        mensagem = mensagem.concat(b.getText().toString());


        //mostrar caixa de mensagem
        AlertDialog alertDialog;
        alertDialog = new AlertDialog.Builder(this).create();
        alertDialog.setTitle("Botão Apertado");
        alertDialog.setMessage(mensagem);
        alertDialog.show();
    }

}
