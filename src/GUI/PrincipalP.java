package GUI;

import Utilitarios.Conexao;
import Utilitarios.GerentedeJanelas;
import java.sql.Connection;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;



public class PrincipalP extends javax.swing.JFrame {
    
    GerentedeJanelas gerentedeJanelas;
    //FundoTela tela;
    EstoqueTela estoquetela;
    ClienteTela clientetela;
    ServicoCad servicoCad;
    UserTela Usertela;
    ServicoPesq servicoPesq;
    Connection conexao = null;

    
    public static boolean fecha = false;
    public static boolean fecha1 = false;
       
    public PrincipalP() {
        
        initComponents(); 
        setExtendedState(JFrame.MAXIMIZED_BOTH); // Código para abrir tela inteira
        try {
            jDesktopPane.add(TeladeFundo);
            TeladeFundo.setMaximum(true);
            TeladeFundo.setVisible(true);
        } catch (Exception e) {
        }
        //setLayout(new GridLayout());
        //tela = new FundoTela("/Icones/FundoTela.png");   // Fundo Responsivo
        //getContentPane().add(tela);
               
        CadastroProdutos.setIcon(new ImageIcon(getClass().getResource("/Icones/ico_stock.png")));
        MenuClientes.setIcon(new ImageIcon(getClass().getResource("/Icones/ico_client.png")));
        PesqOS.setIcon(new ImageIcon(getClass().getResource("/Icones/ico_pesqos.png")));
        MenuDesconectar.setIcon(new ImageIcon(getClass().getResource("/Icones/desconect.png")));
        ServicosCad.setIcon(new ImageIcon(getClass().getResource("/Icones/ico_os.png")));
        
        
        ImageIcon logo = new ImageIcon(getClass().getResource("/Icones/ico_nserv.png"));
        setIconImage(logo.getImage());
        
        this.gerentedeJanelas = new GerentedeJanelas(jDesktopPane);
        
        conexao = Conexao.getConnection();
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jDesktopPane = new javax.swing.JDesktopPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        MenuCadastro = new javax.swing.JMenu();
        MenuClientes = new javax.swing.JMenuItem();
        CadastroProdutos = new javax.swing.JMenuItem();
        ServicosCad = new javax.swing.JMenuItem();
        MenuServicos = new javax.swing.JMenu();
        PesqOS = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();
        MenuDesconectar = new javax.swing.JMenuItem();

        jMenu1.setText("jMenu1");

        jMenuItem1.setText("jMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Nserv - Administrador");

        javax.swing.GroupLayout jDesktopPaneLayout = new javax.swing.GroupLayout(jDesktopPane);
        jDesktopPane.setLayout(jDesktopPaneLayout);
        jDesktopPaneLayout.setHorizontalGroup(
            jDesktopPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jDesktopPaneLayout.setVerticalGroup(
            jDesktopPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 279, Short.MAX_VALUE)
        );

        MenuCadastro.setText("Cadastro");
        MenuCadastro.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        MenuClientes.setText("Clientes");
        MenuClientes.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        MenuClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuClientesActionPerformed(evt);
            }
        });
        MenuCadastro.add(MenuClientes);

        CadastroProdutos.setText("Estoque");
        CadastroProdutos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        CadastroProdutos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CadastroProdutosActionPerformed(evt);
            }
        });
        MenuCadastro.add(CadastroProdutos);

        ServicosCad.setText("Serviços");
        ServicosCad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ServicosCadActionPerformed(evt);
            }
        });
        MenuCadastro.add(ServicosCad);

        jMenuBar1.add(MenuCadastro);

        MenuServicos.setText("Serviços");

        PesqOS.setText("Pesquisar / Editar");
        PesqOS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PesqOSActionPerformed(evt);
            }
        });
        MenuServicos.add(PesqOS);

        jMenuBar1.add(MenuServicos);
        jMenuBar1.add(jMenu2);

        jMenu3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/gear.png"))); // NOI18N

        MenuDesconectar.setText("Desconectar");
        MenuDesconectar.setName("MenuDesconectar"); // NOI18N
        MenuDesconectar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuDesconectarActionPerformed(evt);
            }
        });
        jMenu3.add(MenuDesconectar);

        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane, javax.swing.GroupLayout.Alignment.TRAILING)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void CadastroProdutosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CadastroProdutosActionPerformed
        //estoquetela = new EstoqueTela();
        //tela.add(estoquetela);
        //estoquetela.setVisible(true);
        gerentedeJanelas.abrirJanelas(estoquetela.getInstancia());
    }//GEN-LAST:event_CadastroProdutosActionPerformed

    private void MenuClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuClientesActionPerformed
        //clientetela = new ClienteTela();
        //tela.add(clientetela);
        //clientetela.setVisible(true);
        gerentedeJanelas.abrirJanelas(clientetela.getInstancia());
    }//GEN-LAST:event_MenuClientesActionPerformed
    
    
    private void PesqOSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PesqOSActionPerformed
        //ostela = new OSTela();
        //tela.add(ostela);
        //ostela.setVisible(true);
        gerentedeJanelas.abrirJanelas(servicoPesq.getInstancia());
    }//GEN-LAST:event_PesqOSActionPerformed
    
    
    private void MenuDesconectarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuDesconectarActionPerformed
        if(JOptionPane.showConfirmDialog(this, "Deseja Finalizar a Sessão?", "", JOptionPane.YES_NO_OPTION, 0, new ImageIcon(getClass().getResource("/Icones/desconect2.png"))) ==  (JOptionPane.YES_OPTION)){
        this.dispose();
        Login login = new Login();
        login.setLocationRelativeTo(null);
        login.setVisible(true);              
    }
    }//GEN-LAST:event_MenuDesconectarActionPerformed

    private void ServicosCadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ServicosCadActionPerformed
        gerentedeJanelas.abrirJanelas(servicoCad.getInstancia());
    }//GEN-LAST:event_ServicosCadActionPerformed
    

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
            java.util.logging.Logger.getLogger(PrincipalP.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PrincipalP.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PrincipalP.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PrincipalP.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PrincipalP().setVisible(true);
            }
        });
    }
    
    private TeladeFundo TeladeFundo = new TeladeFundo();

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem CadastroProdutos;
    private javax.swing.JMenu MenuCadastro;
    private javax.swing.JMenuItem MenuClientes;
    private javax.swing.JMenuItem MenuDesconectar;
    private javax.swing.JMenu MenuServicos;
    private javax.swing.JMenuItem PesqOS;
    private javax.swing.JMenuItem ServicosCad;
    private javax.swing.JDesktopPane jDesktopPane;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    // End of variables declaration//GEN-END:variables
}
