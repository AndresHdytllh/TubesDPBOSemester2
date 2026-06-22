package LaporanPackage;

import java.util.ArrayList;
import java.util.List;

public class LaporanKeuangan {

    private String idLaporan;
    private String periode;
    private List<Invoice> daftarInvoice;
    private double totalPendapatan;

    public LaporanKeuangan(String idLaporan, String periode) {
        this.idLaporan = idLaporan;
        this.periode = periode;
        this.daftarInvoice = new ArrayList<>();
        this.totalPendapatan = 0;
    }

    public String getIdLaporan() {
        return idLaporan;
    }

    public String getPeriode() {
        return periode;
    }

    public double getTotalPendapatan() {
        return totalPendapatan;
    }

    public List<Invoice> getDaftarInvoice() {
        return daftarInvoice;
    }

    public void tambahInvoice(Invoice invoice) {
        daftarInvoice.add(invoice);
        totalPendapatan += invoice.getTotalBayar();
    }

    public void tampilkanLaporan() {
        System.out.println("=================================");
        System.out.println("        LAPORAN KEUANGAN         ");
        System.out.println("=================================");
        System.out.println("ID Laporan      : " + idLaporan);
        System.out.println("Periode         : " + periode);
        System.out.println("Jumlah Transaksi: " + daftarInvoice.size());
        System.out.printf("Total Pendapatan: Rp %.2f%n", totalPendapatan);
        System.out.println("=================================");
    }
}
