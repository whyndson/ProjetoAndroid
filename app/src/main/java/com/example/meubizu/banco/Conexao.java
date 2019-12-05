package com.example.meubizu.banco;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Conexao extends SQLiteOpenHelper {

    public Conexao(Context context) {
        super(context, "BANCO", null, 3);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String SQL_TABLE_RASCUNHOS = "CREATE TABLE RASCUNHOS (" +
                "ID INTEGER PRIMARY KEY AUTOINCREMENT," +
                "TITULO TEXT NOT NULL," +
                "ID_MATERIA INTEGER NOT NULL," +
                "DATA_CRIACAO TEXT NOT NULL," +
                "DESCRICAO TEXT NOT NULL);";

        String SQL_TABLE_AGENDA = "CREATE TABLE AGENDA (" +
                "ID INTEGER PRIMARY KEY AUTOINCREMENT," +
                "DATA TEXT NOT NULL," +
                "HORA TEXT NOT NULL,"+
                "DESCRICAO TEXT NOT NULL);";


        db.execSQL(SQL_TABLE_RASCUNHOS);
        db.execSQL(SQL_TABLE_AGENDA);
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String SQL_TABLE_RASCUNHOS = "DROP TABLE IF EXISTS RASCUNHOS";
        db.execSQL(SQL_TABLE_RASCUNHOS);

        String SQL_TABLE_AGENDA = "DROP TABLE IF EXISTS AGENDA";
        db.execSQL(SQL_TABLE_AGENDA);

        onCreate(db);
    }
}