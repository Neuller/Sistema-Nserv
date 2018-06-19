package Controller;

import Beans.ClienteBeans;
import DAO.ClienteDAO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;


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
        
        if(Cliente.getBairro().equals("")){
           JOptionPane.showMessageDialog(null, "Preencha o campo Bairro", "", 0, new ImageIcon("Imagens/btn_sair.png"));
        return false;
        }
          
        if(Cliente.getRua().equals("")){
           JOptionPane.showMessageDialog(null, "Preencha o campo Rua", "", 0, new ImageIcon("Imagens/btn_sair.png"));
        return false;
        }
        
        if(Cliente.getTelefone().equals("(  )      -    ")){
           JOptionPane.showMessageDialog(null, "Preencha o campo Telefone", "", 0, new ImageIcon("Imagens/btn_sair.png"));
        return false;
        }
        
        ClienteD.CadastrarCliente(Cliente);
        
        return true;        
    }
    
    public String controleDeCodigo(){
        return ClienteD.proximoCliente();
    }
}