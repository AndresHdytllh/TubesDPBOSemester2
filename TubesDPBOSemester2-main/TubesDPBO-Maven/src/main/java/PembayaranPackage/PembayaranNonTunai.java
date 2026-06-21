/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PembayaranPackage;

/**
 *
 * @author lenovo
 */
public class PembayaranNonTunai extends Pembayaran{
    private String jenisMetode;

    public PembayaranNonTunai(String idPembayaran, double jumlahBayar, String jenisMetode) {
        super(idPembayaran, jumlahBayar);
        this.jenisMetode = jenisMetode;
    }

    public String getJenisMetode() {
        return jenisMetode;
    }

    public void setJenisMetode(String jenisMetode) {
        this.jenisMetode = jenisMetode;
    }
    
    @Override
     public boolean prosesPembayaran() {
        if (jenisMetode != null && !jenisMetode.equals("")) {
            System.out.println("=== Pembayaran Non-Tunai Berhasil ===");
            System.out.println("ID Pembayaran  : " + getIdPembayaran());
            System.out.println("Metode         : " + jenisMetode);
            System.out.printf ("Jumlah Bayar   : Rp %.2f%n", getJumlahBayar());
            System.out.println("Transaksi diproses melalui sistem " + jenisMetode + ".");
            return true;
        } else {
            System.out.println("=== Pembayaran Non-Tunai Gagal ===");
            System.out.println("Metode pembayaran tidak valid atau tidak dipilih.");
            return false;
        }
    }
}
