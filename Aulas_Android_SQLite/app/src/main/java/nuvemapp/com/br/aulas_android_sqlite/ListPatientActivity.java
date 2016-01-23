package nuvemapp.com.br.aulas_android_sqlite;

import android.app.ListActivity;
import android.os.Bundle;

import java.util.List;

public class ListPatientActivity extends ListActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_listar_paciente);

        DataBase bd = new DataBase(this);

        List<Paciente> list = bd.buscar();
        setListAdapter(new PacienteAdapter(this, list));
    }
}

