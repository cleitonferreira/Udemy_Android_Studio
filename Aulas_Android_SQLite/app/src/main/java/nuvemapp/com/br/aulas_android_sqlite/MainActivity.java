package nuvemapp.com.br.aulas_android_sqlite;

import android.support.v7.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void getActv(View view){
        Button button = (Button) view;
        Intent intent;

        if(button.getText().toString().equalsIgnoreCase("Inserir")){
            intent = new Intent(this, EnterPatientActivity.class);
        }
        else{
            intent = new Intent(this, ListPatientActivity.class);
        }

        startActivity(intent);
    }

}

