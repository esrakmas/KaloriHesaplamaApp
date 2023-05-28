package com.example.kalorihesaplama;

public class Food2 {

    private String miktar2;
    private String ad2;
    private String kalori2;

    public  Food2(){

    }

    public Food2(String miktar2,String ad2,String kalori2) {
        this.miktar2=miktar2;
        this.ad2=ad2;
        this.kalori2=kalori2;
    }


    public String getMiktar2() {

        return miktar2;
    }

    public void setMiktar2(String miktar2) {

        this.miktar2 = miktar2;
    }

    public String getAd2() {

        return ad2;
    }

    public void setAd2(String ad2) {
        this.ad2 = ad2;
    }

    public String getKalori2() {

        return kalori2;
    }

    public void setKalori2(String kalori2) {

        this.kalori2 = kalori2;
    }
}
