package com.example.user.listligainggris;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;


public class ListLigaInggris implements Serializable {
    String idTeam, strTeam, strTeamBadge, strManager, strStadium, strStadiumThumb, strDescriptionEN;


    public ListLigaInggris(String idTeam,
                           String strTeam,
                           String strTeamBadge,
                           String strManager,
                           String strStadium,
                           String strStadiumThumb,
                           String strDescriptionEN){
        this.idTeam = idTeam;
        this.strTeam = strTeam;
        this.strTeamBadge = strTeamBadge;
        this.strManager = strManager;
        this.strStadium = strStadium;
        this.strStadiumThumb = strStadiumThumb;
        this.strDescriptionEN = strDescriptionEN;

    }
    /**

    protected ListLigaInggris(Parcel in){
        idTeam = in.readString();
        strTeam =in.readString();
        strTeamBadge = in.readString();
        strManager = in.readString();
        strStadiumThumb = in.readString();
        strDescriptionEN = in.readString();
        strStadium = in.readString();
    }
    public static final Creator<ListLigaInggris> CREATOR = new Creator<ListLigaInggris>() {
        @Override
        public ListLigaInggris createFromParcel(Parcel parcel) {

            return new ListLigaInggris(parcel);
        }

        @Override
        public ListLigaInggris[] newArray(int size) {

            return new ListLigaInggris[size];
        }
    }; **/

    public String getIdTeam() {
        return idTeam;
    }

    public void setIdTeam(String idTeam) {
        this.idTeam = idTeam;
    }

    public String getStrTeam() {
        return strTeam;
    }

    public void setStrTeam(String strTeam) {
        this.strTeam = strTeam;
    }

    public String getStrTeamBadge() {
        return strTeamBadge;
    }

    public void setStrTeamBadge(String strTeamBadge) {
        this.strTeamBadge = strTeamBadge;
    }

    public String getStrManager() {
        return strManager;
    }

    public String getStrStadium() {
        return strStadium;
    }

    public void setStrStadium(String strStadium) {
        this.strStadium = strStadium;
    }

    public void setStrManager(String strManager) {
        this.strManager = strManager;
    }

    public String getStrStadiumThumb() {
        return strStadiumThumb;
    }

    public void setStrStadiumThumb(String strStadiumThumb) {
        this.strStadiumThumb = strStadiumThumb;
    }

    public String getStrDescriptionEN() {
        return strDescriptionEN;
    }

    public void setStrDescriptionEN(String strDescriptionEN) {
        this.strDescriptionEN = strDescriptionEN;
    }

    /**

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int flags) {
        parcel.writeString(idTeam);
        parcel.writeString(strTeam);
        parcel.writeString(strTeamBadge);
        parcel.writeString(strManager);
        parcel.writeString(strStadium);
        parcel.writeString(strStadiumThumb);
        parcel.writeString(strDescriptionEN);

    } **/
}
