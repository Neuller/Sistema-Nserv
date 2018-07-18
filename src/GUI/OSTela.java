package GUI;

import Beans.ServicosBeans;
import Controller.ServicosController;
import java.sql.*;
import Utilitarios.Conexao;
import Utilitarios.Corretores;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;
import java.util.Date;
import javax.swing.table.DefaultTableModel;


public class OSTela extends javax.swing.JInternalFrame {
    
    ResultSet rs = null;
    SimpleDateFormat Formatodata;
    Date DataAtual;
    ServicosBeans ServicosB;
    ServicosController ServicosC;
    DefaultTableModel Modelo;   
    

    public OSTela() {
        initComponents();       
        BTN_Cadastrar.setVisible(false);
        BTN_Voltar.setVisible(false);
        BTN_Editar.setVisible(false);
        TXT_Data.setEnabled(false);
        BTN_Voltar.setVisible(false);
        BTN_Pesquisar.setEnabled(false);
        TBL_Clientes.setVisible(false);
        habilitarcampos(false);
        //conexao = Conexao.getConnection();
        Formatodata = new SimpleDateFormat("dd/MM/yyyy");
       
        
        
           ServicosB = new ServicosBeans();
           ServicosC = new ServicosController();
           Modelo = (DefaultTableModel)TBL_Clientes.getModel();
           
    }
    
    private void pesquisar_cliente(){
        String SQLInsertion = "select CodCliente as ID, Cli_Nome as Nome, Cli_Telefone as Telefone, Cli_Celular as Celular from clientes where Cli_Nome like ?";
        try {
           
            PreparedStatement pst = Conexao.getConnection().prepareStatement(SQLInsertion);
            pst.setString(1, TXT_Clientes.getText() + "%");
            rs = pst.executeQuery();
            TBL_Clientes.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    private void setar_campos(){
        Modelo.removeRow(TBL_Clientes.getSelectedRow());
        int setar = TBL_Clientes.getSelectedRow();
        TXT_CodCliente.setText(TBL_Clientes.getModel().getValueAt(setar, 0).toString());   
    }
      
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        PN_OS = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        TXT_CodServico = new javax.swing.JTextField();
        TXT_Data = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        CB_Situacao = new javax.swing.JComboBox<>();
        PN_Clientes = new javax.swing.JPanel();
        TXT_Clientes = new javax.swing.JTextField();
        BTN_Pesquisar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        TXT_CodCliente = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        TBL_Clientes = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        TXT_Aparelho = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        TXT_Informacao = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        TXT_Valor = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        CB_Tecnico = new javax.swing.JComboBox<>();
        CB_Garantia = new javax.swing.JComboBox<>();
        BTN_Cadastrar = new javax.swing.JButton();
        BTN_Novo = new javax.swing.JButton();
        BTN_Editar = new javax.swing.JButton();
        BTN_Voltar = new javax.swing.JButton();
        CB_Genero = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        TXT_Modelo = new javax.swing.JTextField();

        setClosable(true);
        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeactivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeiconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameIconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameOpened(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameOpened(evt);
            }
        });

        PN_OS.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setText("Código Serviço");

        jLabel2.setText("Data");

