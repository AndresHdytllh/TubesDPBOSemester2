/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author gungmoning
 */
public class KatalogMenu {

    public KatalogMenu() {
    }
    
    public void tampilkanMenu(){
        Connection koneksi = KoneksiDB.getKoneksi();
        
        if (koneksi != null) {
            String query = "SELECT * FROM menu";
            
            try (Statement stmt = koneksi.createStatement();
                 ResultSet rs = stmt.executeQuery(query)) {
                
                System.out.println("\n=== DAFTAR MENU ===");

                while (rs.next()) {
                    int id = rs.getInt("id");
                    String nama = rs.getString("nama");
                    String harga = rs.getString("harga");
                    
                    System.out.println(id + ". " + nama + " - Rp" + harga);
                }
                
            } catch (Exception e) {
                System.out.println("Gagal mengambil data: " + e.getMessage());
            }
        }
    }
}
