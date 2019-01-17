package com.example.user.listligainggris;


import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;





public class    MainActivity extends AppCompatActivity implements MainView {
    @BindView(R.id.recyclerView)
            RecyclerView recyclerView;
    Presenter presenter;
    ListLigaInggrisAdapter adapter;
    ApiRepository apiRepository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        adapter = new ListLigaInggrisAdapter(this);
        apiRepository = new ApiRepository();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        presenter = new Presenter(this,this,apiRepository);
        presenter.Load("English%20Premier%20League");


    }
    @Override
    public void  showData(final ArrayList<ListLigaInggris> liga){
        adapter.setListLigaInggrisList(liga);
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
        ItemClickSupport.addTo(recyclerView).setOnItemClickListener(new ItemClickSupport.OnItemClickListener() {
            @Override
            public void onItemClick(RecyclerView recyclerView, int position, View view) {
                Intent intent = new Intent(MainActivity.this,DetaiTeam.class);
                ListLigaInggris ligaData = new ListLigaInggris(liga.get(position).getIdTeam(),
                        liga.get(position).getNamaTeam(),
                        liga.get(position).getNamaPelatih(),
                        liga.get(position).getNamaStadion(),
                        liga.get(position).getGambarTeam(),
                        liga.get(position).getGambarStadion(),
                        liga.get(position).getLogoTeam(),
                        liga.get(position).getJerseyTeam(),
                        liga.get(position).getJulukan(),
                        liga.get(position).getAsalLiga(),
                        liga.get(position).getDeskripsiTeam(),
                        liga.get(position).getDeskripsiStadion(),
                        liga.get(position).getKapsitasStadion(),
                        liga.get(position).getIntFormedYear(),
                        liga.get(position).getFbTeam(),
                        liga.get(position).getTwTeam(),
                        liga.get(position).getIgTeam(),
                        liga.get(position).getWebTeam(),
                        liga.get(position).getYoutubeTeam(),
                        liga.get(position).getLokasiStadion(),
                        liga.get(position).getNegara()
                        );

                intent.putExtra("teams",ligaData);
                startActivity(intent);

            }
        });

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.liga_inggris:
                presenter.Load("English%20Premier%20League");
                break;
            case R.id.liga_spain:
                presenter.Load("Spanish%20La%20Liga");
                break;
        }
        return true;

    }


    }
