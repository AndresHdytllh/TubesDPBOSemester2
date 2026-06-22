package GUI.login.pelanggan;

import Database.KatalogMenu;
import Database.KoneksiDB;
import MenuPackage.DetailPesanan;
import MenuPackage.Meja;
import MenuPackage.Menu;
import MenuPackage.Reservasi;
import PesananPackage.Pesanan;
import GUI.Pembayaran.PembayaranPage;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.util.UUID;

public class PelangganHome extends JFrame {

    private JTable tableMenu;
    private DefaultTableModel tableModel;
    private JScrollPane scrollMenu, scrollKeranjang;
    
    // UI Komponen Pesanan Menu
    private JLabel lblJudul, lblMenu, lblKeranjang, lblIdMenu, lblJumlah, lblTotal;
    private JTextField txtIdMenu, txtJumlah;
    private JButton btnTambah, btnPesan, btnLogout;
    private JTextArea txtAreaKeranjang;

    // UI Komponen Reservasi Meja
    private JLabel lblResv, lblNoMeja, lblJmlOrang;
    private JTextField txtNoMeja, txtJmlOrang;
    private JButton btnReservasi;

    private KatalogMenu katalogMenu;
    private Pesanan pesananAktif;
    
    // Pembolehubah untuk menyimpan username pelanggan yang sedang log masuk
    private String usernameAktif; 

    // Konstruktor menerima nama user dari form login
    public PelangganHome(String username) {
        this.usernameAktif = username;
        initCustomComponents();
        setLocationRelativeTo(null);
    }

    private void initCustomComponents() {
        getContentPane().removeAll();
        getContentPane().setLayout(null);
        setSize(800, 620);
        setTitle("Halaman Pelanggan - Buana Coffee");

        katalogMenu = new KatalogMenu();
        pesananAktif = new Pesanan("P-" + UUID.randomUUID().toString().substring(0, 4).toUpperCase());

        // Tajuk yang memaparkan nama pengguna
        lblJudul = new JLabel("SELAMAT DATANG, " + usernameAktif.toUpperCase());
        lblJudul.setFont(new java.awt.Font("Dialog", 1, 18));
        lblJudul.setBounds(250, 10, 400, 30);
        add(lblJudul);

        // --- UI DAFTAR MENU ---
        lblMenu = new JLabel("Daftar Menu:");
        lblMenu.setBounds(20, 50, 100, 20);
        add(lblMenu);

        String[] kolom = {"ID Menu", "Nama Produk", "Harga"};
        tableModel = new DefaultTableModel(kolom, 0) {
            public boolean isCellEditable(int row, int column) { return false; }
        };
        tableMenu = new JTable(tableModel);
        scrollMenu = new JScrollPane(tableMenu);
        scrollMenu.setBounds(20, 80, 400, 240);
        add(scrollMenu);

        lblIdMenu = new JLabel("ID Menu:"); lblIdMenu.setBounds(20, 330, 80, 25); add(lblIdMenu);
        txtIdMenu = new JTextField(); txtIdMenu.setBounds(20, 355, 80, 25); add(txtIdMenu);

        lblJumlah = new JLabel("Jumlah:"); lblJumlah.setBounds(110, 330, 80, 25); add(lblJumlah);
        txtJumlah = new JTextField(); txtJumlah.setBounds(110, 355, 80, 25); add(txtJumlah);

        btnTambah = new JButton("Tambah ke Keranjang");
        btnTambah.setBounds(200, 355, 170, 25);
        add(btnTambah);

        // --- UI RESERVASI MEJA ---
        lblResv = new JLabel("Reservasi Meja:"); 
        lblResv.setFont(new java.awt.Font("Dialog", 1, 12)); 
        lblResv.setBounds(20, 400, 150, 20); 
        add(lblResv);
        
        lblNoMeja = new JLabel("No Meja:"); lblNoMeja.setBounds(20, 425, 60, 25); add(lblNoMeja);
        txtNoMeja = new JTextField(); txtNoMeja.setBounds(80, 425, 40, 25); add(txtNoMeja);
        
        lblJmlOrang = new JLabel("Jml Orang:"); lblJmlOrang.setBounds(135, 425, 70, 25); add(lblJmlOrang);
        txtJmlOrang = new JTextField(); txtJmlOrang.setBounds(205, 425, 40, 25); add(txtJmlOrang);

        btnReservasi = new JButton("Pesan Meja");
        btnReservasi.setBounds(260, 425, 110, 25);
        add(btnReservasi);

        // --- UI KERANJANG (TROLI) ---
        lblKeranjang = new JLabel("Keranjang Pesanan: " + pesananAktif.getIdPesanan()); 
        lblKeranjang.setBounds(450, 50, 250, 20); 
        add(lblKeranjang);
        
        txtAreaKeranjang = new JTextArea(); 
        txtAreaKeranjang.setEditable(false);
        scrollKeranjang = new JScrollPane(txtAreaKeranjang); 
        scrollKeranjang.setBounds(450, 80, 300, 240); 
        add(scrollKeranjang);

        lblTotal = new JLabel("Total Bayar: Rp 0"); 
        lblTotal.setFont(new java.awt.Font("Dialog", 1, 14)); 
        lblTotal.setBounds(450, 330, 300, 25); 
        add(lblTotal);

        btnPesan = new JButton("Lanjut Pembayaran"); 
        btnPesan.setBounds(450, 360, 300, 35); 
        add(btnPesan);
        
        btnLogout = new JButton("Logout"); 
        btnLogout.setBounds(20, 500, 100, 30); 
        add(btnLogout);

        loadDataMenu();

        // Action Listeners
        btnTambah.addActionListener(this::tambahKeKeranjang);
        btnPesan.addActionListener(this::lanjutPembayaran);
        btnReservasi.addActionListener(this::prosesReservasi);
        btnLogout.addActionListener(e -> { 
            // Pastikan anda mempunyai fail LoginPage.java untuk memanggil halaman login semula
            // new GUI.login.LoginPage().setVisible(true); 
            this.dispose(); 
        }); 

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().revalidate(); 
        getContentPane().repaint();
    }

