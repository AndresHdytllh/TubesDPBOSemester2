package Database;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import LaporanPackage.Invoice;
import MenuPackage.DetailPesanan; // Import ini ditambahkan

public class CatatLaporanKeuanganDB {

    public boolean catatInvoice(Invoice invoice) {
        Connection koneksi = KoneksiDB.getKoneksi();
        if (koneksi == null) return false;

        // --- BAGIAN BARU: Ekstrak nama menu dari keranjang ---
        StringBuilder detail = new StringBuilder();
        for (DetailPesanan dp : invoice.getPesanan().getDaftarItem()) {
            // Format: Nama Produk (xJumlah), 
            detail.append(dp.getNamaProduk()).append(" (x").append(dp.getQuantity()).append("), ");
        }
        
        // Hapus tanda koma dan spasi ekstra di akhir kalimat
        if (detail.length() > 0) {
            detail.setLength(detail.length() - 2);
        }
        String detailStr = detail.toString();
        // -----------------------------------------------------

        // Update Query SQL dengan tambahan kolom detail_pesanan
        String sql = "INSERT INTO laporan_keuangan (id_invoice, id_pesanan, detail_pesanan, metode_pembayaran, total_bayar) VALUES (?, ?, ?, ?, ?)";
        
        try (PreparedStatement ps = koneksi.prepareStatement(sql)) {
            ps.setString(1, invoice.getIdInvoice());
            ps.setString(2, invoice.getPesanan().getIdPesanan());
            ps.setString(3, detailStr); // Masukkan string nama menu
            ps.setString(4, invoice.getMetodePembayaran());
            ps.setDouble(5, invoice.getTotalBayar());

            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Gagal mencatat invoice: " + e.getMessage());
            return false;
        }
    }

    public List<String[]> getLaporanList() {
        List<String[]> list = new ArrayList<>();
        Connection koneksi = KoneksiDB.getKoneksi();
        if (koneksi == null) return list;

        String query = "SELECT * FROM laporan_keuangan";
        try (Statement stmt = koneksi.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                list.add(new String[]{
                    rs.getString("id_invoice"),
                    rs.getString("id_pesanan"),
                    rs.getString("detail_pesanan"), // Ambil data nama menu dari DB
                    rs.getString("metode_pembayaran"),
                    String.valueOf(rs.getDouble("total_bayar"))
                });
            }
        } catch (SQLException e) { System.out.println("Gagal tarik laporan: " + e.getMessage()); }
        return list;
    }
}