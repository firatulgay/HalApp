package com.mycompany.app;

import java.io.Serializable;

/**
 * Created by FiratUlgay on 6.12.2019.
 */
public class Stok implements Serializable{

    private Urun urun;
    private Personel personel;
    private int miktar;

    public int getMiktar() {
        return miktar;
    }

    public void setMiktar(int miktar) {
        this.miktar = miktar;
    }

    public Personel getPersonel() {
        return personel;
    }

    public void setPersonel(Personel personel) {
        this.personel = personel;
    }

    public Urun getUrun() {
        return urun;
    }

    public void setUrun(Urun urun) {
        this.urun = urun;
    }






}
