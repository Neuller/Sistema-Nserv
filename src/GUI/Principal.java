package GUI;

import Utilitarios.FundoTela;
import java.awt.GridLayout;
import javax.swing.JFrame;

public class Principal extends javax.swing.JFrame {
    
    FundoTela tela;

    public Principal() {
        initComponents();
        setExtendedState(JFrame.MAXIMIZED_BOTH); // Código para abrir tela inteira
        setLayout(new GridLayout());
        tela = new FundoTela("imagens/FundoTela.png");   // Fundo Responsivo
        getContentPane().add(tela);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenu1 = new javax.swing.JMenu();
        jMenuBar1 = new javax.swing.JMenuBar();
        MenuCadastro = new javax.swing.JMenu();
        CadastroClientes = new javax.swing.JMenuItem();
        CadastroFuncionarios = new javax.swing.JMenuItem();
        CadastroCardapio = new javax.swing.JMenuItem();
        CadastroEntregador = new javax.swing.JMenuItem();
        MenuCaixa = new javax.swing.JMenu();
        MenuRelatorios = new javax.swing.JMenu();
        MenuSair = new javax.swing.JMenu();

        jMenu1.setText("jMenu1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Pizzaria");

        MenuCadastro.setText("Cadastro");

        CadastroClientes.setText("Clientes");
        MenuCadastro.add(CadastroClientes);

        CadastroFuncionarios.setText("Funcionários");
        CadastroFuncionarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CadastroFuncionariosActionPerformed(evt);
            }
        });
        MenuCadastro.add(CadastroFuncionarios);

        CadastroCardapio.setText("Cardápio");
        MenuCadastro.add(CadastroCardapio);

        CadastroEntregador.setText("Entregador");
        MenuCadastro.add(CadastroEntregador);

        jMenuBar1.add(MenuCadastro);

        MenuCaixa.setText("Caixa");
        jMenuBar1.add(MenuCaixa);

        MenuRelatorios.setText("Relatórios");
        jMenuBar1.add(MenuRelatorios);

        MenuSair.setText("Sair");
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

    private void CadastroFuncionariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CadastroFuncionariosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CadastroFuncionariosActionPerformed


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
    private javax.swing.JMenuItem CadastroCardapio;
    private javax.swing.JMenuItem CadastroClientes;
    private javax.swing.JMenuItem CadastroEntregador;
    private javax.swing.JMenuItem CadastroFuncionarios;
    private javax.swing.JMenu MenuCadastro;
    private javax.swing.JMenu MenuCaixa;
    private javax.swing.JMenu MenuRelatorios;
    private javax.swing.JMenu MenuSair;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    // End of variables declaration//GEN-END:variables
}
