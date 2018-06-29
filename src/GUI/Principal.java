package GUI;

import Utilitarios.FundoTela;
import java.awt.GridLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class Principal extends javax.swing.JFrame {
    
    FundoTela tela;
    EstoqueTela estoquetela;

    public Principal() {
        initComponents();
        setExtendedState(JFrame.MAXIMIZED_BOTH); // Código para abrir tela inteira
        setLayout(new GridLayout());
        tela = new FundoTela("/Icones/FundoTela.png");   // Fundo Responsivo
        getContentPane().add(tela);
        
        CadastroProdutos.setIcon(new ImageIcon(getClass().getResource("/Icones/ico_clientes.png")));
        
        ImageIcon logo = new ImageIcon(getClass().getResource("/Icones/ico_cardapio.png"));
        setIconImage(logo.getImage());
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenu1 = new javax.swing.JMenu();
        jMenuBar1 = new javax.swing.JMenuBar();
        MenuCadastro = new javax.swing.JMenu();
        CadastroProdutos = new javax.swing.JMenuItem();
        MenuSair = new javax.swing.JMenu();

        jMenu1.setText("jMenu1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Pizzaria");

        MenuCadastro.setText("Cadastro");
        MenuCadastro.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        CadastroProdutos.setText("Produtos");
        CadastroProdutos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        CadastroProdutos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CadastroProdutosActionPerformed(evt);
            }
        });
        MenuCadastro.add(CadastroProdutos);

        jMenuBar1.add(MenuCadastro);

        MenuSair.setText("Sair");
        MenuSair.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jMenuBar1.add(MenuSair);

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
    private javax.swing.JMenu MenuSair;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    // End of variables declaration//GEN-END:variables
}
