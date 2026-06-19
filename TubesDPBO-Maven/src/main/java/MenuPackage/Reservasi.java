/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MenuPackage;

/**
 *
 * @author lenovo
 */
public class Reservasi extends Menu{

    private String idReservasi;
    private int jumlahOrang;

    public Reservasi(String idMenu, String menuProduk, int harga, String idReservasi, int jumlahOrang) {
        super(idMenu, menuProduk, harga);
        this.idReservasi = idReservasi;
        this.jumlahOrang = jumlahOrang;
    }

    public String getIdReservasi() {
        return idReservasi;
    }

    public int getJumlahOrang() {
        return jumlahOrang;
    }

    public void setIdReservasi(String idReservasi) {
        this.idReservasi = idReservasi;
    }

    public void setJumlahOrang(int jumlahOrang) {
        this.jumlahOrang = jumlahOrang;
    }

}
