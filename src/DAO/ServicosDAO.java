package DAO;

import Beans.ServicosBeans;
import Utilitarios.Conexao;
import Utilitarios.Corretores;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;


public class ServicosDAO {
    
    public ServicosDAO(){
        
    }
    
    public void CadastrarOS(ServicosBeans OS){
        try {
            String SQLInsertion = "insert into servicos(Data_Servicos, Tipo, Situacao, Aparelho, Informacao, Tecnico, Garantia, Valor, Cli_Servicos) values (?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement st = Conexao.getConnection().prepareStatement(SQLInsertion);
            st.setString(1, Corretores.ConverterParaSQL(OS.getData_Servicos()));
            st.setString(2, OS.getTipo());
            st.setString(3, OS.getSituacao());
            st.setString(4, OS.getAparelho());
            st.setString(5, OS.getInformacao());
            st.setString(6, OS.getTecnico());
            st.setString(7, OS.getGarantia());
            st.setDouble(8, OS.getValor());
            st.setInt(9, OS.getCli_Servicos());                    
            st.execute();
            Conexao.getConnection().commit();
            JOptionPane.showMessageDialog(null, "Cadastro Realizado com Sucesso", "", 1, new ImageIcon(getClass().getResource("/Icones/ok.png")));
            
        } catch (SQLException ex) {
            //JOptionPane.showMessageDialog(null, ex, "", 0, new ImageIcon("Imagens/btn_sair.png"));
           JOptionPane.showMessageDialog(null, "Erro ao Cadastrar", "", 0, new ImageIcon(getClass().getResource("/Icones/btn_sair.png")));
            
        }
               
    }
    
    public String proximaOS(){
            String SQLSelection = "select * from servicos order by CodServicos desc limit 1";
        try {
            PreparedStatement st = Conexao.getConnection().prepareStatement(SQLSelection);
            ResultSet rs = st.executeQuery();
            if(rs.next()){
                return (Integer.parseInt(rs.getString("CodServicos")) + 1) + "";
            }else{
                return "1";
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Buscar OS");
            return "0";
        }       
        
    }  
    
    public ServicosBeans preencherCampos(int Codigo){
        ServicosBeans Servicos = new ServicosBeans();
        try {
            String SQLSelection = "select * from servicos where CodServicos = ?" ;  
            PreparedStatement st = Conexao.getConnection().prepareStatement(SQLSelection);
            st.setInt(1, Codigo);
            ResultSet rs = st.executeQuery();
            if(rs.next()){
               Servicos.setCodServicos(rs.getInt("CodServicos"));
               Servicos.setData_Servicos(Corretores.ConverterParaJava(rs.getString("Data_Servicos")));
               Servicos.setTipo(rs.getString("Tipo"));
               Servicos.setSituacao(rs.getString("Situacao"));
               Servicos.setAparelho(rs.getString("Aparelho"));
               Servicos.setInformacao(rs.getString("Informacao"));
               Servicos.setTecnico(rs.getString("Tecnico"));
               Servicos.setGarantia(rs.getString("Garantia"));
               Servicos.setValor(rs.getDouble("Valor"));              
               Servicos.setCli_Servicos(rs.getInt("Cli_Servicos"));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Buscar Serviço", "", 0, new ImageIcon(getClass().getResource("/Icones/btn_sair.png")));
        }
        
        return Servicos;
    }
  
    public void editarOS(ServicosBeans OS){
        try {
            String SQLInsertion = "update servicos set Data_Servicos = ?, Tipo = ?, Situacao = ?, Aparelho = ?, Informacao = ?, Tecnico = ?, Garantia = ?, Valor = ?, Cli_Servicos = ? where CodServicos = ?";
            PreparedStatement st = Conexao.getConnection().prepareStatement(SQLInsertion);
            st.setString(1, OS.getData_Servicos());
            st.setString(2, OS.getTipo());
            st.setString(3, OS.getSituacao());
            st.setString(4, OS.getAparelho());
            st.setString(5, OS.getInformacao());
            st.setString(6, OS.getTecnico());
            st.setString(7, OS.getGarantia());
            st.setDouble(8, OS.getValor());
            st.setInt(9, OS.getCli_Servicos());
            st.execute();
            Conexao.getConnection().commit();
            JOptionPane.showMessageDialog(null, "Editado com sucesso", "", 1, new ImageIcon(getClass().getResource("/Icones/ok.png")));
            
        } catch (SQLException ex) {
            //JOptionPane.showMessageDialog(null, ex, "", 0, new ImageIcon("Imagens/btn_sair.png"));
           JOptionPane.showMessageDialog(null, "Erro ao editar Serviço", "", 0, new ImageIcon(getClass().getResource("/Icones/btn_sair.png")));
            
        }
        
    }
}
