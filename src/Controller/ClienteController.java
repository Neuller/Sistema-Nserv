package Controller;

import Beans.ClienteBeans;
import DAO.ClienteDAO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class ClienteController {
    
    ClienteDAO ClienteD;
    
    public ClienteController(){
        ClienteD = new ClienteDAO();
        
        
    }
    
    
    
    public String controleDeCodigo(){
        return ClienteD.proximoCliente();
    }
    
    public void controlePesquisa(String Pesquisa, DefaultTableModel Modelo){
        ClienteD.buscarCliente(Pesquisa, Modelo);
    }
    
    public ClienteBeans controlePreencherCampos(int Codigo){
        return ClienteD.preencherCampos(Codigo);
    }
        
}
