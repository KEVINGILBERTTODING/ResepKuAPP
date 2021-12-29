package com.example.resepku;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.resepku.Response.Data_Response;
import com.example.resepku.model.Data_Model;
import com.example.resepku.rest.ApiConnection;
import com.example.resepku.rest.InterfaceConnection;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DashBoardFragment extends Fragment {
    ArrayList<Data_Model> daftarseluruhBarang = new ArrayList<>();
    RecyclerView tabel_barang;
    InterfaceConnection interfaceConnection;
    AdapterDaftarBarang adapterDaftarBarang;
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        tabel_barang = (RecyclerView)view.findViewById(R.id.recyclerView_daftarBarang);
        interfaceConnection = ApiConnection.getClient().create(InterfaceConnection.class);
        loadDataBarang();
    }
    private void loadDataBarang() {
        adapterDaftarBarang = new AdapterDaftarBarang(getContext());
        Call<Data_Response> daftar_barang = interfaceConnection.daftar_barang();
        daftar_barang.enqueue(new Callback<Data_Response>() {
            @Override
            public void onResponse(Call<Data_Response> call, Response<Data_Response> response) {
                if (response.isSuccessful()){
                    List<Data_Model> seluruh_barang = response.body().getSeluruh_barang();
                    daftarseluruhBarang.addAll(seluruh_barang);
                } else {
                    try {
                        JSONObject jObjError = new JSONObject(response.errorBody().string());
                        Toast.makeText(getActivity(), jObjError.getString("message"), Toast.LENGTH_LONG).show();
                    } catch (Exception e) {
                        Toast.makeText(getActivity(), e.getMessage(), Toast.LENGTH_LONG).show();
                    }
                }
                adapterDaftarBarang.updatedatabarang(daftarseluruhBarang);
            }
            @Override
            public void onFailure(Call<Data_Response> call, Throwable t) {
                Log.d("Error Jaringan", "disini");
                t.printStackTrace();
                Log.d("here", "here", t);
                Toast.makeText(getActivity(), "Terjadi kesalahan", Toast.LENGTH_SHORT).show();
            }
        });
        startRecyclerView();
    }

    private void startRecyclerView() {
        tabel_barang.setAdapter(adapterDaftarBarang);
        tabel_barang.setLayoutManager(new LinearLayoutManager(getActivity()));
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_dashboard, container, false);
    }
}
