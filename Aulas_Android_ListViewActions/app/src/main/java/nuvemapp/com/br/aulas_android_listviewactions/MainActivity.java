package nuvemapp.com.br.aulas_android_listviewactions;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private ListView listView;
    private AdapterListView adapterListView;
    private ArrayList<ItemListView> itens;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //carrega o layout onde contem o ListView
        setContentView(R.layout.activity_main);

        //Pega a referencia do ListView
        listView = (ListView) findViewById(R.id.listView);
        //Define o Listener quando alguem clicar no item.
        listView.setOnItemClickListener(this);

        createListView();
    }

    private void createListView() {
        //Criamos nossa lista que preenchera o ListView
        itens = new ArrayList<ItemListView>();
        ItemListView item1 = new ItemListView("Felpudo", R.drawable.felpudo);
        ItemListView item2 = new ItemListView("Felpudão", R.drawable.felpudo1);
        ItemListView item3 = new ItemListView("Felpudinho", R.drawable.felpudo2);

        itens.add(item1);
        itens.add(item2);
        itens.add(item3);

        //Cria o adapter
        adapterListView = new AdapterListView(this, itens);

        //Define o Adapter
        listView.setAdapter(adapterListView);
        //Cor quando a lista é selecionada para ralagem.
        listView.setCacheColorHint(Color.TRANSPARENT);
    }

    public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
        //Pega o item que foi selecionado.
        ItemListView item = adapterListView.getItem(arg2);
        //Demostração
        Toast.makeText(this, "Você Clicou em: " + item.getTexto(), Toast.LENGTH_LONG).show();
    }

    public void deletaItem(View v) {
        adapterListView.removeItem((Integer) v.getTag());
    }

    public void editaItem(View v) {
        //Posição na lista
        final int selecionado = (Integer) v.getTag();

        //Pega o item que foi selecionado.
        final ItemListView item = adapterListView.getItem(selecionado);

        final AlertDialog.Builder alert = new AlertDialog.Builder(this);
        final EditText input = new EditText(this);
        input.setText(item.getTexto());
        alert.setView(input);
        alert.setPositiveButton("Alterar", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
                String value = input.getText().toString().trim();
                item.setTexto(value);

                itens.set(selecionado, item);

                adapterListView.updateItens(itens);
            }
        });

        alert.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
                dialog.cancel();
            }
        });

        alert.show();
    }


}


