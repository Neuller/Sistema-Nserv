package Controller;

import Beans.ClienteBeans;
import Beans.OSBeans;
import DAO.OSDAO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;


public class OSController {
    
    OSDAO OSD;
    
    public OSController(){
        
        OSD = new OSDAO();
        
    }
    
    public boolean verificardados(OSBeans OS){
        if(OS.getAparelho().equals("")){
           JOptionPane.showMessageDialog(null, "Preencha o campo Aparelho", "", 0, new ImageIcon(getClass().getResource("/Icones/btn_sair.png")));
        return false;
        }
        
        if(OS.getInformacao().equals("")){
           JOptionPane.showMessageDialog(null, "Preencha o campo Informação", "", 0, new ImageIcon(getClass().getResource("/Icones/btn_sair.png")));
        return false;
        }
        
        if(OS.getValor() == 0){
        JOptionPane.showMessageDialog(null, "Preencha o campo Valor", "", 0, new ImageIcon(getClass().getResource("/Icones/btn_sair.png")));
        return false;
        }
        
        OSD.CadastrarOS(OS);
        
        return true;        
    }

public String controleDeCodigo(){
        return OSD.proximaOS();
    } 
    
}
