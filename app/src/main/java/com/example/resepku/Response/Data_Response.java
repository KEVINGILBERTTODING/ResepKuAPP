package com.example.resepku.Response;

import com.example.resepku.model.Data_Model;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Data_Response {

    private Boolean status;
    private String message;

    @SerializedName("data")
    List<Data_Model> seluruh_barang;

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<Data_Model> getSeluruh_barang() {
        return seluruh_barang;
    }

    public void setSeluruh_barang(List<Data_Model> seluruh_barang) {
        this.seluruh_barang = seluruh_barang;
    }
}
