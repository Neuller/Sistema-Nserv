/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Utilitarios.Conexao;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author Ncesar
 */
public class Login extends javax.swing.JFrame {
    
    SplashScreen inicio;
    Connection conexao = null;

    /**
     * Creates new form Login
     */
    public Login() {
        initComponents();        
        this.setLocationRelativeTo(null);
        ImageIcon logo = new ImageIcon(getClass().getResource("/Icones/ico_nserv.png"));
        setIconImage(logo.getImage()); 
        
        conexao = Conexao.getConnection();    
    }
    
    public Login(SplashScreen inicio){
        this.inicio = inicio;
        initComponents();
        setProgress(0, "Carregando..");
        setProgress(20, "Conectando ao Banco..");
        setProgress(60, "Carregando Módulos..");
        setProgress(90, "Carregando Interface..");     
        setProgress(99, "Inicializando..");  
        this.setLocationRelativeTo(null);
        ImageIcon logo = new ImageIcon(getClass().getResource("/Icones/ico_nserv.png"));
        setIconImage(logo.getImage()); 
        
        conexao = Conexao.getConnection();               
    }
    
    void setProgress(int percent, String info){
        inicio.getJLabel().setText(info);
        inicio.getJProgressBar().setValue(percent);
        
        try {
            Thread.sleep(800);
            
        } catch (InterruptedException e) {
            JOptionPane.showMessageDialog(this, "Não foi possível Carregar a Inicialização");
        }
    }    
    
