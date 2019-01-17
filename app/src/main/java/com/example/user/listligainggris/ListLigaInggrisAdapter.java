package com.example.user.listligainggris;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;

public class ListLigaInggrisAdapter extends RecyclerView.Adapter<ListLigaInggrisAdapter.ViewHolder> {
    private ArrayList<ListLigaInggris> listLigaInggrisList;
    private Context context;

    public ListLigaInggrisAdapter(Context context){
        this.context = context;
    }
    public ArrayList<ListLigaInggris> getListLigaInggrisList(){
        return listLigaInggrisList;
    }
    public void setListLigaInggrisList(ArrayList<ListLigaInggris> listLigaInggrisList){
        this.listLigaInggrisList = listLigaInggrisList;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_row, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListLigaInggrisAdapter.ViewHolder viewHolder, int i) {
        Glide.with(context).load(getListLigaInggrisList().get(i).getGambarTeam()).into(viewHolder.imgTeam);
        viewHolder.tvTeam.setText(getListLigaInggrisList().get(i).getNamaTeam());

    }



    @Override
    public int getItemCount() {
        return getListLigaInggrisList().size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
        @BindView(R.id.img_team)
        CircleImageView imgTeam;

        @BindView(R.id.tv_nama_team)
        TextView tvTeam;

//        @BindView(R.id.tv_nama_pelatih)
//        TextView tvManager;
//
//        @BindView(R.id.tv_nama_stadion)
//        TextView tvStadium;
//
//        @BindView(R.id.tv_deskripsi_team)
//        TextView tvDescriptionEN;

    }


}
