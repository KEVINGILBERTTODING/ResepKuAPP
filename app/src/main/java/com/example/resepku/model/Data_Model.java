package com.example.resepku.model;

import com.google.gson.annotations.SerializedName;

public class Data_Model {

    @SerializedName("id")
    private String kode_barang;

    @SerializedName("title")
    private String title_resep;
    @SerializedName("duration")
    private String duration_resep;
    @SerializedName("category")
    private String nama_barang;
    @SerializedName("ingredient")
    private String jumlah_barang;
    @SerializedName("detail")
    private String detail_resep;
    @SerializedName("picture")
    private String picture_resep;


    public String getKode_barang() {
        return kode_barang;
    }

    public void setKode_barang(String kode_barang) {
        this.kode_barang = kode_barang;
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

    public String getNama_barang() {
        return nama_barang;
    }

    public void setNama_barang(String nama_barang) {
        this.nama_barang = nama_barang;
    }

    public String getJumlah_barang() {
        return jumlah_barang;
    }

    public void setJumlah_barang(String jumlah_barang) {
        this.jumlah_barang = jumlah_barang;
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
}
