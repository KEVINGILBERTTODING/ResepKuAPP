package com.example.resepku;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.resepku.Response.Data_Response;
import com.example.resepku.rest.ApiConnection;
import com.example.resepku.rest.InterfaceConnection;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import org.json.JSONObject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AddBarangFragment extends Fragment {

    TextInputLayout layoutNamaBarang, layoutJumlahBarang;
    TextInputEditText inputNamaBarang, inputJumlahBarng;
    Button btnTambahBarang;

    InterfaceConnection interfaceConnection;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        layoutNamaBarang = (TextInputLayout)view.findViewById(R.id.layoutNamaBarang);
        layoutJumlahBarang = (TextInputLayout)view.findViewById(R.id.layoutJumlahBarang);
        inputNamaBarang = (TextInputEditText)view.findViewById(R.id.inputNamaBarang);
        inputJumlahBarng = (TextInputEditText)view.findViewById(R.id.inputJumlahBarang);
        btnTambahBarang = (Button)view.findViewById(R.id.btnTambahBarang);

        interfaceConnection = ApiConnection.getClient().create(InterfaceConnection.class);
        btnTambahBarang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                add_Barang();
            }
        });
    }

    private void add_Barang() {
        String namaBarang = inputNamaBarang.getText().toString();
        String jmlBarang = inputJumlahBarng.getText().toString();
        if (namaBarang.isEmpty() || namaBarang.length() == 0){
            layoutNamaBarang.setError("Nama Barang Tidak Boleh Kosong");
        } else if (jmlBarang.isEmpty() || jmlBarang.length() == 0){
            layoutJumlahBarang.setError("Jumlah Barang Tidak Boleh Kosong");
        } else if (((!namaBarang.isEmpty() && namaBarang.length() !=0) && (!jmlBarang.isEmpty() && jmlBarang.length()!=0))){
            Call<Data_Response> add_barang = interfaceConnection.tambah_barang(namaBarang, jmlBarang);
            add_barang.enqueue(new Callback<Data_Response>() {
                @Override
                public void onResponse(Call<Data_Response> call, Response<Data_Response> response) {
                    if (response.isSuccessful()){
                        Toast.makeText(getActivity(), response.body().getMessage(), Toast.LENGTH_SHORT).show();
                    } else {
                        try {
                            JSONObject jObjError = new JSONObject(response.errorBody().string());
                            Toast.makeText(getActivity(), jObjError.getString("message"), Toast.LENGTH_LONG).show();
                        } catch (Exception e) {
                            Toast.makeText(getActivity(), e.getMessage(), Toast.LENGTH_LONG).show();
                        }
                    }
                }

                @Override
                public void onFailure(Call<Data_Response> call, Throwable t) {
                    Log.d("Error here", "Error here", t);
                    t.printStackTrace();
                    Log.d("Error here", "Error here2", t);
                    Toast.makeText(getActivity(), "Terjadi kesalahan", Toast.LENGTH_SHORT).show();
                }
            });
        }

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_add_resep, container, false);
    }

}
