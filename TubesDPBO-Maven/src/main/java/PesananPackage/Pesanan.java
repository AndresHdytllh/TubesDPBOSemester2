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
    private String status;

    public Pesanan(String idPesanan) {
        this.idPesanan = idPesanan;
        this.totalHarga = 0;
        this.status = "MENUNGGU";
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

    public void setTotalHarga(double total) {
        this.totalHarga = total;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String s) {
        this.status = s;
    }

    public void tambahItem(String namaItem, int qty) {
        System.out.println(qty + " x " + namaItem + " ditambahkan.");
    }

    public double hitungTotal() {
        return totalHarga;
    }
}