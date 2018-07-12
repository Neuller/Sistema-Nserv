package DAO;

import Beans.EstoqueBeans;
import Beans.OSBeans;
import Utilitarios.Conexao;
import Utilitarios.Corretores;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;


public class OSDAO {
    
    public OSDAO(){
        
    }
    
    public void CadastrarOS(OSBeans OS){
        try {
            String SQLInsertion = "insert into os(OS, Data_OS, Tipo, Situacao, Aparelho, Informacao, Tecnico, Garantia, Valor, Cli_OS) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement st = Conexao.getConnection().prepareStatement(SQLInsertion);
            st.setInt(1, OS.getOS());
            st.setString(2, Corretores.ConverterParaSQL(OS.getData_OS()));
            st.setString(3, OS.getTipo());
            st.setString(4, OS.getSituacao());
            st.setString(5, OS.getAparelho());
            st.setString(6, OS.getInformacao());
            st.setString(7, OS.getTecnico());
            st.setString(8, OS.getGarantia());
            st.setDouble(9, OS.getValor());
            st.setInt(10, OS.getCli_OS());
            
            
            st.execute();
            Conexao.getConnection().commit();
            JOptionPane.showMessageDialog(null, "Cadastro Realizado com Sucesso", "", 1, new ImageIcon(getClass().getResource("/Icones/ok.png")));
            
        } catch (SQLException ex) {
            //JOptionPane.showMessageDialog(null, ex, "", 0, new ImageIcon("Imagens/btn_sair.png"));
           JOptionPane.showMessageDialog(null, "Erro ao Cadastrar", "", 0, new ImageIcon(getClass().getResource("/Icones/btn_sair.png")));
            
        }
               
    }
    
    public String proximaOS(){
            String SQLSelection = "select * from os order by OS desc limit 1";
        try {
            PreparedStatement st = Conexao.getConnection().prepareStatement(SQLSelection);
            ResultSet rs = st.executeQuery();
            if(rs.next()){
                return (Integer.parseInt(rs.getString("OS")) + 1) + "";
            }else{
                return "1";
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Buscar OS");
            return "0";
        }       
        
    }  
}
