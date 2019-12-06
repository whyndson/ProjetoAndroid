package com.example.meubizu.banco;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.meubizu.model.Cronograma;

public class CronogramaDAO {

    private Conexao conn;
    private String TABLE = "CRONOGRAMA";

    public CronogramaDAO(Context context) {
        conn = new Conexao(context);
    }

    public long salvar(Cronograma cronograma) {
        SQLiteDatabase db = conn.getWritableDatabase(); //Metodo para abrir uma conexao
        ContentValues dados = preencherDados(cronograma);
        long id = db.insert(TABLE, null, dados);
        db.close();
        return id;
    }

    private ContentValues preencherDados(Cronograma cronograma) {
        ContentValues dados = new ContentValues();
        //dados.put("DESCRIÇÃO", cronograma.());
        return dados;
    }
}
