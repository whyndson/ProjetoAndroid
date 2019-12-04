package com.example.meubizu.view;

import android.os.Bundle;
import android.util.Log;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.meubizu.R;
import com.example.meubizu.model.Rascunho;

public class RascunhoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.visualizar_rascunho);

        Rascunho rascunho = (Rascunho) getIntent().getSerializableExtra("rascunho");

        Log.i("RascunhoIsNull",""+(rascunho==null));

        TextView t1 = findViewById(R.id.visualizar_resumo_titulo);
        t1.setText(rascunho.getTitulo());
        TextView t2 = findViewById(R.id.visualizar_resumo_data);
        t2.setText(rascunho.getDataDeCriacao());
        TextView t3 = findViewById(R.id.visualizar_resumo_descricao);
        t3.setText(rascunho.getTexto());
    }
}
