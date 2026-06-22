package PembayaranPackage;

import PesananPackage.Pesanan;
import StatusPackage.StatusPesanan;

/**
 * PERBAIKAN: Ditambahkan referensi ke Pesanan sehingga prosesPembayaran() bisa
 * langsung memperbarui status pesanan setelah berhasil. Sebelumnya Pembayaran
 * sama sekali tidak terhubung ke Pesanan.
 */
public abstract class Pembayaran {

    private String idPembayaran;
    private double jumlahBayar;
    private Pesanan pesanan;        // relasi ke Pesanan

    public Pembayaran(String idPembayaran, Pesanan pesanan) {
        this.idPembayaran = idPembayaran;
        this.pesanan = pesanan;
        this.jumlahBayar = pesanan.hitungTotal();
    }

    public String getIdPembayaran() {
        return idPembayaran;
    }

    public double getJumlahBayar() {
        return jumlahBayar;
    }

    public Pesanan getPesanan() {
        return pesanan;
    }

    public void setIdPembayaran(String id) {
        this.idPembayaran = id;
    }

    public void setJumlahBayar(double bayar) {
        this.jumlahBayar = bayar;
    }

    public void setPesanan(Pesanan p) {
        this.pesanan = p;
        this.jumlahBayar = p.hitungTotal();
    }

    /**
     * Dipanggil oleh subclass setelah pembayaran berhasil: mengubah status
     * pesanan menjadi SELESAI.
     */
    protected void selesaikanPembayaran() {
        pesanan.setStatus(StatusPesanan.SELESAI);
        System.out.println("Status pesanan " + pesanan.getIdPesanan() + " → SELESAI");
    }

    public abstract boolean prosesPembayaran();
}
