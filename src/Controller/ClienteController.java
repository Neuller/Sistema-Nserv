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
    
    public boolean verificardados(ClienteBeans Cliente){
        if(Cliente.getNome().equals("")){
           JOptionPane.showMessageDialog(null, "Preencha o campo Nome", "", 0, new ImageIcon(getClass().getResource("/Icones/btn_sair.png")));
        return false;
        }           
        
        ClienteD.CadastrarCliente(Cliente);
        
        return true;        
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
    
    public boolean verificardadosEditar(ClienteBeans Cliente){
        if(Cliente.getNome().equals("")){
           JOptionPane.showMessageDialog(null, "Preencha o campo Nome", "", 0, new ImageIcon(getClass().getResource("/Icones/btn_sair.png")));
        return false;
        }            
        
        ClienteD.editarCliente(Cliente);
        
        return true;        
    }
}
