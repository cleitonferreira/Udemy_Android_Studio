package nuvemapp.com.br.aula14_switchradio;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private RadioGroup radioGroup;
    private RadioButton radioButton;

    private TextView statusSwitch;
    private Switch controleSwitch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        radioGroup = (RadioGroup) findViewById(R.id.radioGroup);

        statusSwitch = (TextView) findViewById(R.id.textView);
        controleSwitch = (Switch) findViewById(R.id.switch1);


        controleSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if (isChecked) {
                    controleSwitch.setText("Ligago");
                } else {
                    controleSwitch.setText("Desligado");
                }
            }
        });

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

               switch (checkedId) {
                   case R.id.radioButton:
                       statusSwitch.setText("Opção A - papai");
                       break;
                   case R.id.radioButton2:
                       statusSwitch.setText("Opção B - felpudo");
                       break;
                   case R.id.radioButton3:
                       statusSwitch.setText("Opção C - todos");
                       break;

               }
            }
        });

    }
}
