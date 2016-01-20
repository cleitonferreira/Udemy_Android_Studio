package nuvemapp.com.br.aula03_botaoaction;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        final TextView campoTexto = (TextView) findViewById(R.id.campoTexto);
        Button botaoTexto = (Button) findViewById(R.id.botaoTexto);
        Button botaoCor = (Button) findViewById(R.id.botaoCor);
        final RelativeLayout fundoTela = (RelativeLayout) findViewById(R.id.fundoTela);


        botaoTexto.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                campoTexto.setText("Cleiton Ferreira");
            }
        });

        botaoCor.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                fundoTela.setBackgroundColor(Color.parseColor("#0B9AE2"));
            }
        });






    }









}
