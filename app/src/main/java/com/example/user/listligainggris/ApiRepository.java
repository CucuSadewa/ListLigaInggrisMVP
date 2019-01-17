package com.example.user.listligainggris;

import android.util.Log;

public class ApiRepository {
    public String getLiga(String string){
        String ligaURL = "search_all_teams.php?l=";
        String url = BuildConfig.BASE_URL+ligaURL+string;
        Log.d("TAG", "getLiga :"+url);
        return url;
    }
}
