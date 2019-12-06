package com.example.meubizu.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.meubizu.R;
import com.example.meubizu.banco.AgendaDAO;
import com.example.meubizu.model.Agenda;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class agendaActivity extends AppCompatActivity {

    ArrayAdapter adapter;
    private ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agenda);

        ArrayList<Agenda> agendas = (ArrayList<Agenda>) new AgendaDAO(getBaseContext()).listarAgendas();
        adapter = new AgendaAdapter(getBaseContext(),agendas);

        listView = findViewById(R.id.agendas_list_view);
        listView.setAdapter(adapter);

        FloatingActionButton fbutton = findViewById(R.id.activity_agenda_floating_action_button);
        fbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(agendaActivity.this,
                        acontecimentoAgendaActivity.class);
                startActivity(intent);
            }
        });
        
        registerForContextMenu(listView);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Agenda agenda = (Agenda) adapterView.getItemAtPosition(i);
                Intent minhaIntent = new Intent(getBaseContext(), VisualizarAgendamento.class);
                minhaIntent.putExtra("agenda",agenda);
                startActivity(minhaIntent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.options_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.ajuda:
                Toast.makeText(this, "Deus te abençoe!", Toast.LENGTH_SHORT).show();
                break;
            case R.id.direitos_autorais:
                Intent intent = new Intent(agendaActivity.this,
                        direitosAutoraisActivity.class);
                startActivity(intent);
                break;
        }

        return super.onOptionsItemSelected(item);
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
        Agenda a = (Agenda) adapter.getItem(contextMenuInfo.position);

        //VERIFICAR QUAL ITEM DO CONTEXT MENU FOI CLICADO
        //OPCAO EDITAR
        if(item.getItemId() == R.id.menu_editar){
            //CRIA A INTENT, ADD O PRODUTO E INICIA A ACITIVITY
            Log.i("SQLITE","ID: "+a.getId());
            Intent i = new Intent(getBaseContext(), acontecimentoAgendaActivity.class);
            i.putExtra("agenda", a);
            startActivity(i);
        }

        //OPCAO APAGAR
        if(item.getItemId() == R.id.menu_apagar){
            //INICIA O BD, CHAMA O METODO APAGAR E ATUALIZA O ADAPTER CHAMANDO O ONRESUME
            AgendaDAO bd = new AgendaDAO(getBaseContext());
            bd.apagarAgendamento(a);
            onResume();
        }

        return super.onContextItemSelected(item);


    }

    @Override
    public void onResume(){
        super.onResume();

        ArrayList<Agenda> agendas = (ArrayList<Agenda>) new AgendaDAO(getBaseContext()).listarAgendas();
        adapter = new AgendaAdapter(getBaseContext(),agendas);

        listView.setAdapter(adapter);
    }

    @Override
    public void onBackPressed(){
        super.onBackPressed();
        finish();
    }
}