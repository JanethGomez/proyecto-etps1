package com.example.store_shoes.models;

public class StoreModel {

    private int idStore;
    private String nameStore;
    private String descriptionStore;
    private String imageStore;
    private String status;

    public StoreModel(){

    }

    public StoreModel(int idStore, String nameStore, String descriptionStore, String imageStore, String status) {
        this.idStore = idStore;
        this.nameStore = nameStore;
        this.descriptionStore = descriptionStore;
        this.imageStore = imageStore;
        this.status = status;
    }

    public int getIdStore() {
        return idStore;
    }

    public void setIdStore(int idStore) {
        this.idStore = idStore;
    }

    public String getNameStore() {
        return nameStore;
    }

    public void setNameStore(String nameStore) {
        this.nameStore = nameStore;
    }

    public String getDescriptionStore() {
        return descriptionStore;
    }

    public void setDescriptionStore(String descriptionStore) {
        this.descriptionStore = descriptionStore;
    }

    public String getImageStore() {
        return imageStore;
    }

    public void setImageStore(String imageStore) {
        this.imageStore = imageStore;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
