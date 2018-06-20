package DAO;

import Beans.ClienteBeans;
import Utilitarios.Conexao;
import Utilitarios.Corretores;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


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
            //JOptionPane.showMessageDialog(null, ex, "", 0, new ImageIcon("Imagens/btn_sair.png"));
           JOptionPane.showMessageDialog(null, "Erro ao Cadastrar Registro", "", 0, new ImageIcon("Imagens/btn_sair.png"));
            
        }
               
    }
    
    public String proximoCliente(){
            String SQLSelection = "select * from clientes order by CodCliente desc limit 1";
        try {
            PreparedStatement st = Conexao.getConnection().prepareStatement(SQLSelection);
            ResultSet rs = st.executeQuery();
            if(rs.next()){
                return (Integer.parseInt(rs.getString("CodCliente")) + 1) + "";
            }else{
                return "1";
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Buscar Registro", "", 0, new ImageIcon("Imagens/btn_sair.png"));
            return "0";
        }
        
    }     
    
    public void buscarCliente(String Pesquisa, DefaultTableModel Modelo){     
        try {
            String SQLSelection = "select * from clientes where Cli_Nome like '%" + Pesquisa + "%'" ;  
            PreparedStatement st = Conexao.getConnection().prepareStatement(SQLSelection);
            ResultSet rs = st.executeQuery();
            while(rs.next()){
                Modelo.addRow(new Object[] {rs.getString("CodCliente"), rs.getString("Cli_Nome"), rs.getString("Cli_Rua"), rs.getString("Cli_Bairro"), rs.getString("Cli_Telefone")});      
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Buscar Cliente", "", 0, new ImageIcon("Imagens/btn_sair.png"));
        }
        
    }
    
    public ClienteBeans preencherCampos(int Codigo){
        ClienteBeans Cliente = new ClienteBeans();
        try {
            String SQLSelection = "select * from clientes where CodCliente = ?" ;  
            PreparedStatement st = Conexao.getConnection().prepareStatement(SQLSelection);
            st.setInt(1, Codigo);
            ResultSet rs = st.executeQuery();
            if(rs.next()){
               Cliente.setCodigo(rs.getInt("CodCliente"));
               Cliente.setNome(rs.getString("Cli_Nome"));
               Cliente.setRua(rs.getString("Cli_Rua"));
               Cliente.setBairro(rs.getString("Cli_Bairro"));
               Cliente.setTelefone(rs.getString("Cli_Telefone"));
               Cliente.setDataCad(Corretores.ConverterParaJava(rs.getString("Cli_DataCadastro")));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Buscar Cliente", "", 0, new ImageIcon("Imagens/btn_sair.png"));
        }
        
        return Cliente;
    }
  
}
