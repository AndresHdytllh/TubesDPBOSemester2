package GUI.login.admin;

import GUI.login.LoginPage;

public class AdminHome extends javax.swing.JFrame {

    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(AdminHome.class.getName());

    public AdminHome() {
        initComponents();
        setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        laporanKeuanganBut = new javax.swing.JButton();
        kelolaMenuBut = new javax.swing.JButton();
        lihatReservasiBut = new javax.swing.JButton(); // TOMBOL BARU
        logoutBut = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Halaman Admin");

        jLabel1.setFont(new java.awt.Font("Dialog", 0, 18));
        jLabel1.setText("Selamat Datang");

        laporanKeuanganBut.setText("Laporan Keuangan");
        laporanKeuanganBut.addActionListener(this::laporanKeuanganButActionPerformed);

        kelolaMenuBut.setText("Kelola Menu");
        kelolaMenuBut.addActionListener(this::kelolaMenuButActionPerformed);

        // SETTING TOMBOL BARU
        lihatReservasiBut.setText("Lihat Reservasi Meja");
        lihatReservasiBut.addActionListener(this::lihatReservasiButActionPerformed);

        logoutBut.setText("Logout");
        logoutBut.addActionListener(this::logoutButActionPerformed);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(132, 132, 132)
                                                .addComponent(jLabel1))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(94, 94, 94)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(laporanKeuanganBut, javax.swing.GroupLayout.DEFAULT_SIZE, 205, Short.MAX_VALUE)
                                                        .addComponent(kelolaMenuBut, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(lihatReservasiBut, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))) // Tambahkan ke layout horizontal
                                        .addGroup(layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(logoutBut, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(101, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(33, 33, 33)
                                .addComponent(jLabel1)
                                .addGap(30, 30, 30)
                                .addComponent(laporanKeuanganBut)
                                .addGap(18, 18, 18)
                                .addComponent(kelolaMenuBut)
                                .addGap(18, 18, 18)
                                .addComponent(lihatReservasiBut) // Tambahkan ke layout vertikal
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                                .addComponent(logoutBut)
                                .addContainerGap())
        );

        pack();
    }

    private void kelolaMenuButActionPerformed(java.awt.event.ActionEvent evt) {
        KelolaMenuPage kelola = new KelolaMenuPage();
        kelola.setVisible(true);
        this.dispose();
    }

    private void laporanKeuanganButActionPerformed(java.awt.event.ActionEvent evt) {
        LaporanPage laporan = new LaporanPage();
        laporan.setVisible(true);
        this.dispose();
    }

    // ACTION UNTUK TOMBOL BARU
    private void lihatReservasiButActionPerformed(java.awt.event.ActionEvent evt) {
        LihatReservasiPage reservasi = new LihatReservasiPage();
        reservasi.setVisible(true);
        this.dispose();
    }

    private void logoutButActionPerformed(java.awt.event.ActionEvent evt) {
        javax.swing.JOptionPane.showMessageDialog(this, "Anda telah logout!");
        LoginPage login = new LoginPage();
        login.setVisible(true);
        this.dispose();
    }

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(() -> new AdminHome().setVisible(true));
    }

    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton kelolaMenuBut;
    private javax.swing.JButton laporanKeuanganBut;
    private javax.swing.JButton lihatReservasiBut; // Deklarasi tombol baru
    private javax.swing.JButton logoutBut;
}
