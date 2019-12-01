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
        String SQL_TABLE_RESUMOS = "CREATE TABLE RESUMOS (" +
                "ID INTEGER PRIMARY KEY AUTOINCREMENT," +
                "TITULO TEXT NOT NULL," +
                "TEXTO TEXT NOT NULL);";

        db.execSQL(SQL_TABLE_RESUMOS);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String SQL_TABLE_RESUMOS = "DROP TABLE IF EXISTS RESUMOS";
        db.execSQL(SQL_TABLE_RESUMOS);
        onCreate(db);
    }
}
