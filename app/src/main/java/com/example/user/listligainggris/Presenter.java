package com.example.user.listligainggris;

import android.content.Context;
import android.util.Log;
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

public class Presenter {

    private String idTeam = "idTeam";
    private String namaTeam = "strTeam";
    private String gambarTeam = "strTeamBadge";
    private String intFormedYear = "intFormedYear";
    private String namaPelatih = "strManager";
    private String namaStadion = "strStadium";
    private String gambarStadion = "strStadiumThumb";
    private String deskripsiStadion = "strStadiumDescription";
    private String lokasiStadion = "strStadiumLocation";
    private String kapsitasStadion = "intStadiumCapacity";
    private String webTeam = "strWebsite";
    private String fbTeam = "strFacebook";
    private String twTeam = "strTwitter";
    private String igTeam = "strInstagram";
    private String youtubeTeam = "strYoutube";
    private String negara = "strCountry";
    private String deskripsiTeam = "strDescriptionEN";
    private String jerseyTeam = "strTeamJersey";
    private String logoTeam = "strTeamLogo";
    private String julukan = "strKeywords";
    private String asalLiga = "strLeague";

    MainView view;
    StringRequest stringRequest;
    ApiRepository apiRepository;
    Context context;


    public MainView getView() {
        return view;
    }

    public void setView(MainView view) {
        this.view = view;
    }

    public StringRequest getStringRequest() {
        return stringRequest;
    }

    public void setStringRequest(StringRequest stringRequest) {
        this.stringRequest = stringRequest;
    }

    public ApiRepository getApiRepository() {
        return apiRepository;
    }

    public void setApiRepository(ApiRepository apiRepository) {
        this.apiRepository = apiRepository;
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }
    public Presenter(Context context, MainView view, ApiRepository apiRepository){
        this.apiRepository = apiRepository;
        this.context = context;
        this.view = view;
    }
    public void Load(String string){
        String URL = apiRepository.getLiga(string);
        Log.d("TAG", "Load : "+URL);
        final ArrayList<ListLigaInggris> listLigaInggrisList = new ArrayList<>();

        StringRequest stringRequest = new StringRequest(Request.Method.GET, URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject object = new JSONObject(response);
                    JSONArray ligaArray = object.getJSONArray("teams");
                    for (int i = 0; i < ligaArray.length(); i++) {
                        JSONObject ligaObject = ligaArray.getJSONObject(i);
                        ListLigaInggris listLigaInggris = new ListLigaInggris(ligaObject.getString(idTeam),
                                ligaObject.getString(namaTeam),
                                ligaObject.getString(namaPelatih),
                                ligaObject.getString(namaStadion),
                                ligaObject.getString(gambarTeam),
                                ligaObject.getString(gambarStadion),
                                ligaObject.getString(logoTeam),
                                ligaObject.getString(jerseyTeam),
                                ligaObject.getString(julukan),
                                ligaObject.getString(asalLiga),
                                ligaObject.getString(deskripsiTeam),
                                ligaObject.getString(deskripsiStadion),
                                ligaObject.getString(kapsitasStadion),
                                ligaObject.getString(intFormedYear),
                                ligaObject.getString(igTeam),
                                ligaObject.getString(fbTeam),
                                ligaObject.getString(twTeam),
                                ligaObject.getString(webTeam),
                                ligaObject.getString(youtubeTeam),
                                ligaObject.getString(lokasiStadion),
                                ligaObject.getString(negara));

                        listLigaInggrisList.add(listLigaInggris);
                    }
                    view.showData(listLigaInggrisList);

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(context, "Error",Toast.LENGTH_SHORT).show();
            }
        });
        RequestQueue requestQueue = Volley.newRequestQueue(context);
        requestQueue.add(stringRequest);
    }
}
