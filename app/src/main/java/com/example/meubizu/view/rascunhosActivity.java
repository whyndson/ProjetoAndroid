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

public class rascunhosActivity extends AppCompatActivity {

    private static final String[] campos = {"Biologia", "Espanhol", "Filosofia", "Física",
            "Geografia",
            "História", "Inglês", "Matemática", "Português","Redação", "Química", "Sociologia"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rascunhos);

        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1,
                campos);

        ListView listView = findViewById(R.id.activity_rascunhos_list_view);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                if(campos[position].equalsIgnoreCase("biologia")){
                    Intent intent = new Intent(rascunhosActivity.this, materiaActivity.class);
                    intent.putExtra("materia", "Biologia");
                    startActivity(intent);
                }if(campos[position].equalsIgnoreCase("espanhol")){
                    Intent intent = new Intent(rascunhosActivity.this, materiaActivity.class);
                    intent.putExtra("materia", "Espanhol");
                    startActivity(intent);
                }else if(campos[position].equalsIgnoreCase("filosofia")){
                    Intent intent = new Intent(rascunhosActivity.this, materiaActivity.class);
                    intent.putExtra("materia", "Filosofia");
                    startActivity(intent);
                }else if(campos[position].equalsIgnoreCase("física")){
                    Intent intent = new Intent(rascunhosActivity.this, materiaActivity.class);
                    intent.putExtra("materia", "Física");
                    startActivity(intent);
                }else if(campos[position].equalsIgnoreCase("geografia")){
                    Intent intent = new Intent(rascunhosActivity.this, materiaActivity.class);
                    intent.putExtra("materia", "Geografia");
                    startActivity(intent);
                }else if(campos[position].equalsIgnoreCase("história")){
                    Intent intent = new Intent(rascunhosActivity.this, materiaActivity.class);
                    intent.putExtra("materia", "História");
                    startActivity(intent);
                }else if(campos[position].equalsIgnoreCase("inglês")){
                    Intent intent = new Intent(rascunhosActivity.this, materiaActivity.class);
                    intent.putExtra("materia", "Inglês");
                    startActivity(intent);
                }else if(campos[position].equalsIgnoreCase("matemática")){
                    Intent intent = new Intent(rascunhosActivity.this, materiaActivity.class);
                    intent.putExtra("materia", "Matemática");
                    startActivity(intent);
                }else if(campos[position].equalsIgnoreCase("português")){
                    Intent intent = new Intent(rascunhosActivity.this, materiaActivity.class);
                    intent.putExtra("materia", "Português");
                    startActivity(intent);
                }else if(campos[position].equalsIgnoreCase("redação")){
                    Intent intent = new Intent(rascunhosActivity.this, materiaActivity.class);
                    intent.putExtra("materia", "Redação");
                    startActivity(intent);
                }else if(campos[position].equalsIgnoreCase("química")){
                    Intent intent = new Intent(rascunhosActivity.this, materiaActivity.class);
                    intent.putExtra("materia", "Química");
                    startActivity(intent);
                }else if(campos[position].equalsIgnoreCase("sociologia")){
                    Intent intent = new Intent(rascunhosActivity.this, materiaActivity.class);
                    intent.putExtra("materia", "Sociologia");
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
                Intent intent = new Intent(rascunhosActivity.this,
                        direitosAutoraisActivity.class);
                startActivity(intent);
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