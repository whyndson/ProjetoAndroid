package com.example.rotina;

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

public class main_activity extends AppCompatActivity {

    private static final String[] campos = {"Agenda", "Cronograma",
            "Mapa", "Rascunhos", "Resumos"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, campos);

        ListView listView = findViewById(R.id.listview);
        listView.setAdapter(adapter);

        registerForContextMenu(listView);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                if(campos[position].equalsIgnoreCase("agenda")){
                    Intent intent = new Intent(getBaseContext(), agenda_activity.class);
                    startActivity(intent);
                }else if(campos[position].equalsIgnoreCase("cronograma")){
                    Toast.makeText(getBaseContext(), "Esta seção ainda será implementada",
                            Toast.LENGTH_SHORT).show();
                }else if(campos[position].equalsIgnoreCase("mapa")){
                    Toast.makeText(getBaseContext(), "Esta seção ainda será implementada",
                            Toast.LENGTH_SHORT).show();
                }else if(campos[position].equalsIgnoreCase("rascunhos")){
                    Intent intent = new Intent(getBaseContext(), rascunhos_activity.class);
                    startActivity(intent);
                }else if(campos[position].equalsIgnoreCase("resumos")){
                    Toast.makeText(getBaseContext(), "Esta seção ainda será implementada",
                            Toast.LENGTH_SHORT).show();
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
                Toast.makeText(this, "Esta seção ainda será implementada",
                        Toast.LENGTH_SHORT).show();
                break;
        }

        return super.onOptionsItemSelected(item);
    }
}