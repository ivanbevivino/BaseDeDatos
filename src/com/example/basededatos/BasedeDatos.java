package com.example.basededatos;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class BasedeDatos extends SQLiteOpenHelper {
	// string con la instruccion para crear la base de datos
String sqlCreate ="CREATE TABLE Ejemplo(_id INTEGER PRIMARY KEY AUTOINCREMENT, codigo INTEGER, nombre TEXT)";
	public BasedeDatos(Context context, String name, CursorFactory factory, int version) {
		super(context, name, factory, version);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		// se crea la base de datos
		db.execSQL(sqlCreate);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int arg1, int arg2) {
		// En este ejemplo se pierden todos los datos de la tabla
		// se debería hacer un bkup
		 db.execSQL("DROP TABLE IF EXISTS Ejemplo");
	     db.execSQL(sqlCreate);
	}
}