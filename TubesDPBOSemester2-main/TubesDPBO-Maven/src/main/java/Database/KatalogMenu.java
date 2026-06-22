package Database;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import MenuPackage.Menu;

/**
 * PERBAIKAN: getMenuList() sekarang mengembalikan List<Menu> (domain model)
 * bukan List<String[]>, sehingga caller bisa bekerja dengan objek Menu
 * secara proper alih-alih parsing array string.
 */
public class KatalogMenu {

    /** Ambil seluruh menu dari database sebagai objek Menu. */
    public List<Menu> getMenuList() {
        List<Menu> menuList = new ArrayList<>();
        Connection koneksi  = KoneksiDB.getKoneksi();
        if (koneksi == null) return menuList;

        String query = "SELECT * FROM menu";
        try (Statement stmt = koneksi.createStatement();
             ResultSet rs   = stmt.executeQuery(query)) {

            while (rs.next()) {
                String id    = String.valueOf(rs.getInt("id"));
                String nama  = rs.getString("nama");
                int    harga = rs.getInt("harga");
                menuList.add(new Menu(id, nama, harga));
            }
        } catch (Exception e) {
            System.out.println("Gagal mengambil data menu: " + e.getMessage());
        }
        return menuList;
    }

    public void tampilkanMenu() {
        List<Menu> list = getMenuList();
        System.out.println("\n=== DAFTAR MENU ===");
        for (Menu m : list) {
            System.out.println(m.getIdMenu() + ". "
                + m.getNamaProduk() + " - Rp" + m.getHarga());
        }
    }

    public boolean tambahMenu(String nama, int harga) {
        Connection koneksi = KoneksiDB.getKoneksi();
        if (koneksi == null) return false;
        String sql = "INSERT INTO menu (nama, harga) VALUES (?, ?)";
        try (PreparedStatement ps = koneksi.prepareStatement(sql)) {
            ps.setString(1, nama);
            ps.setInt(2, harga);
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            System.out.println("Gagal menambahkan menu: " + e.getMessage());
            return false;
        }
    }

    public boolean hapusMenu(String id) {
        Connection koneksi = KoneksiDB.getKoneksi();
        if (koneksi == null) return false;
        String sql = "DELETE FROM menu WHERE id = ?";
        try (PreparedStatement ps = koneksi.prepareStatement(sql)) {
            ps.setString(1, id);
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            System.out.println("Gagal menghapus menu: " + e.getMessage());
            return false;
        }
    }
}
