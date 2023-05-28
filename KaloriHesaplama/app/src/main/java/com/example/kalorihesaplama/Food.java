package com.example.kalorihesaplama;

import android.view.View;

public class Food {
    //private int foto;
    private String miktar;
    private String ad;
    private String kalori;

    public  Food(){

    }

    public Food(String miktar,String ad,String kalori) {
        this.miktar=miktar;
        this.ad=ad;
        this.kalori=kalori;
    }


    public String getMiktar() {

        return miktar;
    }

    public void setMiktar(String miktar) {

        this.miktar = miktar;
    }

    public String getAd() {

        return ad;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }

    public String getKalori() {

        return kalori;
    }

    public void setKalori(String kalori) {

        this.kalori = kalori;
    }

}
