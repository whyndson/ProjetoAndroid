package com.example.meubizu.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.meubizu.R;
import com.example.meubizu.banco.SemanaBD;
import com.example.meubizu.model.Semana;

public class FormularioCronogramaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario_cronograma);

        Intent intent = getIntent();
        if(intent.hasExtra("semana")){
            //RECUPERAR OS EDITTEXTS
            EditText editTextCod = findViewById(R.id.edittext_cod);
            EditText editTextDomingo = findViewById(R.id.edittext_domingo);
            EditText editTextSegunda = findViewById(R.id.edittext_segunda);
            EditText editTextTerca = findViewById(R.id.edittext_terca);
            EditText editTextQuarta = findViewById(R.id.edittext_quarta);
            EditText editTextQuinta = findViewById(R.id.edittext_quinta);
            EditText editTextSexta = findViewById(R.id.edittext_sexta);
            EditText editTextSabado = findViewById(R.id.edittext_sabado);
            

            Semana semana = (Semana) intent.getSerializableExtra("semana");
            editTextCod.setText(String.valueOf(semana.getCod()));
            editTextDomingo.setText(semana.getDomingo());
            editTextSegunda.setText(semana.getSegunda());
            editTextTerca.setText(semana.getTerca());
            editTextQuarta.setText(semana.getQuarta());
            editTextQuinta.setText(semana.getQuinta());
            editTextSexta.setText(semana.getSexta());
            editTextSabado.setText(semana.getSabado());
            


        }


        //RECUPERA O BOTAO E ADICIONA ACAO AO CLICK
        Button button = findViewById(R.id.button_form);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //RECUPERAR OS EDITTEXTS
                EditText editTextCod = findViewById(R.id.edittext_cod);
                EditText editTextDomingo = findViewById(R.id.edittext_domingo);
                EditText editTextSegunda = findViewById(R.id.edittext_segunda);
                EditText editTextTerca = findViewById(R.id.edittext_terca);
                EditText editTextQuarta = findViewById(R.id.edittext_quarta);
                EditText editTextQuinta = findViewById(R.id.edittext_quinta);
                EditText editTextSexta = findViewById(R.id.edittext_sexta);
                EditText editTextSabado = findViewById(R.id.edittext_sabado);

                //RECUPERA O TEXTO
                int cod = Integer.parseInt(editTextCod.getText().toString());
                String domingo = editTextDomingo.getText().toString();
                String segunda = editTextSegunda.getText().toString();
                String terca = editTextTerca.getText().toString();
                String quarta = editTextQuarta.getText().toString();
                String quinta = editTextQuinta.getText().toString();
                String sexta = editTextSexta.getText().toString();
                String sabado = editTextSabado.getText().toString();
                

               //CRIA O OBJETO SEMANA
                Semana s = new Semana(cod,domingo,segunda,terca,quarta,quinta,sexta,sabado);

                //SALVA A SEMANA NO BD
                SemanaBD db = new SemanaBD(FormularioCronogramaActivity.this);

                Intent intent = getIntent();
                if(intent.hasExtra("semana")) {
                    db.atualizarSemana(s);
                } else {
                    db.salvarSemana(s);
                }

                //ENCERRA A ACTIVITY
                finish();
            }
        });

    }




}