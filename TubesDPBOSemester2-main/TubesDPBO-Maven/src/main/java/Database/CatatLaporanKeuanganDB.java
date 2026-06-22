package Database;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import LaporanPackage.Invoice;
import LaporanPackage.LaporanKeuangan;

/**
 * PERBAIKAN: Method utama sekarang menerima objek Invoice dan LaporanKeuangan
 * alih-alih menerima 5 parameter primitif satu per satu. Ini menghilangkan
 * duplikasi logika ekstraksi data dan membuat kode lebih mudah dipelihara.
 */
public class CatatLaporanKeuanganDB {

    /** Catat satu Invoice ke tabel laporan_keuangan. */
    public boolean catatInvoice(Invoice invoice) {
        Connection koneksi = KoneksiDB.getKoneksi();
        if (koneksi == null) return false;

        String sql = "INSERT INTO laporan_keuangan "
                   + "(id_invoice, id_pesanan, metode_pembayaran, total_bayar) "
                   + "VALUES (?, ?, ?, ?)";
        try (PreparedStatement ps = koneksi.prepareStatement(sql)) {
            ps.setString(1, invoice.getIdInvoice());
            ps.setString(2, invoice.getPesanan().getIdPesanan());
            ps.setString(3, invoice.getMetodePembayaran());
            ps.setDouble(4, invoice.getTotalBayar());

            boolean ok = ps.executeUpdate() > 0;
            if (ok) System.out.println("Invoice " + invoice.getIdInvoice() + " berhasil dicatat.");
            else    System.out.println("Gagal mencatat invoice " + invoice.getIdInvoice() + ".");
            return ok;
        } catch (SQLException e) {
            System.out.println("Gagal mencatat invoice: " + e.getMessage());
            return false;
        }
    }

    /** Catat semua invoice dalam sebuah LaporanKeuangan sekaligus. */
    public void catatLaporan(LaporanKeuangan laporan) {
        System.out.println("Mencatat laporan periode " + laporan.getPeriode() + "...");
        for (Invoice inv : laporan.getDaftarInvoice()) {
            catatInvoice(inv);
        }
        System.out.println("Laporan " + laporan.getIdLaporan() + " selesai dicatat.");
    }

    /** Ambil ringkasan laporan dari database. */
    public List<String[]> getLaporanList() {
        List<String[]> list    = new ArrayList<>();
        Connection     koneksi = KoneksiDB.getKoneksi();
        if (koneksi == null) return list;

        String query = "SELECT * FROM laporan_keuangan";
        try (Statement stmt = koneksi.createStatement();
             ResultSet rs   = stmt.executeQuery(query)) {

            while (rs.next()) {
                list.add(new String[]{
                    rs.getString("id_invoice"),
                    rs.getString("id_pesanan"),
                    rs.getString("metode_pembayaran"),
                    String.valueOf(rs.getDouble("total_bayar"))
                });
            }
        } catch (SQLException e) {
            System.out.println("Gagal mengambil data laporan: " + e.getMessage());
        }
        return list;
    }
}
