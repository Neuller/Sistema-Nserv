package Controller;

import Beans.EstoqueBeans;
import DAO.EstoqueDAO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;



public class EstoqueController {
    
    EstoqueDAO EstoqueD;
    
    public EstoqueController(){
        EstoqueD = new EstoqueDAO();
        
        
    }
    
    public boolean verificardados(EstoqueBeans Estoque){
        if(Estoque.getNome().equals("")){
           JOptionPane.showMessageDialog(null, "Preencha o campo Nome", "", 0, new ImageIcon("Imagens/btn_sair.png"));
        return false;
        }
        
        if(Estoque.getQuantidade()){
           JOptionPane.showMessageDialog(null, "Preencha o campo Quantidade", "", 0, new ImageIcon("Imagens/btn_sair.png"));
        return false;
        }
          
        if(Estoque.getValor() == '?'){
           JOptionPane.showMessageDialog(null, "Preencha o campo Valor", "", 0, new ImageIcon("Imagens/btn_sair.png"));
        return false;
        }
        
        if(Estoque.getNF() == '?'){
           JOptionPane.showMessageDialog(null, "Preencha o campo NF", "", 0, new ImageIcon("Imagens/btn_sair.png"));
        return false;
        }
        
        if(Estoque.getNCM() == '?'){
           JOptionPane.showMessageDialog(null, "Preencha o campo NCM", "", 0, new ImageIcon("Imagens/btn_sair.png"));
        return false;
        }
        
        EstoqueD.CadastrarProduto(Estoque);
        
        return true;        
    }
    
    public String controleDeCodigo(){
        return EstoqueD.proximoProduto();
    }
    
    public void controlePesquisa(String Pesquisa, DefaultTableModel Modelo){
        EstoqueD.buscarProduto(Pesquisa, Modelo);
    }
    
    public EstoqueBeans controlePreencherCampos(int Codigo){
        return EstoqueD.preencherCampos(Codigo);
    }
    
    public boolean verificardadosEditar(EstoqueBeans Estoque){
        if(Estoque.getNome().equals("")){
           JOptionPane.showMessageDialog(null, "Preencha o campo Nome", "", 0, new ImageIcon("Imagens/btn_sair.png"));
        return false;
        }
        
        if(Estoque.getQuantidade() == null){
           JOptionPane.showMessageDialog(null, "Preencha o campo Quantidade", "", 0, new ImageIcon("Imagens/btn_sair.png"));
        return false;
        }
          
        if(Estoque.getValor() == null){
           JOptionPane.showMessageDialog(null, "Preencha o campo Valor", "", 0, new ImageIcon("Imagens/btn_sair.png"));
        return false;
        }
        
        if(Estoque.getNF() == null){
           JOptionPane.showMessageDialog(null, "Preencha o campo NF", "", 0, new ImageIcon("Imagens/btn_sair.png"));
        return false;
        }
        
        if(Estoque.getNCM() == null){
           JOptionPane.showMessageDialog(null, "Preencha o campo NCM", "", 0, new ImageIcon("Imagens/btn_sair.png"));
        return false;
        }
        
        EstoqueD.editarProduto(Estoque);
        
        return true;        
    }
}