package nuvemapp.com.br.aulas_android_vibrate;

import android.content.Context;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void vibra(View view) {
        vibrate();
    }

    private void vibrate() {
        Vibrator vv = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        // intensidade da vibração
        long milisec = 40;
        vv.vibrate(milisec);
    }
}
