package DAO;

import Beans.EstoqueBeans;
import Utilitarios.Conexao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;



public class EstoqueDAO {
    
    
    public EstoqueDAO(){             
        
    }
    
    
    
    public void buscarProduto(String Pesquisa, DefaultTableModel Modelo){     
        try {
            String SQLSelection = "select * from estoque where CodEstoque like '%" + Pesquisa + "%'" ;  
            PreparedStatement st = Conexao.getConnection().prepareStatement(SQLSelection);
            ResultSet rs = st.executeQuery();
            while(rs.next()){
                Modelo.addRow(new Object[] {rs.getString("CodEstoque"), rs.getString("Est_Nome"), rs.getString("Est_Quantidade"), rs.getString("Est_Valor"), rs.getString("Est_NF"), rs.getString("Est_NCM")});      
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Buscar Produto", "", 0, new ImageIcon(getClass().getResource("/Icones/btn_sair.png")));
        }
        
    }
    
    public EstoqueBeans preencherCampos(int Codigo){
        EstoqueBeans Estoque = new EstoqueBeans();
        try {
            String SQLSelection = "select * from estoque where CodEstoque = ?" ;  
            PreparedStatement st = Conexao.getConnection().prepareStatement(SQLSelection);
            st.setInt(1, Codigo);
            ResultSet rs = st.executeQuery();
            if(rs.next()){
               Estoque.setCodigo(rs.getInt("CodEstoque"));
               Estoque.setNome(rs.getString("Est_Nome"));
               Estoque.setQuantidade(rs.getInt("Est_Quantidade"));
               Estoque.setValor(rs.getDouble("Est_Valor"));
               Estoque.setNF(rs.getInt("Est_NF"));
               Estoque.setNCM(rs.getInt("Est_NCM"));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Buscar Produto", "", 0, new ImageIcon(getClass().getResource("/Icones/btn_sair.png")));
        }
        
        return Estoque;
    }
     
}
