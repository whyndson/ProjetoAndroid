package com.example.rotina;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class ciencias_natureza_activitity extends AppCompatActivity {

    private static final String[] campos = {"Biologia", "Física","Química"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ciencias_natureza);

        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, campos);

        ListView listView = findViewById(R.id.list_view_ciencias_natureza);
        listView.setAdapter(adapter);

        registerForContextMenu(listView);
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
