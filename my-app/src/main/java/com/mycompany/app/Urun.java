package com.mycompany.app;

import java.io.Serializable;

/**
 * Created by FiratUlgay on 6.12.2019.
 */
public abstract class Urun implements Serializable {

    private EnumMiktarTuru miktarTuru;
    private int fiyat;
    private int id;

    public EnumMiktarTuru getMiktarTuru() {
        return miktarTuru;
    }


    @Override
    public boolean equals(Object o) {
        Urun urun = (Urun) o;
        return this.id == urun.getId();
    }


    public void setMiktarTuru(EnumMiktarTuru miktarTuru) {
        this.miktarTuru = miktarTuru;
    }

    public int getFiyat() {
        return fiyat;
    }

    public void setFiyat(int fiyat) {
        this.fiyat = fiyat;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


}
