package com.example.store_shoes.utility;

public class Constant {

    public static final Integer VERSION = 8;
    public static final String DB = "shoes_store";

    public static final String TABLE_STORE = "store";
    public static final String TABLE_TYPE_SHOES = "type_shoes";
    public static final String TABLE_SHORE_ADDRESS = "store_address";
    public static final String TABLE_SHOES = "shoes";


    public static final String CREATE_TABLE_STORE = "CREATE TABLE "
            +TABLE_STORE+"(id_store integer primary key autoincrement, "
            +"name_store text not null, description_store text not null, image_store text not null, status text not null)";

    public static final String CREATE_TABLE_TYPE_SHOES = "create table "
            +TABLE_TYPE_SHOES+"(id_type_shoes integer primary key autoincrement, "
            +"title_shoes text not null, description text not null, status text not null)";

    public static final String CREATE_TABLE_STORE_ADD = "create table "
            +TABLE_SHORE_ADDRESS+"(id_store_address integer primary key autoincrement,"
            +"id_store integer not null, address text not null, phone text not null, "
            +"status text not null)";

    public static final String CREATE_TABLE_SHOES = "create table "
            +TABLE_SHOES+"(id_shoes integer primary key autoincrement, "
            +"id_type_shoes integer not null, id_store integer not null, "
            +"title_shoes text not null, description text not null,"
            +"image text not null, price text not null, status text not null)";

    public static final String DROP_TABLE_STORE = "DROP TABLE IF EXISTS "+TABLE_STORE;
    public static final String DROP_TABLE_TYPE_SHOES = "DROP TABLE IF EXISTS "+TABLE_TYPE_SHOES;
    public static final String DROP_TABLE_STORE_ADD = "DROP TABLE IF EXISTS "+TABLE_SHORE_ADDRESS;
    public static final String DROP_TABLE_SHOES = "DROP TABLE IF EXISTS "+TABLE_SHOES;

}
