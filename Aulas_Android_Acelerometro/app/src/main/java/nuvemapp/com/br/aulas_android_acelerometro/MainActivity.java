package nuvemapp.com.br.aulas_android_acelerometro;

import android.app.Activity;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends Activity implements SensorEventListener {

    private TextView textViewX;
    private TextView textViewY;
    private TextView textViewZ;
    private TextView detalhes;
    private SensorManager sensorManager;
    private Sensor acelerometro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewX = (TextView) findViewById(R.id.textViewX);
        textViewY = (TextView) findViewById(R.id.textViewY);
        textViewZ = (TextView) findViewById(R.id.textViewZ);

        detalhes = (TextView) findViewById(R.id.detalhes);

        //Instância da classe SensorManager através do método abaixo
        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);

        //Definição do tipo de sensor que será utilizado
        acelerometro = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);

    }

    //Método que inicia a captura do acelerometro
    protected void onResume() {
        super.onResume();
        //Parâmetro SENSOR_DELAY_NORMAL define a velocidade da captura das informações
        sensorManager.registerListener(this, acelerometro, SensorManager.SENSOR_DELAY_NORMAL);
    }

    //Método para parar quando não houver interação do usuário, economizando bateria
    protected void onPause() {
        super.onPause();
        sensorManager.unregisterListener(this);
    }

    //Acionado se houver mudança na precisão do sensor do acelerômetro
    public void onAccuracyChanged(Sensor sensor, int accuracy){

    }

    //Acionado sempre quando houver mudança na posição do dispositivo, identificado pelo sensor
    public void onSensorChanged(SensorEvent event){
        Float x = event.values[0];
        Float y = event.values[1];
        Float z = event.values[2];

        textViewX.setText("Posição X: "+ x.intValue());
        textViewY.setText("Posição Y: " + y.intValue());
        textViewZ.setText("Posição Z: "+ z.intValue());

        if (y < 0) { //O celular está de cabeça para baixo
            if (x > 0){
                detalhes.setText("Esquerda \nInvertido");
            }
            if (x < 0) {
                detalhes.setText("Direita \nInvertido");
            }
        } else {
            if (x > 0){
                detalhes.setText("Esquerda ");
            }
            if (x < 0) {
                detalhes.setText("Direita ");
            }
        }
    }


}
