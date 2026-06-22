package Database;

import java.sql.*;
import UserPackage.User;

/**
 * PERBAIKAN: Tidak lagi menduplikasi field username/password/role dari User.
 * Tersedia dua overload:
 *   - loginUser(User) → untuk kode OOP yang sudah punya objek User
 *   - loginUser(String, String, String) → backward-compat untuk GUI yang masih
 *     melempar String langsung
 */
public class UserLogin {

    /** Login menggunakan objek User. */
    public boolean loginUser(User user) {
        return loginUser(user.getUsername(), user.getPassword(), user.getRole());
    }

    /** Login langsung dengan string (dipakai GUI). */
    public boolean loginUser(String username, String password, String role) {
        String sql = "SELECT * FROM users WHERE username = ? AND password = ? AND role = ?";
        try (Connection koneksi   = KoneksiDB.getKoneksi();
             PreparedStatement ps = koneksi.prepareStatement(sql)) {

            ps.setString(1, username);
            ps.setString(2, password);
            ps.setString(3, role.toLowerCase());

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                System.out.println("Login berhasil! Selamat datang, "
                    + username + " (" + role + ")");
                return true;
            } else {
                System.out.println("Login gagal! Username, password, atau role salah.");
                return false;
            }
        } catch (SQLException e) {
            System.out.println("Error saat login: " + e.getMessage());
            return false;
        }
    }
}
