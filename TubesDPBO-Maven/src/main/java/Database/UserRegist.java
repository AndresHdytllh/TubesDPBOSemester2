/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Database;

/**
 *
 * @author gungmoning
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserRegist {
private String username;
private String password;
private String role;

    public UserRegist(String username, String password) {
        this.username = username;
        this.password = password;
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
    
    
    public boolean registerUser() {
       
        String sql = "INSERT INTO users (username, password) VALUES (?, ?)";
        
        try (Connection koneksi = KoneksiDB.getKoneksi();
             PreparedStatement statement = koneksi.prepareStatement(sql)) {
            
            
            statement.setString(1, getUsername());
            statement.setString(2, getPassword());
            statement.setString(3, getRole().toLowerCase()); 
            
            
            int rowsInserted = statement.executeUpdate();
            return rowsInserted > 0; 
            
        } catch (SQLException e) {
            System.out.println("Error saat registrasi database: " + e.getMessage());
            return false;
        }
    }
}