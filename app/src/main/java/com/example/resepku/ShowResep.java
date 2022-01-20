package com.example.resepku;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
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

public class ShowResep extends Fragment {


    ImageButton btnback1;

    Button btnUpdateResep;
    String  detail, title, category, duration, ingredients, details;
    TextView hiddenKodeBarang, titleresep, categoryresep, durationresep, ingredientsresep, detailresep;
    InterfaceConnection interfaceConnection;


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        interfaceConnection = ApiConnection.getClient().create(InterfaceConnection.class);
        hiddenKodeBarang = (TextView)view.findViewById(R.id.hiddenkodeBarang);
        titleresep = (TextView)view.findViewById(R.id.title_resep);
        categoryresep = (TextView)view.findViewById(R.id.category_resep);
        durationresep = (TextView)view.findViewById(R.id.duration_resep);
        ingredientsresep = (TextView)view.findViewById(R.id.ingredient_resep);
        detailresep = (TextView)view.findViewById(R.id.detail_resep);

        btnUpdateResep = (Button)view.findViewById(R.id.btnUpdateBarang);
        btnback1 = (ImageButton)view.findViewById(R.id.btn_back1);



        try {
            final Bundle bundle = getArguments();

            detail = bundle.getString("detail");
            title = bundle.getString("title");
            category = bundle.getString("category");
            duration = bundle.getString("duration");
            ingredients = bundle.getString("ingredient");


        }
        catch(final Exception e){
            // Do nothing
        }


        detailresep.setText(detail);
        titleresep.setText(title);
        categoryresep.setText(category);
        durationresep.setText(duration);
        ingredientsresep.setText(ingredients);
        btnUpdateResep.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.show_resep, container, false);
    }




}
