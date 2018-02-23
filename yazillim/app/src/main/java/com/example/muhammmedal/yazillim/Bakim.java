package com.example.muhammmedal.yazillim;

import java.util.Date;

/**
 *
 * @author ghost
 */
public class Bakim {
    private Date tarih;
    private String tur;
    private String aciklama;

    public void setTarih(Date tarih) {
        this.tarih = tarih;
    }

    public void setTur(String tur) {
        this.tur = tur;
    }

    public void setAciklama(String aciklama) {
        this.aciklama = aciklama;
    }

    public Date getTarih() {
        return tarih;
    }



}