package com.example.proyectofinal;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import com.example.proyectofinal.Client.Usuarios;

public class ControlUser {
    private AyudanteSqlite ayudanteSqlite;
    public ControlUser(Context context) {
        ayudanteSqlite = new AyudanteSqlite(context);
    }


    public long insertarUser(Usuarios user){
        SQLiteDatabase sqLiteDatabase = ayudanteSqlite.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("nombre",user.getNombre());
        contentValues.put("mes",user.getMes());
        contentValues.put("anio",user.getAnio());

        return sqLiteDatabase.insert(ayudanteSqlite.getNombreTabla(),null,contentValues);
    }
}
