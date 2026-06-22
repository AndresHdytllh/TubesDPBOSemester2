package GUI.login.admin; // Sesuaikan dengan package Anda

import Database.CatatLaporanKeuanganDB;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.util.List;

public class LaporanPage extends JFrame {

    private JTable tableLaporan;
    private DefaultTableModel tableModel;
    private JScrollPane scrollPane;
    private JLabel lblJudul, lblTotalPendapatan;
    private JButton btnKembali;

    public LaporanPage() {
        initUI();
        loadDataLaporan();
    }

    private void initUI() {
        setTitle("Laporan Keuangan - Admin");
        // Diperlebar menjadi 800 agar kolom detail menu muat
        setSize(800, 450);
        setLayout(null);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        lblJudul = new JLabel("DATA LAPORAN KEUANGAN");
        lblJudul.setFont(new java.awt.Font("Dialog", 1, 18));
        lblJudul.setBounds(270, 20, 300, 30);
        add(lblJudul);

        // --- BAGIAN BARU: Tambah Kolom Detail Pesanan ---
        String[] kolom = {"ID Invoice", "ID Pesanan", "Detail Pesanan (Menu)", "Metode", "Total Bayar (Rp)"};
        tableModel = new DefaultTableModel(kolom, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        tableLaporan = new JTable(tableModel);

        // Atur lebar kolom khusus Detail Pesanan agar lebih luas
        tableLaporan.getColumnModel().getColumn(2).setPreferredWidth(250);

        scrollPane = new JScrollPane(tableLaporan);
        scrollPane.setBounds(30, 70, 720, 230); // Diperlebar
        add(scrollPane);

        lblTotalPendapatan = new JLabel("Total Pendapatan: Rp 0");
        lblTotalPendapatan.setFont(new java.awt.Font("Dialog", 1, 14));
        lblTotalPendapatan.setBounds(30, 310, 350, 25);
        add(lblTotalPendapatan);

        btnKembali = new JButton("Kembali");
        btnKembali.setBounds(30, 350, 100, 35);
        add(btnKembali);

        btnKembali.addActionListener((ActionEvent e) -> {
            new AdminHome().setVisible(true);
            this.dispose();
        });
    }

    private void loadDataLaporan() {
        CatatLaporanKeuanganDB db = new CatatLaporanKeuanganDB();
        List<String[]> dataList = db.getLaporanList();

        double totalKeseluruhan = 0;

        for (String[] baris : dataList) {
            tableModel.addRow(baris);

            try {
                // Karena ada kolom "Detail Pesanan", indeks total_bayar sekarang mundur ke baris[4]
                totalKeseluruhan += Double.parseDouble(baris[4]);
            } catch (NumberFormatException ex) {
                System.out.println("Terjadi kesalahan parsing angka: " + ex.getMessage());
            }
        }

        lblTotalPendapatan.setText("Total Pendapatan: Rp " + String.format("%.2f", totalKeseluruhan));
    }

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(() -> new LaporanPage().setVisible(true));
    }
}
