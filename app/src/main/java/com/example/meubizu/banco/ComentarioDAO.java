package com.example.meubizu.banco;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import java.util.ArrayList;
import java.util.List;

import com.example.meubizu.model.Comentario;


public class ComentarioDAO {

    private Conexao conn;
    private String TABLE = "COMENTARIO";

    public ComentarioDAO(Context context) {
        conn = new Conexao(context);
    }

    public void salvar(Comentario comentario) {
        SQLiteDatabase db = conn.getWritableDatabase(); 
        ContentValues dados = preencherDados(comentario);

        db.insert(TABLE, null, dados);
        db.close();
    }


    public ArrayList<Comentario> listarComentarios() {
        ArrayList<Comentario> list = new ArrayList<>();

        String sql = "SELECT * FROM COMENTARIO;";
        SQLiteDatabase db = conn.getWritableDatabase();
        Cursor cursor = db.rawQuery(sql, null);

        while (cursor.moveToNext()){
            int id = cursor.getInt(cursor.getColumnIndex("ID"));
            String nome = cursor.getString(cursor.getColumnIndex("NOME"));
            String cep = cursor.getString(cursor.getColumnIndex("CEP"));
            String cidade = cursor.getString(cursor.getColumnIndex("CIDADE"));
            String estado = cursor.getString(cursor.getColumnIndex("ESTADO"));
            String conteudo = cursor.getString(cursor.getColumnIndex("CONTEUDO"));


            list.add(new Comentario(id,nome,cep,cidade,estado,conteudo));
        }

        cursor.close();
        db.close();

        return list;
    }

  
    public void atualizar(Comentario comentario) {
        SQLiteDatabase db = conn.getWritableDatabase();
        ContentValues dados = preencherDados(comentario);
        String[] param = {String.valueOf(comentario.getId())};

        db.update(TABLE,dados,"id = ?",param);
        db.close();
    }

    private ContentValues preencherDados(Comentario comentario) {
        ContentValues dados = new ContentValues();
        dados.put("NOME", comentario.getNome());
        dados.put("CEP", comentario.getCep());
        dados.put("CIDADE", comentario.getCidade());
        dados.put("ESTADO", comentario.getEstado());
        dados.put("CONTEUDO", comentario.getConteudo());
        return dados;
    }

}