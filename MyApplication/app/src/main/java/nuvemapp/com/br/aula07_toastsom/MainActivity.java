package nuvemapp.com.br.aula07_toastsom;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void clicaToastCurto(View view){
        //mostrar mensagem toast
        Toast toast = Toast.makeText(MainActivity.this, "Curto Toast", Toast.LENGTH_SHORT);
        toast.show();
    }

    public void clicaToastLongo(View view){
        //mostrar mensagem toast
        Toast toast = Toast.makeText(MainActivity.this, "Longo Toast", Toast.LENGTH_LONG);
        toast.show();
    }

    public void clicaSom(View view){
        //reproduzir som
        MediaPlayer som = MediaPlayer.create(this, R.raw.pegaitem);
        som.start();
    }


}
