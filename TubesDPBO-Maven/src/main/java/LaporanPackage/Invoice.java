package LaporanPackage;

import PesananPackage.Pesanan;

/**
 *
 * @author lenovo
 */
public class Invoice {
    private String idInvoice;
    private Pesanan pesanan;
    private double totalBayar;
    private String metodePembayaran; 

    public Invoice(String idInvoice, Pesanan pesanan, String metodePembayaran) {
        this.idInvoice = idInvoice;
        this.pesanan = pesanan;
        this.metodePembayaran = metodePembayaran;
        this.totalBayar = pesanan.hitungTotal();
    }

    public String getIdInvoice() {
        return idInvoice;
    }

    public void setIdInvoice(String idInvoice) {
        this.idInvoice = idInvoice;
    }

    public Pesanan getPesanan() {
        return pesanan;
    }

    public void setPesanan(Pesanan pesanan) {
        this.pesanan = pesanan;
        this.totalBayar = pesanan.hitungTotal();
    }

    public double getTotalBayar() {
        return totalBayar;
    }

    public String getMetodePembayaran() {
        return metodePembayaran;
    }

    public void setMetodePembayaran(String metodePembayaran) {
        this.metodePembayaran = metodePembayaran;
    }

    public void cetakInvoice() {
        System.out.println("=================================");
        System.out.println("         INVOICE PEMBAYARAN      ");
        System.out.println("=================================");
        System.out.println("ID Invoice   : " + idInvoice);
        System.out.println("ID Pesanan   : " + pesanan.getIdPesanan());
        System.out.println("Metode       : " + metodePembayaran);
        System.out.println("Status       : " + pesanan.getStatus());
        System.out.println("---------------------------------");
        System.out.printf("TOTAL BAYAR  : Rp %.2f%n", totalBayar);
        System.out.println("=================================");
    }
}
