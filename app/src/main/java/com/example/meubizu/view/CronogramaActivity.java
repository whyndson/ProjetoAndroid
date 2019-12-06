package com.example.meubizu.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;

import com.example.meubizu.R;
import com.example.meubizu.model.Semana;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;
import com.example.meubizu.banco.SemanaBD;


public class CronogramaActivity extends AppCompatActivity {

    //CRIA O ADAPTER
    private ArrayAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cronograma);

        //CRIA O ADAPTER QUE SERA UTILIZADO
        adapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1);

        //RECUPERA A LISTVIEW E ADD O ADAPTER
        ListView listView = findViewById(R.id.listview_cronogramaativity);
        listView.setAdapter(adapter);

        //Registar Menu de contexto para listview
        registerForContextMenu(listView);

        //CONFIGURAR AÇÃO DA LISTVIEW
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Semana s = (Semana) parent.getAdapter().getItem(position);
                Intent i = new Intent(CronogramaActivity.this, FormularioCronogramaActivity.class);
                i.putExtra("semana", s);
                startActivity(i);
            }
        });



        //CONFIGURA A ACAO DO BOTAO
        FloatingActionButton fbutton = findViewById(R.id.floating_button);
        fbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CronogramaActivity.this,
                        FormularioCronogramaActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();

        //RECUPERA A LISTA DE PRODUTOS DO BD
        List<Semana> lista = new SemanaBD(this).listSemanas();

        //LIMPAR A LISTA E ADCIONAR OS OBJETOS NOVAMENTE
        adapter.clear();
        adapter.addAll(lista);
    }

    //CRIAR CONTEXT MENU
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.menu_item, menu);
    }


    //ACAO DO CLICK PARA O CONTEXT MENU
    @Override
    public boolean onContextItemSelected(MenuItem item) {

        //RECUPERAR O ITEM DA LISTVIEW CLICADA
        AdapterView.AdapterContextMenuInfo contextMenuInfo =
                (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        Semana s = (Semana) adapter.getItem(contextMenuInfo.position);

        //VERIFICAR QUAL ITEM DO CONTEXT MENU FOI CLICADO
        //OPCAO EDITAR
        if(item.getItemId() == R.id.menu_editar){
            //CRIA A INTENT, ADD O PRODUTO E INICIA A ACITIVITY
            Intent i = new Intent(CronogramaActivity.this, FormularioCronogramaActivity.class);
            i.putExtra("semana", s);
            startActivity(i);
        }

        //OPCAO APAGAR
        if(item.getItemId() == R.id.menu_apagar){
            //INICIA O BD, CHAMA O METODO APAGAR E ATUALIZA O ADAPTER CHAMANDO O ONRESUME
            SemanaBD bd = new SemanaBD(this);
            bd.apagarSemana(s);
            onResume();
        }

        return super.onContextItemSelected(item);


    }
}