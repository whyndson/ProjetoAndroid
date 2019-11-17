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

public class linguagensActivity extends AppCompatActivity {

    private static final String[] campos = {"Português","Espanhol","Inglês"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_linguagens);

        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, campos);

        ListView listView = findViewById(R.id.activity_linguagens_list_view);
        listView.setAdapter(adapter);
        
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                if(campos[position].equalsIgnoreCase("Português")){
                    Intent intent = new Intent(getBaseContext(), portuguesActivity.class);
                    startActivity(intent);
                }else if(campos[position].equalsIgnoreCase("Espanhol")){
                    Intent intent = new Intent(getBaseContext(), espanholActivity.class);
                    startActivity(intent);
                }else if(campos[position].equalsIgnoreCase("Inglês")){
                    Intent intent = new Intent(getBaseContext(), inglesActivity.class);
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
