/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PesananPackage;

import java.util.ArrayList;
import java.util.List;

import MenuPackage.DetailPesanan;

/**
 *
 * @author lenovo
 */
public class Pesanan {

    private String idPesanan;
    private double totalHarga;
    private List<DetailPesanan> daftarItem;
    private String status;

    public Pesanan(String idPesanan) {
        this.idPesanan = idPesanan;
        this.daftarItem = new ArrayList<>();
        this.totalHarga = 0;

    }

    public String getIdPesanan() {
        return idPesanan;
    }

    public void setIdPesanan(String idPesanan) {
        this.idPesanan = idPesanan;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public double getTotalHarga() {
        return totalHarga;
    }

    public void tambahItem(DetailPesanan item) {
        daftarItem.add(item);
        totalHarga += item.getSubtotal();
        System.out.println(item.getQuantity() + "x " + item.getNamaProduk() + " berhasil ditambahkan ke pesanan");
    }

    public double hitungTotal() {
        return totalHarga;
    }

    public List<DetailPesanan> getDaftarItem() {
        return daftarItem;

    }
}
