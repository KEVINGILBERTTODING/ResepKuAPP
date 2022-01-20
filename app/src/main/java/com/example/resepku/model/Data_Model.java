package com.example.resepku.model;

import com.google.gson.annotations.SerializedName;

public class Data_Model {

    @SerializedName("id")
    private String kode_resep;

    @SerializedName("title")
    private String title_resep;
    @SerializedName("duration")
    private String duration_resep;
    @SerializedName("category")
    private String nama_category;
    @SerializedName("ingredient")
    private String ingredients;
    @SerializedName("detail")
    private String detail_resep;
    @SerializedName("picture")
    private String picture_resep;

    @SerializedName("image")
    private String image_resep;


    public String getKode_barang() {
        return kode_resep;
    }

    public void setKode_resep(String kode_resep) {
        this.kode_resep = kode_resep;
    }

    public String getTitle_resep() {
        return title_resep;
    }

    public void setTitle_resep(String title_resep) {
        this.title_resep = title_resep;
    }
    public String getDuration_resep() {
        return duration_resep;
    }

    public void setDuration_resep(String duration_resep) {
        this.duration_resep = duration_resep;
    }

    public String getNama_category() {
        return nama_category;
    }

    public void setNama_category(String nama_category) {
        this.nama_category = nama_category;
    }

    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    public String getDetail_resep() {
        return detail_resep;
    }

    public void setDetail_resep(String detail_resep) {
        this.detail_resep = detail_resep;
    }

    public String getPicture_resep() {
        return picture_resep;
    }

    public void setPicture_resep(String picture_resep) {
        this.picture_resep = picture_resep;
    }

    public String getImage_resep() {
        return image_resep;
    }

    public void setImage_resep(String image_resep) {
        this.image_resep = image_resep;
    }
}
