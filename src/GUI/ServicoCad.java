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
import javax.swing.ImageIcon;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;


public class ServicoCad extends javax.swing.JInternalFrame {
    
    ResultSet rs = null;
    SimpleDateFormat Formatodata;
    Date DataAtual;
    ServicosBeans ServicosB;
    ServicosController ServicosC;
    DefaultTableModel Modelo;
    DefaultTableModel Modelo2; 
    Connection conexao = null;
    
   private String Tipo;   
   private static ServicoCad ostela;   
   
   public static ServicoCad getInstancia(){
       if(ostela == null){
           ostela = new ServicoCad();          
       }
       return ostela;
   }     

    public ServicoCad() {
        initComponents();     
        BTN_Voltar.setEnabled(false);
        BTN_Cadastrar.setEnabled(false);
        TXT_Data.setEnabled(false);       
        TBL_Clientes.setVisible(false);
        habilitarcampos(false);
        //conexao = Conexao.getConnection();
        Formatodata = new SimpleDateFormat("dd/MM/yyyy");
       
        
        
        ServicosB = new ServicosBeans();
        ServicosC = new ServicosController();
        conexao = Conexao.getConnection();
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
    
    private void imprimir(){
         int confirma = JOptionPane.showConfirmDialog(null, "Confirma a visualização da Impressão?", "Atenção", JOptionPane.YES_NO_OPTION);
        if(confirma ==  JOptionPane.YES_OPTION){
            Map p = new HashMap();
            p.put("Cod_Serial", TXT_Serial.getText().toString());
            JasperReport relatorio;
            JasperPrint impressao;           
        try {
            if(!TXT_Serial.getText().equals("")){ 
            relatorio = JasperCompileManager.compileReport(new File("").getAbsolutePath()+"/Relatorios/Imp_Servicos.jrxml");
            impressao = JasperFillManager.fillReport(relatorio, p, conexao);
            JasperViewer view  = new JasperViewer(impressao, false);
            view.setTitle("Ordem de Serviço/Orçamento");
            view.setVisible(true);
            }else{
                JOptionPane.showMessageDialog(null, "Tenha um Serial de Equipamento para Impressão", "Atenção", 0);
            }
        } catch (JRException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }   
    }     
    
        private boolean verificardados(ServicosBeans OS){
        
        if(OS.getAparelho().equals("")){
           JOptionPane.showMessageDialog(null, "Preencha o campo Aparelho", "", 0, new ImageIcon(getClass().getResource("/Icones/btn_sair.png")));
        return false;
        } 
             
        if(OS.getSerial().equals("")){
           JOptionPane.showMessageDialog(null, "Preencha o campo Serial", "", 0, new ImageIcon(getClass().getResource("/Icones/btn_sair.png")));
        return false;
        }
        
        CadastrarOS(OS);
        
        return true;        
    }
        
        private void CadastrarOS(ServicosBeans OS){
        try {
            String SQLInsertion = "insert into servicos(Data_Servico, Genero, Situacao, Aparelho, Serial, Informacao, Servico, Tecnico, Garantia, Valor, CodCliente) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement st = Conexao.getConnection().prepareStatement(SQLInsertion);
            st.setString(1, Corretores.ConverterParaSQL(OS.getData_Servico()));
            st.setString(2, OS.getGenero());
            st.setString(3, OS.getSituacao());
            st.setString(4, OS.getAparelho());
            st.setString(5, OS.getSerial());
            st.setString(6, OS.getInformacao());
            st.setString(7, OS.getServico());
            st.setString(8, OS.getTecnico());
            st.setString(9, OS.getGarantia());
            st.setDouble(10, OS.getValor());
            st.setInt(11, OS.getCodCliente());                    
            st.execute();
            Conexao.getConnection().commit();
            JOptionPane.showMessageDialog(null, "Cadastro Realizado com Sucesso", "", 1, new ImageIcon(getClass().getResource("/Icones/ok.png")));            
            
            imprimir();
            limparCampos();
            ((DefaultTableModel) TBL_Clientes.getModel()).setRowCount(0);
            BTN_Novo.setEnabled(true);
            BTN_Cadastrar.setEnabled(false);
            BTN_Voltar.setEnabled(false);
            
        } catch (SQLException ex) {
            //JOptionPane.showMessageDialog(null, ex, "", 0, new ImageIcon("Imagens/btn_sair.png"));
           JOptionPane.showMessageDialog(null, "Erro ao Cadastrar", "", 0, new ImageIcon(getClass().getResource("/Icones/btn_sair.png")));
            
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
        jLabel10 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        CB_Garantia = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        CB_Tecnico = new javax.swing.JComboBox<>();
        TXT_Serial = new javax.swing.JTextField();
        BTN_Novo = new javax.swing.JButton();
        BTN_Voltar = new javax.swing.JButton();
        TXT_Aparelho = new javax.swing.JTextField();
        BTN_Cadastrar = new javax.swing.JButton();
        CB_Situacao = new javax.swing.JComboBox<>();
        TXT_Informacao = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        PN_Clientes = new javax.swing.JPanel();
        TXT_Clientes = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        TXT_CodCliente = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        TBL_Clientes = new javax.swing.JTable();
        jLabel14 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        TXT_Valor = new javax.swing.JTextField();
        RBOrca = new javax.swing.JRadioButton();
        RBOS = new javax.swing.JRadioButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setClosable(true);
        setForeground(java.awt.Color.white);
        setTitle("Cadastro de Serviços");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setPreferredSize(new java.awt.Dimension(960, 470));
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
        PainelGeral.setPreferredSize(new java.awt.Dimension(944, 420));

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
                .addContainerGap(20, Short.MAX_VALUE))
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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel10.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel10.setText("Serial");

        jLabel7.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel7.setText("Técnico");

        CB_Garantia.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        CB_Garantia.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Funcional", "30 Dias", "90 Dias", "180 Dias", "360 Dias", "Orçamento" }));

        jLabel3.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel3.setText("Situação");

        jLabel5.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel5.setText("Aparelho/Modelo");

        CB_Tecnico.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        CB_Tecnico.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Neuller César", "Mario Jackson" }));

        TXT_Serial.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        TXT_Serial.setOpaque(false);
        TXT_Serial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TXT_SerialActionPerformed(evt);
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

        BTN_Voltar.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        BTN_Voltar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/Voltar.png"))); // NOI18N
        BTN_Voltar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BTN_Voltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_VoltarActionPerformed(evt);
            }
        });

