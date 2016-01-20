package nuvemapp.com.br.aula09_tabwidget;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TabHost;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TabHost tabHost=(TabHost)findViewById(R.id.tabHost);
        tabHost.setup();

        TabHost.TabSpec aba1=tabHost.newTabSpec("PRIMEIRA");
        aba1.setContent(R.id.PRIMEIRA);
        aba1.setIndicator("PRIMEIRA");

        TabHost.TabSpec aba2=tabHost.newTabSpec("SEGUNDA");
        aba2.setContent(R.id.SEGUNDA);
        aba2.setIndicator("SEGUNDA");

        TabHost.TabSpec aba3=tabHost.newTabSpec("TERCEIRA");
        aba3.setContent(R.id.TERCEIRA);
        aba3.setIndicator("TERCEIRA");

        tabHost.addTab(aba1);
        tabHost.addTab(aba2);
        tabHost.addTab(aba3);




    }
}
