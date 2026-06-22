package PembayaranPackage;

import PesananPackage.Pesanan;

public class PembayaranTunai extends Pembayaran {

    private double uangDiterima;

    public PembayaranTunai(String idPembayaran, Pesanan pesanan, double uangDiterima) {
        super(idPembayaran, pesanan);
        this.uangDiterima = uangDiterima;
    }

    public double getUangDiterima() {
        return uangDiterima;
    }

    public void setUangDiterima(double u) {
        this.uangDiterima = u;
    }

    @Override
    public boolean prosesPembayaran() {
        if (uangDiterima >= getJumlahBayar()) {
            double kembalian = uangDiterima - getJumlahBayar();
            System.out.println("Pembayaran Tunai Berhasil");
            System.out.println("ID Pembayaran  : " + getIdPembayaran());
            System.out.printf("Jumlah Tagihan : Rp %.2f%n", getJumlahBayar());
            System.out.printf("Uang Diterima  : Rp %.2f%n", uangDiterima);
            System.out.printf("Kembalian      : Rp %.2f%n", kembalian);
            selesaikanPembayaran();
            return true;
        } else {
            double kekurangan = getJumlahBayar() - uangDiterima;
            System.out.println("Pembayaran Tunai Gagal");
            System.out.printf("Uang kurang sebesar Rp %.2f%n", kekurangan);
            return false;
        }
    }
}
