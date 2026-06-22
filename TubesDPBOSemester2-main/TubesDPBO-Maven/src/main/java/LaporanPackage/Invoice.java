package LaporanPackage;

import MenuPackage.DetailPesanan;
import PembayaranPackage.Pembayaran;
import PembayaranPackage.PembayaranNonTunai;
import PembayaranPackage.PembayaranTunai;
import PesananPackage.Pesanan;

/**
 * PERBAIKAN: metodePembayaran (String) diganti dengan referensi ke objek
 * Pembayaran agar detail transaksi dapat diakses secara OOP. Invoice kini
 * dibuat dari objek Pembayaran, bukan dari Pesanan + String metode.
 */
public class Invoice {

    private String idInvoice;
    private Pesanan pesanan;
    private Pembayaran pembayaran;   // referensi ke Pembayaran
    private double totalBayar;

    public Invoice(String idInvoice, Pembayaran pembayaran) {
        this.idInvoice = idInvoice;
        this.pembayaran = pembayaran;
        this.pesanan = pembayaran.getPesanan();
        this.totalBayar = pesanan.hitungTotal();
    }

    public String getIdInvoice() {
        return idInvoice;
    }

    public Pesanan getPesanan() {
        return pesanan;
    }

    public Pembayaran getPembayaran() {
        return pembayaran;
    }

    public double getTotalBayar() {
        return totalBayar;
    }

    /**
     * Nama metode pembayaran diturunkan dari tipe objek Pembayaran.
     */
    public String getMetodePembayaran() {
        if (pembayaran instanceof PembayaranTunai) {
            return "Tunai";
        }
        if (pembayaran instanceof PembayaranNonTunai) {
            return ((PembayaranNonTunai) pembayaran).getJenisMetode();
        }
        return "Tidak Diketahui";
    }

    public void cetakInvoice() {
        System.out.println("============================================");
        System.out.println("           INVOICE BUANACOFFEE              ");
        System.out.println("============================================");
        System.out.println("ID Invoice   : " + idInvoice);
        System.out.println("ID Pesanan   : " + pesanan.getIdPesanan());
        System.out.println("Metode       : " + getMetodePembayaran());
        System.out.println("Status       : " + pesanan.getStatus());
        System.out.println("--------------------------------------------");
        System.out.println("RINCIAN PESANAN:");
        if (pesanan.getDaftarItem().isEmpty()) {
            System.out.println("  Tidak ada item pesanan.");
        } else {
            for (DetailPesanan item : pesanan.getDaftarItem()) {
                System.out.printf("  %dx %-20s Rp %.2f%n",
                        item.getQuantity(), item.getNamaProduk(), item.getSubtotal());
            }
        }
        System.out.println("--------------------------------------------");
        System.out.printf("TOTAL BAYAR  : Rp %.2f%n", totalBayar);
        System.out.println("============================================");
    }
}
