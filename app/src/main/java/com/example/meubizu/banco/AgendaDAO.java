package com.example.meubizu.banco;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.meubizu.model.Agenda;

import java.util.ArrayList;
import java.util.List;

public class AgendaDAO {
    private Conexao conn;
    private String TABLE = "AGENDA";

    public AgendaDAO(Context context) {
        conn = new Conexao(context);
    }

    public long salvar(Agenda agenda) {
        SQLiteDatabase db = conn.getWritableDatabase(); //Metodo para abrir uma conexao
        ContentValues dados = preencherDados(agenda);
        long id = db.insert(TABLE, null, dados);
        Log.i("BD","ID Salvo: " + ((id > 0)? "Sim":"Não") +"\nID: "+id);
        db.close();
        return id;
    }

    private ContentValues preencherDados(Agenda agenda) {
        ContentValues dados = new ContentValues();
        dados.put("DATA", agenda.getData());
        dados.put("HORA", agenda.getHora());
        dados.put("DESCRICAO", agenda.getDescricao());
        return dados;
    }

    public List<Agenda> listarAgendas() {

        String sql = "SELECT * FROM AGENDA;";
        List<Agenda> lista = new ArrayList<>();

        SQLiteDatabase db = conn.getWritableDatabase();
        Cursor cursor = db.rawQuery(sql, null);

        while (cursor.moveToNext()) {
            String data = cursor.getString(cursor.getColumnIndex("DATA"));
            String hora = cursor.getString(cursor.getColumnIndex("HORA"));
            String descricao = cursor.getString(cursor.getColumnIndex("DESCRICAO"));
            long id = cursor.getLong(cursor.getColumnIndex("ID"));

            lista.add(new Agenda(id,descricao, data, hora));
        }

        //Encerrar e liberar o cursor
        cursor.close();
        db.close();

        return lista;
    }
    public long atualizarAgendamento(Agenda a) {
        SQLiteDatabase db = conn.getWritableDatabase();
        ContentValues dados = preencherDados(a);
        String[] params = { String.valueOf(a.getId()) };
        Log.i("Update",a.getId()+"");
        long id = db.update(TABLE,dados,"ID=?", params);

        db.close();
        return id;
    }
    public void apagarAgendamento(Agenda a){
        SQLiteDatabase db = conn.getWritableDatabase();
        String[] params = {String.valueOf(a.getId())};
        long id = db.delete(TABLE,"ID=?",params);
        db.close();
    }
}