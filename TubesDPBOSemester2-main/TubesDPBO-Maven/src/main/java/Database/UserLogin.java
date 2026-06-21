/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author gungmoning
 */
public class UserLogin {
private String username;
private String password;
private String role;

    public UserLogin(String username, String password, String role) {
        this.username = username;
        this.password = password;
        this.role = role;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    

    public boolean loginUser() {

        String sql = "SELECT * FROM users WHERE username = ? AND password = ? AND role = ?";

        try (Connection koneksi = KoneksiDB.getKoneksi();
             PreparedStatement statement = koneksi.prepareStatement(sql)) {

            statement.setString(1, getUsername());
            statement.setString(2, getPassword());
            statement.setString(3, getRole().toLowerCase());

            ResultSet rs = statement.executeQuery();

            if (rs.next()) {
                System.out.println("Login berhasil! : Selamat datang, " + getUsername() + " (" + getRole() + ")");
                return true;
            } else {
                System.out.println("Login gagal! : Username, password, atau role salah.");
                return false;
            }

        } catch (SQLException e) {
            System.out.println("Error saat login database: " + e.getMessage());
            return false;
        }
    }
}
