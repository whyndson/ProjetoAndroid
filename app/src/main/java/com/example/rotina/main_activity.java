package com.example.rotina;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class main_activity extends AppCompatActivity {

    private static final String[] campos = {"Ciências humanas", "Ciências da natureza", "Linguagens", "Matemática"};

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
                if(campos[position].equalsIgnoreCase("linguagens")){
                    Intent intent = new Intent(getBaseContext(), linguagens_activity.class);
                    startActivity(intent);

                }else if(campos[position].equalsIgnoreCase("matemática")){
                    Intent intent = new Intent(getBaseContext(), matematica_activity.class);
                    startActivity(intent);

                }
                else if(campos[position].equalsIgnoreCase("ciências da natureza")){
                    Intent intent = new Intent(getBaseContext(), ciencias_natureza_activitity.class);
                    startActivity(intent);

                }
                else if(campos[position].equalsIgnoreCase("ciências humanas")){
                    Intent intent = new Intent(getBaseContext(), ciencias_humanas_activity.class);
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
}