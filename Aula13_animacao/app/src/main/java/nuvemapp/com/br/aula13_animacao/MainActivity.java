package nuvemapp.com.br.aula13_animacao;

import android.graphics.drawable.AnimationDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private ImageView imagemFelpudo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        imagemFelpudo = (ImageView)findViewById(R.id.imagemFelpudo);
        imagemFelpudo.setBackgroundResource(R.drawable.sequenciaanimacao);

        AnimationDrawable anima = (AnimationDrawable)imagemFelpudo.getBackground();
        anima.start();

    }

    public void clicaPlay(View v){

        Animation desloca = new TranslateAnimation(300,10,0,300);
        desloca.setFillAfter(true);
        desloca.setDuration(1500);

        imagemFelpudo.startAnimation(desloca);
    }
}
