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
                Modelo.addRow(new Object[] {rs.getString("CodCliente"), rs.getString("Cli_Nome"), rs.getString("Cli_Telefone"), rs.getString("Cli_Celular"), rs.getString("Cli_Email")});      
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Buscar Cliente", "", 0, new ImageIcon(getClass().getResource("/Icones/btn_sair.png")));
        }
        
    }
    
        public void buscarCliente2(String Pesquisa, DefaultTableModel Modelo){     
        try {
            String SQLSelection = "select * from clientes where CodCliente like '%" + Pesquisa + "%'" ;  
            PreparedStatement st = Conexao.getConnection().prepareStatement(SQLSelection);
            ResultSet rs = st.executeQuery();
            while(rs.next()){
                Modelo.addRow(new Object[] {rs.getString("CodCliente"), rs.getString("Cli_Nome"), rs.getString("Cli_Telefone"), rs.getString("Cli_Celular"), rs.getString("Cli_Email")});      
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
               Cliente.setEmail(rs.getString("Cli_Email"));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Buscar Cliente", "", 0, new ImageIcon(getClass().getResource("/Icones/btn_sair.png")));
        }
        
        return Cliente;
    }
     
}
