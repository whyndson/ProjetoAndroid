package com.example.meubizu.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.meubizu.R;
import com.example.meubizu.banco.ComentarioDAO;
import com.example.meubizu.model.Comentario;
import com.example.meubizu.services.ConsultaCepTask;

public class AdicionarComentarioActivity extends AppCompatActivity {

    public EditText editTextNome;
    public EditText editTextCep;
    public EditText editTextCidade;
    public EditText editTextEstado;
    public EditText editTextConteudo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adicionar_comentarios);

        
        editTextNome = findViewById(R.id.edittext_comentario_nome);
        editTextCep = findViewById(R.id.edittext_cep);
        editTextCidade = findViewById(R.id.edittext_cidade);
        editTextEstado = findViewById(R.id.edittext_estado);
        editTextConteudo = findViewById(R.id.edittext_conteudo);

        Intent intent = getIntent();
        if(intent.hasExtra("comentario")){
            Comentario comentario = (Comentario) intent.getSerializableExtra("comentario");
            editTextNome.setText(comentario.getNome());
            editTextCep.setText(comentario.getCep());
            editTextCidade.setText(comentario.getCidade());
            editTextEstado.setText(comentario.getEstado());
            editTextConteudo.setText(comentario.getConteudo());
        }

        Button btn = findViewById(R.id.butao_buscar_end);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ConsultaCepTask buscarCep = new ConsultaCepTask(AdicionarComentarioActivity.this);
                buscarCep.execute(editTextCep.getText().toString());
            }
        });


       
        Button button = findViewById(R.id.butao_adicionar_comentarios);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                
                String nome = editTextNome.getText().toString();
                String cep = editTextCep.getText().toString();
                String cidade = editTextCidade.getText().toString();
                String estado = editTextEstado.getText().toString();
                String conteudo = editTextConteudo.getText().toString();

                
                ComentarioDAO dao = new ComentarioDAO(AdicionarComentarioActivity.this);

                Intent intent = getIntent();
                if(intent.hasExtra("comentario")) {
                    Comentario comentario = (Comentario) intent.getSerializableExtra("comentario");
                    comentario.setNome(nome);
                    comentario.setCep(cep);
                    comentario.setCidade(cidade);
                    comentario.setEstado(estado);
                    comentario.setConteudo(conteudo);

                    dao.atualizar(comentario);
                    System.out.println(comentario.getId()  + " " + comentario.toString());

                } else {
                    Comentario comentario = new Comentario(0, nome,cep,cidade, estado, conteudo);
                    dao.salvar(comentario);
                }

                
                finish();
            }
        });

    }




}


