package com.example.meubizu.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.meubizu.R;

public class materiaActivity extends AppCompatActivity {

    private String materia;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_materia);

        Intent intent = getIntent();

        if(intent.hasExtra("materia")) {
            this.materia = (String) intent.getSerializableExtra("materia");
        }

        TextView titulo = findViewById(R.id.activity_materia_text_view);
        titulo.setText(materia);
    }
}
