package Controller;

import Beans.ServicosBeans;
import DAO.ServicosDAO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;


public class ServicosController {
    
    ServicosDAO ServicosD;
    
    public ServicosController(){
        
        ServicosD = new ServicosDAO();
        
    }
    
    public boolean verificardados(ServicosBeans OS){
        
        if(OS.getAparelho().equals("")){
           JOptionPane.showMessageDialog(null, "Preencha o campo Aparelho", "", 0, new ImageIcon(getClass().getResource("/Icones/btn_sair.png")));
        return false;
        } 
             
        if(OS.getSerial().equals("")){
           JOptionPane.showMessageDialog(null, "Preencha o campo Serial", "", 0, new ImageIcon(getClass().getResource("/Icones/btn_sair.png")));
        return false;
        }
        
        ServicosD.CadastrarOS(OS);
        
        return true;        
    }

    public String controleDeCodigo(){
        return ServicosD.proximaOS();
    } 

    
    public ServicosBeans controlePreencherCampos(int Codigo){
        return ServicosD.preencherCampos(Codigo);
    }
    
    public boolean verificardadosEditar(ServicosBeans OS){
       if(OS.getAparelho().equals("")){
           JOptionPane.showMessageDialog(null, "Preencha o campo Aparelho", "", 0, new ImageIcon(getClass().getResource("/Icones/btn_sair.png")));
        return false;
        }
       
       if(OS.getSerial().equals("")){
           JOptionPane.showMessageDialog(null, "Preencha o campo Serial", "", 0, new ImageIcon(getClass().getResource("/Icones/btn_sair.png")));
        return false;
        }
        
        ServicosD.editarOS(OS);  
        
        return true;        
    }
}
