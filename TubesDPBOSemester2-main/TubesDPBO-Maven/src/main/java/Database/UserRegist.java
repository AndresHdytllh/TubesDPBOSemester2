package Database;

import java.sql.*;
import UserPackage.User;

/**
 * PERBAIKAN: Tidak lagi menduplikasi field User.
 * Tersedia dua overload untuk kompatibilitas dengan GUI yang ada.
 */
public class UserRegist {

    /** Registrasi menggunakan objek User. */
    public boolean registerUser(User user) {
        return registerUser(user.getUsername(), user.getPassword(), user.getRole());
    }

    /** Registrasi langsung dengan string (dipakai GUI). */
    public boolean registerUser(String username, String password, String role) {
        String sql = "INSERT INTO users (username, password, role) VALUES (?, ?, ?)";
        try (Connection koneksi   = KoneksiDB.getKoneksi();
             PreparedStatement ps = koneksi.prepareStatement(sql)) {

            ps.setString(1, username);
            ps.setString(2, password);
            ps.setString(3, role.toLowerCase());

            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Error saat registrasi: " + e.getMessage());
            return false;
        }
    }
}