    public void Logar(String id, String senha){
        String dado = null;
        try {
            String sql = "select Nome_Usuario from usuarios where Nome_Usuario = '"+id+"' ";
            Statement st = conexao.createStatement();
            ResultSet rs = st.executeQuery(sql);
            if(rs.first()){
                String sql2 = "select Senha_Usuario from usuarios where Senha_Usuario = '"+senha+"' ";
                Statement st2 = conexao.createStatement();
                ResultSet rs2 = st2.executeQuery(sql2);
                if(rs2.first()){
                    String sql3 = "select Tipo_Usuario from usuarios where Nome_Usuario = '"+id+"' and Senha_Usuario = '"+senha+"' ";
                    Statement st3 = conexao.createStatement();
                    ResultSet rs3 = st3.executeQuery(sql3);
                    
                    while(rs3.next()){
                        dado = rs3.getString(1);                   
                    }
                    
                    if(dado.equals("Administrador")){
                        String sql4 = "select Nome_Usuario from usuarios where Nome_Usuario = '"+id+"' ";
                        Statement st4 = conexao.createStatement();
                        ResultSet rs4 = st4.executeQuery(sql4);
                        
                        while(rs4.next()){
                        dado = rs4.getString(1);                   
                        }
                        
                        dispose();
                        Principal princ = new Principal();
                        JOptionPane.showMessageDialog(this, "Bem Vindo " + dado, "Administrador", 0, new ImageIcon(getClass().getResource("/Icones/welcome.png")));                      
                        princ.setVisible(true);                                             
                    }else{
                        String sql5 = "select Nome_Usuario from usuarios where Nome_Usuario = '"+id+"' ";
                        Statement st5 = conexao.createStatement();
                        ResultSet rs5 = st5.executeQuery(sql5);
                        
                        while(rs5.next()){
                        dado = rs5.getString(1);                   
                        }
                        
                        dispose();
                        PrincipalP princP = new PrincipalP();
                        JOptionPane.showMessageDialog(this, "Bem Vindo " + dado, "Usuário Padrão", 0, new ImageIcon(getClass().getResource("/Icones/welcome.png")));                      
                        princP.setVisible(true);   
                        
                    }                                                                             
                }else{
                    JOptionPane.showMessageDialog(this, "Senha Incorreta");
                }
            }else{
                JOptionPane.showMessageDialog(this, "Usuario Não Encontrado");
            }
        } catch (Exception e) {
        }
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jInternalFrame1 = new javax.swing.JInternalFrame();
        PainelLogin = new javax.swing.JPanel();
        PainelCab = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        PainelCentral = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        senha = new jpass.JRPasswordField();
        usuario = new app.bolivia.swing.JCTextField();
        BTN_Entrar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        BTN_Sair = new javax.swing.JButton();

        jInternalFrame1.setVisible(true);

        javax.swing.GroupLayout jInternalFrame1Layout = new javax.swing.GroupLayout(jInternalFrame1.getContentPane());
        jInternalFrame1.getContentPane().setLayout(jInternalFrame1Layout);
        jInternalFrame1Layout.setHorizontalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jInternalFrame1Layout.setVerticalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Login");
        setBackground(new java.awt.Color(7, 143, 201));
        setLocationByPlatform(true);
        setPreferredSize(new java.awt.Dimension(430, 430));
        setResizable(false);
        getContentPane().setLayout(new java.awt.GridLayout(1, 0));

        PainelLogin.setBackground(new java.awt.Color(255, 255, 255));

        PainelCab.setBackground(new java.awt.Color(7, 143, 201));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/ico_nserv.png"))); // NOI18N

        javax.swing.GroupLayout PainelCabLayout = new javax.swing.GroupLayout(PainelCab);
        PainelCab.setLayout(PainelCabLayout);
        PainelCabLayout.setHorizontalGroup(
            PainelCabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PainelCabLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addContainerGap())
        );
        PainelCabLayout.setVerticalGroup(
            PainelCabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PainelCabLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
                .addContainerGap())
        );

        PainelCentral.setBackground(new java.awt.Color(255, 255, 255));
        PainelCentral.setPreferredSize(new java.awt.Dimension(417, 325));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Acesso");
        jLabel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, null, null, null, new java.awt.Color(7, 143, 201)));
        jLabel1.setOpaque(true);

        senha.setBackground(new java.awt.Color(7, 143, 201));
        senha.setBorder(null);
        senha.setForeground(new java.awt.Color(255, 255, 255));
        senha.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        senha.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        senha.setName("senha"); // NOI18N
        senha.setPhColor(new java.awt.Color(255, 255, 255));
        senha.setPlaceholder("Senha");
        senha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                senhaActionPerformed(evt);
            }
        });

        usuario.setBackground(new java.awt.Color(7, 143, 201));
        usuario.setBorder(null);
        usuario.setForeground(new java.awt.Color(255, 255, 255));
        usuario.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        usuario.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        usuario.setName("usuario"); // NOI18N
        usuario.setPhColor(new java.awt.Color(255, 255, 255));
        usuario.setPlaceholder("Usuario");
        usuario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                usuarioKeyReleased(evt);
            }
        });

        BTN_Entrar.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        BTN_Entrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/Botão Entrar1.png"))); // NOI18N
        BTN_Entrar.setBorder(null);
        BTN_Entrar.setBorderPainted(false);
        BTN_Entrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BTN_Entrar.setOpaque(false);
        BTN_Entrar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/Botão Entrar2.png"))); // NOI18N
        BTN_Entrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_EntrarActionPerformed(evt);
            }
        });

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/login.user.png"))); // NOI18N

        BTN_Sair.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        BTN_Sair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/BTNSair1.png"))); // NOI18N
        BTN_Sair.setBorder(null);
        BTN_Sair.setBorderPainted(false);
        BTN_Sair.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BTN_Sair.setOpaque(false);
        BTN_Sair.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/BTNSair2.png"))); // NOI18N
        BTN_Sair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_SairActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PainelCentralLayout = new javax.swing.GroupLayout(PainelCentral);
        PainelCentral.setLayout(PainelCentralLayout);
        PainelCentralLayout.setHorizontalGroup(
            PainelCentralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(PainelCentralLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PainelCentralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(usuario, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(senha, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(35, 35, 35))
            .addGroup(PainelCentralLayout.createSequentialGroup()
                .addGroup(PainelCentralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(BTN_Entrar, javax.swing.GroupLayout.PREFERRED_SIZE, 412, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BTN_Sair, javax.swing.GroupLayout.PREFERRED_SIZE, 412, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 5, Short.MAX_VALUE))
        );
        PainelCentralLayout.setVerticalGroup(
            PainelCentralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PainelCentralLayout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(jLabel1)
                .addGroup(PainelCentralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PainelCentralLayout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(usuario, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(senha, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PainelCentralLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 101, Short.MAX_VALUE)
                .addComponent(BTN_Entrar, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(BTN_Sair, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5))
        );

        javax.swing.GroupLayout PainelLoginLayout = new javax.swing.GroupLayout(PainelLogin);
        PainelLogin.setLayout(PainelLoginLayout);
        PainelLoginLayout.setHorizontalGroup(
            PainelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PainelLoginLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PainelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(PainelCentral, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(PainelCab, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        PainelLoginLayout.setVerticalGroup(
            PainelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PainelLoginLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(PainelCab, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PainelCentral, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(PainelLogin);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void senhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_senhaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_senhaActionPerformed

    private void usuarioKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_usuarioKeyReleased
        //usuario.setText(usuario.getText().toUpperCase());
    }//GEN-LAST:event_usuarioKeyReleased

    private void BTN_SairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_SairActionPerformed
        dispose();
    }//GEN-LAST:event_BTN_SairActionPerformed

    private void BTN_EntrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_EntrarActionPerformed
        String us = usuario.getText();
        String key = senha.getText();
        if(us.equals("") || key.equals("")){
            JOptionPane.showMessageDialog(this, "Preencha todos os Campos", "Login", 0);
        }else{
            Logar(us, key);
        }
    }//GEN-LAST:event_BTN_EntrarActionPerformed

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BTN_Entrar;
    private javax.swing.JButton BTN_Sair;
    private javax.swing.JPanel PainelCab;
    private javax.swing.JPanel PainelCentral;
    private javax.swing.JPanel PainelLogin;
    private javax.swing.JInternalFrame jInternalFrame1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private jpass.JRPasswordField senha;
    private app.bolivia.swing.JCTextField usuario;
    // End of variables declaration//GEN-END:variables
}
