package com.bruno.futbol;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

public class TimeDAO {

    public static void inserirTime(Context contexto , Time time){
        Banco banco = new Banco(contexto);
        SQLiteDatabase db = banco.getWritableDatabase();

        ContentValues valores = new ContentValues();

        valores.put("nome",time.getNome());

        db.insert("time",null,valores);
    }



    public static void editartime(Context contexto , Time time){
        Banco banco = new Banco(contexto);
        SQLiteDatabase db = banco.getWritableDatabase();

        ContentValues valores = new ContentValues();

        valores.put("nome",time.getNome());

        db.update("time",valores,"id="+time.getId(),null);

    }

}
