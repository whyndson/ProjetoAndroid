package com.example.meubizu.banco;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.meubizu.model.Resumo;

import java.util.ArrayList;
import java.util.List;

public class ResumosDAO {

    private Conexao conn;
    private String TABLE = "RESUMOS";

    public ResumosDAO(Context context) {
        conn = new Conexao(context);
    }

    public void salvar(Resumo resumo) {
        SQLiteDatabase db = conn.getWritableDatabase(); //Metodo para abrir uma conexao
        ContentValues dados = preencherDados(resumo);
        db.insert(TABLE, null, dados);
        db.close();
    }

    private ContentValues preencherDados(Resumo resumo) {
        ContentValues dados = new ContentValues();
        dados.put("TITULO", resumo.getTitulo());
        dados.put("TEXTO", resumo.getTexto());
        return dados;
    }

    public List<Resumo> listarResumos() {

        String sql = "SELECT * FROM RESUMOS;";
        List<Resumo> lista = new ArrayList<>();

        SQLiteDatabase db = conn.getWritableDatabase();
        Cursor cursor = db.rawQuery(sql, null);

        while (cursor.moveToNext()) {
            String titulo = cursor.getString(cursor.getColumnIndex("TITULO"));
            String texto = cursor.getString(cursor.getColumnIndex("TEXTO"));

            lista.add(new Resumo(titulo, texto));
        }

        //Encerrar e liberar o cursor
        cursor.close();
        db.close();

        return lista;
    }
}
