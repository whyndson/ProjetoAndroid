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

    private static final String[] campos = {"Biologia", "Filosofia", "Física", "Geografia",
            "História", "Matemática", "Português","Redação", "Química", "Sociologia"};

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
                if(campos[position].equalsIgnoreCase("biologia")){
                    Toast.makeText(rascunhosActivity.this, "Esta seção ainda está a ser implementada",
                            Toast.LENGTH_LONG).show();
                }else if(campos[position].equalsIgnoreCase("filosofia")){
                    Intent intent = new Intent(rascunhosActivity.this, filosofiaActivity.class);
                    startActivity(intent);
                }else if(campos[position].equalsIgnoreCase("física")){
                    Toast.makeText(rascunhosActivity.this, "Esta seção ainda está a ser implementada",
                            Toast.LENGTH_LONG).show();
                }else if(campos[position].equalsIgnoreCase("geografia")){
                    Intent intent = new Intent(rascunhosActivity.this, geografiaActivity.class);
                    startActivity(intent);
                }else if(campos[position].equalsIgnoreCase("história")){
                    Intent intent = new Intent(rascunhosActivity.this, historiaActivity.class);
                    startActivity(intent);
                }else if(campos[position].equalsIgnoreCase("matemática")){
                    Intent intent = new Intent(rascunhosActivity.this, matematicaActivity.class);
                    startActivity(intent);
                }else if(campos[position].equalsIgnoreCase("português")){
                    Toast.makeText(rascunhosActivity.this, "Esta seção ainda está a ser implementada",
                            Toast.LENGTH_LONG).show();
                }else if(campos[position].equalsIgnoreCase("redação")){
                    Toast.makeText(rascunhosActivity.this, "Esta seção ainda está a ser implementada",
                            Toast.LENGTH_LONG).show();
                }else if(campos[position].equalsIgnoreCase("química")){
                    Toast.makeText(rascunhosActivity.this, "Esta seção ainda está a ser implementada",
                            Toast.LENGTH_LONG).show();
                }else if(campos[position].equalsIgnoreCase("sociologia")){
                    Intent intent = new Intent(rascunhosActivity.this, sociologiaActivity.class);
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
