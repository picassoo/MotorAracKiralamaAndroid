package com.example.muhammmedal.yazillim;

/**
 * Created by MUHAMMMED ALİ on 22.05.2017.
 */

public class Sirket {
    private String ad;
    private int kredi;

    public Sirket(String ad, int kredi) {
        this.ad = ad;
        this.kredi = kredi;
    }

    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }

    public int getKredi() {
        return kredi;
    }

    public void setKredi(int kredi) {
        this.kredi = kredi;
    }



}
