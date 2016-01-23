package nuvemapp.com.br.aulas_android_multitouchapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RelativeLayout layout = (RelativeLayout) findViewById(R.id.RLayout);
        layout.setOnTouchListener(new RelativeLayout.OnTouchListener() {
                                      public boolean onTouch(View v, MotionEvent m) {
                                          handleTouch(m);
                                          return true;
                                      }
                                  }
        );
    }

    void handleTouch(MotionEvent m){
        TextView tView1 = (TextView)findViewById(R.id.tView1);
        TextView tView2 = (TextView)findViewById(R.id.tView2);

        int pointerCount = m.getPointerCount();

        for(int i = 0; i < pointerCount; i++){
            int x = (int) m.getX(i);
            int y = (int) m.getX(i);
            int id = m.getPointerId(i);
            int action = m.getActionMasked();
            int actionIndex = m.getActionIndex();
            String actionString;

            switch (action){
                case MotionEvent.ACTION_DOWN:
                    actionString = "Baixo";
                    break;
                case MotionEvent.ACTION_UP:
                    actionString = "Cima";
                    break;
                case MotionEvent.ACTION_POINTER_DOWN:
                    actionString = "Pointer Baixo";
                    break;
                case MotionEvent.ACTION_POINTER_UP:
                    actionString = "Pointer Cima";
                    break;
                case MotionEvent.ACTION_MOVE:
                    actionString = "Move";
                    break;
                default:
                    actionString = "";
            }
            String touchStatus = "Ação: " + actionString + " Índice: " + actionIndex + " ID: " + id + " X: " + x + " Y: " + y;

            if (id==0)
                tView1.setText(touchStatus);
            else
                tView2.setText(touchStatus);
        }

    }
}




