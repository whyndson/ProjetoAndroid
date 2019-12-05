package com.example.meubizu.view;

import android.content.Intent;
import android.os.Bundle;

import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import com.example.meubizu.R;
import com.example.meubizu.banco.AgendaDAO;
import com.example.meubizu.model.Agenda;
import com.example.meubizu.utils.Mask;

public class acontecimentoAgendaActivity extends AppCompatActivity {
    Agenda agenda = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acontecimento_agenda);

        Intent intent = getIntent();
        if(intent.hasExtra("agenda")){
            agenda = (Agenda) intent.getSerializableExtra("agenda");
        }




        final EditText data = (EditText) findViewById(R.id.edittext_data);
        data.addTextChangedListener(Mask.insertMaskDate("##/##/####", data));
        data.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                if(b) {
                    DialogFragment dialogfragment = new DateManagerDialog();
                    dialogfragment.show(getSupportFragmentManager(), "Date");
                }
            }
        });

        final EditText hora = (EditText) findViewById(R.id.edittext_hora);
        final EditText descricao = (EditText) findViewById(R.id.edittext_descc);


        Log.i("acontecimento - Data",""+(data==null));
        Log.i("acontecimento - Hora",""+(hora==null));
        Log.i("acontecimento - Des",""+(descricao==null));
        Button ok = (Button) findViewById(R.id.button_enviar);

        if(agenda != null){
            ok.setText("Editar");
            data.setText(agenda.getData());
            hora.setText(agenda.getHora());
            descricao.setText(agenda.getDescricao());
            ok.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (!data.getText().toString().isEmpty() && !hora.getText().toString().isEmpty() && !descricao.getText().toString().isEmpty()) {
                        agenda.setData(data.getText().toString());
                        agenda.setDescricao(descricao.getText().toString());
                        agenda.setHora(hora.getText().toString());


                        long id = new AgendaDAO(getBaseContext()).atualizarAgendamento(agenda);
                        if (id > 0) {
                            Toast.makeText(getBaseContext(), "Agendamento atualizado com sucesso", Toast.LENGTH_SHORT).show();
                            finish();
                        } else {
                            Toast.makeText(getBaseContext(), "Falha na atualização", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        Toast.makeText(getBaseContext(), "Nenhum campo pode ser nulo", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }else {

            ok.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (!data.getText().toString().isEmpty() && !hora.getText().toString().isEmpty() && !descricao.getText().toString().isEmpty()) {
                        Agenda agenda = new Agenda(descricao.getText().toString(), data.getText().toString(), hora.getText().toString());
                        long id = new AgendaDAO(getBaseContext()).salvar(agenda);
                        if (id > 0) {
                            Toast.makeText(getBaseContext(), "Agendamento salvo com sucesso", Toast.LENGTH_SHORT).show();
                            finish();
                        } else {
                            Toast.makeText(getBaseContext(), "Falha no agendamento", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        Toast.makeText(getBaseContext(), "Nenhum campo pode ser nulo", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.ajuda:
                Toast.makeText(this, "Deus te abençoe!", Toast.LENGTH_SHORT).show();
                break;
            case R.id.direitos_autorais:
                Intent intent = new Intent(acontecimentoAgendaActivity.this,
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