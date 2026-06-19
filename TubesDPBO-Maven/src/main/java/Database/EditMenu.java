package Database;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class EditMenu {
    
    public boolean editMenu(String idMenu, String namaMenu, double harga) {
        String sql = "UPDATE menu SET nama_menu = ?, harga = ? WHERE id_menu = ?";
        
        try (Connection koneksi = KoneksiDB.getKoneksi();
             PreparedStatement statement = koneksi.prepareStatement(sql)) {
            
            statement.setString(1, namaMenu);
            statement.setDouble(2, harga);
            statement.setString(3, idMenu);
            
            int rowsUpdated = statement.executeUpdate();
            return rowsUpdated > 0; 
        } catch (SQLException e) {
            System.out.println("Gagal mengedit menu: " + e.getMessage());
            return false;
        }
    }
}
