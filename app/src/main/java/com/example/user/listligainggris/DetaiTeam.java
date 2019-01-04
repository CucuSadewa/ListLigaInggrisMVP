package com.example.user.listligainggris;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import java.util.List;

public class DetaiTeam extends AppCompatActivity {
    ImageView imageView
            ;
    TextView tvTeam, tvManager, tvStadium, tvDescriptionEN, tvDescriptionStadium;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.detail_activity );
        imageView = findViewById(R.id.img_team);
        tvTeam = findViewById(R.id.tv_nama_team);
        tvManager = findViewById(R.id.tv_nama_pelatih);
        tvStadium = findViewById(R.id.tv_nama_stadion);
        tvDescriptionEN = findViewById(R.id.tv_deskripsi_team);

        ListLigaInggris listLigaInggris = getIntent().getParcelableExtra("team");

        Glide.with(this).load(listLigaInggris.getStrTeamBadge()).into(imageView);
        tvTeam.setText(listLigaInggris.getStrTeam());
        tvManager.setText(listLigaInggris.getStrManager());
        tvStadium.setText(listLigaInggris.getStrStadium());
        tvDescriptionEN.setText(listLigaInggris.getStrDescriptionEN());


    }
}
