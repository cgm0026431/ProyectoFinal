package com.example.proyectofinal;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class AyudanteSqlite extends SQLiteOpenHelper {
    private static final String NOMBRE_BD = "pryecto.db",NOMBRE_TABLA="user";

    public AyudanteSqlite(@Nullable Context context) {
        super(context, NOMBRE_BD, null, 1);
    }




    public static String getNombreBd() {
        return NOMBRE_BD;
    }
    public static String getNombreTabla() {
        return NOMBRE_TABLA;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(String.format("create table if not exists %s(id integer primary key autoincrement,nombre text not null,mes text not null,anio integer not null);",NOMBRE_TABLA));
    }


    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
