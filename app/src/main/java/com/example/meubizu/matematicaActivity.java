package com.example.meubizu;

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

public class matematicaActivity extends AppCompatActivity {

    private static final String[] campos = {"Geometria","Aritmética","Razões","Funções","Porcentagem"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_matematica);

        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, campos);

        ListView listView = findViewById(R.id.list_view_matematica);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                if(campos[position].equalsIgnoreCase("Geometria")){
                    Intent intent = new Intent(getBaseContext(), geometriaActivity.class);
                    startActivity(intent);
                }else if(campos[position].equalsIgnoreCase("Aritmética")){
                    Intent intent = new Intent(getBaseContext(), aritmeticaActivity.class);
                    startActivity(intent);
                }else if(campos[position].equalsIgnoreCase("Razões")){
                    Intent intent = new Intent(getBaseContext(), razoesActivity.class);
                    startActivity(intent);
                }else if(campos[position].equalsIgnoreCase("Funções")){
                    Intent intent = new Intent(getBaseContext(), funcoesActivity.class);
                    startActivity(intent);
                }else if(campos[position].equalsIgnoreCase("Porcentagem")){
                    Intent intent = new Intent(getBaseContext(), porcentagemActivity.class);
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
                Toast.makeText(this, "Esta seção ainda será implementada",
                        Toast.LENGTH_SHORT).show();
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed(){
        super.onBackPressed();
        finish();
    }
}
