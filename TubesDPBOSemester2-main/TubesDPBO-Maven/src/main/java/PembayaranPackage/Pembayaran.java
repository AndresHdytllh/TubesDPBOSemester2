/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PembayaranPackage;

/**
 *
 * @author lenovo
 */
abstract class Pembayaran {
    private String idPembayaran;
    private double jumlahBayar;

    public Pembayaran(String idPembayaran, double jumlahBayar) {
        this.idPembayaran = idPembayaran;
        this.jumlahBayar = jumlahBayar;
    }

    public String getIdPembayaran() {
        return idPembayaran;
    }

    public void setIdPembayaran(String idPembayaran) {
        this.idPembayaran = idPembayaran;
    }

    public double getJumlahBayar() {
        return jumlahBayar;
    }

    public void setJumlahBayar(double jumlahBayar) {
        this.jumlahBayar = jumlahBayar;
    }
    
    public abstract boolean prosesPembayaran();
}