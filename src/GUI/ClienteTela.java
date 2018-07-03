package GUI;

import Beans.ClienteBeans;
import Controller.ClienteController;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;

public class ClienteTela extends javax.swing.JInternalFrame {

   MaskFormatter Formatotel;
   SimpleDateFormat Formatodata;
   Date DataAtual;
   ClienteBeans ClienteB;
   ClienteController ClienteC;
   DefaultTableModel Modelo;
   
    public ClienteTela() {
        initComponents();
        TXT_Codigo.setEnabled(false);
        TXT_Data.setEnabled(false);
        habilitarcampos(false);
        Formatodata = new SimpleDateFormat("dd/MM/yyyy");
        
        
        ClienteB = new ClienteBeans();
        ClienteC = new ClienteController();
        Modelo = (DefaultTableModel)TBL_Clientes.getModel();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel5 = new javax.swing.JLabel();
        BTN_Cadastrar = new javax.swing.JButton();
        TXT_Data = new javax.swing.JTextField();
        BTN_Editar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        TXT_Codigo = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        TXT_Nome = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        TXT_Buscar = new javax.swing.JTextField();
        jSeparator2 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        TBL_Clientes = new javax.swing.JTable();
        jSeparator4 = new javax.swing.JSeparator();
        BTN_Novo = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        try {
            Formatotel = new MaskFormatter("(##)# ####-####");   
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao Inserir Campo Personalizado", "Erro", 0);
        }
        TXT_Celular = new JFormattedTextField(Formatotel);
        try {
            Formatotel = new MaskFormatter("(##)# ####-####");   
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao Inserir Campo Personalizado", "Erro", 0);
        }
        TXT_Telefone = new JFormattedTextField(Formatotel);

        setClosable(true);

        jLabel5.setText("Telefone");

        BTN_Cadastrar.setText("Cadastrar");
        BTN_Cadastrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BTN_Cadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_CadastrarActionPerformed(evt);
            }
        });

        TXT_Data.setEditable(false);

        BTN_Editar.setText("Editar");
        BTN_Editar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BTN_Editar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_EditarActionPerformed(evt);
            }
        });

        jLabel1.setText("Código");

        jLabel6.setText("Data Cadastro");

        TXT_Codigo.setEditable(false);
        TXT_Codigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TXT_CodigoActionPerformed(evt);
            }
        });

        jLabel7.setText("Buscar");

        jLabel2.setText("Nome");

        TXT_Buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TXT_BuscarActionPerformed(evt);
            }
        });
        TXT_Buscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                TXT_BuscarKeyReleased(evt);
            }
        });

        TBL_Clientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Nome", "Rua", "Bairro", "Telefone"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TBL_Clientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TBL_ClientesMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                TBL_ClientesMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(TBL_Clientes);

        BTN_Novo.setText("Novo");
        BTN_Novo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BTN_Novo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_NovoActionPerformed(evt);
            }
        });

        jLabel8.setText("Celular");

        TXT_Celular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TXT_CelularActionPerformed(evt);
            }
        });

        TXT_Telefone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TXT_TelefoneActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addComponent(jSeparator2)
            .addComponent(jSeparator4)
            .addComponent(jScrollPane1)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(TXT_Codigo, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(23, 23, 23)
                                .addComponent(TXT_Data, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(TXT_Nome)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(TXT_Buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 413, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(BTN_Novo, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BTN_Cadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BTN_Editar, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(TXT_Telefone, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TXT_Celular, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(TXT_Codigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TXT_Data, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(TXT_Nome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel8)
                    .addComponent(TXT_Celular, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TXT_Telefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TXT_Buscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BTN_Novo)
                    .addComponent(BTN_Cadastrar)
                    .addComponent(BTN_Editar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BTN_CadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_CadastrarActionPerformed
        popularClienteBeans();
        ClienteC.verificardados(ClienteB);
        limparCampos();
    }//GEN-LAST:event_BTN_CadastrarActionPerformed

    private void BTN_EditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_EditarActionPerformed
        popularClienteBeans();
        ClienteC.verificardadosEditar(ClienteB);
        limparCampos();
        TXT_Buscar.setText("");
        habilitarcampos(false);
    }//GEN-LAST:event_BTN_EditarActionPerformed

    private void TXT_CodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TXT_CodigoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TXT_CodigoActionPerformed

    private void TXT_BuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TXT_BuscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TXT_BuscarActionPerformed

    private void TXT_BuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TXT_BuscarKeyReleased
        Modelo.setNumRows(0);
        ClienteC.controlePesquisa(TXT_Buscar.getText(), Modelo);
    }//GEN-LAST:event_TXT_BuscarKeyReleased

    private void TBL_ClientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TBL_ClientesMouseClicked
        habilitarcampos(true);
        ClienteB = ClienteC.controlePreencherCampos(Integer.parseInt(Modelo.getValueAt(TBL_Clientes.getSelectedRow(), 0).toString()));
        TXT_Codigo.setText(ClienteB.getCodigo()+ "");
        TXT_Nome.setText(ClienteB.getNome());
        TXT_Telefone.setText(ClienteB.getTelefone());
        TXT_Celular.setText(ClienteB.getCelular());
        TXT_Data.setText(ClienteB.getDataCad());
    }//GEN-LAST:event_TBL_ClientesMouseClicked

    private void TBL_ClientesMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TBL_ClientesMousePressed

    }//GEN-LAST:event_TBL_ClientesMousePressed

    private void BTN_NovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_NovoActionPerformed
        DataAtual = new Date();
        TXT_Data.setText(Formatodata.format(DataAtual));
        habilitarcampos(true);
        ClienteC.controleDeCodigo();
        TXT_Codigo.setText(ClienteC.controleDeCodigo());
    }//GEN-LAST:event_BTN_NovoActionPerformed

    private void TXT_CelularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TXT_CelularActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TXT_CelularActionPerformed

    private void TXT_TelefoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TXT_TelefoneActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TXT_TelefoneActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BTN_Cadastrar;
    private javax.swing.JButton BTN_Editar;
    private javax.swing.JButton BTN_Novo;
    private javax.swing.JTable TBL_Clientes;
    private javax.swing.JTextField TXT_Buscar;
    private javax.swing.JTextField TXT_Celular;
    private javax.swing.JTextField TXT_Codigo;
    private javax.swing.JTextField TXT_Data;
    private javax.swing.JTextField TXT_Nome;
    private javax.swing.JTextField TXT_Telefone;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator4;
    // End of variables declaration//GEN-END:variables
    // End of variables declaration                   

final void habilitarcampos(boolean valor){
    TXT_Nome.setEnabled(valor);
    TXT_Telefone.setEnabled(valor);
    TXT_Celular.setEnabled(valor);
    TXT_Data.setEnabled(valor);
}

final void popularClienteBeans(){
    ClienteB.setNome(TXT_Nome.getText());
    ClienteB.setTelefone(TXT_Telefone.getText());
    ClienteB.setCelular(TXT_Celular.getText());
    ClienteB.setDataCad(TXT_Data.getText());
}

final void limparCampos(){
    TXT_Codigo.setText("");
    TXT_Nome.setText("");
    TXT_Telefone.setText("");
    TXT_Celular.setText("");
    TXT_Data.setText("");
}

}
