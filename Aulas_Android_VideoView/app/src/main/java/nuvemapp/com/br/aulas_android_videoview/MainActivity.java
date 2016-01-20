package nuvemapp.com.br.aulas_android_videoview;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.MediaController;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        VideoView video = (VideoView) findViewById(R.id.videoView);

        //Acessar o Video atraves de um servidor web
        //Uri src = Uri.parse("rtsp://r5---sn-p5qlsu7s.c.youtube.com/CiILENy73wIaGQm-9k0PLfxyHBMYDSANFEgGUgZ2aWRlb3MM/0/0/0/video.3gp");
        //video.setVideoURI(src);

        Uri src = Uri.parse("android.resource://nuvemapp.com.br.aulas_android_videoview/raw/felpudo");
        video.setVideoURI(src);

        video.setMediaController(new MediaController(this));


    }
}
