package com.example.store_shoes.models;

public class TypeShoesModel {

    private Integer idTypeShoes;
    private String titleShoes;
    private String description;
    private String status;

    public TypeShoesModel(Integer idTypeShoes, String titleShoes, String description, String status) {
        this.idTypeShoes = idTypeShoes;
        this.titleShoes = titleShoes;
        this.description = description;
        this.status = status;
    }

    public Integer getIdTypeShoes() {
        return idTypeShoes;
    }

    public void setIdTypeShoes(Integer idTypeShoes) {
        this.idTypeShoes = idTypeShoes;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