    private void loadDataMenu() {
        tableModel.setRowCount(0);
        for (Menu m : katalogMenu.getMenuList()) {
            tableModel.addRow(new Object[]{m.getIdMenu(), m.getNamaProduk(), m.getHarga()});
        }
    }

    private void tambahKeKeranjang(ActionEvent evt) {
        String id = txtIdMenu.getText().trim(); 
        String jumlahStr = txtJumlah.getText().trim();
        
        if (id.isEmpty() || jumlahStr.isEmpty()) { 
            JOptionPane.showMessageDialog(this, "Isi ID Menu dan Jumlah!"); 
            return; 
        }

        try {
            int qty = Integer.parseInt(jumlahStr);
            if (qty <= 0) return;
            
            Menu menuTerpilih = null;
            for (Menu m : katalogMenu.getMenuList()) {
                if (m.getIdMenu().equals(id)) { 
                    menuTerpilih = m; 
                    break; 
                }
            }
            if (menuTerpilih != null) {
                pesananAktif.tambahItem(new DetailPesanan(menuTerpilih, qty)); 
                updateTampilanKeranjang();
                txtIdMenu.setText(""); 
                txtJumlah.setText(""); 
                txtIdMenu.requestFocus();
            } else {
                JOptionPane.showMessageDialog(this, "Menu tidak ditemukan!");
            }
        } catch (NumberFormatException e) { 
            JOptionPane.showMessageDialog(this, "Jumlah harus dalam bentuk nombor!"); 
        }
    }

