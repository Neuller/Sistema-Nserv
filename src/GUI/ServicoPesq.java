package GUI;

import Beans.ServicosBeans;
import Controller.ServicosController;
import java.sql.*;
import Utilitarios.Conexao;
import Utilitarios.Corretores;
import java.io.File;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;


public class ServicoPesq extends javax.swing.JInternalFrame {
    
    ResultSet rs = null;
    SimpleDateFormat Formatodata;
    Date DataAtual;
    ServicosBeans ServicosB;
    ServicosController ServicosC;
    DefaultTableModel Modelo;
    DefaultTableModel Modelo2; 
    Connection conexao = null;
    
   private String Tipo;   
   private static ServicoPesq ostela;   
   
   public static ServicoPesq getInstancia(){
       if(ostela == null){
           ostela = new ServicoPesq();          
       }
       return ostela;
   }     

    public ServicoPesq() {
        initComponents();     
        BTN_Imprimir.setEnabled(false);
        BTN_Voltar.setEnabled(false);
        BTN_Editar.setEnabled(false);
        TXT_Data.setEnabled(false);       
        TBL_Servicos.setVisible(false);
        habilitarcampos(false);
        //conexao = Conexao.getConnection();
        Formatodata = new SimpleDateFormat("dd/MM/yyyy");
       
        
        
        ServicosB = new ServicosBeans();
        ServicosC = new ServicosController();

        Modelo2 = (DefaultTableModel)TBL_Servicos.getModel();
        conexao = Conexao.getConnection();                 
    }   
    
