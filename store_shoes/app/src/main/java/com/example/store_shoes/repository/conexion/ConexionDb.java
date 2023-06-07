package com.example.store_shoes.repository.conexion;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.store_shoes.utility.Constant;

public class ConexionDb extends SQLiteOpenHelper {

    public ConexionDb(@Nullable Context context){
        super(context, Constant.DB, null, Constant.VERSION);
        System.out.println("========================Creando base de datos");
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(Constant.CREATE_TABLE_STORE);
        sqLiteDatabase.execSQL(Constant.CREATE_TABLE_TYPE_SHOES);
        sqLiteDatabase.execSQL(Constant.CREATE_TABLE_STORE_ADD);
        sqLiteDatabase.execSQL(Constant.CREATE_TABLE_SHOES);
        System.out.println("========================Creando tablas");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL(Constant.DROP_TABLE_STORE);
        sqLiteDatabase.execSQL(Constant.DROP_TABLE_TYPE_SHOES);
        sqLiteDatabase.execSQL(Constant.DROP_TABLE_STORE_ADD);
        sqLiteDatabase.execSQL(Constant.DROP_TABLE_SHOES);

        onCreate(sqLiteDatabase);
    }
}
