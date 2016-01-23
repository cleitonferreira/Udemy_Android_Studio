package nuvemapp.com.br.aulas_android_swipescreen;

import android.view.GestureDetector;
import android.app.Activity;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;

/**
 * Created by XPredator on 23/01/2016.
 */
public class filtroGestos extends GestureDetector.SimpleOnGestureListener {

    public final static int SWIPE_CIMA    = 1;
    public final static int SWIPE_BAIXO  = 2;
    public final static int SWIPE_ESQUERDA  = 3;
    public final static int SWIPE_DIREITA = 4;

    public final static int MODE_TRANSPARENT = 0;
    public final static int MODE_SOLID       = 1;
    public final static int MODE_DYNAMIC     = 2;

    private final static int ACTION_FAKE = -13; //um número improvável
    private int swipe_Min_Distance = 100;
    private int swipe_Max_Distance = 350;
    private int swipe_Min_Velocity = 100;

    private int mode             = MODE_DYNAMIC;
    private boolean running      = true;
    private boolean tapIndicator = false;

    private Activity context;
    private GestureDetector detector;
    private SimpleGestureListener listener;

    public filtroGestos(Activity context,SimpleGestureListener sgl) {

        this.context = context;
        this.detector = new GestureDetector(context, this);
        this.listener = sgl;
    }

    public void onTouchEvent(MotionEvent event){

        if(!this.running)
            return;

        boolean result = this.detector.onTouchEvent(event);

        if(this.mode == MODE_SOLID)
            event.setAction(MotionEvent.ACTION_CANCEL);
        else if (this.mode == MODE_DYNAMIC) {

            if(event.getAction() == ACTION_FAKE)
                event.setAction(MotionEvent.ACTION_UP);
            else if (result)
                event.setAction(MotionEvent.ACTION_CANCEL);
            else if(this.tapIndicator){
                event.setAction(MotionEvent.ACTION_DOWN);
                this.tapIndicator = false;
            }

        }
        //Senão não faça nada
    }

    public void setMode(int m){
        this.mode = m;
    }

    public int getMode(){
        return this.mode;
    }

    public void setEnabled(boolean status){
        this.running = status;
    }

    public void setSwipeMaxDistance(int distance){
        this.swipe_Max_Distance = distance;
    }

    public void setSwipeMinDistance(int distance){
        this.swipe_Min_Distance = distance;
    }

    public void setSwipeMinVelocity(int distance){
        this.swipe_Min_Velocity = distance;
    }

    public int getSwipeMaxDistance(){
        return this.swipe_Max_Distance;
    }

    public int getSwipeMinDistance(){
        return this.swipe_Min_Distance;
    }

    public int getSwipeMinVelocity(){
        return this.swipe_Min_Velocity;
    }

    @Override
    public boolean onFling(MotionEvent event1, MotionEvent event2, float velocityX,
                           float velocityY) {

        final float xDistance = Math.abs(event1.getX() - event2.getX());
        final float yDistance = Math.abs(event1.getY() - event2.getY());

        if(xDistance > this.swipe_Max_Distance || yDistance > this.swipe_Max_Distance)
            return false;

        velocityX = Math.abs(velocityX);
        velocityY = Math.abs(velocityY);
        boolean result = false;

        if(velocityX > this.swipe_Min_Velocity && xDistance > this.swipe_Min_Distance){
            if(event1.getX() > event2.getX()) // esquerda para direita
                this.listener.onSwipe(SWIPE_ESQUERDA);
            else
                this.listener.onSwipe(SWIPE_DIREITA);

            result = true;
        }
        else if(velocityY > this.swipe_Min_Velocity && yDistance > this.swipe_Min_Distance){
            if(event1.getY() > event2.getY()) // baixo para cima
                this.listener.onSwipe(SWIPE_CIMA);
            else
                this.listener.onSwipe(SWIPE_BAIXO);

            result = true;
        }

        return result;
    }

    @Override
    public boolean onSingleTapUp(MotionEvent e) {
        this.tapIndicator = true;
        return false;
    }

    @Override
    public boolean onDoubleTap(MotionEvent arg) {
        this.listener.onDoubleTap();
        return true;
    }

    @Override
    public boolean onDoubleTapEvent(MotionEvent arg) {
        return true;
    }

    @Override
    public boolean onSingleTapConfirmed(MotionEvent arg) {

        if(this.mode == MODE_DYNAMIC){
            arg.setAction(ACTION_FAKE);
            this.context.dispatchTouchEvent(arg);
        }

        return false;
    }

    static interface SimpleGestureListener{
        void onSwipe(int direction);
        void onDoubleTap();
    }

}