        TXT_CodServico.setEditable(false);
        TXT_CodServico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TXT_CodServicoActionPerformed(evt);
            }
        });

        TXT_Data.setEditable(false);

        javax.swing.GroupLayout PN_OSLayout = new javax.swing.GroupLayout(PN_OS);
        PN_OS.setLayout(PN_OSLayout);
        PN_OSLayout.setHorizontalGroup(
            PN_OSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PN_OSLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TXT_CodServico, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TXT_Data, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        PN_OSLayout.setVerticalGroup(
            PN_OSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PN_OSLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PN_OSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(TXT_CodServico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TXT_Data, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        jLabel3.setText("Situação");

        CB_Situacao.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Entrada", "Na Bancada", "Entrega Feita", "Orçamento Reprovado", "Aguardando Aprovação", "Aguardando Peças", "Abandonado pelo Cliente", "Retorno" }));
        CB_Situacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CB_SituacaoActionPerformed(evt);
            }
        });

        PN_Clientes.setBorder(javax.swing.BorderFactory.createTitledBorder("Clientes"));

        TXT_Clientes.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                TXT_ClientesKeyReleased(evt);
            }
        });

        BTN_Pesquisar.setText("Pesquisar");
        BTN_Pesquisar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BTN_Pesquisar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BTN_PesquisarMouseClicked(evt);
            }
        });
        BTN_Pesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_PesquisarActionPerformed(evt);
            }
        });

        jLabel4.setText("Código Cliente");

        TXT_CodCliente.setEditable(false);

        TBL_Clientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "Nome", "Telefone", "Celular"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TBL_Clientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TBL_ClientesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TBL_Clientes);

        javax.swing.GroupLayout PN_ClientesLayout = new javax.swing.GroupLayout(PN_Clientes);
        PN_Clientes.setLayout(PN_ClientesLayout);
        PN_ClientesLayout.setHorizontalGroup(
            PN_ClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PN_ClientesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PN_ClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 402, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, PN_ClientesLayout.createSequentialGroup()
                        .addComponent(TXT_Clientes)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BTN_Pesquisar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TXT_CodCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(6, 6, 6))
        );
        PN_ClientesLayout.setVerticalGroup(
            PN_ClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PN_ClientesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PN_ClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TXT_Clientes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(TXT_CodCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BTN_Pesquisar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLabel5.setText("Aparelho");

        jLabel6.setText("Informação");

        jLabel7.setText("Técnico");

        jLabel8.setText("Valor");

        jLabel9.setText("Garantia");

        CB_Tecnico.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Neuller César", "Mario Jackson" }));

        CB_Garantia.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Funcional", "30 Dias", "90 Dias", "180 Dias", "360 Dias" }));

        BTN_Cadastrar.setText("Cadastrar");
        BTN_Cadastrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BTN_Cadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_CadastrarActionPerformed(evt);
            }
        });

        BTN_Novo.setText("Novo");
        BTN_Novo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BTN_Novo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_NovoActionPerformed(evt);
            }
        });

        BTN_Editar.setText("Editar");
        BTN_Editar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        BTN_Voltar.setText("Voltar");
        BTN_Voltar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BTN_Voltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_VoltarActionPerformed(evt);
            }
        });

        CB_Genero.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Orçamento", "Ordem de Serviço" }));
        CB_Genero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CB_GeneroActionPerformed(evt);
            }
        });

        jLabel10.setText("Marca/Modelo");

        TXT_Modelo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TXT_ModeloActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(PN_OS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(CB_Tecnico, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(CB_Situacao, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(CB_Garantia, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(38, 38, 38)
                                .addComponent(CB_Genero, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(32, 32, 32)
                        .addComponent(PN_Clientes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, 61, Short.MAX_VALUE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 61, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 61, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(TXT_Valor, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(BTN_Novo, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(BTN_Cadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(BTN_Editar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(BTN_Voltar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(24, 24, 24))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(TXT_Aparelho, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(TXT_Modelo, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(TXT_Informacao))
                                .addContainerGap())))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(PN_Clientes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(PN_OS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(CB_Genero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(CB_Situacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(CB_Tecnico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(CB_Garantia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(TXT_Aparelho, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(TXT_Modelo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(TXT_Informacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(TXT_Valor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BTN_Cadastrar)
                    .addComponent(BTN_Novo)
                    .addComponent(BTN_Editar)
                    .addComponent(BTN_Voltar))
                .addGap(34, 34, 34))
        );

        setBounds(0, 0, 800, 450);
    }// </editor-fold>//GEN-END:initComponents

    private void BTN_PesquisarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BTN_PesquisarMouseClicked
        pesquisar_cliente();
        TBL_Clientes.setVisible(true);
    }//GEN-LAST:event_BTN_PesquisarMouseClicked

    private void TXT_ClientesKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TXT_ClientesKeyReleased
        pesquisar_cliente();
        TBL_Clientes.setVisible(true);
    }//GEN-LAST:event_TXT_ClientesKeyReleased

    private void TBL_ClientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TBL_ClientesMouseClicked
        setar_campos();
        TXT_Valor.setText("0");
        TXT_CodCliente.setEnabled(true);
        TXT_Aparelho.setEnabled(true);
        TXT_Valor.setEnabled(true);   
        TXT_Informacao.setEnabled(true); 
        TXT_Modelo.setEnabled(true);
        TXT_Clientes.setEnabled(true);     
        BTN_Novo.setVisible(false);
    }//GEN-LAST:event_TBL_ClientesMouseClicked

    private void formInternalFrameOpened(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameOpened
     
    }//GEN-LAST:event_formInternalFrameOpened

    private void CB_SituacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CB_SituacaoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CB_SituacaoActionPerformed

    private void BTN_CadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_CadastrarActionPerformed
        popularOSBeans();
        ServicosC.verificardados(ServicosB);
        TXT_Aparelho.setText("");
        TXT_CodCliente.setText(ServicosC.controleDeCodigo());
        DataAtual = new Date();
        TXT_Data.setText(Formatodata.format(DataAtual));
    }//GEN-LAST:event_BTN_CadastrarActionPerformed

    private void BTN_NovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_NovoActionPerformed
        limparCampos();
        DataAtual = new Date();
        TXT_Data.setText(Formatodata.format(DataAtual));       
        BTN_Pesquisar.setEnabled(true);
        BTN_Cadastrar.setVisible(true);
        BTN_Voltar.setVisible(true);
        TXT_CodServico.setText(ServicosC.controleDeCodigo());
        TXT_CodServico.setEnabled(true);  
        TXT_Data.setEnabled(true); 
    }//GEN-LAST:event_BTN_NovoActionPerformed

    private void BTN_PesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_PesquisarActionPerformed
        TXT_Clientes.setEnabled(true);        
    }//GEN-LAST:event_BTN_PesquisarActionPerformed

    private void BTN_VoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_VoltarActionPerformed
        TXT_CodCliente.setEnabled(false);
        habilitarcampos(false);
        BTN_Cadastrar.setVisible(false);
        BTN_Editar.setVisible(false);
        BTN_Novo.setVisible(true);
        limparCampos();
        Modelo.removeRow(TBL_Clientes.getSelectedRow());
        BTN_Voltar.setVisible(false);
    }//GEN-LAST:event_BTN_VoltarActionPerformed

    private void TXT_CodServicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TXT_CodServicoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TXT_CodServicoActionPerformed

    private void CB_GeneroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CB_GeneroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CB_GeneroActionPerformed

    private void TXT_ModeloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TXT_ModeloActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TXT_ModeloActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BTN_Cadastrar;
    private javax.swing.JButton BTN_Editar;
    private javax.swing.JButton BTN_Novo;
    private javax.swing.JButton BTN_Pesquisar;
    private javax.swing.JButton BTN_Voltar;
    private javax.swing.JComboBox<String> CB_Garantia;
    private javax.swing.JComboBox<String> CB_Genero;
    private javax.swing.JComboBox<String> CB_Situacao;
    private javax.swing.JComboBox<String> CB_Tecnico;
    private javax.swing.JPanel PN_Clientes;
    private javax.swing.JPanel PN_OS;
    private javax.swing.JTable TBL_Clientes;
    private javax.swing.JTextField TXT_Aparelho;
    private javax.swing.JTextField TXT_Clientes;
    private javax.swing.JTextField TXT_CodCliente;
    private javax.swing.JTextField TXT_CodServico;
    private javax.swing.JTextField TXT_Data;
    private javax.swing.JTextField TXT_Informacao;
    private javax.swing.JTextField TXT_Modelo;
    private javax.swing.JTextField TXT_Valor;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables

    final void habilitarcampos(boolean valor){
        TXT_CodCliente.setEnabled(valor);
        TXT_Aparelho.setEnabled(valor);
        TXT_Valor.setEnabled(valor);
        TXT_Informacao.setEnabled(valor);    
        TXT_CodServico.setEnabled(valor); 
        TXT_Clientes.setEnabled(valor); 
        TXT_Modelo.setEnabled(valor);
}
    
    final void limparCampos(){
        TXT_CodCliente.setText("");
        TXT_Aparelho.setText("");
        TXT_Valor.setText("");
        TXT_Informacao.setText("");   
        TXT_Modelo.setText("");
    }
    
    final void popularOSBeans(){
    ServicosB.setData_Servico(TXT_Data.getText());
    ServicosB.setGenero(CB_Genero.getSelectedItem().toString());
    ServicosB.setModelo(TXT_Modelo.getText());
    ServicosB.setSituacao(CB_Situacao.getSelectedItem().toString());
    ServicosB.setAparelho(TXT_Aparelho.getText());
    ServicosB.setInformacao(TXT_Informacao.getText());
    ServicosB.setTecnico(CB_Tecnico.getSelectedItem().toString());
    ServicosB.setGarantia(CB_Garantia.getSelectedItem().toString());
    ServicosB.setValor(Double.parseDouble(TXT_Valor.getText().replace(",",".")));
    ServicosB.setCodCliente(Integer.parseInt(TXT_CodCliente.getText()));
}
    
}
