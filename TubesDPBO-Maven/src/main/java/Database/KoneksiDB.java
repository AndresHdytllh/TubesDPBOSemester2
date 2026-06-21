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
import java.sql.DriverManager;
import java.sql.SQLException;

public class KoneksiDB {
    
    private static final String URL = "jdbc:mysql://localhost:3306/db_buanacoffee";
    private static final String USER = "root"; 
    private static final String PASS = "";     

    public static Connection getKoneksi() {
        Connection koneksi = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            koneksi = DriverManager.getConnection(URL, USER, PASS);
            System.out.println("Koneksi ke Database Berhasil");
        } catch (ClassNotFoundException e) {
            System.out.println("Driver tidak ditemukan: " + e.getMessage());
        } catch (SQLException e) {
            System.out.println("Koneksi Gagal: " + e.getMessage());
        }
        return koneksi;
    }
}
