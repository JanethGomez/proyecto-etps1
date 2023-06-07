package com.example.store_shoes.repository;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import androidx.annotation.Nullable;
import com.example.store_shoes.models.TypeShoesModel;
import com.example.store_shoes.repository.conexion.ConexionDb;
import com.example.store_shoes.utility.Constant;

import java.util.ArrayList;
import java.util.List;

public class TypeShoesRepository  extends ConexionDb {

    private Context context;

    public TypeShoesRepository(@Nullable Context context){
        super(context);
        this.context = context;
        //insertGenericValue();
    }

    public void insertGenericValue(){
        ConexionDb conn = new ConexionDb(context);
        SQLiteDatabase db = conn.getWritableDatabase();

        List<TypeShoesModel> list = new ArrayList<>();
        list.add(new TypeShoesModel(0, "Zapato", "Deportivo", "A"));
        list.add(new TypeShoesModel(0, "Zapato", "Tacon Alto", "A"));
        list.add(new TypeShoesModel(0, "Zapato", "De montaña", "A"));
        for (TypeShoesModel sm: list) {
            ContentValues values = new ContentValues();
            values.put("title_shoes", sm.getTitleShoes());
            values.put("description", sm.getDescription());
            values.put("status", sm.getStatus());

            int id = (int) db.insert(Constant.TABLE_TYPE_SHOES, null, values);
            System.out.println("======================== Creando registro "+id);
        }
    }
}
