package com.example.meubizu.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.meubizu.R;
import com.example.meubizu.banco.RascunhosDAO;
import com.example.meubizu.model.Rascunho;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MateriaActivity extends AppCompatActivity {

    private String materia;
    private long id_materia;

    private ListView listView;
    ArrayAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_materia);

        Intent intent = getIntent();

        if(intent.hasExtra("materia")) {
            this.materia = (String) intent.getSerializableExtra("materia");
            this.id_materia = Rascunho.getIdDeUmaMateria(materia);
        }

        ArrayList<Rascunho> rascunhos = (ArrayList<Rascunho>) new RascunhosDAO(getBaseContext()).listarRascunhosByMateria(id_materia);
        adapter = new RascunhoAdapter(getBaseContext(),rascunhos);

        TextView titulo = findViewById(R.id.activity_materia_text_view);
        titulo.setText(materia);

        listView = findViewById(R.id.rascunhos_materia_list_view);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Rascunho rascunho = (Rascunho) adapterView.getItemAtPosition(i);
                Intent minhaIntent = new Intent(MateriaActivity.this, RascunhoActivity.class);
                Log.i("RascunhoIsNull","Chamou... Rascunho é null? "+(rascunho==null));
                minhaIntent.putExtra("rascunho", rascunho);
                startActivity(minhaIntent);
            }
        });

        registerForContextMenu(listView);

        FloatingActionButton add = (FloatingActionButton) findViewById(R.id.activity_materia_floating_action_button);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent newIntent = new Intent(getBaseContext(), FormularioActivity.class);
                newIntent.putExtra("materia",materia);
                startActivity(newIntent);
            }
        });
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.menu_item, menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {

        //RECUPERAR O ITEM DA LISTVIEW CLICADA
        AdapterView.AdapterContextMenuInfo contextMenuInfo =
                (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        Rascunho p = (Rascunho) adapter.getItem(contextMenuInfo.position);

        //VERIFICAR QUAL ITEM DO CONTEXT MENU FOI CLICADO
        //OPCAO EDITAR
        if(item.getItemId() == R.id.menu_editar){
            //CRIA A INTENT, ADD O PRODUTO E INICIA A ACITIVITY
            Log.i("SQLITE","ID: "+p.getId());
            Intent i = new Intent(getBaseContext(), FormularioActivity.class);
            i.putExtra("rascunho", p);
            startActivity(i);
        }

        //OPCAO APAGAR
        if(item.getItemId() == R.id.menu_apagar){
            //INICIA O BD, CHAMA O METODO APAGAR E ATUALIZA O ADAPTER CHAMANDO O ONRESUME
            RascunhosDAO bd = new RascunhosDAO(getBaseContext());
            bd.apagarRascunho(p);
            onResume();
        }

        return super.onContextItemSelected(item);


    }


    @Override
    public void onResume(){
        super.onResume();

        Log.i("Materia",id_materia+"");
        ArrayList<Rascunho> rascunhos = (ArrayList<Rascunho>) new RascunhosDAO(getBaseContext()).listarRascunhosByMateria(id_materia);
        adapter = new RascunhoAdapter(getBaseContext(),rascunhos);

        Log.i("MateriaSize",rascunhos.size()+"");

        listView.setAdapter(adapter);
    }

    @Override
    public void onBackPressed(){
        super.onBackPressed();

        finish();
    }
}