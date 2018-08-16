package Controller;

import Beans.EstoqueBeans;
import DAO.EstoqueDAO;
import javax.swing.table.DefaultTableModel;



public class EstoqueController {
    
    EstoqueDAO EstoqueD;
    
    public EstoqueController(){
        EstoqueD = new EstoqueDAO();
        
        
    }   
    
    public void controlePesquisa(String Pesquisa, DefaultTableModel Modelo){
        EstoqueD.buscarProduto(Pesquisa, Modelo);
    }
    
    public EstoqueBeans controlePreencherCampos(int Codigo){
        return EstoqueD.preencherCampos(Codigo);
    }   
    
}