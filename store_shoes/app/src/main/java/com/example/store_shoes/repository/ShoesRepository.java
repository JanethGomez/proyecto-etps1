package com.example.store_shoes.repository;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import androidx.annotation.Nullable;

import com.example.store_shoes.models.ShoesModel;
import com.example.store_shoes.repository.conexion.ConexionDb;
import com.example.store_shoes.utility.Constant;

import java.util.ArrayList;
import java.util.List;

public class ShoesRepository extends ConexionDb {

    private Context context;

    public ShoesRepository(@Nullable Context context){
        super(context);
        this.context =context;
        //insertGenericValue();
    }

    public void insertGenericValue(){
        ConexionDb conn = new ConexionDb(context);
        SQLiteDatabase db = conn.getWritableDatabase();

        List<ShoesModel> shoes = new ArrayList<>();
        shoes.add(new ShoesModel(0, 2, 2, "MD", "Tacones Rojos", "@drawable/tacon_rojo", "$ 33.50", "A"));
        shoes.add(new ShoesModel(0, 1, 4, "Adidas", "LIGHT RUNNING SHOES", "@drawable/adidas1", "$ 120.00", "A"));
        shoes.add(new ShoesModel(0, 2, 4, "Adidas", "PRO 3 RUNNING SHOES", "@drawable/adidas2", "$ 150.99", "A"));
        shoes.add(new ShoesModel(0, 3, 3, "NIKE Pegasus", "Trail 4 GORE-TEX", "@drawable/nike1", "$ 90.00", "A"));
        shoes.add(new ShoesModel(0, 1, 3, "NIKE", "Zoom Fly 5", "@drawable/nike2", "$ 175.60", "A"));
        shoes.add(new ShoesModel(0, 1, 3, "NIKE", "Air Jordan 1 Mid", "@drawable/nike3", "$ 225.60", "A"));
        shoes.add(new ShoesModel(0, 3, 5, "PAR2", "Airy Bracos", "@drawable/par1", "$ 25.60", "A"));

        for (ShoesModel sm: shoes) {
            ContentValues values = new ContentValues();
            values.put("id_type_shoes", sm.getIdTypeShoes());
            values.put("id_store", sm.getIdStore());
            values.put("title_shoes", sm.getTitleShoes());
            values.put("description", sm.getDescription());
            values.put("image", sm.getImage());
            values.put("price", sm.getPrice());
            values.put("status", sm.getStatus());

            int id = (int) db.insert(Constant.TABLE_SHOES, null, values);
            System.out.println("======================== Creando registro "+id);
        }
    }

    public List<ShoesModel> findShoes() {

        try {
            ConexionDb conn = new ConexionDb(context);
            SQLiteDatabase db = conn.getWritableDatabase();

            Cursor c = db.rawQuery("SELECT sh.*, tsh.description, st.name_store FROM shoes sh " +
                    "left join type_shoes tsh on(sh.id_type_shoes = tsh.id_type_shoes) " +
                    "left join store st on(sh.id_store = st.id_store) " +
                    "where sh.status = 'A'", null);

            return parseToList(c);

        }catch (Exception e){
            System.err.println(e.getMessage());
            return null;
        }
    }

    public List<ShoesModel> findShoes(String idStore) {

        try {
            ConexionDb conn = new ConexionDb(context);
            SQLiteDatabase db = conn.getWritableDatabase();

            Cursor c = db.rawQuery("SELECT sh.*, tsh.description, st.name_store FROM shoes sh " +
                    "left join type_shoes tsh on(sh.id_type_shoes = tsh.id_type_shoes) " +
                    "left join store st on(sh.id_store = st.id_store) " +
                    "where sh.status = 'A' and sh.id_store = '"+idStore+"'", null);

            return parseToList(c);

        }catch (Exception e){
            System.err.println(e.getMessage());
            return null;
        }
    }

    public List<ShoesModel> findShoes(String idShoes, boolean filtro) {

        try {
            ConexionDb conn = new ConexionDb(context);
            SQLiteDatabase db = conn.getWritableDatabase();

            Cursor c = db.rawQuery("SELECT sh.*, tsh.description, st.name_store FROM shoes sh " +
                    "left join type_shoes tsh on(sh.id_type_shoes = tsh.id_type_shoes) " +
                    "left join store st on(sh.id_store = st.id_store) " +
                    "where sh.status = 'A' and sh.id_shoes = '"+idShoes+"'", null);

            return parseToList(c);

        }catch (Exception e){
            System.err.println(e.getMessage());
            return null;
        }
    }

    private List<ShoesModel> parseToList(Cursor rs) throws Exception {
        List<ShoesModel> list = new ArrayList<>();
        if (rs.moveToFirst()) {
            while (rs.moveToNext()){
                ShoesModel shoes = new ShoesModel();
                shoes.setIdShoes(rs.getInt(0));
                shoes.setIdTypeShoes(rs.getInt(1));
                shoes.setIdStore(rs.getInt(2));
                shoes.setTitleShoes(rs.getString(3));
                shoes.setDescription(rs.getString(4));
                shoes.setImage(rs.getString(5));
                shoes.setPrice(rs.getString(6));
                shoes.setStatus(rs.getString(7));

                shoes.setDescriptionTypeShoes(rs.getString(8));
                shoes.setTitleShoes(rs.getString(9));
                list.add(shoes);
            }
        }

        rs.close();
        return list;
    }

}
