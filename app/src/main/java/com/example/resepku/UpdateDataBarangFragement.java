package com.example.resepku;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.resepku.Response.Data_Response;
import com.example.resepku.model.Data_Model;
import com.example.resepku.rest.ApiConnection;
import com.example.resepku.rest.InterfaceConnection;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import org.json.JSONObject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UpdateDataBarangFragement extends Fragment {

    TextInputEditText updateNamaBarang, updateJumlahBarang, updatedetail;
    TextInputLayout layoutUpdateNamaBarang, layoutUpdateJumlahBarang, layoutUpdatedetail;

    Button btnUpdateBarang;
    String kodeBarang, namaBarang, jumlahBarang, detail, title;
    TextView hiddenKodeBarang, titleresep;
    InterfaceConnection interfaceConnection;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        interfaceConnection = ApiConnection.getClient().create(InterfaceConnection.class);
         updatedetail= (TextInputEditText)view.findViewById(R.id.updatedetail);
        updateNamaBarang = (TextInputEditText)view.findViewById(R.id.updateNamaBarang);
        updateJumlahBarang = (TextInputEditText)view.findViewById(R.id.updateJumlahBarang);
        layoutUpdateNamaBarang = (TextInputLayout)view.findViewById(R.id.layoutUpdateNamaBarang);
        layoutUpdateJumlahBarang = (TextInputLayout)view.findViewById(R.id.layoutUpdateJumlahBarang);
        layoutUpdatedetail = (TextInputLayout)view.findViewById(R.id.layoutUpdatedetail);
        hiddenKodeBarang = (TextView)view.findViewById(R.id.hiddenkodeBarang);
        titleresep = (TextView)view.findViewById(R.id.title_resep);
        btnUpdateBarang = (Button)view.findViewById(R.id.btnUpdateBarang);

        try {
            final Bundle bundle = getArguments();
            kodeBarang = bundle.getString("kdBarang");
            namaBarang = bundle.getString("nmBarang");
            jumlahBarang = bundle.getString("jmlBarang");
            detail = bundle.getString("detail");
            title = bundle.getString("title");
        }
        catch(final Exception e){
            // Do nothing
        }

        updateNamaBarang.setText(namaBarang);
        updateJumlahBarang.setText(jumlahBarang);
        updatedetail.setText(detail);
        titleresep.setText(title);

        btnUpdateBarang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateBarang();
            }
        });
    }

    private void updateBarang() {
//        Toast.makeText(getContext(), namaBarang, Toast.LENGTH_SHORT).show();
        String getNewNamaBarang = updateNamaBarang.getText().toString();
        String getNewJumlahaBarang = updateJumlahBarang.getText().toString();
        Data_Model dataModel = new Data_Model();
        dataModel.setNama_barang(getNewJumlahaBarang);
        dataModel.setJumlah_barang(getNewNamaBarang);
        Call<Data_Response> update_data_barang = interfaceConnection.update_barang(kodeBarang, getNewNamaBarang, getNewJumlahaBarang);
        Log.d("Kode Barang", kodeBarang);
        Log.d("Nama Barang", kodeBarang);
        Log.d("Jumlah Barang", kodeBarang);
        update_data_barang.enqueue(new Callback<Data_Response>() {
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
                Toast.makeText(getActivity(), "Terjadi kesalahan", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_update_data_barang, container, false);
    }


}
