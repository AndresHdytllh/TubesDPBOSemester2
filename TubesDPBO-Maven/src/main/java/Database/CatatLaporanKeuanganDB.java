package Database;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class CatatLaporanKeuanganDB {
    public void catatLaporanKeuangan(String id_item, String nama_produk, int produk_terjual, double harga_produk, double total_pendapatan) {
        Connection koneksi = KoneksiDB.getKoneksi();
        
        if (koneksi != null) {
            String  sql = "INSERT INTO laporan_keuangan (id_item, nama_produk, produk_terjual, harga_produk, total_pendapatan) VALUES ('" + id_item + "', '" + nama_produk + "', " + produk_terjual + ", " + harga_produk + ", " + total_pendapatan + ")";
            try (Statement stmt = koneksi.createStatement()) {
                int rowsAffected = stmt.executeUpdate(sql);
                
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
