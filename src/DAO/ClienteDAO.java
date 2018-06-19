package DAO;

import Beans.ClienteBeans;
import Utilitarios.Conexao;
import Utilitarios.Corretores;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class ClienteDAO {
    
    public ClienteDAO(){
        
    }
    
    public void CadastrarCliente(ClienteBeans Cliente){
        try {
            String SQLInsertion = "insert into clientes(Cli_Nome, Cli_Rua, Cli_Bairro, Cli_Telefone, Cli_DataCadastro) values (?, ?, ?, ?, ?)";
            PreparedStatement st = Conexao.getConnection().prepareStatement(SQLInsertion);
            st.setString(1, Cliente.getNome());
            st.setString(2, Cliente.getRua());
            st.setString(3, Cliente.getBairro());
            st.setString(4, Cliente.getTelefone());
            st.setString(5, Corretores.ConverterParaSQL(Cliente.getDataCad()));
            
            st.execute();
            Conexao.getConnection().commit();
            JOptionPane.showMessageDialog(null, "Cadastro Realizado com Sucesso", "", 1, new ImageIcon("Imagens/ok.png"));
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex, "", 0, new ImageIcon("Imagens/btn_sair.png"));
           //JOptionPane.showMessageDialog(null, "Erro ao Cadastrar Registro", "Erro", 0, new ImageIcon("Imagens/btn_sair.png"));
            
        }
    }
    
}
