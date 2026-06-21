package Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CatatLaporanKeuanganDB {

    public void catatLaporanKeuangan(String id_item, String nama_produk, int produk_terjual, double harga_produk, double total_pendapatan) {
        Connection koneksi = KoneksiDB.getKoneksi();

        if (koneksi != null) {
            String sql = "INSERT INTO laporan_keuangan (id_item, nama_produk, produk_terjual, harga_produk, total_pendapatan) VALUES (?, ?, ?, ?, ?)";

            try (PreparedStatement pstmt = koneksi.prepareStatement(sql)) {
                pstmt.setString(1, id_item);
                pstmt.setString(2, nama_produk);
                pstmt.setInt(3, produk_terjual);
                pstmt.setDouble(4, harga_produk);
                pstmt.setDouble(5, total_pendapatan);
                int rowsAffected = pstmt.executeUpdate();

                if (rowsAffected > 0) {
                    System.out.println("Laporan keuangan berhasil dicatat.");
                } else {
                    System.out.println("Gagal mencatat laporan keuangan.");
                }

            } catch (SQLException e) {
                System.out.println("Gagal mencatat laporan keuangan: " + e.getMessage());
            }
        }
    }
}
