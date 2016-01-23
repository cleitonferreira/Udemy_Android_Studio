package nuvemapp.com.br.aulas_android_gesturedetector;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v4.view.GestureDetectorCompat;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements GestureDetector.OnGestureListener, GestureDetector.OnDoubleTapListener {

    private TextView gestureDetector;
    private GestureDetectorCompat gestureDetectorCompat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gestureDetector = (TextView)findViewById(R.id.gestureDetector);

        this.gestureDetectorCompat = new GestureDetectorCompat(this,this);
        gestureDetectorCompat.setOnDoubleTapListener(this);
    }

    @Override
    public boolean onDown (MotionEvent e){
        gestureDetector.setText("onDown");
        return true;
    }

    @Override
    public boolean onFling (MotionEvent e1, MotionEvent e2, float velocityX, float velocityY){
        gestureDetector.setText("onFling");
        return true;
    }

    @Override
    public void onLongPress(MotionEvent e){
        gestureDetector.setText("onLongPress");

    }

    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY){
        gestureDetector.setText("onScroll");
        return true;
    }

    @Override
    public void onShowPress(MotionEvent e){
        gestureDetector.setText("onShowPress");
    }

    @Override
    public boolean onSingleTapUp(MotionEvent e){
        gestureDetector.setText("onSingleTapUp");
        return true;
    }

    @Override
    public boolean onSingleTapConfirmed(MotionEvent e){
        gestureDetector.setText("onSingleTapConfirmed");
        return true;
    }

    @Override
    public boolean onDoubleTap(MotionEvent e){
        gestureDetector.setText("onDoubleTap");
        return true;
    }

    @Override
    public boolean onDoubleTapEvent(MotionEvent e){
        gestureDetector.setText("onDoubleTapEvent");
        return true;
    }

    @Override
    public boolean onTouchEvent(MotionEvent e){
        this.gestureDetectorCompat.onTouchEvent(e);
        return super.onTouchEvent(e);
    }

}
