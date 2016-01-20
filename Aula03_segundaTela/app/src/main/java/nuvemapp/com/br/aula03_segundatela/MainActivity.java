package nuvemapp.com.br.aula03_segundatela;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button botaoA = (Button) findViewById(R.id.botaoA);


        botaoA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setContentView(R.layout.segundatela);
            }
        });



    }


    public void chamaTela(View view){
        setContentView(R.layout.segundatela);
    }



}