        TXT_Aparelho.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        TXT_Aparelho.setOpaque(false);

        BTN_Cadastrar.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        BTN_Cadastrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/Valid.png"))); // NOI18N
        BTN_Cadastrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BTN_Cadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_CadastrarActionPerformed(evt);
            }
        });

        CB_Situacao.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        CB_Situacao.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Na Bancada", "Entrega Feita", "Orçamento Reprovado", "Aguardando Aprovação", "Aguardando Peças", "Abandonado pelo Cliente", "Retorno" }));
        CB_Situacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CB_SituacaoActionPerformed(evt);
            }
        });

        TXT_Informacao.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        TXT_Informacao.setOpaque(false);

        jLabel9.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel9.setText("Garantia");

        PN_Clientes.setBackground(new java.awt.Color(255, 255, 255));
        PN_Clientes.setBorder(javax.swing.BorderFactory.createTitledBorder("Clientes"));

        TXT_Clientes.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        TXT_Clientes.setOpaque(false);
        TXT_Clientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TXT_ClientesActionPerformed(evt);
            }
        });
        TXT_Clientes.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                TXT_ClientesKeyReleased(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel4.setText("Código Cliente");

        TXT_CodCliente.setEditable(false);
        TXT_CodCliente.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        TBL_Clientes.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
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
        TBL_Clientes.setGridColor(new java.awt.Color(255, 255, 255));
        TBL_Clientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TBL_ClientesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TBL_Clientes);

        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/Lupa.png"))); // NOI18N
        jLabel14.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);

        javax.swing.GroupLayout PN_ClientesLayout = new javax.swing.GroupLayout(PN_Clientes);
        PN_Clientes.setLayout(PN_ClientesLayout);
        PN_ClientesLayout.setHorizontalGroup(
            PN_ClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PN_ClientesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PN_ClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 535, Short.MAX_VALUE)
                    .addGroup(PN_ClientesLayout.createSequentialGroup()
                        .addComponent(TXT_Clientes, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel14)
                        .addGap(78, 78, 78)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TXT_CodCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(6, 6, 6))
        );
        PN_ClientesLayout.setVerticalGroup(
            PN_ClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PN_ClientesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PN_ClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(PN_ClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(TXT_Clientes, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel4)
                        .addComponent(TXT_CodCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(12, Short.MAX_VALUE))
        );

        jLabel6.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel6.setText("Informação");

        jLabel8.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel8.setText("Valor");

        TXT_Valor.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        TXT_Valor.setOpaque(false);
        TXT_Valor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TXT_ValorActionPerformed(evt);
            }
        });

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

        javax.swing.GroupLayout PainelGeralLayout = new javax.swing.GroupLayout(PainelGeral);
        PainelGeral.setLayout(PainelGeralLayout);
        PainelGeralLayout.setHorizontalGroup(
            PainelGeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PainelGeralLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PainelGeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PainelGeralLayout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(TXT_Aparelho)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(TXT_Serial, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PainelGeralLayout.createSequentialGroup()
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(TXT_Informacao))
                    .addGroup(PainelGeralLayout.createSequentialGroup()
                        .addGroup(PainelGeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(PainelGeralLayout.createSequentialGroup()
                                .addGap(110, 110, 110)
                                .addComponent(TXT_Valor, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(PainelGeralLayout.createSequentialGroup()
                        .addGroup(PainelGeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PainelGeralLayout.createSequentialGroup()
                                .addGap(44, 44, 44)
                                .addComponent(RBOrca)
                                .addGap(18, 18, 18)
                                .addComponent(RBOS))
                            .addGroup(PainelGeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PainelGeralLayout.createSequentialGroup()
                                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(CB_Tecnico, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PainelGeralLayout.createSequentialGroup()
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(CB_Situacao, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PainelGeralLayout.createSequentialGroup()
                                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(CB_Garantia, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(60, 60, 60)
                        .addComponent(PN_Clientes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PainelGeralLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(BTN_Novo, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BTN_Cadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BTN_Voltar, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(PainelGeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(PainelGeralLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(PN_OS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(605, Short.MAX_VALUE)))
        );
        PainelGeralLayout.setVerticalGroup(
            PainelGeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PainelGeralLayout.createSequentialGroup()
                .addGroup(PainelGeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PainelGeralLayout.createSequentialGroup()
                        .addGap(79, 79, 79)
                        .addGroup(PainelGeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(RBOrca)
                            .addComponent(RBOS))
                        .addGap(18, 18, 18)
                        .addGroup(PainelGeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(CB_Situacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(PainelGeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(CB_Tecnico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(PainelGeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(CB_Garantia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(PainelGeralLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(PN_Clientes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(19, 19, 19)
                .addGroup(PainelGeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PainelGeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(TXT_Serial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel10))
                    .addGroup(PainelGeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel5)
                        .addComponent(TXT_Aparelho, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PainelGeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(TXT_Informacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PainelGeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(TXT_Valor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PainelGeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(BTN_Cadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BTN_Novo, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BTN_Voltar, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(58, Short.MAX_VALUE))
            .addGroup(PainelGeralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(PainelGeralLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(PN_OS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(392, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PainelGeral, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PainelGeral, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        setBounds(0, 0, 960, 460);
    }// </editor-fold>//GEN-END:initComponents

    private void formInternalFrameOpened(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameOpened
        RBOS.setSelected(true);
        Tipo = "Ordem de Serviço";
    }//GEN-LAST:event_formInternalFrameOpened

    private void RBOSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RBOSActionPerformed
        Tipo = "Ordem de Serviço";
    }//GEN-LAST:event_RBOSActionPerformed

    private void RBOrcaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RBOrcaActionPerformed
        Tipo = "Orçamento";
    }//GEN-LAST:event_RBOrcaActionPerformed

    private void TXT_ValorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TXT_ValorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TXT_ValorActionPerformed

    private void TBL_ClientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TBL_ClientesMouseClicked
        setar_campos();
        TXT_Valor.setText("0");
        TXT_CodCliente.setEnabled(true);
        TXT_Aparelho.setEnabled(true);
        TXT_Valor.setEnabled(true);
        TXT_Informacao.setEnabled(true);
        TXT_Serial.setEnabled(true);
        TXT_Clientes.setEnabled(true);
        BTN_Novo.setEnabled(false);
    }//GEN-LAST:event_TBL_ClientesMouseClicked

    private void TXT_ClientesKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TXT_ClientesKeyReleased
        pesquisar_cliente();
        TBL_Clientes.setVisible(true);
    }//GEN-LAST:event_TXT_ClientesKeyReleased

    private void TXT_ClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TXT_ClientesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TXT_ClientesActionPerformed

    private void CB_SituacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CB_SituacaoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CB_SituacaoActionPerformed

    private void BTN_CadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_CadastrarActionPerformed
        popularOSBeans();
        verificardados(ServicosB);
        //limparCampos();
        //((DefaultTableModel) TBL_Clientes.getModel()).setRowCount(0);
        //BTN_Novo.setVisible(true);
        //TXT_CodCliente.setText(ServicosC.controleDeCodigo());
        //DataAtual = new Date();
        //TXT_Data.setText(Formatodata.format(DataAtual));
    }//GEN-LAST:event_BTN_CadastrarActionPerformed

    private void BTN_VoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_VoltarActionPerformed
        BTN_Voltar.setEnabled(false);
        BTN_Cadastrar.setEnabled(false);
        BTN_Novo.setEnabled(true);
        TXT_CodCliente.setEnabled(false);
        ((DefaultTableModel) TBL_Clientes.getModel()).setRowCount(0);
        limparCampos();
        habilitarcampos(false);
    }//GEN-LAST:event_BTN_VoltarActionPerformed

    private void BTN_NovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_NovoActionPerformed
        limparCampos();
        DataAtual = new Date();
        TXT_Data.setText(Formatodata.format(DataAtual));
        BTN_Novo.setEnabled(false);
        BTN_Cadastrar.setEnabled(true);
        BTN_Voltar.setEnabled(true);
        TXT_CodServico.setText(ServicosC.controleDeCodigo());
        TXT_CodServico.setEnabled(true);
        TXT_Clientes.setEnabled(true);
        TXT_CodCliente.setEnabled(false);
        TXT_Data.setEnabled(true);
        TBL_Clientes.setVisible(true);
    }//GEN-LAST:event_BTN_NovoActionPerformed

    private void TXT_SerialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TXT_SerialActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TXT_SerialActionPerformed

    private void TXT_CodServicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TXT_CodServicoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TXT_CodServicoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BTN_Cadastrar;
    private javax.swing.JButton BTN_Novo;
    private javax.swing.JButton BTN_Voltar;
    private javax.swing.ButtonGroup ButtonGroup;
    private javax.swing.JComboBox<String> CB_Garantia;
    private javax.swing.JComboBox<String> CB_Situacao;
    private javax.swing.JComboBox<String> CB_Tecnico;
    private javax.swing.JPanel PN_Clientes;
    private javax.swing.JPanel PN_OS;
    private javax.swing.JPanel PainelGeral;
    private javax.swing.JRadioButton RBOS;
    private javax.swing.JRadioButton RBOrca;
    private javax.swing.JTable TBL_Clientes;
    private javax.swing.JTextField TXT_Aparelho;
    private javax.swing.JTextField TXT_Clientes;
    private javax.swing.JTextField TXT_CodCliente;
    private javax.swing.JTextField TXT_CodServico;
    private javax.swing.JTextField TXT_Data;
    private javax.swing.JTextField TXT_Informacao;
    private javax.swing.JTextField TXT_Serial;
    private javax.swing.JTextField TXT_Valor;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel14;
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
        TXT_Serial.setEnabled(valor);
        TXT_Data.setEnabled(valor);
}   
    
    final void limparCampos(){
        TXT_CodCliente.setText("");
        TXT_Aparelho.setText("");
        TXT_Valor.setText("");
        TXT_Informacao.setText("");   
        TXT_Serial.setText("");
        TXT_CodServico.setText("");
        TXT_Data.setText("");
        TXT_Clientes.setText("");
    }
    
    final void popularOSBeans(){
      
    ServicosB.setData_Servico(TXT_Data.getText());
    ServicosB.setGenero(Tipo.toString());   
    ServicosB.setSituacao(CB_Situacao.getSelectedItem().toString());    
    ServicosB.setAparelho(TXT_Aparelho.getText().toUpperCase());
    ServicosB.setSerial(TXT_Serial.getText().toUpperCase());
    ServicosB.setInformacao(TXT_Informacao.getText().toUpperCase());
    ServicosB.setServico("");
    ServicosB.setTecnico(CB_Tecnico.getSelectedItem().toString());
    ServicosB.setGarantia(CB_Garantia.getSelectedItem().toString());
    ServicosB.setValor(Double.parseDouble(TXT_Valor.getText().replace(",",".")));
    ServicosB.setCodCliente(Integer.parseInt(TXT_CodCliente.getText()));
}
        
}
