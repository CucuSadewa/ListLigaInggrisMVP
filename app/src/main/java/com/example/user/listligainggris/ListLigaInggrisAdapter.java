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

public class ListLigaInggrisAdapter extends ArrayAdapter<ListLigaInggris> {
    private List<ListLigaInggris> listLigaInggrisList;
    private Context context;

    public ListLigaInggrisAdapter(List<ListLigaInggris> listLigaInggrisList, Context context){
        super(context, R.layout.list_row, listLigaInggrisList);
        this.listLigaInggrisList = listLigaInggrisList;
        this.context = context;
    }

    @Override
    public View getView(final  int position, View converView, ViewGroup parent){
        LayoutInflater inflater = LayoutInflater.from(context);
        View listViewTeam =inflater.inflate(R.layout.list_row, null, true);

        ImageView imgTeam = listViewTeam.findViewById(R.id.img_team);
        //TextView tvIdTeam = listViewTeam.findViewById(R.id.tv_team);
        TextView tvNamaTeam = listViewTeam.findViewById(R.id.tv_nama_team);
        TextView tvNamaPelatih = listViewTeam.findViewById(R.id.tv_nama_pelatih);
        TextView tvNamaStadion = listViewTeam.findViewById(R.id.tv_nama_stadion);
        //TextView tvDeskripsi = listViewTeam.findViewById(R.id.tv_deskripsi_team);

        ListLigaInggris listLigaInggris = listLigaInggrisList.get(position);

        Glide.with(context).load(listLigaInggris.getStrTeamBadge()).into(imgTeam);
        tvNamaTeam.setText(listLigaInggris.getStrTeam());
        tvNamaPelatih.setText(listLigaInggris.getStrManager());
        tvNamaStadion.setText(listLigaInggris.getStrStadium());
        //tvDeskripsi.setText(listLigaInggris.getStrDescriptionEN());

        return listViewTeam;
    }

    /**
    public ArrayList<ListLigaInggris> getListLigaInggrise(){
        return listLigaInggrise;
    }
    public void setListLigaInggrise(ArrayList<ListLigaInggris> listLigaInggrise){
        this.listLigaInggrise = listLigaInggrise;
    }
    private ArrayList<ListLigaInggris> listLigaInggrise;


    public ListLigaInggrisAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_row, viewGroup,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        Glide.with(context).load(getListLigaInggrise().get(i).getStrTeamBadge()).into(viewHolder.imgTeam);

        viewHolder.tvTeam.setText(String.format("strTeam", getListLigaInggrise().get(i).getStrTeam()));
        viewHolder.tvManager.setText(String.format("strManager", getListLigaInggrise().get(i).strManager));
        viewHolder.tvStadium.setText(String.format("strStadium", getListLigaInggrise().get(i).strStadium));
        viewHolder.tvDescriptionEN.setText(String.format("strDescriptionEN", getListLigaInggrise().get(i).strDescriptionEN));


    }
    @Override
    public int getItemCount() {
        return getListLigaInggrise().size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
        @BindView(R.id.img_team)
        ImageView imgTeam;

        @BindView(R.id.tv_nama_team)
        TextView tvTeam;

        @BindView(R.id.tv_nama_pelatih)
        TextView tvManager;

        @BindView(R.id.tv_nama_stadion)
        TextView tvStadium;

        @BindView(R.id.tv_deskripsi_team)
        TextView tvDescriptionEN;

    } **/


}
