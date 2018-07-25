package GUI;

import Beans.EstoqueBeans;
import Controller.EstoqueController;
import Utilitarios.SoNumeros;
import java.text.DecimalFormat;
import javax.swing.table.DefaultTableModel;




public class EstoqueTela extends javax.swing.JInternalFrame {
    
   EstoqueBeans EstoqueB;
   EstoqueController EstoqueC;
   DefaultTableModel Modelo;
   DecimalFormat formatoDecimal;

 
    public EstoqueTela() {
        initComponents();
        //TXT_Valor.setDocument(new SoNumeros());
        TXT_Quantidade.setDocument(new SoNumeros());
        TXT_NF.setDocument(new SoNumeros());
        TXT_NCM.setDocument(new SoNumeros());
        TXT_Codigo.setEnabled(false);
        habilitarcampos(false);
        BTN_Cadastrar.setVisible(false);
        BTN_Editar.setVisible(false);
        TXT_Buscar.setEnabled(false);
        BTN_Voltar.setVisible(false);
        
       EstoqueB = new EstoqueBeans();
       EstoqueC = new EstoqueController();
       Modelo = (DefaultTableModel)TBL_Estoque.getModel();
       formatoDecimal = new DecimalFormat("0.00");
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFormattedTextField1 = new javax.swing.JFormattedTextField();
        PainelCabecalho = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        PainelGeral = new javax.swing.JPanel();
        TXT_NCM = new javax.swing.JTextField();
        TXT_Buscar = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        TXT_Codigo = new javax.swing.JTextField();
        TXT_Nome = new javax.swing.JTextField();
        BTN_Voltar = new javax.swing.JButton();
        BTN_Pesquisar = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        TBL_Estoque = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        TXT_NF = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        BTN_Cadastrar = new javax.swing.JButton();
        BTN_Editar = new javax.swing.JButton();
        TXT_Valor = new javax.swing.JFormattedTextField();
        jSeparator4 = new javax.swing.JSeparator();
        TXT_Quantidade = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        BTN_Novo = new javax.swing.JButton();

        jFormattedTextField1.setText("jFormattedTextField1");

        setBackground(new java.awt.Color(255, 255, 255));
        setClosable(true);
        setTitle("Cadastro de Estoque");
        setPreferredSize(new java.awt.Dimension(480, 540));

        PainelCabecalho.setBackground(new java.awt.Color(7, 143, 201));
        PainelCabecalho.setPreferredSize(new java.awt.Dimension(480, 480));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/ico_nserv.png"))); // NOI18N

        PainelGeral.setBackground(new java.awt.Color(255, 255, 255));

        TXT_NCM.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        TXT_NCM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TXT_NCMActionPerformed(evt);
            }
        });

        TXT_Buscar.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
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

        jLabel1.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel1.setText("Código");

        jLabel5.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel5.setText("NCM/SH");

        TXT_Codigo.setEditable(false);
        TXT_Codigo.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        TXT_Codigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TXT_CodigoActionPerformed(evt);
            }
        });

        TXT_Nome.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        BTN_Voltar.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        BTN_Voltar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/Voltar.png"))); // NOI18N
        BTN_Voltar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BTN_Voltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_VoltarActionPerformed(evt);
            }
        });

        BTN_Pesquisar.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        BTN_Pesquisar.setText("Pesquisar");
        BTN_Pesquisar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BTN_Pesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_PesquisarActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel6.setText("Quantidade");

        TBL_Estoque.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
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

        jLabel3.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel3.setText("Valor");

        TXT_NF.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel2.setText("Nome");

        BTN_Cadastrar.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        BTN_Cadastrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/Valid.png"))); // NOI18N
        BTN_Cadastrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BTN_Cadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_CadastrarActionPerformed(evt);
            }
        });

        BTN_Editar.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        BTN_Editar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/Edit.png"))); // NOI18N
        BTN_Editar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BTN_Editar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_EditarActionPerformed(evt);
            }
        });

        TXT_Valor.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                TXT_ValorFocusLost(evt);
            }
        });
        TXT_Valor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TXT_ValorActionPerformed(evt);
            }
        });

        TXT_Quantidade.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel4.setText("NF/e");

        BTN_Novo.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        BTN_Novo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/New.png"))); // NOI18N
        BTN_Novo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BTN_Novo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_NovoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PainelGeralLayout = new javax.swing.GroupLayout(PainelGeral);
        PainelGeral.setLayout(PainelGeralLayout);
        PainelGeralLayout.setHorizontalGroup(
            PainelGeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PainelGeralLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PainelGeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(PainelGeralLayout.createSequentialGroup()
                        .addComponent(BTN_Novo, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BTN_Cadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BTN_Editar, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BTN_Voltar, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PainelGeralLayout.createSequentialGroup()
                        .addGroup(PainelGeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel5)
                            .addComponent(jLabel1)
                            .addComponent(jLabel4)
                            .addComponent(jLabel2))
                        .addGap(18, 18, 18)
                        .addGroup(PainelGeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(TXT_Quantidade, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(PainelGeralLayout.createSequentialGroup()
                                .addGroup(PainelGeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(PainelGeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(TXT_NF)
                                        .addComponent(TXT_NCM, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PainelGeralLayout.createSequentialGroup()
                                        .addComponent(TXT_Codigo, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(1, 1, 1)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel3)
                                .addGap(9, 9, 9)
                                .addComponent(TXT_Valor, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(TXT_Nome)))
                    .addComponent(jSeparator4)
                    .addComponent(jScrollPane1)
                    .addComponent(jSeparator2)
                    .addGroup(PainelGeralLayout.createSequentialGroup()
                        .addComponent(BTN_Pesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(TXT_Buscar))
                    .addComponent(jSeparator1))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        PainelGeralLayout.setVerticalGroup(
            PainelGeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PainelGeralLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(PainelGeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(TXT_Codigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TXT_Valor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PainelGeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(TXT_Nome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PainelGeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(TXT_Quantidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(PainelGeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PainelGeralLayout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(jLabel4))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PainelGeralLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TXT_NF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PainelGeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(TXT_NCM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PainelGeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TXT_Buscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BTN_Pesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PainelGeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BTN_Novo, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BTN_Cadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BTN_Editar, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BTN_Voltar, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(71, 71, 71))
        );

        javax.swing.GroupLayout PainelCabecalhoLayout = new javax.swing.GroupLayout(PainelCabecalho);
        PainelCabecalho.setLayout(PainelCabecalhoLayout);
        PainelCabecalhoLayout.setHorizontalGroup(
            PainelCabecalhoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PainelGeral, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PainelCabecalhoLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel7)
                .addGap(19, 19, 19))
        );
        PainelCabecalhoLayout.setVerticalGroup(
            PainelCabecalhoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PainelCabecalhoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(PainelGeral, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(54, 54, 54))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PainelCabecalho, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PainelCabecalho, javax.swing.GroupLayout.PREFERRED_SIZE, 530, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void TXT_NCMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TXT_NCMActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TXT_NCMActionPerformed

    private void BTN_NovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_NovoActionPerformed
        habilitarcampos(true);
        limparCampos();
        BTN_Cadastrar.setVisible(true);
        BTN_Voltar.setVisible(true);
        EstoqueC.controleDeCodigo();
        TXT_Codigo.setText(EstoqueC.controleDeCodigo());
        TXT_Valor.setText("0");
        TXT_Quantidade.setText("0");
        TXT_NF.setText("0");
        TXT_NCM.setText("0");
    }//GEN-LAST:event_BTN_NovoActionPerformed

    private void BTN_CadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_CadastrarActionPerformed
        popularEstoqueBeans();
        EstoqueC.verificardados(EstoqueB);
        //limparCampos();
        TXT_Nome.setText("");
        TXT_Codigo.setText(EstoqueC.controleDeCodigo());
        TXT_Valor.setText("0");
        TXT_Quantidade.setText("0");
        TXT_NF.setText("0");
        TXT_NCM.setText("0");
    }//GEN-LAST:event_BTN_CadastrarActionPerformed

    private void BTN_EditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_EditarActionPerformed
        popularEstoqueBeans();
        EstoqueC.verificardadosEditar(EstoqueB);
        limparCampos();
        Modelo.removeRow(TBL_Estoque.getSelectedRow());
        TXT_Buscar.setText("");
        habilitarcampos(false);
        TXT_Buscar.setEnabled(false);
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
        BTN_Editar.setVisible(true);
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

    private void TXT_ValorFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_TXT_ValorFocusLost

    }//GEN-LAST:event_TXT_ValorFocusLost

    private void TXT_ValorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TXT_ValorActionPerformed

    }//GEN-LAST:event_TXT_ValorActionPerformed

    private void BTN_PesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_PesquisarActionPerformed
        habilitarcampos(false);
        TXT_Buscar.setEnabled(true);
        BTN_Novo.setVisible(false);
        BTN_Editar.setVisible(true);
        BTN_Cadastrar.setVisible(false); 
        BTN_Voltar.setVisible(true);
    }//GEN-LAST:event_BTN_PesquisarActionPerformed

    private void BTN_VoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_VoltarActionPerformed
        TXT_Codigo.setEnabled(false);
        habilitarcampos(false);
        BTN_Cadastrar.setVisible(false);
        BTN_Editar.setVisible(false);
        TXT_Buscar.setEnabled(false);
        BTN_Novo.setVisible(true);
        limparCampos();
        Modelo.removeRow(TBL_Estoque.getSelectedRow());
        TXT_Buscar.setText("");
        BTN_Voltar.setVisible(false);
    }//GEN-LAST:event_BTN_VoltarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BTN_Cadastrar;
    private javax.swing.JButton BTN_Editar;
    private javax.swing.JButton BTN_Novo;
    private javax.swing.JButton BTN_Pesquisar;
    private javax.swing.JButton BTN_Voltar;
    private javax.swing.JPanel PainelCabecalho;
    private javax.swing.JPanel PainelGeral;
    private javax.swing.JTable TBL_Estoque;
    private javax.swing.JTextField TXT_Buscar;
    private javax.swing.JTextField TXT_Codigo;
    private javax.swing.JTextField TXT_NCM;
    private javax.swing.JTextField TXT_NF;
    private javax.swing.JTextField TXT_Nome;
    private javax.swing.JTextField TXT_Quantidade;
    private javax.swing.JFormattedTextField TXT_Valor;
    private javax.swing.JFormattedTextField jFormattedTextField1;
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
    EstoqueB.setValor(Double.parseDouble(TXT_Valor.getText().replace(",",".")));
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


