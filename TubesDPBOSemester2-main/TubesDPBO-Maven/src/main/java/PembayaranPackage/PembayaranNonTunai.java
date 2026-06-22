package PembayaranPackage;

import PesananPackage.Pesanan;

public class PembayaranNonTunai extends Pembayaran {

    private String jenisMetode;

    public PembayaranNonTunai(String idPembayaran, Pesanan pesanan, String jenisMetode) {
        super(idPembayaran, pesanan);
        this.jenisMetode = jenisMetode;
    }

    public String getJenisMetode() {
        return jenisMetode;
    }

    public void setJenisMetode(String metode) {
        this.jenisMetode = metode;
    }

    @Override
    public boolean prosesPembayaran() {
        if (jenisMetode != null && !jenisMetode.isBlank()) {
            System.out.println("=== Pembayaran Non-Tunai Berhasil ===");
            System.out.println("ID Pembayaran  : " + getIdPembayaran());
            System.out.println("Metode         : " + jenisMetode);
            System.out.printf("Jumlah Bayar   : Rp %.2f%n", getJumlahBayar());
            System.out.println("Transaksi diproses melalui " + jenisMetode + ".");
            selesaikanPembayaran();
            return true;
        } else {
            System.out.println("=== Pembayaran Non-Tunai Gagal ===");
            System.out.println("Metode pembayaran tidak valid atau tidak dipilih.");
            return false;
        }
    }
}
