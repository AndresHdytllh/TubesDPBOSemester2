package GUI.login.pelanggan;
import GUI.LandingPage;
/**
 *
 * @author lenovo
 */
public class PelangganHome extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(PelangganHome.class.getName());
    private String username;
    /**
     * Creates new form PelangganHome
     */
    public PelangganHome() {
        initComponents();
        setLocationRelativeTo(null);
    }
    
    public PelangganHome(String username) {
        initComponents();
        this.username = username;
        jLabelWelcome.setText("Selamat Datang, " + username + "!");
        setLocationRelativeTo(null);
    }
    @SuppressWarnings("unchecked")
    private void initComponents() {
        jLabelTitle = new javax.swing.JLabel();
        jLabelWelcome = new javax.swing.JLabel();
        pesanMenuBut = new javax.swing.JButton();
        reservasiBut = new javax.swing.JButton();
        logoutBut = new javax.swing.JButton();
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Buana Coffee - Pelanggan");
        jLabelTitle.setFont(new java.awt.Font("Dialog", 1, 20));
        jLabelTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelTitle.setText("BUANA COFFEE");
        jLabelWelcome.setFont(new java.awt.Font("Dialog", 0, 16));
        jLabelWelcome.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelWelcome.setText("Selamat Datang");
        pesanMenuBut.setFont(new java.awt.Font("Dialog", 0, 14));
        pesanMenuBut.setText("Pesan Menu");
        pesanMenuBut.addActionListener(this::pesanMenuButActionPerformed);
        reservasiBut.setFont(new java.awt.Font("Dialog", 0, 14));
        reservasiBut.setText("Reservasi Meja");
        reservasiBut.addActionListener(this::reservasiButActionPerformed);
        logoutBut.setForeground(new java.awt.Color(255, 0, 51));
        logoutBut.setText("Logout");
        logoutBut.addActionListener(this::logoutButActionPerformed);
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(80, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabelTitle)
                    .addComponent(jLabelWelcome)
                    .addComponent(pesanMenuBut, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(reservasiBut, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(80, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(logoutBut, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jLabelTitle)
                .addGap(15, 15, 15)
                .addComponent(jLabelWelcome)
                .addGap(40, 40, 40)
                .addComponent(pesanMenuBut, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(reservasiBut, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 60, Short.MAX_VALUE)
                .addComponent(logoutBut)
                .addContainerGap())
        );
        pack();
    }
    private void pesanMenuButActionPerformed(java.awt.event.ActionEvent evt) {
        PesanMenuPage pesanMenu = new PesanMenuPage(username);
        pesanMenu.setVisible(true);
        this.dispose();
    }
    private void reservasiButActionPerformed(java.awt.event.ActionEvent evt) {
        ReservasiPage reservasi = new ReservasiPage(username);
        reservasi.setVisible(true);
        this.dispose();
    }
    private void logoutButActionPerformed(java.awt.event.ActionEvent evt) {
        LandingPage lp = new LandingPage();
        lp.setVisible(true);
        this.dispose();
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(() -> new PelangganHome().setVisible(true));
    }
    private javax.swing.JLabel jLabelTitle;
    private javax.swing.JLabel jLabelWelcome;
    private javax.swing.JButton logoutBut;
    private javax.swing.JButton pesanMenuBut;
    private javax.swing.JButton reservasiBut;
}
