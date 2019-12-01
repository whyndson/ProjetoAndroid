package com.example.meubizu.banco;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.meubizu.model.Materia;

public class MateriasDAO {

    private Conexao conn;
    private String TABLE = "MATERIAS";

    public MateriasDAO(Context context) {
        conn = new Conexao(context);
    }

    public void salvar(String materia) {
        SQLiteDatabase db = conn.getWritableDatabase(); //Metodo para abrir uma conexao
        ContentValues dados = preencherDados(materia);
        db.insert(TABLE, null, dados);
        db.close();
    }

    /*public materia buscarMateria(String materia) {
        //Materia resultado = null;

        String sql = "SELECT * FROM MATERIAS WHERE NOME = ?;";
        String[] param = {materia};
         SQLiteDatabase db = conn.getWritableDatabase();
        Cursor cursor = db.rawQuery(sql, param);


        while (cursor.moveToNext()){
            int id = cursor.getInt(cursor.getColumnIndex("ID"));
            String nome = cursor.getString(cursor.getColumnIndex("NOME"));
            //resultado = new materia(id, nome);
        }

        //Encerrar e liberar o cursor
        cursor.close();
        db.close();

        //return resultado;
    }*/

    private ContentValues preencherDados(String materia) {
        ContentValues dados = new ContentValues();
        dados.put("NOME", materia);
        return dados;
    }
}
