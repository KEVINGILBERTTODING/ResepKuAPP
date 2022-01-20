package com.example.resepku.Response;

import com.example.resepku.model.Data_Model;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Data_Response {

    private Boolean status;
    private String message;

    @SerializedName("data")
    List<Data_Model> seluruh_resep;

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

    public List<Data_Model> getSeluruh_resep() {
        return seluruh_resep;
    }

    public void setSeluruh_resep(List<Data_Model> seluruh_resep) {
        this.seluruh_resep = seluruh_resep;
    }
}
