package com.mycompany.app;

/**
 * Created by FiratUlgay on 9.12.2019.
 */
public class UrunException extends Exception {

    String hataMEsaj;

    public UrunException(String hataMEsaj){
        this.hataMEsaj = hataMEsaj;
    }

    @Override
    public String getMessage() {
        return hataMEsaj;
    }
}
