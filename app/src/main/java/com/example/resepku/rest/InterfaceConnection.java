package com.example.resepku.rest;

import com.example.resepku.Response.Data_Response;

import retrofit2.Call;
import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface InterfaceConnection {

    @GET("post")
    Call<Data_Response> daftar_resep();

}