    private void updateTampilanKeranjang() {
        txtAreaKeranjang.setText("");
        for (DetailPesanan dp : pesananAktif.getDaftarItem()) {
            txtAreaKeranjang.append(dp.getNamaProduk() + " (x" + dp.getQuantity() + ")\n");
            txtAreaKeranjang.append("Subtotal: Rp " + dp.getSubtotal() + "\n");
            txtAreaKeranjang.append("---------------------------------\n");
        }
        lblTotal.setText("Total Bayar: Rp " + pesananAktif.hitungTotal());
    }

    private void lanjutPembayaran(ActionEvent evt) {
        if (pesananAktif.getDaftarItem().isEmpty()) { 
            JOptionPane.showMessageDialog(this, "Keranjang masih kosong!"); 
            return; 
        }
        // Menghantar objek pesanan dan username ke halaman pembayaran
        new PembayaranPage(pesananAktif, usernameAktif).setVisible(true);
        this.dispose(); 
    }

    private void prosesReservasi(ActionEvent evt) {
        String noMejaStr = txtNoMeja.getText().trim(); 
        String jmlOrangStr = txtJmlOrang.getText().trim();
        
        if (noMejaStr.isEmpty() || jmlOrangStr.isEmpty()) { 
            JOptionPane.showMessageDialog(this, "Sila isikan No Meja dan Jumlah Orang!"); 
            return; 
        }

        try {
            int noMeja = Integer.parseInt(noMejaStr); 
            int jmlOrang = Integer.parseInt(jmlOrangStr);
            Connection conn = KoneksiDB.getKoneksi();
            
            // 1. Semak status meja di pangkalan data
            PreparedStatement pstCek = conn.prepareStatement("SELECT status_meja, kapasitas FROM meja WHERE no_meja = ?");
            pstCek.setInt(1, noMeja); 
            ResultSet rs = pstCek.executeQuery();

            if (rs.next()) {
                if (rs.getString("status_meja").equalsIgnoreCase("Terisi")) {
                    JOptionPane.showMessageDialog(this, "Maaf, Meja " + noMeja + " sudah terisi!"); 
                    return;
                }
                
                // 2. Laksanakan Logik OOP
                String idRes = "RES-" + UUID.randomUUID().toString().substring(0, 4).toUpperCase();
                Reservasi reservasi = new Reservasi(idRes, usernameAktif, jmlOrang, new Meja(noMeja, rs.getInt("kapasitas")));
                reservasi.konfirmasiReservasi(); 

                // 3. Simpan perubahan ke pangkalan data
                PreparedStatement pstUpdate = conn.prepareStatement("UPDATE meja SET status_meja = 'Terisi' WHERE no_meja = ?");
                pstUpdate.setInt(1, noMeja); 
                pstUpdate.executeUpdate();

                PreparedStatement pstInsert = conn.prepareStatement("INSERT INTO reservasi (id_reservasi, nama_pelanggan, no_meja, jumlah_orang) VALUES (?, ?, ?, ?)");
                pstInsert.setString(1, idRes); 
                pstInsert.setString(2, usernameAktif); 
                pstInsert.setInt(3, noMeja); 
                pstInsert.setInt(4, jmlOrang); 
                pstInsert.executeUpdate();

                JOptionPane.showMessageDialog(this, "Tempahan Meja Berjaya!\nID Tempahan: " + idRes + "\nNama: " + usernameAktif + "\nMeja No: " + noMeja);
                txtNoMeja.setText(""); 
                txtJmlOrang.setText("");
            } else {
                JOptionPane.showMessageDialog(this, "Meja tidak wujud dalam pangkalan data!");
            }
        } catch (NumberFormatException e) {
             JOptionPane.showMessageDialog(this, "No Meja dan Jumlah Orang mesti dalam angka!");
        } catch (Exception e) { 
             JOptionPane.showMessageDialog(this, "Ralat Sistem: " + e.getMessage()); 
        }
    }

    public static void main(String args[]) {
        // Untuk tujuan pengujian secara terus (Run File), tetapan lalai nama pengguna ialah "Tetamu"
        java.awt.EventQueue.invokeLater(() -> new PelangganHome("Tetamu").setVisible(true));
    }
}