package com.example.meubizu.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.meubizu.R;
import com.example.meubizu.model.Agenda;

public class VisualizarAgendamento extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.visualizar_agendamentos);

        TextView data = (TextView) findViewById(R.id.visualizar_agendamento_data);
        TextView hora = (TextView) findViewById(R.id.visualizar_agendamento_hora);
        TextView desc = (TextView) findViewById(R.id.visualizar_agendamento_descricao);

        Intent intent = getIntent();
        Agenda agenda = null;
        if(intent.hasExtra("agenda")){
            agenda = (Agenda) intent.getSerializableExtra("agenda");
        }
        if(agenda != null){
            data.setText(agenda.getData());
            hora.setText(agenda.getHora());
            desc.setText(agenda.getDescricao());
        }
    }
}