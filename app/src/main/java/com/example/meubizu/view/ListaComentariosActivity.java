package com.example.meubizu.view;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

import androidx.appcompat.app.AppCompatActivity;
import com.example.meubizu.R;
import com.example.meubizu.banco.ComentarioDAO;
import com.example.meubizu.model.Comentario;


public class ListaComentariosActivity extends AppCompatActivity {

   
    private ArrayAdapter adapter;
    private Comentario comentario;
    private ArrayList<Comentario> comentarios;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_comentarios);

        

        ComentarioDAO comDAO = new ComentarioDAO(this);

        adapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1, comDAO.listarComentarios());

        
        ListView listView = findViewById(R.id.listview_lista_comentarios);
        listView.setAdapter(adapter);

        

        
        FloatingActionButton fbutton = findViewById(R.id.fab_adicionar_comentarios);
        fbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ListaComentariosActivity.this, AdicionarComentarioActivity.class);
                startActivity(intent);
            }
        });
    }

    
    @Override
    protected void onResume() {
        super.onResume();

        
        comentarios = new ComentarioDAO(this).listarComentarios();

        
        adapter.clear();
        adapter.addAll(comentarios);
    }
}