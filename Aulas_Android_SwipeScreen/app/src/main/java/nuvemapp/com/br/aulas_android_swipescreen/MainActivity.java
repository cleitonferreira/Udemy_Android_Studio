package nuvemapp.com.br.aulas_android_swipescreen;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements filtroGestos.SimpleGestureListener{

    private filtroGestos detect;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Detecta area tocada
        detect = new filtroGestos(this,this);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent motionEvent){
        // Chama o método onTouchEvent da classe filtroGestos
        this.detect.onTouchEvent(motionEvent);
        return super.dispatchTouchEvent(motionEvent);
    }
    @Override
    public void onSwipe(int swipeDirection) {
        String str = "";

        switch (swipeDirection) {

            case filtroGestos.SWIPE_DIREITA : str = "Swipe Esquerda para Direita";
                break;
            case filtroGestos.SWIPE_ESQUERDA :  str = "Swipe Direita para Esquerda";
                break;
            case filtroGestos.SWIPE_BAIXO :  str = "Swipe Cima para Baixo";
                break;
            case filtroGestos.SWIPE_CIMA :    str = "Swipe Baixo para Cima";
                break;

        }
        Toast.makeText(this, str, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onDoubleTap() {
        Toast.makeText(this, "Toque Duplo", Toast.LENGTH_SHORT).show();
    }

}