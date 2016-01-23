package nuvemapp.com.br.aulas_android_sqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBCore extends SQLiteOpenHelper {

    private static final String NOME_BD = "teste";
    private static final int VERSAO_BD = 7;


    public DBCore(Context ctx){
        super(ctx, NOME_BD, null, VERSAO_BD);
    }


    @Override
    public void onCreate(SQLiteDatabase bd) {
        bd.execSQL("create table paciente(_id integer primary key autoincrement, nome text not null, email text not null, senha text not null);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase bd, int arg1, int arg2) {
        bd.execSQL("drop table paciente;");
        onCreate(bd);
    }

}


