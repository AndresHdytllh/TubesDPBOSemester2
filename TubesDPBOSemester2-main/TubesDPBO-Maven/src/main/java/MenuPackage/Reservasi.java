/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MenuPackage;

/**
 *
 * @author lenovo
 */
public class Reservasi{

    private String idReservasi;
    private int jumlahOrang;

    public Reservasi(String idReservasi, int jumlahOrang) {
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
