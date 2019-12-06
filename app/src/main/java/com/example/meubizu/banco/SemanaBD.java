package com.example.meubizu.banco;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

import com.example.meubizu.model.Semana;

public class SemanaBD extends SQLiteOpenHelper {

    //DEFINE O NOME E A VERSAO DO BD
    private static String name = "lista";
    private static int version = 3;


    public SemanaBD(Context context) {
        super(context, name, null, version);
    }

    //CRIAR O BD
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE SEMANA " +
                "(CODIGO INTEGER NOT NULL, 	DOMINGO TEXT, SEGUNDA TEXT, TERCA TEXT, QUARTA TEXT, QUINTA TEXT, SEXTA TEXT, SABADO TEXT, " +
                "PRIMARY KEY(CODIGO));";
        db.execSQL(sql);
    }

    //INVOCADO AO ATUALIZAR O BD
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String sql = "DROP TABLE IF EXISTS SEMANA";
        db.execSQL(sql);
        onCreate(db);
    }

    //SALVAR UM NOVA SEMANA
    public void salvarSemana(Semana s) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues dados = obterDados(s);
        db.insert("semana", null, dados);
    }

    //EDITAR UMA SEMANA
    public void atualizarSemana(Semana s) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues dados = obterDados(s);

        String[] params = { String.valueOf(s.getCod()) };
        db.update("semana",dados,"CODIGO=?", params);

        db.close();
    }

    //OBTER OS DADOS DO OBJETO SEMANA
    private ContentValues obterDados(Semana s) {
        ContentValues dados = new ContentValues();
        dados.put("CODIGO", s.getCod());
        dados.put("DOMINGO", s.getDomingo());
        dados.put("SEGUNDA", s.getSegunda());
        dados.put("TERCA", s.getTerca());
        dados.put("QUARTA", s.getQuarta());
        dados.put("QUINTA", s.getQuinta());
        dados.put("SEXTA", s.getSexta());
        dados.put("SABADO", s.getSabado());
        
        
        return dados;
    }

    //RECUPERAR TODOS AS SEMANAS SALVAS
    public List<Semana> listSemanas() {

        String sql = "SELECT * FROM SEMANA;";
        List<Semana> list = new ArrayList<>();

        SQLiteDatabase db = getWritableDatabase();
        Cursor cursor = db.rawQuery(sql, null);

        while (cursor.moveToNext()) {
            int codigo = cursor.getInt(cursor.getColumnIndex("CODIGO"));
            String domingo = cursor.getString(cursor.getColumnIndex("DOMINGO"));
            String segunda = cursor.getString(cursor.getColumnIndex("SEGUNDA"));
            String terca = cursor.getString(cursor.getColumnIndex("TERCA"));
            String quarta = cursor.getString(cursor.getColumnIndex("QUARTA"));
            String quinta = cursor.getString(cursor.getColumnIndex("QUINTA"));
            String sexta = cursor.getString(cursor.getColumnIndex("SEXTA"));
            String sabado = cursor.getString(cursor.getColumnIndex("SABADO"));

            list.add(new Semana(codigo, domingo, segunda, terca, quarta, quinta, sexta, sabado));
        }

        //Encerrar e liberar o cursor
        cursor.close();
        db.close();
        return list;
    }

    public void apagarSemana(Semana s) {
        SQLiteDatabase db = getWritableDatabase();
        String[] params = { String.valueOf(s.getCod()) };
        db.delete("semana","CODIGO=?", params);
        db.close();
    }
}

