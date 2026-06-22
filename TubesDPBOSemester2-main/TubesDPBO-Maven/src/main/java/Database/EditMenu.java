package Database;

import java.sql.*;
import MenuPackage.Menu;

/**
 * PERBAIKAN: Ditambahkan overload editMenu(Menu) agar caller
 * bisa langsung melempar objek Menu tanpa mengurai field-nya.
 */
public class EditMenu {

    /** Edit menu menggunakan objek Menu. */
    public boolean editMenu(Menu menu) {
        return editMenu(menu.getIdMenu(), menu.getNamaProduk(), menu.getHarga());
    }

    /** Edit menu dengan parameter primitif (dipakai GUI). */
    public boolean editMenu(String idMenu, String namaMenu, int harga) {
        String sql = "UPDATE menu SET nama = ?, harga = ? WHERE id = ?";
        try (Connection koneksi   = KoneksiDB.getKoneksi();
             PreparedStatement ps = koneksi.prepareStatement(sql)) {

            ps.setString(1, namaMenu);
            ps.setInt(2, harga);
            ps.setString(3, idMenu);

            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Gagal mengedit menu: " + e.getMessage());
            return false;
        }
    }
}
