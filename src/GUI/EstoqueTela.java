package GUI;

import Beans.EstoqueBeans;
import Controller.EstoqueController;
import javax.swing.table.DefaultTableModel;



public class EstoqueTela extends javax.swing.JInternalFrame {
    
   EstoqueBeans EstoqueB;
   EstoqueController EstoqueC;
   DefaultTableModel Modelo;

 
    public EstoqueTela() {
        initComponents();
        TXT_Codigo.setEnabled(false);
        habilitarcampos(false);
        
       EstoqueB = new EstoqueBeans();
       EstoqueC = new EstoqueController();
       Modelo = (DefaultTableModel)TBL_Estoque.getModel();
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        TXT_NCM = new javax.swing.JTextField();
        BTN_Novo = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        BTN_Cadastrar = new javax.swing.JButton();
        BTN_Editar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        TXT_Codigo = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        TXT_Nome = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        TXT_Buscar = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        TBL_Estoque = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        TXT_NF = new javax.swing.JTextField();
        jSeparator4 = new javax.swing.JSeparator();
        jLabel6 = new javax.swing.JLabel();
        TXT_Valor = new javax.swing.JTextField();
        TXT_Quantidade = new javax.swing.JTextField();

        setClosable(true);

        TXT_NCM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TXT_NCMActionPerformed(evt);
            }
        });

        BTN_Novo.setText("Novo");
        BTN_Novo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BTN_Novo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_NovoActionPerformed(evt);
            }
        });

        jLabel5.setText("NCM/SH");

        BTN_Cadastrar.setText("Cadastrar");
        BTN_Cadastrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BTN_Cadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_CadastrarActionPerformed(evt);
            }
        });

        BTN_Editar.setText("Editar");
        BTN_Editar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BTN_Editar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_EditarActionPerformed(evt);
            }
        });

        jLabel1.setText("Código");

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

        jLabel3.setText("Valor");

        TBL_Estoque.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Nome", "Quantidade", "Valor", "NF/e", "NCM/SH"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TBL_Estoque.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TBL_EstoqueMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                TBL_EstoqueMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(TBL_Estoque);

        jLabel4.setText("NF/e");

        jLabel6.setText("Quantidade");

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
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TXT_Buscar))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel4))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(TXT_NF, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
                                            .addComponent(TXT_NCM))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                            .addComponent(TXT_Codigo, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(1, 1, 1)))
                                    .addComponent(TXT_Quantidade, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(50, 50, 50))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addComponent(TXT_Valor, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(81, 81, 81))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(BTN_Novo, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BTN_Cadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BTN_Editar, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(46, 46, 46)
                        .addComponent(TXT_Nome)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(TXT_Codigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(TXT_Valor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(TXT_Nome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(TXT_Quantidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(jLabel4))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TXT_NF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(TXT_NCM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TXT_Buscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BTN_Novo)
                    .addComponent(BTN_Cadastrar)
                    .addComponent(BTN_Editar))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void TXT_NCMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TXT_NCMActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TXT_NCMActionPerformed

    private void BTN_NovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_NovoActionPerformed
        habilitarcampos(true);
        EstoqueC.controleDeCodigo();
        TXT_Codigo.setText(EstoqueC.controleDeCodigo());
    }//GEN-LAST:event_BTN_NovoActionPerformed

    private void BTN_CadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_CadastrarActionPerformed
        popularEstoqueBeans();
        EstoqueC.verificardados(EstoqueB);
        limparCampos();
    }//GEN-LAST:event_BTN_CadastrarActionPerformed

    private void BTN_EditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_EditarActionPerformed
        popularEstoqueBeans();
        EstoqueC.verificardadosEditar(EstoqueB);
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
        EstoqueC.controlePesquisa(TXT_Buscar.getText(), Modelo);
    }//GEN-LAST:event_TXT_BuscarKeyReleased

    private void TBL_EstoqueMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TBL_EstoqueMouseClicked
        habilitarcampos(true);
        EstoqueB = EstoqueC.controlePreencherCampos(Integer.parseInt(Modelo.getValueAt(TBL_Estoque.getSelectedRow(), 0).toString()));
        TXT_Codigo.setText(EstoqueB.getCodigo()+ "");
        TXT_Nome.setText(EstoqueB.getNome());
        TXT_Quantidade.setText(EstoqueB.getQuantidade()+ "");
        TXT_Valor.setText(EstoqueB.getValor() + "");
        TXT_NF.setText(EstoqueB.getNF() + "");
        TXT_NCM.setText(EstoqueB.getNCM() + "");
    }//GEN-LAST:event_TBL_EstoqueMouseClicked

    private void TBL_EstoqueMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TBL_EstoqueMousePressed

    }//GEN-LAST:event_TBL_EstoqueMousePressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BTN_Cadastrar;
    private javax.swing.JButton BTN_Editar;
    private javax.swing.JButton BTN_Novo;
    private javax.swing.JTable TBL_Estoque;
    private javax.swing.JTextField TXT_Buscar;
    private javax.swing.JTextField TXT_Codigo;
    private javax.swing.JTextField TXT_NCM;
    private javax.swing.JTextField TXT_NF;
    private javax.swing.JTextField TXT_Nome;
    private javax.swing.JTextField TXT_Quantidade;
    private javax.swing.JTextField TXT_Valor;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator4;
    // End of variables declaration//GEN-END:variables

    final void habilitarcampos(boolean b) {
    TXT_Valor.setEnabled(b);
    TXT_Quantidade.setEnabled(b);
    TXT_NF.setEnabled(b);
    TXT_NCM.setEnabled(b);
    TXT_Nome.setEnabled(b);
    }

    final void popularEstoqueBeans() {
    EstoqueB.setNome(TXT_Nome.getText());
    EstoqueB.setQuantidade(Integer.parseInt(TXT_Quantidade.getText()));
    EstoqueB.setValor(Integer.parseInt(TXT_Valor.getText()));
    EstoqueB.setNF(Integer.parseInt(TXT_NF.getText()));
    EstoqueB.setNCM(Integer.parseInt(TXT_NCM.getText()));
    }

    final void limparCampos() {
    TXT_Codigo.setText("");
    TXT_Nome.setText("");
    TXT_Quantidade.setText("");
    TXT_Valor.setText("");
    TXT_NF.setText("");
    TXT_NCM.setText("");
    }
}


