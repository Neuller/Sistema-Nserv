package GUI;

import Utilitarios.Conexao;
import Utilitarios.GerentedeJanelas;
import java.io.InputStream;
import java.sql.Connection;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;
import javax.swing.ImageIcon;

public class Principal extends javax.swing.JFrame {
    
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
       
    public Principal() {
        
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
        Rel_Clientes.setIcon(new ImageIcon(getClass().getResource("/Icones/ico_reportfull.png")));
        Rel_Estoque.setIcon(new ImageIcon(getClass().getResource("/Icones/ico_reportfull.png")));
        Rel_Clientes30.setIcon(new ImageIcon(getClass().getResource("/Icones/ico_report30.png")));
        ServicosCad.setIcon(new ImageIcon(getClass().getResource("/Icones/ico_os.png")));
        MenuUsuarios.setIcon(new ImageIcon(getClass().getResource("/Icones/ico_user.png")));
        
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
        MenuUsuarios = new javax.swing.JMenuItem();
        MenuServicos = new javax.swing.JMenu();
        PesqOS = new javax.swing.JMenuItem();
        MenuRelatorios = new javax.swing.JMenu();
        Rel_Clientes = new javax.swing.JMenuItem();
        Rel_Estoque = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        Rel_Clientes30 = new javax.swing.JMenuItem();
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

        MenuUsuarios.setText("Usuários");
        MenuUsuarios.setName("MenuUsuarios"); // NOI18N
        MenuUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuUsuariosActionPerformed(evt);
            }
        });
        MenuCadastro.add(MenuUsuarios);

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

        MenuRelatorios.setText("Relatórios");
        MenuRelatorios.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        Rel_Clientes.setText("Clientes - Completo");
        Rel_Clientes.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Rel_Clientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Rel_ClientesActionPerformed(evt);
            }
        });
        MenuRelatorios.add(Rel_Clientes);

        Rel_Estoque.setText("Estoque - Completo");
        Rel_Estoque.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Rel_EstoqueActionPerformed(evt);
            }
        });
        MenuRelatorios.add(Rel_Estoque);
        MenuRelatorios.add(jSeparator1);

        Rel_Clientes30.setText("Clientes - 30 Dias");
        Rel_Clientes30.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Rel_Clientes30ActionPerformed(evt);
            }
        });
        MenuRelatorios.add(Rel_Clientes30);

        jMenuBar1.add(MenuRelatorios);
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

    private void Rel_ClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Rel_ClientesActionPerformed
        int confirma = JOptionPane.showConfirmDialog(null, "Confirma a visualização do Relatório?", "Atenção", JOptionPane.YES_NO_OPTION);
        if(confirma ==  JOptionPane.YES_OPTION){
        try {
            InputStream caminho = getClass().getResourceAsStream("/Relatorios/Rel_Clientes.jasper");
            JasperPrint print = JasperFillManager.fillReport(caminho, null, conexao);
            JasperViewer.viewReport(print, false);
        } catch (JRException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_Rel_ClientesActionPerformed
    }
    
    private void PesqOSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PesqOSActionPerformed
        //ostela = new OSTela();
        //tela.add(ostela);
        //ostela.setVisible(true);
        gerentedeJanelas.abrirJanelas(servicoPesq.getInstancia());
    }//GEN-LAST:event_PesqOSActionPerformed

    private void Rel_EstoqueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Rel_EstoqueActionPerformed
        int confirma = JOptionPane.showConfirmDialog(null, "Confirma a visualização do Relatório?", "Atenção", JOptionPane.YES_NO_OPTION);
        if(confirma ==  JOptionPane.YES_OPTION){
        try {
            InputStream caminho = getClass().getResourceAsStream("/Relatorios/Rel_Estoque.jasper");
            JasperPrint print = JasperFillManager.fillReport(caminho, null, conexao);
            JasperViewer.viewReport(print, false);
        } catch (JRException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_Rel_EstoqueActionPerformed
    }
    
    private void MenuUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuUsuariosActionPerformed
        gerentedeJanelas.abrirJanelas(Usertela.getInstancia());
    }//GEN-LAST:event_MenuUsuariosActionPerformed

    private void MenuDesconectarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuDesconectarActionPerformed
        if(JOptionPane.showConfirmDialog(this, "Deseja Finalizar a Sessão?", "", JOptionPane.YES_NO_OPTION, 0, new ImageIcon(getClass().getResource("/Icones/desconect2.png"))) ==  (JOptionPane.YES_OPTION)){
        this.dispose();
        Login login = new Login();
        login.setLocationRelativeTo(null);
        login.setVisible(true);              
    }
    }//GEN-LAST:event_MenuDesconectarActionPerformed

    private void Rel_Clientes30ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Rel_Clientes30ActionPerformed
        int confirma = JOptionPane.showConfirmDialog(null, "Confirma a visualização do Relatório?", "Atenção", JOptionPane.YES_NO_OPTION);
        if(confirma ==  JOptionPane.YES_OPTION){
        try {
            InputStream caminho = getClass().getResourceAsStream("/Relatorios/Rel_Clientes30.jasper");
            JasperPrint print = JasperFillManager.fillReport(caminho, null, conexao);
            JasperViewer.viewReport(print, false);
        } catch (JRException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }                                            
    }//GEN-LAST:event_Rel_Clientes30ActionPerformed

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
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Principal().setVisible(true);
            }
        });
    }
    
    private TeladeFundo TeladeFundo = new TeladeFundo();

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem CadastroProdutos;
    private javax.swing.JMenu MenuCadastro;
    private javax.swing.JMenuItem MenuClientes;
    private javax.swing.JMenuItem MenuDesconectar;
    private javax.swing.JMenu MenuRelatorios;
    private javax.swing.JMenu MenuServicos;
    private javax.swing.JMenuItem MenuUsuarios;
    private javax.swing.JMenuItem PesqOS;
    private javax.swing.JMenuItem Rel_Clientes;
    private javax.swing.JMenuItem Rel_Clientes30;
    private javax.swing.JMenuItem Rel_Estoque;
    private javax.swing.JMenuItem ServicosCad;
    private javax.swing.JDesktopPane jDesktopPane;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    // End of variables declaration//GEN-END:variables
}
