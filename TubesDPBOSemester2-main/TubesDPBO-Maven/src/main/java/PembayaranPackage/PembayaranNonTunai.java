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
            selesaikanPembayaran();
            return true;
        }
        return false;
    }
}