package GUI.login.admin;

import Database.KoneksiDB;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class LihatReservasiPage extends JFrame {

    private JTable tableReservasi;
    private DefaultTableModel tableModel;
    private JScrollPane scrollPane;
    private JLabel lblJudul;
    private JButton btnKembali;

    public LihatReservasiPage() {
        initUI();
        loadDataReservasi();
    }

    private void initUI() {
        setTitle("Data Reservasi Meja - Admin");
        setSize(600, 400);
        setLayout(null); // Absolute layout
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        lblJudul = new JLabel("DAFTAR RESERVASI MEJA PELANGGAN");
        lblJudul.setFont(new java.awt.Font("Dialog", 1, 16));
        lblJudul.setBounds(140, 20, 350, 30);
        add(lblJudul);

        // Setup Tabel
        String[] kolom = {"ID Reservasi", "Nama Pelanggan", "No Meja", "Jumlah Orang"};
        tableModel = new DefaultTableModel(kolom, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; 
            }
        };
        tableReservasi = new JTable(tableModel);
        scrollPane = new JScrollPane(tableReservasi);
        scrollPane.setBounds(30, 70, 520, 200);
        add(scrollPane);

        // Tombol Kembali
        btnKembali = new JButton("Kembali");
        btnKembali.setBounds(30, 290, 100, 35);
        add(btnKembali);

        btnKembali.addActionListener((ActionEvent e) -> {
            new AdminHome().setVisible(true);
            this.dispose(); 
        });
    }

    private void loadDataReservasi() {
        // Mengosongkan tabel sebelum diisi data baru
        tableModel.setRowCount(0);

        try {
            Connection conn = KoneksiDB.getKoneksi();
            if (conn == null) {
                JOptionPane.showMessageDialog(this, "Koneksi ke database gagal!");
                return;
            }

            Statement stmt = conn.createStatement();
            // Mengambil data dari tabel reservasi
            String sql = "SELECT * FROM reservasi";
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                String idRes = rs.getString("id_reservasi");
                String nama = rs.getString("nama_pelanggan");
                int noMeja = rs.getInt("no_meja");
                int jmlOrang = rs.getInt("jumlah_orang");

                // Memasukkan data ke dalam baris tabel
                tableModel.addRow(new Object[]{idRes, nama, noMeja, jmlOrang});
            }

            rs.close();
            stmt.close();
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Gagal memuat data reservasi: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(() -> new LihatReservasiPage().setVisible(true));
    }
}