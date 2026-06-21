/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PesananPackage;

/**
 *
 * @author lenovo
 */
public class Promo {

    private String kodePromo;
    private double diskon;

    public Promo(String kode, double diskon) {
        this.kodePromo = kode;
        this.diskon = diskon;
    }

    public String getKodePromo() {
        return kodePromo;
    }

    public void setKodePromo(String kode) {
        this.kodePromo = kode;
    }

    public double getDiskon() {
        return diskon;
    }

    public void setDiskon(double d) {
        this.diskon = d;
    }
}
