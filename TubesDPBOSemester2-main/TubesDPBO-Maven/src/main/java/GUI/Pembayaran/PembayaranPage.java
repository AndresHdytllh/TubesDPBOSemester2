package GUI.Pembayaran; // Sesuaikan jika package Anda berbeda

import Database.CatatLaporanKeuanganDB;
import LaporanPackage.Invoice;
import PembayaranPackage.Pembayaran;
import PembayaranPackage.PembayaranNonTunai;
import PembayaranPackage.PembayaranTunai;
import PesananPackage.Pesanan;
import GUI.login.pelanggan.PelangganHome;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.UUID;

public class PembayaranPage extends JFrame {

    private Pesanan pesanan; 
    private String usernameAktif; // Variabel untuk menyimpan username dari halaman sebelumnya
    
    private JLabel lblJudul, lblTotal, lblPilihMetode, lblInputUang;
    private JRadioButton rbTunai, rbNonTunai;
    private ButtonGroup btnGroupMetode;
    private JTextField txtUangDiterima;
    private JButton btnBayar, btnBatal;

    // KONSTRUKTOR: Menerima objek Pesanan dan String username
    public PembayaranPage(Pesanan pesanan, String username) {
        this.pesanan = pesanan;
        this.usernameAktif = username;
        initUI();
    }

    private void initUI() {
        setTitle("Halaman Pembayaran");
        setSize(400, 350);
        setLayout(null); // Absolute Layout
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        lblJudul = new JLabel("PEMBAYARAN PESANAN: " + pesanan.getIdPesanan());
        lblJudul.setFont(new java.awt.Font("Dialog", 1, 14));
        lblJudul.setBounds(20, 20, 350, 20);
        add(lblJudul);

        lblTotal = new JLabel("Total Tagihan: Rp " + pesanan.getTotalHarga());
        lblTotal.setFont(new java.awt.Font("Dialog", 1, 14));
        lblTotal.setBounds(20, 50, 300, 20);
        add(lblTotal);

        lblPilihMetode = new JLabel("Pilih Metode Pembayaran:");
        lblPilihMetode.setBounds(20, 90, 200, 20);
        add(lblPilihMetode);

        // Hanya dua opsi pembayaran: Tunai dan Non-Tunai
        rbTunai = new JRadioButton("Tunai");
        rbNonTunai = new JRadioButton("Non-Tunai");
        
        rbTunai.setBounds(20, 110, 80, 25);
        rbNonTunai.setBounds(100, 110, 120, 25);
        
        btnGroupMetode = new ButtonGroup();
        btnGroupMetode.add(rbTunai);
        btnGroupMetode.add(rbNonTunai);
        
        add(rbTunai); add(rbNonTunai);

        lblInputUang = new JLabel("Uang Diterima (Khusus Tunai):");
        lblInputUang.setBounds(20, 150, 200, 20);
        add(lblInputUang);

        txtUangDiterima = new JTextField();
        txtUangDiterima.setBounds(20, 175, 150, 25);
        add(txtUangDiterima);

        // Event listener: Matikan input uang jika memilih Non-Tunai
        rbTunai.addActionListener(e -> txtUangDiterima.setEnabled(true));
        rbNonTunai.addActionListener(e -> { 
            txtUangDiterima.setEnabled(false); 
            txtUangDiterima.setText(""); // Kosongkan text field
        });

        rbTunai.setSelected(true); // Tunai sebagai default

        btnBayar = new JButton("Proses Pembayaran");
        btnBayar.setBounds(20, 220, 170, 35);
        add(btnBayar);

        btnBatal = new JButton("Batal");
        btnBatal.setBounds(200, 220, 100, 35);
        add(btnBatal);

        // Action Listeners Tombol
        btnBayar.addActionListener(this::prosesBayar);
        btnBatal.addActionListener(e -> {
            // Kembali ke PelangganHome dengan membawa kembali username-nya
            new PelangganHome(usernameAktif).setVisible(true); 
            this.dispose();
        });
    }

    private void prosesBayar(ActionEvent evt) {
        String idPay = "PAY-" + UUID.randomUUID().toString().substring(0,4).toUpperCase();
        
        Pembayaran pembayaranSukses = null; 
        String pesanHasil = "";

        // --- 1. PROSES LOGIKA PEMBAYARAN OOP ---
        if (rbTunai.isSelected()) {
            try {
                double uang = Double.parseDouble(txtUangDiterima.getText());
                PembayaranTunai payTunai = new PembayaranTunai(idPay, pesanan, uang);
                
                if (payTunai.prosesPembayaran()) {
                    pembayaranSukses = payTunai;
                    pesanHasil = "Pembayaran Tunai Berhasil!\nTotal Kembalian Anda: Rp " + payTunai.getKembalian();
                } else {
                    double kurang = pesanan.getTotalHarga() - uang;
                    JOptionPane.showMessageDialog(this, "Uang Anda kurang Rp " + kurang, "Transaksi Gagal", JOptionPane.ERROR_MESSAGE);
                    return; // Hentikan proses
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "Masukkan nominal angka uang tunai dengan valid!");
                return;
            }
        } else {
            // Logika Pembayaran Non-Tunai Umum
            String metode = "Non-Tunai"; 
            PembayaranNonTunai payNonTunai = new PembayaranNonTunai(idPay, pesanan, metode);
            if (payNonTunai.prosesPembayaran()) {
                pembayaranSukses = payNonTunai;
                pesanHasil = "Pembayaran " + metode + " Berhasil diproses!";
            }
        }

        // --- 2. JIKA SUKSES: BUAT INVOICE & SIMPAN KE DATABASE ---
        if (pembayaranSukses != null) {
            String idInv = "INV-" + UUID.randomUUID().toString().substring(0,4).toUpperCase();
            Invoice invoiceBaru = new Invoice(idInv, pembayaranSukses);
            
            invoiceBaru.cetakInvoice(); // Cetak di console sbg log log

            CatatLaporanKeuanganDB dbLaporan = new CatatLaporanKeuanganDB();
            boolean tersimpan = dbLaporan.catatInvoice(invoiceBaru);

            if (tersimpan) {
                JOptionPane.showMessageDialog(this, pesanHasil + "\n\nInvoice " + idInv + " berhasil disimpan ke Laporan Keuangan.");
            } else {
                JOptionPane.showMessageDialog(this, pesanHasil + "\n\n(Peringatan: Transaksi berhasil namun gagal menyimpan ke Database Laporan)");
            }

            // Kembali ke halaman pelanggan utama dan keranjang akan otomatis tersetel ulang karena kita membuat objek PelangganHome baru
            new PelangganHome(usernameAktif).setVisible(true);
            this.dispose();
        }
    }
}