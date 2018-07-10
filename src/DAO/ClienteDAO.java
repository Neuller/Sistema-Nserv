package DAO;

import Beans.ClienteBeans;
import Utilitarios.Conexao;
import Utilitarios.Corretores;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class ClienteDAO {
    
    
    public ClienteDAO(){             
        
    }
    
    public void CadastrarCliente(ClienteBeans Cliente){
        try {
            String SQLInsertion = "insert into clientes(Cli_Nome, Cli_Telefone, Cli_DataCadastro, Cli_Celular) values (?, ?, ?, ?)";
            PreparedStatement st = Conexao.getConnection().prepareStatement(SQLInsertion);
            st.setString(1, Cliente.getNome());
            st.setString(2, Cliente.getTelefone());
            st.setString(3, Corretores.ConverterParaSQL(Cliente.getDataCad()));
            st.setString(4, Cliente.getCelular());
            
            st.execute();
            Conexao.getConnection().commit();
            JOptionPane.showMessageDialog(null, "Cadastro Realizado com Sucesso", "", 1, new ImageIcon(getClass().getResource("/Icones/ok.png")));
            
        } catch (SQLException ex) {
            //JOptionPane.showMessageDialog(null, ex, "", 0, new ImageIcon("Imagens/btn_sair.png"));
           JOptionPane.showMessageDialog(null, "Erro ao Cadastrar Cliente", "", 0, new ImageIcon(getClass().getResource("/Icones/btn_sair.png")));
            
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
            JOptionPane.showMessageDialog(null, "Erro ao Buscar Cliente", "", 0, new ImageIcon(getClass().getResource("/Icones/btn_sair.png")));
            return "0";
        }
        
    }     
    
    public void buscarCliente(String Pesquisa, DefaultTableModel Modelo){     
        try {
            String SQLSelection = "select * from clientes where Cli_Nome like '%" + Pesquisa + "%'" ;  
            PreparedStatement st = Conexao.getConnection().prepareStatement(SQLSelection);
            ResultSet rs = st.executeQuery();
            while(rs.next()){
                Modelo.addRow(new Object[] {rs.getString("CodCliente"), rs.getString("Cli_Nome"), rs.getString("Cli_Telefone"), rs.getString("Cli_Celular")});      
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Buscar Cliente", "", 0, new ImageIcon(getClass().getResource("/Icones/btn_sair.png")));
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
               Cliente.setTelefone(rs.getString("Cli_Telefone"));
               Cliente.setDataCad(Corretores.ConverterParaJava(rs.getString("Cli_DataCadastro")));
               Cliente.setCelular(rs.getString("Cli_Celular"));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Buscar Cliente", "", 0, new ImageIcon(getClass().getResource("/Icones/btn_sair.png")));
        }
        
        return Cliente;
    }
  
    public void editarCliente(ClienteBeans Cliente){
        try {
            String SQLInsertion = "update clientes set Cli_Nome = ?, Cli_Telefone = ?, Cli_Celular = ? where CodCliente = ?";
            PreparedStatement st = Conexao.getConnection().prepareStatement(SQLInsertion);
            st.setString(1, Cliente.getNome());
            st.setString(2, Cliente.getTelefone());
            st.setString(3, Cliente.getCelular());
            st.setInt(4, Cliente.getCodigo());
            st.execute();
            Conexao.getConnection().commit();
            JOptionPane.showMessageDialog(null, "Registro editado com sucesso", "", 1, new ImageIcon(getClass().getResource("/Icones/ok.png")));
            
        } catch (SQLException ex) {
            //JOptionPane.showMessageDialog(null, ex, "", 0, new ImageIcon("Imagens/btn_sair.png"));
           JOptionPane.showMessageDialog(null, "Erro ao editar registro", "", 0, new ImageIcon(getClass().getResource("/Icones/btn_sair.png")));
            
        }
        
    }
}
