package com.example.store_shoes.models;

public class ShoesModel {
    
    private int idShoes;
    private int idTypeShoes;
    private int idStore;
    private String titleShoes;
    private String description;
    private String image;
    private String price;
    private String status;

    private String descriptionTypeShoes;
    private String titleStore;

    public ShoesModel(){}

    public ShoesModel(int idShoes, int idTypeShoes, int idStore, String titleShoes, String description, String image, String price, String status) {
        this.idShoes = idShoes;
        this.idTypeShoes = idTypeShoes;
        this.idStore = idStore;
        this.titleShoes = titleShoes;
        this.description = description;
        this.image = image;
        this.price = price;
        this.status = status;
    }

    public int getIdShoes() {
        return idShoes;
    }

    public void setIdShoes(int idShoes) {
        this.idShoes = idShoes;
    }

    public int getIdTypeShoes() {
        return idTypeShoes;
    }

    public void setIdTypeShoes(int idTypeShoes) {
        this.idTypeShoes = idTypeShoes;
    }

    public int getIdStore() {
        return idStore;
    }

    public void setIdStore(int idStore) {
        this.idStore = idStore;
    }

    public String getTitleShoes() {
        return titleShoes;
    }

    public void setTitleShoes(String titleShoes) {
        this.titleShoes = titleShoes;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDescriptionTypeShoes() {
        return descriptionTypeShoes;
    }

    public void setDescriptionTypeShoes(String descriptionTypeShoes) {
        this.descriptionTypeShoes = descriptionTypeShoes;
    }

    public String getTitleStore() {
        return titleStore;
    }

    public void setTitleStore(String titleStore) {
        this.titleStore = titleStore;
    }
}
