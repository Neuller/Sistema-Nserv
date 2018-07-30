package GUI;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.plaf.basic.BasicProgressBarUI;


public class SplashScreen extends javax.swing.JFrame {
    
    SplashScreen spl = this;
    Color MYCOLOR = new Color(51, 153, 255);

    public SplashScreen() {
        initComponents();
        this.setLocationRelativeTo(null);
        startThread();
        
        Progresso.setUI(new BasicProgressBarUI(){
            @Override
            protected void paintDeterminate(Graphics g, JComponent jc) {
               Graphics2D g2d = (Graphics2D)g;
               
               int baixo = Progresso.getWidth();
               int alto = Progresso.getHeight();
               int espacobaixo = baixo;
               int espacoalto = alto - 5;
               
               double pJProgress = Progresso.getPercentComplete();
               
               espacobaixo = (int) (espacobaixo*pJProgress);
               
               g2d.setColor(MYCOLOR);
               Rectangle Progress1 = new Rectangle(5 ,5, espacobaixo -5, espacoalto -5);
               g2d.fill(Progress1);               
               
               
            }
            
        });
        
        ImageIcon logo = new ImageIcon(getClass().getResource("/Icones/ico_nserv.png"));
        setIconImage(logo.getImage());
    }
    
    void startThread(){
    Thread hi = new Thread(new Runnable() {      
        @Override
        public void run(){
            Login log = new Login(spl);
            log.setLocationRelativeTo(null);
            log.setVisible(true);
            dispose();
        }
    }
    );
    
    hi.start();
    
    }
    
    public JProgressBar getJProgressBar(){
        return Progresso;
    }
    
    public JLabel getJLabel(){
        return lblText;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PainelGeral = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        PainelProgressBar = new javax.swing.JPanel();
        lblText = new javax.swing.JLabel();
        Progresso = new javax.swing.JProgressBar();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocationByPlatform(true);
        setPreferredSize(new java.awt.Dimension(820, 420));
        setResizable(false);

        PainelGeral.setBackground(new java.awt.Color(255, 255, 255));
        PainelGeral.setPreferredSize(new java.awt.Dimension(820, 420));

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/Splash.png"))); // NOI18N

        PainelProgressBar.setBackground(new java.awt.Color(255, 255, 255));
        PainelProgressBar.setOpaque(false);

        lblText.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        lblText.setText("Carregando...");
        lblText.setName("lblText"); // NOI18N

        Progresso.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 153, 255)));
        Progresso.setName("Progresso"); // NOI18N

        javax.swing.GroupLayout PainelProgressBarLayout = new javax.swing.GroupLayout(PainelProgressBar);
        PainelProgressBar.setLayout(PainelProgressBarLayout);
        PainelProgressBarLayout.setHorizontalGroup(
            PainelProgressBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PainelProgressBarLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PainelProgressBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Progresso, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(PainelProgressBarLayout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(lblText)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        PainelProgressBarLayout.setVerticalGroup(
            PainelProgressBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PainelProgressBarLayout.createSequentialGroup()
                .addComponent(lblText)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Progresso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout PainelGeralLayout = new javax.swing.GroupLayout(PainelGeral);
        PainelGeral.setLayout(PainelGeralLayout);
        PainelGeralLayout.setHorizontalGroup(
            PainelGeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PainelGeralLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(PainelProgressBar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        PainelGeralLayout.setVerticalGroup(
            PainelGeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PainelGeralLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PainelProgressBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(55, 55, 55))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PainelGeral, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PainelGeral, javax.swing.GroupLayout.PREFERRED_SIZE, 379, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

   
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(SplashScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SplashScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SplashScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SplashScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SplashScreen().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PainelGeral;
    private javax.swing.JPanel PainelProgressBar;
    private javax.swing.JProgressBar Progresso;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lblText;
    // End of variables declaration//GEN-END:variables
}
