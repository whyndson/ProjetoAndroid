package com.example.meubizu.banco;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.meubizu.model.Rascunho;

import java.util.ArrayList;
import java.util.List;

public class RascunhosDAO {
    private Conexao conn;
    private String TABLE = "RASCUNHOS";

    public RascunhosDAO(Context context) {
        conn = new Conexao(context);
    }

    public long salvar(Rascunho rascunho) {
        SQLiteDatabase db = conn.getWritableDatabase(); //Metodo para abrir uma conexao
        ContentValues dados = preencherDados(rascunho);
        long id = db.insert(TABLE, null, dados);
        Log.i("BD","ID Salvo: " + ((id > 0)? "Sim":"Não") +"\nID: "+id);
        db.close();
        return id;
    }

    private ContentValues preencherDados(Rascunho rascunho) {
        ContentValues dados = new ContentValues();
        dados.put("TITULO", rascunho.getTitulo());
        dados.put("DESCRICAO", rascunho.getTexto());
        dados.put("ID_MATERIA", rascunho.getId_materia());
        dados.put("DATA_CRIACAO", rascunho.getDataDeCriacao());
        dados.put("FOTO", rascunho.getFoto());
        return dados;
    }

    public List<Rascunho> listarRascunhos() {

        String sql = "SELECT * FROM RASCUNHOS;";
        List<Rascunho> lista = new ArrayList<>();

        SQLiteDatabase db = conn.getWritableDatabase();
        Cursor cursor = db.rawQuery(sql, null);

        while (cursor.moveToNext()) {
            String titulo = cursor.getString(cursor.getColumnIndex("TITULO"));
            String texto = cursor.getString(cursor.getColumnIndex("DESCRICAO"));
            long id_materia = cursor.getLong(cursor.getColumnIndex("ID_MATERIA"));
            String data = cursor.getString(cursor.getColumnIndex("DATA_CRIACAO"));
            String foto = cursor.getString(cursor.getColumnIndex("FOTO"));

            lista.add(new Rascunho(titulo, texto,id_materia,data, foto));
        }

        //Encerrar e liberar o cursor
        cursor.close();
        db.close();

        return lista;
    }
    public List<Rascunho> listarRascunhosByMateria(long id_materia) {
        String idMateria = id_materia+"";

        List<Rascunho> lista = new ArrayList<>();

        SQLiteDatabase db = conn.getWritableDatabase();
        Cursor cursor = db.query("RASCUNHOS",new String[]{"ID","TITULO","DESCRICAO","DATA_CRIACAO", "FOTO"},"ID_MATERIA=?",new String[]{idMateria},null,null,null);
        while (cursor.moveToNext()) {
            String titulo = cursor.getString(cursor.getColumnIndex("TITULO"));
            String texto = cursor.getString(cursor.getColumnIndex("DESCRICAO"));
            long id = cursor.getLong(cursor.getColumnIndex("ID"));
            String data = cursor.getString(cursor.getColumnIndex("DATA_CRIACAO"));
            String foto = cursor.getString(cursor.getColumnIndex("FOTO"));

            lista.add(new Rascunho(titulo, texto,id_materia,id,data, foto));


        }

        //Encerrar e liberar o cursor
        cursor.close();
        db.close();

        return lista;
    }
    public long atualizarRascunho(Rascunho r) {
        SQLiteDatabase db = conn.getWritableDatabase();
        ContentValues dados = preencherDados(r);
        String[] params = { String.valueOf(r.getId()) };
        long id = db.update(TABLE,dados,"ID=?", params);

        db.close();
        return id;
    }
    public void apagarRascunho(Rascunho r){
        SQLiteDatabase db = conn.getWritableDatabase();
        String[] params = {String.valueOf(r.getId())};
        long id = db.delete(TABLE,"ID=?",params);
        db.close();
        return;
    }
}