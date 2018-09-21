package Utilitarios;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;



public class Conexao {
    // Banco de Dados LocalXampp
    /*
    private final String URL = "jdbc:mysql://localhost:3306/nserv";
    private final String Driver = "org.gjt.mm.mysql.Driver";
    private final String Usuario = "root";
    private final String Senha = "";
    private static Connection Con;
*/
    // Banco de Dados Hospedado

    private final String URL = "jdbc:mysql://nservbd.mysql.uhserver.com:3306/nservbd";
    private final String Driver = "org.gjt.mm.mysql.Driver";
    private final String Usuario = "";
    private final String Senha = "";
    private static Connection Con;

    
    public Conexao(){
        try {
            Con = DriverManager.getConnection(URL, Usuario, Senha);
            Con.setAutoCommit(false);
            //JOptionPane.showMessageDialog(null, "Conectado com Sucesso", "Conectado", 1);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao Conectar com o Banco de Dados", "", 0);
        }
        
    }
    
    public static Connection getConnection(){ // Loop
        if(Con == null){
            new Conexao();
        }
        return Con;
    }
    
    public static void FecharConexao(){
        try {
            if(!Con.isClosed()){
                Con.close();
               }
        } catch (SQLException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        }
            
    }


public static void main(String args[]){
    Conexao.getConnection();
}
}