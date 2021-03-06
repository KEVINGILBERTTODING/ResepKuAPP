package com.example.resepku;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.resepku.model.Data_Model;
import com.example.resepku.rest.InterfaceConnection;

import java.util.ArrayList;


public class AdapterDaftarResep extends RecyclerView.Adapter<AdapterDaftarResep.ViewHolder> {

    ShowResep showResep;
    InterfaceConnection interfaceConnection;
    ArrayList<Data_Model> daftarBarang;
    Context mContext;
    String id;

    public AdapterDaftarResep(Context context){
        daftarBarang = new ArrayList<>();
        mContext = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_daftar_resep, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.kodeBarang.setText(daftarBarang.get(position).getKode_barang());
        holder.titleResep.setText(daftarBarang.get(position).getTitle_resep());
        holder.namaBarang.setText(daftarBarang.get(position).getNama_category());
        holder.durationResep.setText(daftarBarang.get(position).getDuration_resep());
        holder.jumlahBarang.setText(daftarBarang.get(position).getIngredients());


        // Menggunakan library glide

        Glide.with(mContext)
             .load("http://172.20.10.3/myresep/storage/app/pictures/"+daftarBarang.get(position).getPicture_resep())
           .into(holder.picture_Resep);


//        Glide.with(mContext)
//                .load(daftarBarang.get(position).getImage_resep())
//                .into(holder.picture_Resep);



        
        holder.btnShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String kode = daftarBarang.get(position).getKode_barang();
                String nama = daftarBarang.get(position).getNama_category();
                String jumlah = daftarBarang.get(position).getIngredients();
                String detail = daftarBarang.get(position).getDetail_resep();
                String title = daftarBarang.get(position).getTitle_resep();
                String category = daftarBarang.get(position).getNama_category();
                String duration = daftarBarang.get(position).getDuration_resep();



                Bundle bundle = new Bundle();
//                bundle.putString("key", "data");
                bundle.putString("kdBarang", kode);
                bundle.putString("nmBarang", nama);
                bundle.putString("jmlBarang", jumlah);
                bundle.putString("detail", detail);
                bundle.putString("title", title);
                bundle.putString("category", category);
                bundle.putString("duration", duration);
                bundle.putString("ingredient", jumlah);



                Fragment fragment = new ShowResep();
                fragment.setArguments(bundle);
                FragmentManager fragmentManager = ((MainActivity)mContext).getSupportFragmentManager();
                  fragmentManager.beginTransaction().replace(R.id.fragment_container, fragment).commit();
            }
        });
    }


    @Override
    public int getItemCount() {
        return daftarBarang.size();
    }

    public void updatedatabarang(ArrayList<Data_Model> updatedatabarang){
        daftarBarang.clear();
        daftarBarang.addAll(updatedatabarang);
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        ConstraintLayout layout_daftar_barang;
        TextView kodeBarang, namaBarang, jumlahBarang, titleResep, durationResep, detailResep;
        ImageButton btnDelete, btnShow;
        ImageView picture_Resep;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            layout_daftar_barang = (ConstraintLayout)itemView.findViewById(R.id.layout_daftar_barang);
            kodeBarang = (TextView) itemView.findViewById(R.id.textViewKodeBarang);
            namaBarang = (TextView)itemView.findViewById(R.id.textViewNamaBarang);
            titleResep = (TextView) itemView.findViewById(R.id.textViewtitle) ;
            jumlahBarang = (TextView)itemView.findViewById(R.id.textViewJumlahBarang);
            durationResep = (TextView)itemView.findViewById(R.id.textviewduration);
            detailResep = (TextView)itemView.findViewById(R.id.detail_resep);
            picture_Resep = itemView.findViewById(R.id.picture_resep);
            btnDelete = (ImageButton)itemView.findViewById(R.id.imgBtnDeleteBarang);
            btnShow = (ImageButton)itemView.findViewById(R.id.imgBtnEditBarang);
        }
    }




}
