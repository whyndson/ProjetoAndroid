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

public class rascunhosActivity extends AppCompatActivity {

    private static final String[] campos = {"Ciências humanas", "Ciências da Natureza", "Linguagens",
            "Matemática", "Redação"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rascunhos);

        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, campos);

        ListView listView = findViewById(R.id.activity_rascunhos_list_view);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                if(campos[position].equalsIgnoreCase("ciências humanas")){
                    Intent intent = new Intent(getBaseContext(), cienciashumanasActivity.class);
                    startActivity(intent);
                }else if(campos[position].equalsIgnoreCase("ciências da natureza")){
                    Intent intent = new Intent(getBaseContext(), cienciasnaturezaActivity.class);
                    startActivity(intent);
                }else if(campos[position].equalsIgnoreCase("linguagens")){
                    Intent intent = new Intent(getBaseContext(), linguagensActivity.class);
                    startActivity(intent);
                }else if(campos[position].equalsIgnoreCase("matemática")){
                    Intent intent = new Intent(getBaseContext(), matematicaActivity.class);
                    startActivity(intent);
                }else if(campos[position].equalsIgnoreCase("redação")){
                    Toast.makeText(getBaseContext(), "Esta seção ainda está a ser implementada",
                            Toast.LENGTH_LONG).show();
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
