/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PesananPackage;

/**
 *
 * @author lenovo
 */
public class Kasir {

    private String idShift;

    public Kasir(String idShift) {
        this.idShift = idShift;
    }

    public String getIdShift() {
        return idShift;
    }

    public void setIdShift(String shift) {
        this.idShift = shift;
    }

    public String getRole() {
        return "Kasir";
    }

    public void konfirmasiPembayaran(Pesanan p) {
        p.setStatus("LUNAS");
        System.out.println("Pembayaran pesanan "
                + p.getIdPesanan()
                + " berhasil dikonfirmasi.");
    }
}