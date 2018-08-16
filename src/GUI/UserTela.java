package GUI;

import Beans.UserBeans;
import Utilitarios.Conexao;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class UserTela extends javax.swing.JInternalFrame {
    
    UserBeans UserB;

   private static UserTela Usertela;   
   
   public static UserTela getInstancia(){
       if(Usertela == null){
           Usertela = new UserTela();          
       }
       return Usertela;
   }     
   
    public UserTela() {
        initComponents();
        
        UserB = new UserBeans();
        
    }
    
    private boolean verificardados(UserBeans UserB){
        
        if(UserB.getNome_Usuario().equals("")){
           JOptionPane.showMessageDialog(null, "Preencha o campo Login", "", 0, new ImageIcon(getClass().getResource("/Icones/btn_sair.png")));
        return false;
        } 
             
        if(UserB.getSenha_Usuario().equals("")){
           JOptionPane.showMessageDialog(null, "Preencha o campo Senha", "", 0, new ImageIcon(getClass().getResource("/Icones/btn_sair.png")));
        return false;
        }
        
        CadastrarOS(UserB);
        
        return true;        
    }

    private void CadastrarOS(UserBeans UserB){
        try {
            String SQLInsertion = "insert into usuarios(Nome_Usuario, Sexo_Usuario, Tipo_Usuario, Senha_Usuario) values (?, ?, ?, ?)";
            PreparedStatement st = Conexao.getConnection().prepareStatement(SQLInsertion);
            st.setString(1, UserB.getNome_Usuario());
            st.setString(2, UserB.getSexo_Usuario());
            st.setString(3, UserB.getTipo_Usuario());
            st.setString(4, UserB.getSenha_Usuario());                  
            st.execute();
            Conexao.getConnection().commit();
            JOptionPane.showMessageDialog(null, "Cadastro Realizado com Sucesso", "", 1, new ImageIcon(getClass().getResource("/Icones/ok.png")));            

            
        } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null, "Erro ao Cadastrar", "", 0, new ImageIcon(getClass().getResource("/Icones/btn_sair.png")));
            
        }
               
    }  
 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        TXT_Nome = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        CB_Tipo = new javax.swing.JComboBox<>();
        TXT_Senha = new jpass.JRPasswordField();
        Icon = new javax.swing.JLabel();
        BTN_Cadastrar = new javax.swing.JButton();
        CB_Sexo = new javax.swing.JComboBox<>();

        setClosable(true);
        setTitle("Cadastro de Usuários");
        setPreferredSize(new java.awt.Dimension(550, 300));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel1.setText("Login");

        TXT_Nome.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        TXT_Nome.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel2.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel2.setText("Senha");

        CB_Tipo.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        CB_Tipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Administrador", "Padrao" }));

        TXT_Senha.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        TXT_Senha.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        TXT_Senha.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        TXT_Senha.setName("TXT_Senha"); // NOI18N
        TXT_Senha.setPhColor(new java.awt.Color(255, 255, 255));
        TXT_Senha.setPlaceholder("Senha");
        TXT_Senha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TXT_SenhaActionPerformed(evt);
            }
        });

        Icon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/UserPlus.png"))); // NOI18N

        BTN_Cadastrar.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        BTN_Cadastrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icones/Valid.png"))); // NOI18N
        BTN_Cadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_CadastrarActionPerformed(evt);
            }
        });

        CB_Sexo.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        CB_Sexo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Masculino", "Feminino" }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(TXT_Nome, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(CB_Tipo, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(TXT_Senha, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(CB_Sexo, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(BTN_Cadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(57, 57, 57)
                .addComponent(Icon)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TXT_Nome, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TXT_Senha, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(CB_Sexo, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(CB_Tipo, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(BTN_Cadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(Icon)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void TXT_SenhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TXT_SenhaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TXT_SenhaActionPerformed

    private void BTN_CadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_CadastrarActionPerformed
       popularUserBeans();
       verificardados(UserB);
       LimparCampos();
    }//GEN-LAST:event_BTN_CadastrarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BTN_Cadastrar;
    private javax.swing.JComboBox<String> CB_Sexo;
    private javax.swing.JComboBox<String> CB_Tipo;
    private javax.swing.JLabel Icon;
    private javax.swing.JTextField TXT_Nome;
    private jpass.JRPasswordField TXT_Senha;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables

    final void popularUserBeans(){
      
    UserB.setNome_Usuario(TXT_Nome.getText());
    UserB.setSexo_Usuario(CB_Sexo.getSelectedItem().toString());   
    UserB.setTipo_Usuario(CB_Tipo.getSelectedItem().toString());    
    UserB.setSenha_Usuario(TXT_Senha.getText());
}
    final void LimparCampos(){
        TXT_Nome.setText("");
        TXT_Senha.setText("");
    }
        


}
