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
           JOptionPane.showMessageDialog(null, "Preencha o campo Nome", "", 0, new ImageIcon("Imagens/btn_sair.png"));
        return false;
        }
        
        if(Cliente.getTelefone().equals("(  )     -    ")){
           JOptionPane.showMessageDialog(null, "Preencha o campo Telefone", "", 0, new ImageIcon("Imagens/btn_sair.png"));
        return false;
        }
        
        if(Cliente.getCelular().equals("(  ) 9     -    ")){
        JOptionPane.showMessageDialog(null, "Preencha o campo Celular", "", 0, new ImageIcon("Imagens/btn_sair.png"));
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
           JOptionPane.showMessageDialog(null, "Preencha o campo Nome", "", 0, new ImageIcon("Imagens/btn_sair.png"));
        return false;
        }
        
        if(Cliente.getTelefone().equals("(  )     -    ")){
           JOptionPane.showMessageDialog(null, "Preencha o campo Telefone", "", 0, new ImageIcon("Imagens/btn_sair.png"));
        return false;
        }
        
        if(Cliente.getCelular().equals("(  ) 9     -    ")){
        JOptionPane.showMessageDialog(null, "Preencha o campo Celular", "", 0, new ImageIcon("Imagens/btn_sair.png"));
        return false;
        }
        
        ClienteD.editarCliente(Cliente);
        
        return true;        
    }
}
