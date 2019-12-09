package com.mycompany.app;

import java.io.Serializable;

/**
 * Created by FiratUlgay on 7.12.2019.
 */
public class Personel implements Serializable {

    private String personelId;
    private String personelAdi;

    public String getPersonelId() {
        return personelId;
    }

    public void setPersonelId(String personelId) {
        this.personelId = personelId;
    }

    public String getPersonelAdi() {
        return personelAdi;
    }

    public void setPersonelAdi(String personelAdi) {
        this.personelAdi = personelAdi;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Personel personel = (Personel) o;

        return personelId == personel.personelId;
    }


}
