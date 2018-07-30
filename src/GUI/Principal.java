package GUI;

import Utilitarios.Conexao;
import Utilitarios.FundoTela;
import java.awt.GridLayout;
import java.io.InputStream;
import java.sql.Connection;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

public class Principal extends javax.swing.JFrame {
    
    FundoTela tela;
    EstoqueTela estoquetela;
    ClienteTela clientetela;
    OSTela ostela;
    Connection conexao = null;

    public Principal() {
        initComponents();
        setExtendedState(JFrame.MAXIMIZED_BOTH); // Código para abrir tela inteira
        setLayout(new GridLayout());
        tela = new FundoTela("/Icones/FundoTela.png");   // Fundo Responsivo
        getContentPane().add(tela);
        
        CadastroProdutos.setIcon(new ImageIcon(getClass().getResource("/Icones/ico_stock.png")));
        MenuClientes.setIcon(new ImageIcon(getClass().getResource("/Icones/ico_client.png")));
        MenuOS.setIcon(new ImageIcon(getClass().getResource("/Icones/ico_os.png")));
        
        ImageIcon logo = new ImageIcon(getClass().getResource("/Icones/ico_nserv.png"));
        setIconImage(logo.getImage());
        
        conexao = Conexao.getConnection();
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuBar1 = new javax.swing.JMenuBar();
        MenuCadastro = new javax.swing.JMenu();
        MenuClientes = new javax.swing.JMenuItem();
        CadastroProdutos = new javax.swing.JMenuItem();
        MenuServicos = new javax.swing.JMenu();
        MenuOS = new javax.swing.JMenuItem();
        MenuRelatorios = new javax.swing.JMenu();
        Rel_Clientes = new javax.swing.JMenuItem();
        Rel_Servicos = new javax.swing.JMenuItem();

        jMenu1.setText("jMenu1");

        jMenuItem1.setText("jMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Nserv ");

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

        jMenuBar1.add(MenuCadastro);

        MenuServicos.setText("Serviços");

        MenuOS.setText("Emitir Serviços");
        MenuOS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuOSActionPerformed(evt);
            }
        });
        MenuServicos.add(MenuOS);

        jMenuBar1.add(MenuServicos);

        MenuRelatorios.setText("Relatórios");
        MenuRelatorios.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        Rel_Clientes.setText("Clientes");
        Rel_Clientes.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Rel_Clientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Rel_ClientesActionPerformed(evt);
            }
        });
        MenuRelatorios.add(Rel_Clientes);

        Rel_Servicos.setText("Serviços");
        Rel_Servicos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Rel_ServicosActionPerformed(evt);
            }
        });
        MenuRelatorios.add(Rel_Servicos);

        jMenuBar1.add(MenuRelatorios);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 279, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void CadastroProdutosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CadastroProdutosActionPerformed
        estoquetela = new EstoqueTela();
        tela.add(estoquetela);
        estoquetela.setVisible(true);
    }//GEN-LAST:event_CadastroProdutosActionPerformed

    private void MenuClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuClientesActionPerformed
        clientetela = new ClienteTela();
        tela.add(clientetela);
        clientetela.setVisible(true);
    }//GEN-LAST:event_MenuClientesActionPerformed

    private void Rel_ClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Rel_ClientesActionPerformed
        try {
            InputStream caminho = getClass().getResourceAsStream("/Relatorios/Rel_Clientes.jasper");
            JasperPrint print = JasperFillManager.fillReport(caminho, null, conexao);
            JasperViewer.viewReport(print, false);
        } catch (JRException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_Rel_ClientesActionPerformed

    private void MenuOSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuOSActionPerformed
        ostela = new OSTela();
        tela.add(ostela);
        ostela.setVisible(true);
    }//GEN-LAST:event_MenuOSActionPerformed

    private void Rel_ServicosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Rel_ServicosActionPerformed
        int confirma = JOptionPane.showConfirmDialog(null, "Confirma a visualização do Relatório?", "Atenção", JOptionPane.YES_NO_OPTION);
        if(confirma ==  JOptionPane.YES_OPTION){
        try {
            InputStream caminho = getClass().getResourceAsStream("");
            JasperPrint print = JasperFillManager.fillReport(caminho, null, conexao);
            JasperViewer.viewReport(print, false);
        } catch (JRException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_Rel_ServicosActionPerformed
    }

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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem CadastroProdutos;
    private javax.swing.JMenu MenuCadastro;
    private javax.swing.JMenuItem MenuClientes;
    private javax.swing.JMenuItem MenuOS;
    private javax.swing.JMenu MenuRelatorios;
    private javax.swing.JMenu MenuServicos;
    private javax.swing.JMenuItem Rel_Clientes;
    private javax.swing.JMenuItem Rel_Servicos;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    // End of variables declaration//GEN-END:variables
}
