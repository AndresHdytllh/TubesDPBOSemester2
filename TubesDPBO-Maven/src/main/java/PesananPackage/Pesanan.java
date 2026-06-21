/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PesananPackage;

/**
 *
 * @author lenovo
 */
public class Pesanan {

    private String idPesanan;
    private double totalHarga;

    public Pesanan(String idPesanan, int jumlahPesanan) {
        this.idPesanan = idPesanan;
        this.totalHarga = 0;
    }

    public String getIdPesanan() {
        return idPesanan;
    }

    public void setIdPesanan(String id) {
        this.idPesanan = id;
    }

    public double getTotalHarga() {
        return totalHarga;
    }

    public void tambahItem(String namaItem, int jumlahPesanan) {
        System.out.println(jumlahPesanan + " x " + namaItem + " ditambahkan.");
    }

    public double hitungTotal() {
        return totalHarga;
    }
}
