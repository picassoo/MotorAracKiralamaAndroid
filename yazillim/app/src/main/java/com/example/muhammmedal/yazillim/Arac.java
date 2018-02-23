package com.example.muhammmedal.yazillim;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by MUHAMMMED ALİ on 22.05.2017.
 */

public class Arac {

    public Arac(String plaka, String marka, String model, boolean durum, Sirket malSahibi) {
        this.plaka = plaka;
        this.marka = marka;
        this.model = model;
        this.durum = durum;

        this.malSahibi = malSahibi;
    }

    @Override
    public String toString() {
        return "Arac{" + "plaka=" + plaka + ", marka=" + marka + ", model=" + model + ", durum=" + durum + ", malSahibi=" + malSahibi.getAd() + '}';
    }
    private String plaka;
    private String marka;
    private String model;
    private boolean durum;
    private Sirket malSahibi;

    private ArrayList<YakitHarcama> yHarcama = new ArrayList<YakitHarcama>();

    public void addHarcama(YakitHarcama ya) {
        yHarcama.add(ya);
    }
    public void addKm(KilometreVerisi km) {
        kv.add(km);
    }
    public void addBakım(Bakim ba) {
        bakim.add(ba);
    }
    public void AddParça(ParcaDegisimi pa) {
        pd.add(pa);
    }
    public void setBakim(ArrayList<Bakim> bakim) {
        this.bakim = bakim;
    }

    public void setKv(ArrayList<KilometreVerisi> kv) {
        this.kv = kv;
    }

    public void setPd(ArrayList<ParcaDegisimi> pd) {
        this.pd = pd;
    }

    public Sirket getMalSahibi() {
        return malSahibi;
    }

    public void setMalSahibi(Sirket malSahibi) {
        this.malSahibi = malSahibi;
    }

    public ArrayList<YakitHarcama> getyHarcama() {
        return yHarcama;
    }

    public ArrayList<Bakim> getBakim() {
        return bakim;
    }

    public ArrayList<KilometreVerisi> getKv() {
        return kv;
    }

    public ArrayList<ParcaDegisimi> getPd() {
        return pd;
    }
    private ArrayList<Bakim> bakim = new ArrayList<Bakim>();
    private ArrayList<KilometreVerisi> kv = new ArrayList<KilometreVerisi>();
    private ArrayList<ParcaDegisimi> pd = new ArrayList<ParcaDegisimi>();

    public String getPlaka() {
        return plaka;
    }

    public void setPlaka(String plaka) {
        this.plaka = plaka;
    }

    public String getMarka() {
        return marka;
    }

    public void setMarka(String marka) {
        this.marka = marka;
    }

    public void getDate(){
    }

    public void setKM(Date d){

    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public boolean getDurum() {
        return durum;
    }

    public void setDurum(boolean durum) {
        this.durum = durum;
    }

    public boolean getHavuz(){
        return true;
    }

}
