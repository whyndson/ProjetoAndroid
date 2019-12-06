package com.example.meubizu.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.meubizu.R;

public class MainActivity extends AppCompatActivity {

    private static final String[] campos = {"Agenda", "Cronograma",
            "Mapa", "Rascunhos", "Comentários"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, campos);

        ListView listView = findViewById(R.id.activity_main_list_view);
        listView.setAdapter(adapter);

        registerForContextMenu(listView);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                if(campos[position].equalsIgnoreCase("agenda")){
                    Intent intent = new Intent(MainActivity.this, AgendaActivity.class);
                    startActivity(intent);
                }else if(campos[position].equalsIgnoreCase("cronograma")){
                    Intent intent = new Intent(MainActivity.this, CronogramaActivity.class);
                    startActivity(intent);
                }else if(campos[position].equalsIgnoreCase("mapa")){
                    Toast.makeText(MainActivity.this, "Esta seção ainda será implementada",
                            Toast.LENGTH_SHORT).show();
                }else if(campos[position].equalsIgnoreCase("rascunhos")){
                    Intent intent = new Intent(MainActivity.this, RascunhosActivity.class);
                    startActivity(intent);
                }else if(campos[position].equalsIgnoreCase("comentários")){
                    Intent intent = new Intent(MainActivity.this, ListaComentariosActivity.class);
                    startActivity(intent);
                }
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
                Intent intent = new Intent(MainActivity.this,
                        DireitosAutoraisActivity.class);
                startActivity(intent);
        }

        return super.onOptionsItemSelected(item);
    }
}
