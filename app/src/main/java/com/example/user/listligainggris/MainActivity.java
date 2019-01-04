package com.example.user.listligainggris;


import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
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





public class MainActivity extends AppCompatActivity {
    ListView listView;
    private List<ListLigaInggris> listLigaInggrisList;

    /**
    @BindView(R.id.ListView)
    RecyclerView recyclerView;
    ListLigaInggrisAdapter adapter;

    private ArrayList<ListLigaInggris> listLigaInggrisList;
    String TAG = "TEST"; **/

    private static String URL = "https://www.thesportsdb.com/api/v1/json/1/search_all_teams.php?l=English%20Premier%20League";
    public final String ARRAY_NAME = "teams";
    public final String OBJECT_ID_TEAM = "idTeam";
    public final String OBJECT_NAMA_TEAM = "strTeam";
    public final String OBJECT_NAMA_PELATIH = "strManager";
    public final String OBJECT_NAMA_STADION = "strStadium";
    public final String OBJECT_GAMBAR_STADION = "strStadiumThumb";
    public final String OBJECT_GAMBAR_TEAM = "strTeamBadge";
    public final String OBJECT_DESKRIPSI_TEAM = "strDescriptionEN";


    @SuppressLint("WringViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        listView =(ListView)findViewById(R.id.ListView);
        listLigaInggrisList = new ArrayList<>();

        /**
        adapter = new ListLigaInggrisAdapter(this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
         **/

        Load();

    }

    private void Load() {
        StringRequest stringRequest = new StringRequest(Request.Method.GET, URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject obj = new JSONObject(response);
                    JSONArray ligaArray = obj.getJSONArray(ARRAY_NAME);
                    for (int i = 0; i < ligaArray.length(); i++) {
                        JSONObject ligaObject = ligaArray.getJSONObject(i);

                        ListLigaInggris listLigaInggris = new ListLigaInggris(ligaObject.getString(OBJECT_ID_TEAM),
                                ligaObject.getString(OBJECT_NAMA_TEAM),
                                ligaObject.getString(OBJECT_GAMBAR_TEAM),
                                ligaObject.getString(OBJECT_NAMA_PELATIH),
                                ligaObject.getString(OBJECT_NAMA_STADION),
                                ligaObject.getString(OBJECT_DESKRIPSI_TEAM),
                                ligaObject.getString(OBJECT_GAMBAR_STADION));
                        Log.d("text", "onResponse : " + listLigaInggris.getIdTeam());
                        listLigaInggrisList.add(listLigaInggris);
                    }
                    ListLigaInggrisAdapter adapter = new ListLigaInggrisAdapter(listLigaInggrisList, getApplicationContext());
                    listView.setAdapter(adapter);

                    /**
                    adapter.setListLigaInggrise(listLigaInggrisList);
                    adapter.notifyDataSetChanged();
                    recyclerView.setAdapter(adapter);
                    ItemClickSupport.addTo(recyclerView).setOnItemClickListener(new ItemClickSupport.OnItemClickListener() {
                        @Override
                        public void onItemClick(RecyclerView recyclerView, int position, View view) {
                            showClick(listLigaInggrisList.get(position));
                        }

                    }); **/

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(MainActivity.this, "Error", Toast.LENGTH_SHORT).show();

            }
        });
        RequestQueue requestQueue = Volley.newRequestQueue(MainActivity.this);
        requestQueue.add(stringRequest);

    }

    /**
        public void showClick (ListLigaInggris item){
            Toast.makeText(this, "Anda mengclik" + item.getStrTeamBadge(), Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this, DetaiTeam.class);
            intent.putExtra("team", item);
            startActivity(intent);
        } **/
    }
