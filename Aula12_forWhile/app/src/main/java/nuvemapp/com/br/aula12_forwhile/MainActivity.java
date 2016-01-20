package nuvemapp.com.br.aula12_forwhile;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView textoResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textoResultado = (TextView) findViewById(R.id.textoResultado);
        textoResultado.setText("");
    }

    public void clicaFor(View view){
        textoResultado.setText("");
        textoResultado.setTextColor(Color.GREEN);
        for (int i = 0; i <= 10; i++) {
            String stringInt = Integer.toString(i);
            textoResultado.append("For 0 a "+stringInt + "\n");
            textoResultado.refreshDrawableState();
        }
    }

    public void clicaWhile(View view){
        textoResultado.setText("");
        textoResultado.setTextColor(Color.YELLOW);
        int j = 0;
        while (j <= 10){
            String stringInt = Integer.toString(j);
            textoResultado.append("Nome posição "+stringInt + "\n");
            j++;
        }
    }

    public void clicaLimpar(View view){
        textoResultado.setText("");
    }
}
