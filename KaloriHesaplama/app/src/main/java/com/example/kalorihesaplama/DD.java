package com.example.kalorihesaplama;

public class DD {
    private String tarih;
    private String toplamkcal;

    public DD(){

    }

    public DD(String tarih,String toplamkcal) {
        this.tarih = tarih;
        this.toplamkcal=toplamkcal;
    }

    public String getTarih() {
        return tarih;
    }

    public void setTarih(String tarih) {
        this.tarih = tarih;
    }

    public String getToplamkcal() {
        return toplamkcal;
    }

    public void setToplamkcal(String toplamkcal) {
        this.toplamkcal = toplamkcal;
    }
}
