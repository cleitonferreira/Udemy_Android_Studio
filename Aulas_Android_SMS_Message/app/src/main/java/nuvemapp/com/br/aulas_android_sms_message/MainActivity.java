package nuvemapp.com.br.aulas_android_sms_message;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText editTelefone;
    EditText editMensagem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editMensagem = (EditText) findViewById(R.id.editMensagem);
        editTelefone = (EditText) findViewById(R.id.editTelefone);
    }

    public void enviarMensagem(View v){

        String numeroTelefone = editTelefone.getText().toString();
        String sms = editMensagem.getText().toString();

        try{
            SmsManager smsManager = SmsManager.getDefault();
            smsManager.sendTextMessage(numeroTelefone, null, sms, null, null);
            Toast.makeText(getApplicationContext(), "Mensagem Enviada", Toast.LENGTH_SHORT).show();
        } catch (Exception e){
            Toast.makeText(getApplicationContext(), "Falha no Envio - Tente Novamente", Toast.LENGTH_SHORT).show();
            e.printStackTrace();
        }
    }

}

