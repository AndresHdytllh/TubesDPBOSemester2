/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PembayaranPackage;

/**
 *
 * @author lenovo
 */
public class PembayaranTunai extends Pembayaran{
    private double uangDiterima;

    public PembayaranTunai(String idPembayaran, double jumlahBayar, double uangDiterima) {
        super(idPembayaran, jumlahBayar);
        this.uangDiterima = uangDiterima;
    }

    public double getUangDiterima() {
        return uangDiterima;
    }

    public void setUangDiterima(double uangDiterima) {
        this.uangDiterima = uangDiterima;
    }
    
    @Override
    public boolean prosesPembayaran(){
        if(uangDiterima >= getJumlahBayar()){
            double kembalian = uangDiterima - getJumlahBayar();
            System.out.println("Pembayaran Berhasil");
            System.out.println("ID Pembayaran : " + getIdPembayaran());
            System.out.printf("Jumlah Tagihan : Rp %.2f%n", getJumlahBayar());
            System.out.printf ("Uang Diterima : Rp %.2f%n", uangDiterima);
            System.out.printf ("Kembalian     : Rp %.2f%n", kembalian);
            return true;
        }else {
             double kekurangan = getJumlahBayar() - uangDiterima;
            System.out.println("Pembayaran Tunai Gagal");
            System.out.printf ("Uang kurang sebesar Rp %.2f%n", kekurangan);
            return false;
        }
    }
}
