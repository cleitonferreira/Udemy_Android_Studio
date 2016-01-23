package nuvemapp.com.br.aulas_android_sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;


public class DataBase {

    private SQLiteDatabase bd;

    public DataBase(Context context){
        DBCore auxBd = new DBCore(context);
        bd = auxBd.getWritableDatabase();
    }


    public void inserir(Paciente paciente){
        ContentValues valores = new ContentValues();
        valores.put("nome", paciente.getNome());
        valores.put("email", paciente.getEmail());
        valores.put("senha", paciente.getSenha());

        bd.insert("paciente", null, valores);
    }


    public void atualizar(Paciente paciente){
        ContentValues valores = new ContentValues();
        valores.put("nome", paciente.getNome());
        valores.put("email", paciente.getEmail());

        bd.update("paciente", valores, "_id = ?", new String[]{""+paciente.getId()});
    }


    public void deletar(Paciente paciente){
        bd.delete("paciente", "_id = "+paciente.getId(), null);
    }


    public List<Paciente> buscar(){
        List<Paciente> list = new ArrayList<Paciente>();
        String[] colunas = new String[]{"_id", "nome", "email"};

        Cursor cursor = bd.query("paciente", colunas, null, null, null, null, "nome ASC");

        if(cursor.getCount() > 0){
            cursor.moveToFirst();

            do{

                Paciente p = new Paciente();
                p.setId(cursor.getLong(0));
                p.setNome(cursor.getString(1));
                p.setEmail(cursor.getString(2));
                list.add(p);

            }while(cursor.moveToNext());
        }

        return(list);
    }
}

