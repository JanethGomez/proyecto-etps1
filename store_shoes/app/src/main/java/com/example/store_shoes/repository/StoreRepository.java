package com.example.store_shoes.repository;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import androidx.annotation.Nullable;

import com.example.store_shoes.models.StoreModel;
import com.example.store_shoes.repository.conexion.ConexionDb;
import com.example.store_shoes.utility.Constant;

import java.util.ArrayList;
import java.util.List;

public class StoreRepository extends  ConexionDb{

    private Context context;

    public StoreRepository(@Nullable Context context){
        super(context);
        this.context = context;
        //insertGenericValue();
    }

    public void insertGenericValue(){
        ConexionDb conn = new ConexionDb(context);
        SQLiteDatabase db = conn.getWritableDatabase();

        List<StoreModel> list = new ArrayList<>();
        list.add(new StoreModel(0, "CAT", "Cat Footwear es una división de Wolverine World Wide Inc", "@drawable/logo_cat", "A"));
        list.add(new StoreModel(0, "MD TE ENTIENDE", "La marca fashion que mejor entiende a las mujeres.", "@drawable/logo_md", "A"));
        list.add(new StoreModel(0, "NIKE", "Esta temporada es para deslumbrar con looks diseñados para el movimiento.", "@drawable/logo_nike", "A"));
        list.add(new StoreModel(0, "ADIDAS", "Impossible is Nothing", "@drawable/logo_adidas", "A"));
        list.add(new StoreModel(0, "PAR 2", "MÁS VALOR POR TU DINERO", "@drawable/logo_par2", "A"));

        for (StoreModel sm: list) {
            ContentValues values = new ContentValues();
            values.put("name_store", sm.getNameStore());
            values.put("description_store", sm.getDescriptionStore());
            values.put("image_store", sm.getImageStore());
            values.put("status", sm.getStatus());

            int id = (int) db.insert(Constant.TABLE_STORE, null, values);
            System.out.println("======================== Creando registro "+id);
        }
    }

    public List<StoreModel> findStore() {

        try {
            ConexionDb conn = new ConexionDb(context);
            SQLiteDatabase db = conn.getWritableDatabase();

            Cursor c = db.rawQuery("SELECT * FROM store where status = 'A'", null);

            return parseToList(c);

        }catch (Exception e){
            System.err.println(e.getMessage());
            return null;
        }
    }

    public List<StoreModel> findStore(String id) {

        try {
            ConexionDb conn = new ConexionDb(context);
            SQLiteDatabase db = conn.getWritableDatabase();

            Cursor c = db.rawQuery("SELECT * FROM store where status = 'A' and id_store = '"+id+"'", null);

            return parseToList(c);

        }catch (Exception e){
            System.err.println(e.getMessage());
            return null;
        }
    }

    private List<StoreModel> parseToList(Cursor rs) throws Exception {
        List<StoreModel> list = new ArrayList<>();
        if (rs.moveToFirst()) {
            do {
                StoreModel store = new StoreModel();
                store.setIdStore(rs.getInt(0));
                store.setNameStore(rs.getString(1));
                store.setDescriptionStore(rs.getString(2));
                store.setImageStore(rs.getString(3));
                store.setStatus(rs.getString(4));
                list.add(store);
            }while(rs.moveToNext());
        }

        rs.close();
        return list;
    }
}