    private void pesquisar_servico(){
        String SQLInsertion = "select CodServicos as ID, Data_Servico as DataServico, Genero as Genero, Situacao as Situacao, Aparelho as Aparelho, Serial as Serial, Informacao as Informacao, Servico as Servico, Tecnico as Tecnico, Garantia as Garantia, Valor as Valor, CodCliente as IDCLIENTE from servicos where Serial like ?";
        try {
           
            PreparedStatement pst = Conexao.getConnection().prepareStatement(SQLInsertion);
            pst.setString(1, TXT_PesqServ.getText() + "%");
            rs = pst.executeQuery();
            TBL_Servicos.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }    
    
    private void setar_camposServicos(){
        Modelo2.removeRow(TBL_Servicos.getSelectedRow());
        int setar = TBL_Servicos.getSelectedRow();
        TXT_CodServico.setText(TBL_Servicos.getModel().getValueAt(setar, 0).toString());
        TXT_Data.setText(Corretores.ConverterParaJava(TBL_Servicos.getModel().getValueAt(setar, 1).toString()));  
        String rbTipo = (TBL_Servicos.getModel().getValueAt(setar, 2).toString());  
           if(rbTipo.equals("Orçamento")){
               RBOrca.setSelected(true);
           }else{
               RBOS.setSelected(true);
           }        
        CB_Situacao.setSelectedItem(TBL_Servicos.getModel().getValueAt(setar, 3).toString());  
        TXT_Aparelho.setText(TBL_Servicos.getModel().getValueAt(setar, 4).toString());  
        TXT_Serial.setText(TBL_Servicos.getModel().getValueAt(setar, 5).toString());  
        TXT_Informacao.setText(TBL_Servicos.getModel().getValueAt(setar, 6).toString());  
        TXT_Servico.setText(TBL_Servicos.getModel().getValueAt(setar, 7).toString());  
        CB_Tecnico.setSelectedItem(TBL_Servicos.getModel().getValueAt(setar, 8).toString());  
        CB_Garantia.setSelectedItem(TBL_Servicos.getModel().getValueAt(setar, 9).toString());  
        TXT_Valor.setText(String.valueOf((Double)TBL_Servicos.getModel().getValueAt(setar, 10)));          
        TXT_CodCliente.setText(TBL_Servicos.getModel().getValueAt(setar, 11).toString());  
        BTN_Imprimir.setEnabled(true);
        BTN_Editar.setVisible(true);
        BTN_Voltar.setEnabled(true);
    }
    
    private void imprimir(){
        int confirma = JOptionPane.showConfirmDialog(null, "Confirma a visualização da Impressão?", "Atenção", JOptionPane.YES_NO_OPTION);
        if(confirma ==  JOptionPane.YES_OPTION){
            Map p = new HashMap();            
            p.put("Cod_Serial", TXT_Serial.getText().toString());   
            //p.put("Imagem", ClassLoader.getSystemResourceAsStream("/Icones/Painel.jpg"));            
            JasperReport relatorio;
            JasperPrint impressao;           
        try {
            if(!TXT_Serial.getText().equals("")){               
            relatorio = JasperCompileManager.compileReport(new File("").getAbsolutePath()+"/Relatorios/Saida.jrxml");
            impressao = JasperFillManager.fillReport(relatorio, p, conexao);
            JasperViewer view  = new JasperViewer(impressao, false);
            view.setTitle("Saída de Equipamento");
            view.setVisible(true);
            }else{
                JOptionPane.showMessageDialog(null, "Tenha um Serial de Equipamento para Impressão", "Atenção", 0);
            }
        } catch (JRException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }   
    }     

      
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ButtonGroup = new javax.swing.ButtonGroup();
        PainelGeral = new javax.swing.JPanel();
        PN_OS = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        TXT_CodServico = new javax.swing.JTextField();
        TXT_Data = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        TXT_CodCliente = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        CB_Situacao = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        CB_Tecnico = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        CB_Garantia = new javax.swing.JComboBox<>();
        RBOrca = new javax.swing.JRadioButton();
        RBOS = new javax.swing.JRadioButton();
        jLabel5 = new javax.swing.JLabel();
        TXT_Aparelho = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        TXT_Serial = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        TXT_Informacao = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        TXT_Valor = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        TXT_Servico = new javax.swing.JTextField();
        BTN_Voltar = new javax.swing.JButton();
        BTN_Imprimir = new javax.swing.JButton();
        BTN_Editar = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jScrollPane2 = new javax.swing.JScrollPane();
        TBL_Servicos = new javax.swing.JTable();
        TXT_PesqServ = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setClosable(true);
        setForeground(java.awt.Color.white);
        setTitle("Pesquisar / Editar Serviços");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setPreferredSize(new java.awt.Dimension(960, 630));
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

        PainelGeral.setBackground(new java.awt.Color(255, 255, 255));

        PN_OS.setBackground(new java.awt.Color(255, 255, 255));
        PN_OS.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel1.setText("Código Serviço");

        jLabel2.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel2.setText("Data");

        TXT_CodServico.setEditable(false);
        TXT_CodServico.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        TXT_CodServico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TXT_CodServicoActionPerformed(evt);
            }
        });

        TXT_Data.setEditable(false);
        TXT_Data.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel4.setText("Código Cliente");

        TXT_CodCliente.setEditable(false);
        TXT_CodCliente.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel3.setText("Situação");

        CB_Situacao.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        CB_Situacao.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Na Bancada", "Entrega Feita", "Orçamento Reprovado", "Aguardando Aprovação", "Aguardando Peças", "Abandonado pelo Cliente", "Retorno" }));
        CB_Situacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CB_SituacaoActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel7.setText("Técnico");

        CB_Tecnico.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        CB_Tecnico.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Neuller César", "Mario Jackson" }));

        jLabel9.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel9.setText("Garantia");

        CB_Garantia.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        CB_Garantia.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Funcional", "30 Dias", "90 Dias", "180 Dias", "360 Dias", "Orçamento" }));

        ButtonGroup.add(RBOrca);
        RBOrca.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        RBOrca.setText("Orçamento");
        RBOrca.setOpaque(false);
        RBOrca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RBOrcaActionPerformed(evt);
            }
        });

        ButtonGroup.add(RBOS);
        RBOS.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        RBOS.setText("Ordem de Serviço");
        RBOS.setOpaque(false);
        RBOS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RBOSActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel5.setText("Aparelho/Modelo");

        TXT_Aparelho.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        TXT_Aparelho.setOpaque(false);

        jLabel10.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel10.setText("Serial");

        TXT_Serial.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        TXT_Serial.setOpaque(false);
        TXT_Serial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TXT_SerialActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel6.setText("Informação");

        TXT_Informacao.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        TXT_Informacao.setText("\n\n\n\n\n\n\n");
        TXT_Informacao.setOpaque(false);
        TXT_Informacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TXT_InformacaoActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel8.setText("Valor");

        TXT_Valor.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        TXT_Valor.setOpaque(false);
        TXT_Valor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TXT_ValorActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel11.setText("Serviço");

        TXT_Servico.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        javax.swing.GroupLayout PN_OSLayout = new javax.swing.GroupLayout(PN_OS);
        PN_OS.setLayout(PN_OSLayout);
        PN_OSLayout.setHorizontalGroup(
            PN_OSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PN_OSLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PN_OSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PN_OSLayout.createSequentialGroup()
                        .addGroup(PN_OSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(PN_OSLayout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(TXT_CodServico, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(PN_OSLayout.createSequentialGroup()
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(TXT_CodCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(PN_OSLayout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(20, 20, 20)
                                .addComponent(TXT_Data, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(PN_OSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PN_OSLayout.createSequentialGroup()
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(CB_Tecnico, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PN_OSLayout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(CB_Situacao, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PN_OSLayout.createSequentialGroup()
                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(CB_Garantia, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 75, Short.MAX_VALUE)
                        .addComponent(RBOrca)
                        .addGap(18, 18, 18)
                        .addComponent(RBOS)
                        .addGap(88, 88, 88))
                    .addGroup(PN_OSLayout.createSequentialGroup()
                        .addGroup(PN_OSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(PN_OSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(TXT_Aparelho)
                            .addComponent(TXT_Serial))
                        .addContainerGap())
                    .addGroup(PN_OSLayout.createSequentialGroup()
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(TXT_Informacao)
                        .addGap(10, 10, 10))
                    .addGroup(PN_OSLayout.createSequentialGroup()
                        .addGroup(PN_OSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(PN_OSLayout.createSequentialGroup()
                                .addGap(110, 110, 110)
                                .addComponent(TXT_Valor, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(PN_OSLayout.createSequentialGroup()
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(TXT_Servico)
                        .addContainerGap())))
        );
        PN_OSLayout.setVerticalGroup(
            PN_OSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PN_OSLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PN_OSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PN_OSLayout.createSequentialGroup()
                        .addGroup(PN_OSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(CB_Situacao, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(RBOrca, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(RBOS, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TXT_CodServico, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(PN_OSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(CB_Tecnico, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(PN_OSLayout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(PN_OSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TXT_CodCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(PN_OSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TXT_Data, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(CB_Garantia, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(PN_OSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TXT_Aparelho, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PN_OSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TXT_Serial, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PN_OSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(TXT_Informacao, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PN_OSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TXT_Servico, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PN_OSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TXT_Valor, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        BTN_Voltar.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        BTN_Voltar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/Voltar.png"))); // NOI18N
        BTN_Voltar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BTN_Voltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_VoltarActionPerformed(evt);
            }
        });

        BTN_Imprimir.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        BTN_Imprimir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/Print.png"))); // NOI18N
        BTN_Imprimir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BTN_Imprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_ImprimirActionPerformed(evt);
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

        jSeparator1.setBackground(new java.awt.Color(7, 143, 201));
        jSeparator1.setForeground(new java.awt.Color(7, 143, 201));
        jSeparator1.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        TBL_Servicos.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        TBL_Servicos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "DataServico", "Genero", "Situacao", "Aparelho", "Serial", "Informacao", "Servico", "Tecnico", "Garantia", "Valor", "IDCLIENTE"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TBL_Servicos.setGridColor(new java.awt.Color(255, 255, 255));
        TBL_Servicos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TBL_ServicosMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(TBL_Servicos);

        TXT_PesqServ.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        TXT_PesqServ.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TXT_PesqServActionPerformed(evt);
            }
        });
        TXT_PesqServ.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                TXT_PesqServKeyReleased(evt);
            }
        });

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/Lupa.png"))); // NOI18N
        jLabel12.setText("Serial");
        jLabel12.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);

        javax.swing.GroupLayout PainelGeralLayout = new javax.swing.GroupLayout(PainelGeral);
        PainelGeral.setLayout(PainelGeralLayout);
        PainelGeralLayout.setHorizontalGroup(
            PainelGeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addGroup(PainelGeralLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PainelGeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PainelGeralLayout.createSequentialGroup()
                        .addComponent(TXT_PesqServ, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 674, Short.MAX_VALUE))
                    .addComponent(PN_OS, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane2)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PainelGeralLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(BTN_Editar, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BTN_Imprimir, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BTN_Voltar, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        PainelGeralLayout.setVerticalGroup(
            PainelGeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PainelGeralLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PainelGeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TXT_PesqServ, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PN_OS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(PainelGeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(BTN_Editar, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BTN_Imprimir, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BTN_Voltar, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
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

        setBounds(0, 0, 960, 601);
    }// </editor-fold>//GEN-END:initComponents

    private void formInternalFrameOpened(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameOpened
        RBOS.setSelected(true);
        Tipo = "Ordem de Serviço";
    }//GEN-LAST:event_formInternalFrameOpened

    private void CB_SituacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CB_SituacaoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CB_SituacaoActionPerformed

    private void BTN_VoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_VoltarActionPerformed
        BTN_Voltar.setEnabled(false); 
        BTN_Imprimir.setEnabled(false);
        limparCampos();
        ((DefaultTableModel) TBL_Servicos.getModel()).setRowCount(0);
        habilitarcampos(false);
        TXT_CodCliente.setEnabled(false);        
        BTN_Editar.setVisible(false);                             
    }//GEN-LAST:event_BTN_VoltarActionPerformed

    private void TXT_CodServicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TXT_CodServicoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TXT_CodServicoActionPerformed

    private void TXT_SerialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TXT_SerialActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TXT_SerialActionPerformed

    private void BTN_EditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_EditarActionPerformed
        popularOSBeansEditar();
        ServicosC.verificardadosEditar(ServicosB);
        BTN_Editar.setVisible(false);
        //((DefaultTableModel) TBL_Servicos.getModel()).setRowCount(0);
        //limparCampos();
    }//GEN-LAST:event_BTN_EditarActionPerformed

    private void BTN_ImprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_ImprimirActionPerformed
        imprimir();                                       
    }//GEN-LAST:event_BTN_ImprimirActionPerformed

    private void TXT_ValorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TXT_ValorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TXT_ValorActionPerformed

    private void TXT_PesqServKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TXT_PesqServKeyReleased
        pesquisar_servico();
        TBL_Servicos.setVisible(true);
    }//GEN-LAST:event_TXT_PesqServKeyReleased

    private void TBL_ServicosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TBL_ServicosMouseClicked
        TXT_PesqServ.setText("");
        setar_camposServicos();
        BTN_Editar.setEnabled(true);
        TXT_CodCliente.setEnabled(true);
        TXT_Aparelho.setEnabled(true);
        TXT_CodServico.setEnabled(true);  
        TXT_Serial.setEnabled(true);
        TXT_Informacao.setEnabled(true); 
        TXT_Servico.setEnabled(true);
        TXT_Valor.setEnabled(true);  
        TXT_Data.setEnabled(true); 
    }//GEN-LAST:event_TBL_ServicosMouseClicked

    private void RBOrcaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RBOrcaActionPerformed
        Tipo = "Orçamento";
    }//GEN-LAST:event_RBOrcaActionPerformed

    private void RBOSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RBOSActionPerformed
        Tipo = "Ordem de Serviço";
    }//GEN-LAST:event_RBOSActionPerformed

    private void TXT_PesqServActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TXT_PesqServActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TXT_PesqServActionPerformed

    private void TXT_InformacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TXT_InformacaoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TXT_InformacaoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BTN_Editar;
    private javax.swing.JButton BTN_Imprimir;
    private javax.swing.JButton BTN_Voltar;
    private javax.swing.ButtonGroup ButtonGroup;
    private javax.swing.JComboBox<String> CB_Garantia;
    private javax.swing.JComboBox<String> CB_Situacao;
    private javax.swing.JComboBox<String> CB_Tecnico;
    private javax.swing.JPanel PN_OS;
    private javax.swing.JPanel PainelGeral;
    private javax.swing.JRadioButton RBOS;
    private javax.swing.JRadioButton RBOrca;
    private javax.swing.JTable TBL_Servicos;
    private javax.swing.JTextField TXT_Aparelho;
    private javax.swing.JTextField TXT_CodCliente;
    private javax.swing.JTextField TXT_CodServico;
    private javax.swing.JTextField TXT_Data;
    private javax.swing.JTextField TXT_Informacao;
    private javax.swing.JTextField TXT_PesqServ;
    private javax.swing.JTextField TXT_Serial;
    private javax.swing.JTextField TXT_Servico;
    private javax.swing.JTextField TXT_Valor;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    // End of variables declaration//GEN-END:variables

    final void habilitarcampos(boolean valor){
        TXT_CodCliente.setEnabled(valor);
        TXT_Aparelho.setEnabled(valor);
        TXT_Valor.setEnabled(valor);
        TXT_Informacao.setEnabled(valor);    
        TXT_CodServico.setEnabled(valor); 
        TXT_Serial.setEnabled(valor);
        TXT_Data.setEnabled(valor);
        TXT_Servico.setEnabled(valor);
}   
    
    final void limparCampos(){
        TXT_CodCliente.setText("");
        TXT_Aparelho.setText("");
        TXT_Valor.setText("");
        TXT_Informacao.setText("");   
        TXT_Serial.setText("");
        TXT_CodServico.setText("");
        TXT_Data.setText("");
        TXT_PesqServ.setText("");
    }
    
    final void popularOSBeansEditar(){
        
    ServicosB.setCodServicos(Integer.parseInt(TXT_CodServico.getText()));  
    ServicosB.setGenero(Tipo.toString());    
    ServicosB.setSituacao(CB_Situacao.getSelectedItem().toString());
    ServicosB.setAparelho(TXT_Aparelho.getText().toUpperCase());
    ServicosB.setSerial(TXT_Serial.getText().toUpperCase());
    ServicosB.setInformacao(TXT_Informacao.getText().toUpperCase());
    ServicosB.setServico(TXT_Servico.getText());
    ServicosB.setTecnico(CB_Tecnico.getSelectedItem().toString());
    ServicosB.setGarantia(CB_Garantia.getSelectedItem().toString());
    ServicosB.setValor(Double.parseDouble(TXT_Valor.getText().replace(",",".")));
    
    }
        
}
