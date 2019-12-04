package com.example.meubizu.view;

import android.content.Intent;
import android.os.Bundle;

import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.meubizu.R;
import com.example.meubizu.banco.Conexao;
import com.example.meubizu.banco.RascunhosDAO;
import com.example.meubizu.model.Materia;
import com.example.meubizu.model.Rascunho;

import java.util.Calendar;

public class formularioActivity extends AppCompatActivity {

    private String materia;
    private Button ok;
    private EditText titulo;
    private EditText descricao;
    private Rascunho rascunho;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario);

        ok = (Button) findViewById(R.id.button_form);
        titulo = (EditText) findViewById(R.id.edittext_nome);
        descricao = (EditText)findViewById(R.id.edittext_desc);



        Intent intent = getIntent();

        if(intent.hasExtra("materia")) {
            this.materia = (String) intent.getSerializableExtra("materia");
        }
        if(intent.hasExtra("rascunho")){
            this.rascunho = (Rascunho) intent.getSerializableExtra("rascunho");
            if(this.rascunho != null){
                titulo.setText(rascunho.getTitulo());
                descricao.setText(rascunho.getTexto());
                ok.setText("EDITAR");
            }
        }



        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(rascunho == null) {
                    if (materia != null) {
                        if (!materia.isEmpty()) {
                            if (!titulo.getText().toString().isEmpty() && !descricao.getText().toString().isEmpty()) {

                                Calendar calendar = Calendar.getInstance();

                                String dia = (calendar.get(Calendar.DAY_OF_MONTH)) < 10 ? ("0" + calendar.get(Calendar.DAY_OF_MONTH)) : calendar.get(Calendar.DAY_OF_MONTH) + "";
                                String date = dia + "/" + (calendar.get(Calendar.MONTH) + 1) + "/" + calendar.get(Calendar.YEAR);
                                Rascunho rascunho = new Rascunho(titulo.getText().toString(), descricao.getText().toString(), materia, date);
                                RascunhosDAO rascunhosDAO = new RascunhosDAO(getBaseContext());
                                long id = rascunhosDAO.salvar(rascunho);
                                Log.i("Data", id + "");
                                if (id != 0) {
                                    Toast.makeText(getBaseContext(), "Rascunho salvo com sucesso", Toast.LENGTH_SHORT).show();
                                } else {
                                    Toast.makeText(getBaseContext(), "Falha ao salvar seu rascunho", Toast.LENGTH_SHORT).show();
                                }

                                finish();
                            } else {
                                Toast.makeText(getBaseContext(), "Nenhum campo pode ser vazio", Toast.LENGTH_SHORT).show();
                            }
                        } else {
                            Toast.makeText(getBaseContext(), "Materia inválida", Toast.LENGTH_SHORT).show();
                            finish();
                        }
                    } else {
                        Toast.makeText(getBaseContext(), "Matéria inválida", Toast.LENGTH_SHORT).show();
                        finish();
                    }
                }else{
                    if (!titulo.getText().toString().isEmpty() && !descricao.getText().toString().isEmpty()) {

                        rascunho.setTitulo(titulo.getText().toString());
                        rascunho.setTexto(descricao.getText().toString());
                        RascunhosDAO rascunhosDAO = new RascunhosDAO(getBaseContext());
                        long id = rascunhosDAO.atualizarRascunho(rascunho);
                        Log.i("Data", id + "");
                        if (id != 0) {
                            Toast.makeText(getBaseContext(), "Rascunho atualizado com sucesso", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(getBaseContext(), "Falha ao atualizar seu rascunho", Toast.LENGTH_SHORT).show();
                        }

                        finish();
                    } else {
                        Toast.makeText(getBaseContext(), "Nenhum campo pode ser vazio", Toast.LENGTH_SHORT).show();
                    }
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
                Intent intent = new Intent(formularioActivity.this,
                        direitosAutoraisActivity.class);
                startActivity(intent);
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }


}