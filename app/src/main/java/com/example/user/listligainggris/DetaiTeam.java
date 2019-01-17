package com.example.user.listligainggris;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import java.util.List;

public class DetaiTeam extends AppCompatActivity {


    ImageView imgTeam, imgStadion, imgLogo, imgJersey;
    TextView tvidTeam, tvNamaTeam, tvNamaPelatih, tvNamaStadion, tvKapasitas, tvDescTeam, tvDescStadion, tvTahun,tvJulukan,
            tvAsalLiga, tvWeb, tvFb, tvTw, tvIg, tvYoutube;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_activity);

        imgTeam = findViewById(R.id.img_team_dt);
        tvidTeam = findViewById(R.id.tv_id_team_dt);
        imgStadion = findViewById(R.id.img_stadion_dt);
        imgLogo = findViewById(R.id.img_logo_dt);
        imgJersey = findViewById(R.id.img_jersey_dt);
        tvNamaTeam = findViewById(R.id.tv_nama_team_dt);
        tvNamaPelatih = findViewById(R.id.tv_nama_pelatih_dt);
        tvNamaStadion = findViewById(R.id.tv_nama_stadion_dt);
        tvKapasitas = findViewById(R.id.tv_kapasitas_stadion_dt);
        tvDescStadion = findViewById(R.id.tv_desc_stadion_dt);
        tvTahun = findViewById(R.id.tv_thn_berdiri_dt);
        tvDescTeam = findViewById(R.id.tv_desc_team_dt);
        tvJulukan = findViewById(R.id.tv_julukan_dt);
        tvAsalLiga = findViewById(R.id.tv_str_liga);
        tvWeb = findViewById(R.id.tv_nama_website_dt);
        tvFb = findViewById(R.id.tv_facebook_dt);
        tvTw = findViewById(R.id.tv_twitter_dt);
        tvIg = findViewById(R.id.tv_instagram_dt);
        tvYoutube = findViewById(R.id.tv_youtube_dt);




        ListLigaInggris  pojo  = getIntent().getParcelableExtra("teams");



        Glide.with(this).load(pojo.getGambarTeam()).into(imgTeam);
        Glide.with(this).load(pojo.getGambarStadion()).into(imgStadion);
        Glide.with(this).load(pojo.getLogoTeam()).into(imgLogo);
        Glide.with(this).load(pojo.getJerseyTeam()).into(imgJersey);
        tvNamaTeam.setText(pojo.getNamaTeam());
        tvNamaPelatih.setText(pojo.getNamaPelatih());
        tvJulukan.setText(pojo.getJulukan());
        tvAsalLiga.setText(pojo.getAsalLiga());
        tvTahun.setText(pojo.getIntFormedYear());
        tvDescTeam.setText(pojo.getDeskripsiTeam());
        tvNamaStadion.setText(pojo.getNamaStadion());
        tvKapasitas.setText(pojo.getKapsitasStadion());
        tvDescStadion.setText(pojo.getDeskripsiStadion());
        tvWeb.setText(pojo.getWebTeam());
        tvFb.setText(pojo.getFbTeam());
        tvTw.setText(pojo.getTwTeam());
        tvIg.setText(pojo.getIgTeam());
        tvYoutube.setText(pojo.getYoutubeTeam());
        tvidTeam.setText(pojo.getIdTeam());



//        Glide.with(this).load(getIntent().getStringExtra(EXTRA_IMG_TEAM)).into(imgTeam);
//        Glide.with(this).load(getIntent().getStringExtra(EXTRA_IMG_STADION)).into(imgStadion);
//        tvNamaTeam.setText(getIntent().getStringExtra(EXTRA_NAMA_TEAM));
//        tvNamaPelatih.setText(getIntent().getStringExtra(EXTRA_NAMA_PELATIH));
//        tvNamaStadion.setText(getIntent().getStringExtra(EXTRA_NAMA_STADION));
//        tvKapasitas.setText(getIntent().getStringExtra(EXTRA_KAPASITAS));
    }
}