package com.mycompany.app;

import java.io.Serializable;

/**
 * Created by FiratUlgay on 8.12.2019.
 */
public class Musteri implements Serializable {

    private String musteriAdi;
    private int musteriID;

    public String getMusteriAdi() {
        return musteriAdi;
    }

    public void setMusteriAdi(String musteriAdi) {
        this.musteriAdi = musteriAdi;
    }

    public int getMusteriID() {
        return musteriID;
    }

    public void setMusteriID(int musteriID) {
        this.musteriID = musteriID;
    }
}
