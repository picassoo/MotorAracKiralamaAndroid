package com.example.muhammmedal.yazillim;

import java.util.ArrayList;

/**
 *
 * @author ghost
 */
public class Rapor {

    @Override
    public String toString() {
        String all = "Rapor{" + "arac=" + arac.getMarka() +" "+arac.getModel() +"\n sirket=" + sirket.getAd() + '}';
        for (KilometreVerisi kv : arac.getKv())  all.concat("\n"+kv.getKilometre()+" "+kv.getTarih());
        for (YakitHarcama kv : arac.getyHarcama())  all.concat("\n"+kv.getMiktar()+" "+kv.getLitre()+""+kv.getTarih());
        for (ParcaDegisimi kv : arac.getPd())  all.concat("\n"+kv.getAciklama()+" "+kv.getParca()+""+kv.getTarih());
        return all;
    }
    private Arac arac;
    private Sirket sirket;

    public Sirket getSirket() {
        return sirket;
    }

    public void setSirket(Sirket sirket) {
        this.sirket = sirket;
    }


    public Arac getArac() {
        return arac;
    }

    public void setArac(Arac arac) {
        this.arac = arac;
    }

    public String raporlaSurucu(Arac a,Sirket ss){
        return a.toString()  + ss.toString();
    }

    public Rapor(Arac arac, Sirket sirket) {
        this.arac = arac;
        this.sirket = sirket;
    }



}
