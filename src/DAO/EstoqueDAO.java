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
    
    public void CadastrarProduto(EstoqueBeans Estoque){
        try {
            String SQLInsertion = "insert into estoque(Est_Nome, Est_Quantidade, Est_Valor, Est_NF, Est_NCM) values (?, ?, ?, ?, ?)";
            PreparedStatement st = Conexao.getConnection().prepareStatement(SQLInsertion);
            st.setString(1, Estoque.getNome());
            st.setInt(2, Estoque.getQuantidade());
            st.setFloat(3, Estoque.getValor());
            st.setInt(4, Estoque.getNF());
            st.setInt(5, Estoque.getNCM());
            
            st.execute();
            Conexao.getConnection().commit();
            JOptionPane.showMessageDialog(null, "Cadastro Realizado com Sucesso", "", 1, new ImageIcon("Imagens/ok.png"));
            
        } catch (SQLException ex) {
            //JOptionPane.showMessageDialog(null, ex, "", 0, new ImageIcon("Imagens/btn_sair.png"));
           JOptionPane.showMessageDialog(null, "Erro ao Cadastrar Registro", "", 0, new ImageIcon("Imagens/btn_sair.png"));
            
        }
               
    }
    
    public String proximoProduto(){
            String SQLSelection = "select * from estoque order by CodEstoque desc limit 1";
        try {
            PreparedStatement st = Conexao.getConnection().prepareStatement(SQLSelection);
            ResultSet rs = st.executeQuery();
            if(rs.next()){
                return (Integer.parseInt(rs.getString("CodEstoque")) + 1) + "";
            }else{
                return "1";
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Buscar Registro", "", 0, new ImageIcon("Imagens/btn_sair.png"));
            return "0";
        }
        
    }     
    
    public void buscarProduto(String Pesquisa, DefaultTableModel Modelo){     
        try {
            String SQLSelection = "select * from estoque where Est_Nome like '%" + Pesquisa + "%'" ;  
            PreparedStatement st = Conexao.getConnection().prepareStatement(SQLSelection);
            ResultSet rs = st.executeQuery();
            while(rs.next()){
                Modelo.addRow(new Object[] {rs.getString("CodEstoque"), rs.getString("Est_Nome"), rs.getString("Est_Quantidade"), rs.getString("Est_Valor"), rs.getString("Est_NF"), rs.getString("Est_NCM")});      
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Buscar Produto", "", 0, new ImageIcon("Imagens/btn_sair.png"));
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
               Estoque.setValor(rs.getFloat("Est_Valor"));
               Estoque.setNF(rs.getInt("Est_NF"));
               Estoque.setNCM(rs.getInt("Est_NCM"));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Buscar Produto", "", 0, new ImageIcon("Imagens/btn_sair.png"));
        }
        
        return Estoque;
    }
  
    public void editarProduto(EstoqueBeans Estoque){
        try {
            String SQLInsertion = "update estoque set Est_Nome = ?, Est_Quantidade = ?, Est_Valor = ?, Est_NF = ?, Est_NCM = ? where CodEstoque = ?";
            PreparedStatement st = Conexao.getConnection().prepareStatement(SQLInsertion);
            st.setString(1, Estoque.getNome());
            st.setInt(2, Estoque.getQuantidade());
            st.setFloat(3, Estoque.getValor());
            st.setInt(4, Estoque.getNF());
            st.setInt(5, Estoque.getNCM());
            st.setInt(6, Estoque.getCodigo());
            st.execute();
            Conexao.getConnection().commit();
            JOptionPane.showMessageDialog(null, "Registro editado com sucesso", "", 1, new ImageIcon("Imagens/ok.png"));
            
        } catch (SQLException ex) {
            //JOptionPane.showMessageDialog(null, ex, "", 0, new ImageIcon("Imagens/btn_sair.png"));
           JOptionPane.showMessageDialog(null, "Erro ao editar registro", "", 0, new ImageIcon("Imagens/btn_sair.png"));
            
        }
        
    }
}
