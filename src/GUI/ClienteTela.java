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
   
   private static ClienteTela clientetela;   
   
   public static ClienteTela getInstancia(){
       if(clientetela == null){
           clientetela = new ClienteTela();          
       }
       return clientetela;
   }
   
    public ClienteTela() {
        initComponents();       
        BTN_Cadastrar.setVisible(false);
        BTN_Voltar.setVisible(false);
        BTN_Editar.setVisible(false);
        TXT_Codigo.setEnabled(false);
        TXT_Data.setEnabled(false);
        TXT_Buscar.setEnabled(false);
        habilitarcampos(false);
        Formatodata = new SimpleDateFormat("dd/MM/yyyy");
        
        
        ClienteB = new ClienteBeans();
        ClienteC = new ClienteController();
        Modelo = (DefaultTableModel)TBL_Clientes.getModel();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PainelGeral = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TBL_Clientes = new javax.swing.JTable();
        TXT_Codigo = new javax.swing.JTextField();
        BTN_Cadastrar = new javax.swing.JButton();
        TXT_Buscar = new javax.swing.JTextField();
        try {
            Formatotel = new MaskFormatter("(##) ####-####");   
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao Inserir Campo Personalizado", "Erro", 0);
        }
        TXT_Telefone = new JFormattedTextField(Formatotel);
        TXT_Data = new javax.swing.JTextField();
        BTN_Editar = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        TXT_Nome = new javax.swing.JTextField();
        BTN_Pesquisar = new javax.swing.JButton();
        jSeparator4 = new javax.swing.JSeparator();
        BTN_Novo = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        try {
            Formatotel = new MaskFormatter("(##) 9 ####-####");   
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao Inserir Campo Personalizado", "Erro", 0);
        }
        TXT_Celular = new JFormattedTextField(Formatotel);
        jLabel2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        BTN_Voltar = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();

        setBackground(new java.awt.Color(255, 255, 255));
        setClosable(true);
        setTitle("Cadastro de Clientes");
        setPreferredSize(new java.awt.Dimension(560, 400));

        PainelGeral.setBackground(new java.awt.Color(255, 255, 255));

        jLabel5.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel5.setText("Telefone");

        TBL_Clientes.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        TBL_Clientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Nome", "Telefone", "Celular"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TBL_Clientes.setGridColor(new java.awt.Color(255, 255, 255));
        TBL_Clientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TBL_ClientesMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                TBL_ClientesMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(TBL_Clientes);

        TXT_Codigo.setEditable(false);
        TXT_Codigo.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        TXT_Codigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TXT_CodigoActionPerformed(evt);
            }
        });

        BTN_Cadastrar.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        BTN_Cadastrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/Valid.png"))); // NOI18N
        BTN_Cadastrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BTN_Cadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_CadastrarActionPerformed(evt);
            }
        });

        TXT_Buscar.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        TXT_Buscar.setOpaque(false);
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

        TXT_Telefone.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        TXT_Telefone.setOpaque(false);
        TXT_Telefone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TXT_TelefoneActionPerformed(evt);
            }
        });

        TXT_Data.setEditable(false);
        TXT_Data.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        TXT_Data.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TXT_DataActionPerformed(evt);
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

        TXT_Nome.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        TXT_Nome.setOpaque(false);

        BTN_Pesquisar.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        BTN_Pesquisar.setText("Pesquisar");
        BTN_Pesquisar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BTN_Pesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_PesquisarActionPerformed(evt);
            }
        });

        BTN_Novo.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        BTN_Novo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/New.png"))); // NOI18N
        BTN_Novo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BTN_Novo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_NovoActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel8.setText("Celular");

        jLabel1.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel1.setText("Código");

        TXT_Celular.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        TXT_Celular.setOpaque(false);
        TXT_Celular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TXT_CelularActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel2.setText("Nome");

        jLabel6.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel6.setText("Data Cadastro");

        BTN_Voltar.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        BTN_Voltar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/Voltar.png"))); // NOI18N
        BTN_Voltar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BTN_Voltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_VoltarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PainelGeralLayout = new javax.swing.GroupLayout(PainelGeral);
        PainelGeral.setLayout(PainelGeralLayout);
        PainelGeralLayout.setHorizontalGroup(
            PainelGeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PainelGeralLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PainelGeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1)
                    .addComponent(jSeparator2)
                    .addComponent(jSeparator4)
                    .addComponent(jScrollPane1)
                    .addGroup(PainelGeralLayout.createSequentialGroup()
                        .addGroup(PainelGeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel1))
                        .addGap(21, 21, 21)
                        .addGroup(PainelGeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PainelGeralLayout.createSequentialGroup()
                                .addComponent(TXT_Codigo, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(31, 31, 31)
                                .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(TXT_Data, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(TXT_Nome)))
                    .addGroup(PainelGeralLayout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(TXT_Telefone, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TXT_Celular, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PainelGeralLayout.createSequentialGroup()
                        .addComponent(BTN_Pesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(TXT_Buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PainelGeralLayout.createSequentialGroup()
                        .addComponent(BTN_Novo, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BTN_Cadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BTN_Editar, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BTN_Voltar, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        PainelGeralLayout.setVerticalGroup(
            PainelGeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PainelGeralLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PainelGeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(TXT_Codigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TXT_Data, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PainelGeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(TXT_Nome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PainelGeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel8)
                    .addComponent(TXT_Celular, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TXT_Telefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PainelGeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TXT_Buscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BTN_Pesquisar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PainelGeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(BTN_Novo, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(PainelGeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(BTN_Cadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(BTN_Editar, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(BTN_Voltar, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PainelGeral, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PainelGeral, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BTN_CadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_CadastrarActionPerformed
        popularClienteBeans();
        ClienteC.verificardados(ClienteB);
        limparCampos();
        DataAtual = new Date();
        TXT_Data.setText(Formatodata.format(DataAtual));
        habilitarcampos(true);
        ClienteC.controleDeCodigo();
        TXT_Codigo.setText(ClienteC.controleDeCodigo());
    }//GEN-LAST:event_BTN_CadastrarActionPerformed

    private void BTN_EditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_EditarActionPerformed
        popularClienteBeans();
        ClienteC.verificardadosEditar(ClienteB);
        limparCampos();
        Modelo.removeRow(TBL_Clientes.getSelectedRow());
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
        limparCampos();
        BTN_Voltar.setVisible(true);
        BTN_Cadastrar.setVisible(true);
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

    private void BTN_PesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_PesquisarActionPerformed
        TXT_Buscar.setEnabled(true);
        BTN_Novo.setVisible(false);
        BTN_Voltar.setVisible(true);
        BTN_Editar.setVisible(true);
        BTN_Cadastrar.setVisible(false);
        habilitarcampos(false);
    }//GEN-LAST:event_BTN_PesquisarActionPerformed

    private void BTN_VoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_VoltarActionPerformed
        TXT_Codigo.setEnabled(false);
        habilitarcampos(false);
        BTN_Cadastrar.setVisible(false);
        BTN_Editar.setVisible(false);
        TXT_Buscar.setEnabled(false);
        BTN_Novo.setVisible(true);
        limparCampos();
        Modelo.removeRow(TBL_Clientes.getSelectedRow());
        TXT_Buscar.setText("");
        BTN_Voltar.setVisible(false);
    }//GEN-LAST:event_BTN_VoltarActionPerformed

    private void TXT_DataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TXT_DataActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TXT_DataActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BTN_Cadastrar;
    private javax.swing.JButton BTN_Editar;
    private javax.swing.JButton BTN_Novo;
    private javax.swing.JButton BTN_Pesquisar;
    private javax.swing.JButton BTN_Voltar;
    private javax.swing.JPanel PainelGeral;
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
